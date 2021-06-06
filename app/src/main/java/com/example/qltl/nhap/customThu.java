//package com.example.qltl.nhap;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.LinearLayout;
//import android.widget.PopupMenu;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.qltl.R;
//import com.example.qltl.ThuySan;
//import com.example.qltl.adapter.ThuySanAdapter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class customThu extends LinearLayout {
//    private RecyclerView rcvThuySan;
//    private ThuySanAdapter thuySanAdapter;
//    private Button btnList;
//    List<ThuySan> list = new ArrayList<>();
//    Context context;
//
//    public customThu(Context context) {
//        super(context);
//    }
//
//    public customThu(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        this.context = context;
//        IntializeUILayout();
//        btnList.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                createPopupMenu();
//            }
//        });
//    }
//
//    private void IntializeUILayout(){
//        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.layout_thu,this);
//        btnList = view.findViewById(R.id.btnList);
//
//
//    }
//
//}
