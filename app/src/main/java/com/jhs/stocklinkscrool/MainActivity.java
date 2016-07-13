package com.jhs.stocklinkscrool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jhs.stocklinkscrool.adapter.ALeftAdapter;
import com.jhs.stocklinkscrool.adapter.ARightAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //左侧固定一列数据适配
    private ListView left_container_listview;
    private List<String> leftlList;

    //右侧数据适配
    private ListView right_container_listview;
    private List<Stock> stockList;

    private MyHorizontalScrollView title_horsv;
    private MyHorizontalScrollView content_horsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initData();
        initView();


    }

    private void findView() {
        title_horsv = (com.jhs.stocklinkscrool.MyHorizontalScrollView) findViewById(R.id.title_horsv);
        left_container_listview = (ListView) findViewById(R.id.left_container_listview);
        content_horsv = (com.jhs.stocklinkscrool.MyHorizontalScrollView) findViewById(R.id.content_horsv);
        right_container_listview = (ListView) findViewById(R.id.right_container_listview);
    }

    private void initView() {
        // 设置两个水平控件的联动
        title_horsv.setScrollView(content_horsv);
        content_horsv.setScrollView(title_horsv);
        //添加左侧数据
        ALeftAdapter adapter = new ALeftAdapter(this, leftlList);
        left_container_listview.setAdapter(adapter);
        UtilTools.setListViewHeightBasedOnChildren(left_container_listview);


        // 添加右边内容数据
        ARightAdapter myRightAdapter = new ARightAdapter(this, stockList);
        right_container_listview.setAdapter(myRightAdapter);
        UtilTools.setListViewHeightBasedOnChildren(right_container_listview);
        right_container_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Stock stock = (Stock) parent.getAdapter().getItem(position);
                Toast.makeText(MainActivity.this, stock.getName() + position, Toast.LENGTH_LONG).show();
            }
        });
    }


    //初始化数据源
    private void initData() {

        stockList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            stockList.add(new Stock("风华基金", "222", "333", "444", "555", "666", "dsd", "sdsd"));
        }
        leftlList = new ArrayList<>();
        for (int i = 0; i < stockList.size(); i++) {
            leftlList.add(stockList.get(i).getName());
        }

    }
}
