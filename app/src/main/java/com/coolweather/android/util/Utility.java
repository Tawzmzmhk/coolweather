package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.Province;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

public class Utility {
    public static boolean handleProvinceResp(String jsonStr){
        if (!TextUtils.isEmpty(jsonStr)){
            try {
                JSONArray array = new JSONArray(jsonStr);
                for (int i = 0;i < array.length();i++){
                    JSONObject jsonObject = array.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceCode(jsonObject.getInt("id"));
                    province.setProvinceName(jsonObject.getString("name"));
                    province.save();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}