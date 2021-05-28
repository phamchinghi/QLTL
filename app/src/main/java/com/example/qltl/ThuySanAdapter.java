package com.example.qltl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qltl.nhap.customInput_Output;

import java.util.List;

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
        if(thuySan == null){
            return;
        }
        holder.imgThuySan.setImageResource(thuySan.getResourceId());
        holder.txtName.setText(thuySan.getName());
        holder.txtNameCustomer.setText(thuySan.getTenKH());
    }

    @Override
    public int getItemCount() {
        if(listThuySan != null){
            return listThuySan.size();
        }
        return 0;
    }

    public class ThuySanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgThuySan;
        private TextView txtName;
        private TextView txtNameCustomer;
        private TextView txtTongKhoiLuong;
        private  TextView txtGiaTien;


        public ThuySanViewHolder(@NonNull View itemView) {
            super(itemView);

            imgThuySan = itemView.findViewById(R.id.img_thuysan);
            txtName = itemView.findViewById(R.id.txt_ten_thuysan);
            txtNameCustomer = itemView.findViewById(R.id.txt_tenKH);
            txtTongKhoiLuong = itemView.findViewById(R.id.txt_soluong_da_mua);
            txtGiaTien = itemView.findViewById(R.id.txt_gia_tien);

        }

        @Override
        public void onClick(View v) {

        }
    }


}
