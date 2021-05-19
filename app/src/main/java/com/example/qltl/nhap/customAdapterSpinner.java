package com.example.qltl.nhap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qltl.R;

import java.util.ArrayList;

public class customAdapterSpinner extends BaseAdapter {
    Context context;
    ArrayList<Integer> icons;
    ArrayList<String> names;
    LayoutInflater inflter;

    public customAdapterSpinner() {
    }

    public customAdapterSpinner(Context context, ArrayList<Integer> icons, ArrayList<String> names) {
        this.context = context;
        this.icons = icons;
        this.names = names;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return icons.size();
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
        icon.setImageResource(icons.get(position));
        name.setText(names.get(position));
        return view;
    }
}
