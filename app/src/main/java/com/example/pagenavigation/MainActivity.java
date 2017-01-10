package com.example.pagenavigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.pagenavigation.adapter.QuickAdapter;
import com.example.pagenavigation.bean.PNItem;
import com.example.pagenavigation.utils.DataServer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
                matchPosition(rv_pn,layoutManager.findFirstCompletelyVisibleItemPosition());
            }
        });

        rv_pn = (RecyclerView) findViewById(R.id.rv_pn);
        rv_pn.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rv_pn.addOnItemTouchListener(new OnItemClickListener( ){
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter adapter, View view, int position) {
                PNItem item = (PNItem) adapter.getItem(position);
                scrollToPositoin(rv_pn,position);
                scrollToPositoin(mRecyclerView,item.getPosition());
            }
        });
    }

    private void initAdapter() {
        List<PNItem> list =  DataServer.getSampleData();

        QuickAdapter mAdapter = new QuickAdapter(R.layout.item_pnitem,list);
        mRecyclerView.setAdapter(mAdapter);

        QuickAdapter mAdapter1 = new QuickAdapter(R.layout.item_pnitem_h, getPnList(list));
        rv_pn.setAdapter(mAdapter1);
    }
    private  List<PNItem> getPnList( List<PNItem> list) {
        List<PNItem> pnst =  new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(i!=0&&i%5==0){
                pnst.add(list.get(i));
            }
        }
        return pnst;
    }
    private void matchPosition(RecyclerView rv,int targetPositon) {
        if(rv!=null&&rv.getAdapter()!=null){
            if(rv.getAdapter() instanceof  QuickAdapter){
                QuickAdapter adapter = (QuickAdapter)rv.getAdapter();
                int size = adapter.getItemCount();
                for (int i = 0; i < size; i++) {
                    PNItem item = adapter.getItem(i);
                    if(item!=null&&targetPositon==item.getPosition()){
                        scrollToPositoin(rv,i);
                    }
                }
            }
        }
    }


    private void scrollToPositoin(RecyclerView rv,int positon) {
        if(rv!=null&&rv.getAdapter()!=null
                &&positon>-1&&positon<rv.getAdapter().getItemCount()){
            if(rv.getLayoutManager() instanceof LinearLayoutManager){
                ( (LinearLayoutManager)rv.getLayoutManager()).scrollToPositionWithOffset(positon,0);
            }
        }
    }
}