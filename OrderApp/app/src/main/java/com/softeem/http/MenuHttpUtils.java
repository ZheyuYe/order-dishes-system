package com.softeem.http;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.softeem.bean.TypeBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Edward on 2017/6/20.
 */

public class MenuHttpUtils {
    // 做网络请求使用的对象
    private static final OkHttpClient client = new OkHttpClient();

    public void getAllTypes(final HttpCallback callback){
        //OkHttp : 网络请求框架

        // 创建请求对象
        final Request request = new Request.Builder()
                .get()
                .tag(this)
                .url("http://218.197.97.78:9090/OrderServer/menuController/getAllType.action")
                .build();

        //开启线程.执行网络操作
        new Thread(){
            public void run() {
                Response response = null;
                try {
                    // 执行网络操作
                    response = client.newCall(request).execute();

                    if (response.isSuccessful()) {
                        // 获取响应文本
                        String json = response.body().string();

                        Log.i("OkHttp","打印GET响应的数据：" + json);

                        // json 处理工具
                        Gson gson = new Gson();

                        List<TypeBean> typeBeanList =   gson.fromJson(json,new TypeToken<List<TypeBean>>(){}.getType());

                        Log.i("OkHttp",typeBeanList.toString());

                        // 执行 UI 操作
                        callback.onSuccess(typeBeanList);
                    } else {
                        String message ="Unexpected code " + response;

                        callback.onFailure(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }




}
