package com.example.pagenavigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.pagenavigation.adapter.QuickAdapter;
import com.example.pagenavigation.adapter.QuickAdapter1;


public class MainActivity extends AppCompatActivity  {

    RecyclerView rv_pn;
    RecyclerView mRecyclerView;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initAdapter();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            public void onScrollStateChanged(RecyclerView recyclerView, int newState){
                Log.d("abc","newState ="+newState);
            }

            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                Log.d("abc","dx ="+dx+"  dy="+dy+" firstPosition ="+layoutManager.findFirstCompletelyVisibleItemPosition()
                        +" lastposition ="+layoutManager.findLastCompletelyVisibleItemPosition() );
            }
        });

        rv_pn = (RecyclerView) findViewById(R.id.rv_pn);
        rv_pn.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void initAdapter() {
        QuickAdapter mAdapter = new QuickAdapter();
        mRecyclerView.setAdapter(mAdapter);
        QuickAdapter1 mAdapter1 = new QuickAdapter1();
        rv_pn.setAdapter(mAdapter1);
    }

}