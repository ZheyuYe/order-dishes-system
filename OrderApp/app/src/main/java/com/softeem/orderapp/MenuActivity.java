package com.softeem.orderapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.softeem.bean.TypeBean;
import com.softeem.http.HttpCallback;
import com.softeem.http.MenuHttpUtils;

import java.util.ArrayList;
import java.util.List;

// 点菜页面
public class MenuActivity extends AppCompatActivity {
    private LinearLayout topTypeLinearLayout;
    private List<TypeBean> typeList;

    private HttpCallback typeCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // 先联网获取菜谱类型
        typeCallBack = new TypeCallBack();
        new MenuHttpUtils().getAllTypes(typeCallBack);
    }


    // 初始化类型
    public void initTopTypes() {
        topTypeLinearLayout= (LinearLayout
                ) findViewById(R.id.top_type_LinearLayout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL;

        TextView text = null;

        for (int i = 0; i < typeList.size(); i++) {
            TypeBean typeItem = typeList.get(i);
            text = new TextView(this);
            text.setTextSize(30);
            text.setPadding(20, 10, 20, 10);
            text.setId(typeItem.getTypeId());
            text.setTextColor(Color.WHITE);
            text.setText(typeItem.getTypeName());
            text.setOnClickListener(new TypeListener());

            // 将 TextView 加入到 LinearLayout
            topTypeLinearLayout.addView(text, params);
        }
    }

    class TypeListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Log.d("TypeId",v.getId() + "被点击了");
        }
    }


    class  TypeCallBack implements  HttpCallback{

        @Override
        public void onSuccess(final Object data) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                typeList = (List<TypeBean>) data;
                    initTopTypes();
                }
            });
        }

        @Override
        public void onFailure(String message) {

        }
    }
}
