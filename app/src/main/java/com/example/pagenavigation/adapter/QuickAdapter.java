package com.example.pagenavigation.adapter;



import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pagenavigation.R;
import com.example.pagenavigation.bean.PNItem;
import java.util.List;

public class QuickAdapter extends BaseQuickAdapter<PNItem> {
    public QuickAdapter(int layoutId,List<PNItem> list) {
        super(layoutId, list);
    }

    @Override
    protected void convert(BaseViewHolder helper, PNItem item) {
        helper.setText(R.id.tv_show, item.getName());
//        Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
    }
}