//package com.example.qltl.nhap;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.PopupMenu;
//
//import androidx.annotation.Nullable;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.qltl.R;
//import com.example.qltl.ThuySan;
//import com.example.qltl.adapter.ThuySanAdapter;
//import com.example.qltl.widget.customViewPager;
//import com.google.android.material.tabs.TabLayout;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//public class customInput_Output extends Activity implements Serializable{
//
//    private TabLayout tabLayout;
//    private customViewPager viewPager;
//    private Button btnList;
//    private EditText edt_tim_kiem;
//    private ImageButton imgBtn_search;
//    private RecyclerView rcvThuySan;
//    private ThuySanAdapter thuySanAdapter;
//    List<ThuySan> list = new ArrayList<>();
//    Context context;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout_input_output);
//        IntializeUILayout();
//        setDataa();
//    }
//    private void IntializeUILayout(){
//        tabLayout = findViewById(R.id.tab_layout);
//        viewPager = findViewById(R.id.nhap_view_pager);
//        btnList = findViewById(R.id.btnList);
//        edt_tim_kiem = findViewById(R.id.edt_tim_kiem);
//        imgBtn_search = findViewById(R.id.imgBtn_search);
//        rcvThuySan = findViewById(R.id.recycle_view_thu);
//    }
////    public customInput_Output(Context context) {
////        super(context);
////    }
////
////    public customInput_Output(Context context, AttributeSet attrs) {
////        super(context, attrs);
////        this.context = context;
////        IntializeUILayout();
////        customDialog customDialogg = new customDialog(context);
////        btnList.setOnClickListener(new OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                createPopupMenu();
////            }
////        });
////        //su kien cho nut tim kiem
////        imgBtn_search.setOnClickListener(new OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                String value = edt_tim_kiem.getText().toString();
////                if(value.length() == 0) {
////                   customDialogg.createDialogThongbao();
////                }else{
////                    customDialogg.createDialog();
////                    edt_tim_kiem.setText("");
////                }
////            }
////        });
////    }
////
////    private void IntializeUILayout(){
////        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////        View view = inflater.inflate(R.layout.layout_input_output,this);
////        tabLayout = view.findViewById(R.id.tab_layout);
////        viewPager = view.findViewById(R.id.nhap_view_pager);
////        btnList = view.findViewById(R.id.btnList);
////        edt_tim_kiem = view.findViewById(R.id.edt_tim_kiem);
////        imgBtn_search = view.findViewById(R.id.imgBtn_search);
////    }
//
//    private void createPopupMenu() {
//        PopupMenu popupMenu = new PopupMenu(context, btnList);
//        customDialog customDialogg = new customDialog(context);
//        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
//        Intent intent = new Intent(this, ChiTietThuActivity.class);
//        Bundle bundle = new Bundle();
//        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @SuppressLint("NonConstantResourceId")
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.tom:
//                        customDialogg.createDialog();
//                        break;
//                    case R.id.cua:
//                        bundle.putInt("imgTom", R.drawable.ic_crab);
//                        customDialogg.createDialog();
//                        break;
//                    case R.id.ca:
//                        bundle.putInt("imgTom", R.drawable.ic_fish);
//                        customDialogg.createDialog();
//                        break;
//                    case R.id.so:
//                        bundle.putInt("imgTom", R.drawable.ic_shell);
//                        customDialogg.createDialog();
//                        break;
//                    case R.id.muc:
//                        bundle.putInt("imgTom", R.drawable.ic_octopus);
//                        customDialogg.createDialog();
//                        break;
//                    case R.id.ngheu:
//                        bundle.putInt("imgTom", R.drawable.ic_clam);
//                        customDialogg.createDialog();
//                        break;
//                    default:
//                }
//                intent.putExtra("dataImg", bundle);
//                return true;
//            }
//        });
//        popupMenu.show();
//    }
//}