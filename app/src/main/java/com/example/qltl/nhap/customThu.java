package com.example.qltl.nhap;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qltl.R;
import com.example.qltl.ThuySan;
import com.example.qltl.ThuySanAdapter;

import java.util.ArrayList;
import java.util.List;

public class customThu extends RelativeLayout {
    private RecyclerView rcvThuySan;
    private ThuySanAdapter thuySanAdapter;
    Context context;

    public customThu(Context context) {
        super(context);
    }

    public customThu(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        IntializeUILayout();

    }

    private void IntializeUILayout(){
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_thu,this);

        rcvThuySan = view.findViewById(R.id.recycle_view_thu);
        thuySanAdapter = new ThuySanAdapter(context);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL,false);
        rcvThuySan.setLayoutManager(linearLayoutManager);

        thuySanAdapter.setData(getListThuySan());
        rcvThuySan.setAdapter(thuySanAdapter);

    }

    private List<ThuySan> getListThuySan(){
        List<ThuySan> list = new ArrayList<>();
//        list.add(new ThuySan(R.drawable.ic_crab, "Tom su", "Anh nghi", 50000, 12000));
//        list.add(new ThuySan(R.drawable.ic_crab, "Tom su", "Anh nghi", 50000, 12000));
//        list.add(new ThuySan(R.drawable.ic_clam, "Tom su", "Anh nghi", 50000, 12000));
//        list.add(new ThuySan(R.drawable.ic_crab, "Tom su", "Anh nghi", 50000, 12000));
//        list.add(new ThuySan(R.drawable.ic_crab, "Tom su", "Anh nghi", 50000, 12000));
//        list.add(new ThuySan(R.drawable.ic_clam, "Tom su", "Anh nghi", 50000, 12000));
//        list.add(new ThuySan(R.drawable.ic_crab, "Tom su", "Anh nghi", 50000, 12000));
//        list.add(new ThuySan(R.drawable.ic_crab, "Tom su", "Anh nghi", 50000, 12000));
        list.add(new ThuySan(R.drawable.ic_clam, "Tom su", "Anh nghi", 50000, 12000));
//        list.add(new ThuySan(R.drawable.ic_crab, "Tom su", "Anh nghi", 50000, 12000));
//        list.add(new ThuySan(R.drawable.ic_crab, "Tom su", "Anh nghi", 50000, 12000));
//        list.add(new ThuySan(R.drawable.ic_clam, "Tom su", "Anh nghi", 50000, 12000));
//        list.add(new ThuySan(R.drawable.ic_crab, "Tom su", "Anh nghi", 50000, 12000));
//        list.add(new ThuySan(R.drawable.ic_crab, "Tom su", "Anh nghi", 50000, 12000));
//        list.add(new ThuySan(R.drawable.ic_clam, "Tom su", "Anh nghi", 50000, 12000));
        return list;
    }
}
