package com.example.qltl.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qltl.IconThuySan;
import com.example.qltl.ItemClickListener;
import com.example.qltl.R;
import com.example.qltl.nhap.customDialog;

import java.util.List;

public class IconThuySanAdapter extends RecyclerView.Adapter<IconThuySanAdapter.IconThuySanViewHolder> {

    Context context;
    List<IconThuySan> listIcon;

    public IconThuySanAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<IconThuySan> iconList){
        this.listIcon = iconList;
        notifyDataSetChanged();//build va load du lieu vao viewadapter
    }

    @NonNull
    @Override
    public IconThuySanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_icon_thuysan, parent,false);
        return new IconThuySanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IconThuySanViewHolder holder, int position) {
        IconThuySan iconThuySan = listIcon.get(position);
        if(iconThuySan == null){
            return;
        }
        holder.imgIcon.setImageResource(iconThuySan.getIcon());
        holder.name.setText(iconThuySan.getName());
        holder.setItemClickListener(new ItemClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                customDialog customDialogg = new customDialog(view.getContext());
                Intent intent = new Intent();

                String name = listIcon.get(position).getName();
                switch (name){
                    case "Tôm":
                    case "Sò":
                        customDialogg.createDialog();
                        break;
                    case "Cua":
                    case "Cá":
                    case "Nghêu":
                    case "Mực":
                        customDialogg.createDialogNoneConKg();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listIcon != null){
            return listIcon.size();
        }
        return 0;
    }

    public class IconThuySanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgIcon;
        private TextView name;
        private CardView cardIcon;
        private ItemClickListener itemClickListener;

        public IconThuySanViewHolder(@NonNull View itemView) {
            super(itemView);

            imgIcon = itemView.findViewById(R.id.img_icon_thuysan);
            name = itemView.findViewById(R.id.txt_icon_name);
            cardIcon = itemView.findViewById(R.id.card_icon);
            itemView.setOnClickListener(this);
        }
        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }
    }

}
