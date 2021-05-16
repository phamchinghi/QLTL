package com.example.qltl.nhap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qltl.R;

public class customAdapterSpinner extends BaseAdapter {
    Context context;
    int icons[];
    String[] names;
    LayoutInflater inflter;

    public customAdapterSpinner() {
    }

    public customAdapterSpinner(Context context, int[] icons, String[] names) {
        this.context = context;
        this.icons = icons;
        this.names = names;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return icons.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewgroup) {
        view = inflter.inflate(R.layout.custom_spinner_item_thuchi, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView_thuchi);
        TextView name = (TextView) view.findViewById(R.id.textView_thuchi);
        icon.setImageResource(icons[position]);
        name.setText(names[position]);
        return view;
    }
}
