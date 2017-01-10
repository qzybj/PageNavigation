package com.example.pagenavigation.adapter;


import android.view.View;
import android.widget.Toast;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pagenavigation.R;
import com.example.pagenavigation.bean.PNItem;
import com.example.pagenavigation.utils.DataServer;


public class QuickAdapter1 extends BaseQuickAdapter<PNItem> {
    public QuickAdapter1() {
        super(R.layout.item_pnitem_h, DataServer.getSampleData());
        setOnRecyclerViewItemChildClickListener(new OnRecyclerViewItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String content = null;
                PNItem item = (PNItem) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.tv_show:
                        content = "img:" + item.getName();
                        break;
                }
                Toast.makeText(mContext, content, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void convert(BaseViewHolder helper, PNItem item) {
        helper.setText(R.id.tv_show, item.getName());
//        Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
    }
}