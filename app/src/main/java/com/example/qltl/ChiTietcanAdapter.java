package com.example.qltl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ChiTietcanAdapter extends RecyclerView.Adapter<ChiTietcanAdapter.ChiTietCanViewHolder>{
    Context context;
    private List<ChiTietCan> listCan;

    public ChiTietcanAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ChiTietCan> listCan){
        this.listCan = listCan;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChiTietCanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chitietthu_thuysan, parent,false);
        return new ChiTietCanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChiTietCanViewHolder holder, int position) {
        ChiTietCan chiTietCan = listCan.get(position);
        if(chiTietCan == null){
            return;
        }
//        Locale locale = new Locale("vn", "VN");
//        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
//        holder.txtSoKg.setText(currencyFormatter.format(chiTietCan.getSoKGMoiLanCan()));
//        holder.txtId.setText(currencyFormatter.format(chiTietCan.getId()));
        holder.txtSoKg.setText(String.valueOf(chiTietCan.getSoKGMoiLanCan()));
        holder.txtId.setText(String.valueOf(chiTietCan.getId()));
    }

    @Override
    public int getItemCount() {
        if(listCan != null){
            return listCan.size();
        }
        return 0;
    }

    public class ChiTietCanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView txtId, txtSoKg;

        public ChiTietCanViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txt_id);
            txtSoKg = itemView.findViewById(R.id.txt_soKg);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
