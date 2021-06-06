package com.example.qltl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qltl.MainActivity;
import com.example.qltl.R;
import com.example.qltl.ThuySan;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ThuySanAdapter extends RecyclerView.Adapter<ThuySanAdapter.ThuySanViewHolder>{

    private Context context;
    private List<ThuySan> listThuySan;

    public ThuySanAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ThuySan> thuySanList){
        this.listThuySan = thuySanList;
        notifyDataSetChanged();//build va load du lieu vao viewadapter
    }

    @NonNull
    @Override
    public ThuySanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thuysan, parent,false);
        return new ThuySanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThuySanViewHolder holder, int position) {
        ThuySan thuySan = listThuySan.get(position);
        Locale locale = new Locale("vn", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        if(thuySan == null){
            return;
        }
        holder.txtName.setText(thuySan.getName());
        holder.txtNameCustomer.setText(thuySan.getTenKH());
        holder.txtthanhTien.setText(String.valueOf(currencyFormatter.format(thuySan.getthanhTien())));
        holder.txtTongKhoiLuong.setText(String.valueOf(thuySan.getTongKg()));
    }

    @Override
    public int getItemCount() {
        if(listThuySan != null){
            return listThuySan.size();
        }
        return 0;
    }

    public class ThuySanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtName;
        private TextView txtNameCustomer;
        private TextView txtTongKhoiLuong;
        private  TextView txtthanhTien;


        public ThuySanViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_ten_thuysan);
            txtNameCustomer = itemView.findViewById(R.id.txt_tenKH);
            txtTongKhoiLuong = itemView.findViewById(R.id.txt_soluong_da_mua);
            txtthanhTien = itemView.findViewById(R.id.txt_thanh_tien);

        }

        @Override
        public void onClick(View v) {

        }
    }


}
