package com.softeem.orderapp.testhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;

import com.google.gson.Gson;
import com.softeem.orderapp.R;

import java.lang.reflect.Type;

public class LoadHttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_http);

        // 进行网络请求:
        // url
        // 子线程
        String url = "";
        Type t = null;

        CallBack callBack = new CallBack() {
            @Override
            public void onSuccess(Object data) {
                //刷新 GridView
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }

            @Override
            public void onError() {
                // 提醒用户
            }
        };


        //加载网络操作
        loadData(url,t,callBack);

        // UI线程显示数据
    }


    interface CallBack{
        void onSuccess(Object data);

        void onError();
    }

    public void loadData(String url, final Type t, final CallBack callBack){
        new Thread(){
            @Override
            public void run() {
                //加载网络:
                String json = "json";

                // 转换成 Java 对象
                Gson gson = new Gson();
                Object obj = gson.fromJson(json,t);

                //加载完成后,业务逻辑不一样
                callBack.onSuccess(obj);
            }
        }.start();
    }
}
