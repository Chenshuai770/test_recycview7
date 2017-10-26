package com.cs.test_recycview7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/26/026.
 * 通过禁用焦点事件来判断是否选择,学习了
 */


public class SingleActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private List<SelectBean> datas;
    private SingleAdapter adapter;
    private Map<Integer, List<String>> map = new ArrayMap<>();
    private Button mBtnSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        initView();

        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SingleAdapter(datas);
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickLitener(new OnItemClickLitener() {

            @Override
            public void onItemClick(View view, int position) {


                adapter.setSelection(position);
                Intent intent = new Intent(SingleActivity.this, MultiActivity.class);

                if (map!=null) {

                    Gson gson = new Gson();
                    String json = gson.toJson(map);
                    intent.putExtra("json",json);
                }


                intent.putExtra("pos", position);
                startActivityForResult(intent, 2);

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

    }

    private void initData() {
        datas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            SelectBean selectBean = new SelectBean();
            selectBean.setName("测试" + i);
            datas.add(selectBean);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK) {
            int pos = data.getIntExtra("pos", 0);
            ArrayList<String> selectdata = data.getStringArrayListExtra("selectdata");
            datas.get(pos).setSize(selectdata.size());
            adapter.notifyDataSetChanged();

            map.put(pos, selectdata);
        }


    }

    private void initView() {
        mBtnSelect = (Button) findViewById(R.id.btn_select);

        mBtnSelect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_select:

                for (Map.Entry<Integer,List<String>> entry:map.entrySet()){
                    Log.d("AAA", "entry.getKey():" + entry.getKey());
                    List<String> value = entry.getValue();
                    Log.d("SingleActivity", "第"+entry.getKey()+"个的数据"+"value.size():" + value.size());
                }

                break;
        }
    }
}
