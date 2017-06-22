package com.softeem.orderapp.activity;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.softeem.orderapp.R;
import com.softeem.orderapp.bean.MenuBean;
import com.softeem.orderapp.bean.TypeBean;
import com.softeem.orderapp.constant.ServerUrl;
import com.softeem.orderapp.http.HttpCallback;
import com.softeem.orderapp.http.MenuHttpUtils;

import org.w3c.dom.Text;

public class MenuDetailActivity extends AppCompatActivity {
    private TextView menuNameTextView;
    private ImageView detailPicImageView;
    private Button backButton;
    private Button addOrderButton;
    private TextView menuTypeTextView;
    private TextView menuPriceTextView;
    private TextView menuCutPriceTextView;
    private TextView menuIntroduceTextView;

    private MenuBean menuBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        initView();
        initData();
    }

    private void initView() {
        menuNameTextView = (TextView) findViewById(R.id.menu_name_TextView);
        detailPicImageView = (ImageView) findViewById(R.id.detail_pic_ImageView);
        backButton = (Button) findViewById(R.id.back_Button);
        addOrderButton = (Button) findViewById(R.id.add_order_Button);
        menuTypeTextView = (TextView) findViewById(R.id.menu_type_TextView);
        menuPriceTextView = (TextView) findViewById(R.id.menu_price_TextView);
        menuCutPriceTextView = (TextView) findViewById(R.id.menu_cutprice_TextView);
        menuIntroduceTextView = (TextView) findViewById(R.id.menu_introduce_TextView);

        // 返回按钮:
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuDetailActivity.this.finish();
            }
        });

        //添加订单
        addOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuDetailActivity.this,"加入成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        //获取 MenuBean
        menuBean = (MenuBean) getIntent().getSerializableExtra("menuBean");
        if (menuBean == null)
            return;

        menuNameTextView.setText("菜谱名称:    " + menuBean.getMenuName());

        menuPriceTextView.setText("价格:   " + menuBean.getMenuPrice() + "");
        menuCutPriceTextView.setText("折后价格:    " + menuBean.getMenuCutprice() + "");
        menuIntroduceTextView.setText(menuBean.getMenuIntroduce());

        //使用框架加载图片
        Glide
                .with(MenuDetailActivity.this)
                .load(ServerUrl.SERVER_PATH + "/images/" + menuBean.getMenuPicUrl())
                .fitCenter()
                .into(detailPicImageView);

        // 加载菜谱类型名称
        new MenuHttpUtils().getTypeName(menuBean.getMenuId(), new HttpCallback() {
            @Override
            public void onSuccess(Object data) {
                 final TypeBean t = (TypeBean) data;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        menuTypeTextView.setText("菜谱类型:    " + t.getTypeName());
                    }
                });
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
