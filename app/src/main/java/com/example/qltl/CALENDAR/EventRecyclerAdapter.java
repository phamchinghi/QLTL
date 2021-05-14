package com.example.qltl.CALENDAR;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qltl.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class EventRecyclerAdapter extends RecyclerView.Adapter<EventRecyclerAdapter.MyViewHolder> {
    Context context;
    ArrayList<Events> arrayList;
    DBOpenHelper dbOpenHelper;

    public EventRecyclerAdapter(Context context, ArrayList<Events> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_events_row_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Events events = arrayList.get(position);
        holder.Event.setText(events.getEvent());
        holder.Time.setText(events.getTime());
        holder.Date.setText(events.getDate());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCalendarEvent(events.getEvent(),events.getDate(),events.getTime());
                arrayList.remove(position);
                notifyDataSetChanged();
            }
        });
        if(isAarmed(events.getDate(),events.getEvent(),events.getTime())){
            holder.setAlarm.setBackgroundResource(R.drawable.ic_action_on);

        }else{
            holder.setAlarm.setBackgroundResource(R.drawable.ic_action_off);

        }
        Calendar datecalendar = Calendar.getInstance();
        datecalendar.setTime(convertStringToDate(events.getDate()));
        int alarmYear = datecalendar.get(Calendar.YEAR);
        int alarmMonth= datecalendar.get(Calendar.MONTH);
        int alarmDay = datecalendar.get(Calendar.DAY_OF_MONTH);
        Calendar timecalendar = Calendar.getInstance();
        timecalendar.setTime(convertStringToTime(events.getTime()));
        int alarmHour = timecalendar.get(Calendar.HOUR_OF_DAY);
        int alarmMinuit = timecalendar.get(Calendar.MINUTE);


        holder.setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAarmed(events.getDate(),events.getEvent(),events.getTime())){
                    holder.setAlarm.setBackgroundResource(R.drawable.ic_action_off);
                    CancelAlarm(getRequestCode(events.getDate(),events.getEvent(),events.getTime()));
                    updateEvent(events.getDate(),events.getEvent(),events.getTime(),"off");
                    notifyDataSetChanged();
                }else{
                    holder.setAlarm.setBackgroundResource(R.drawable.ic_action_on);
                    Calendar alarmCalendar = Calendar.getInstance();
                    alarmCalendar.set(alarmYear,alarmMonth,alarmDay,alarmHour,alarmMinuit);
                    setAlarm(alarmCalendar,events.getEvent(),events.getTime(),getRequestCode(events.getDate(),
                            events.getEvent(),events.getTime()));
                    updateEvent(events.getDate(),events.getEvent(),events.getTime(),"on");
                    notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        Button delete;
        TextView Event,Date,Time;
        ImageButton setAlarm;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Date = itemView.findViewById(R.id.eventdate);
            Event = itemView.findViewById(R.id.eventname);
            Time   = itemView.findViewById(R.id.eventime);
            delete = itemView.findViewById(R.id.delete);
            setAlarm=itemView.findViewById(R.id.alarmmeBtn);
        }
    }
    private Date convertStringToDate(String dateInString){
        java.text.SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(dateInString);

        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    private Date convertStringToTime(String dateInString){
        java.text.SimpleDateFormat format = new SimpleDateFormat("kk:mm", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(dateInString);

        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    private void deleteCalendarEvent(String event,String date,String time){
        dbOpenHelper=new DBOpenHelper(context);
        SQLiteDatabase database =dbOpenHelper.getWritableDatabase();
        dbOpenHelper.deleteEvent(event,date,time,database);
        dbOpenHelper.close();
    }

    private boolean isAarmed(String date,String event,String time ){
        boolean alarmed = false;
        dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase sqLiteDatabase = dbOpenHelper.getReadableDatabase();
        Cursor cursor = dbOpenHelper.ReadIDEvents(date,event,time,sqLiteDatabase);
        while (cursor.moveToNext()){
            String nofity= cursor.getString(cursor.getColumnIndex(DBStructure.Notify));
            if(nofity.equals("on")){
                alarmed=true;
            }else{
                alarmed=false;
            }

        }
        cursor.close();
        dbOpenHelper.close();
        return alarmed;
    }
    private void setAlarm(Calendar calendar, String event, String time, int RequestCode){
        Intent intent = new Intent(context.getApplicationContext(),AlarmReceiver.class);
        intent.putExtra("event",event);
        intent.putExtra("time",time);
        intent.putExtra("id",RequestCode);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,RequestCode,intent,PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarmManager= (AlarmManager)context.getApplicationContext().getSystemService(context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
    }
    private void CancelAlarm(int RequestCode){
        Intent intent = new Intent(context.getApplicationContext(),AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,RequestCode,intent,PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarmManager= (AlarmManager)context.getApplicationContext().getSystemService(context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }
    private  int getRequestCode(String date, String event , String time){
        int code =0;
        dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase sqLiteDatabase = dbOpenHelper.getReadableDatabase();
        Cursor cursor = dbOpenHelper.ReadIDEvents(date,event,time,sqLiteDatabase);
        while (cursor.moveToNext()){
            code = cursor.getInt(cursor.getColumnIndex(DBStructure.ID));

        }
        cursor.close();
        dbOpenHelper.close();
        return code;
    }
    private void updateEvent(String date, String event, String time,String notify){
        dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase sqLiteDatabase = dbOpenHelper.getWritableDatabase();
        dbOpenHelper.updateEvent(date,event,time,notify,sqLiteDatabase);
        dbOpenHelper.close();
    }
}