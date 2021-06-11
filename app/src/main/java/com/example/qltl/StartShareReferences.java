package com.example.qltl;

import android.content.Context;
import android.content.SharedPreferences;

public class StartShareReferences {

    private static final String START_SHARE_REFERENCES = "START_SHARE_REFERENCES";
    private Context context;

    public StartShareReferences(Context context) {
        this.context = context;
    }
//ham put du lieu de kiem tra lan dau cai dat app
    public void putBooleanStart(String key, boolean value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(START_SHARE_REFERENCES, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
//ham get du lieu ra de kiem tra lan dau cai dat
    public Boolean getBoolleanValue(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(START_SHARE_REFERENCES, 0);
        return sharedPreferences.getBoolean(key,false);
    }
}
