package com.softeem.orderapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.softeem.orderapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    private GridView mainMenuGridView;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
    private int[] icon = { R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    private String[] iconName = { "点餐","呼叫客服","查台","并台","转台","查询订单",
            "收藏夹","结算","更新菜谱","设置" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    public void initView(){
        setContentView(R.layout.activity_main);
        mainMenuGridView = (GridView) findViewById(R.id.main_menu_GridView);
    }

    public void initData(){
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
        // 通过适配器动态创建 菜单
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.main_menu_item, from, to);
        // 配置适配器
        mainMenuGridView.setAdapter(sim_adapter);

        // 给主菜单添加点击监听器
        mainMenuGridView.setOnItemClickListener(this);
    }

    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<iconName.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }

    // 每个菜单点击之后执行
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = null;
        switch (position){
            case 0:
                // 进入点餐页面
                i = new Intent(MainActivity.this,MenuActivity.class);
                break;
        }

        startActivity(i);
    }
}
