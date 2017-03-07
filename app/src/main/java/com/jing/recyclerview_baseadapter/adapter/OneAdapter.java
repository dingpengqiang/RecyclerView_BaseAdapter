package com.jing.recyclerview_baseadapter.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jing.recyclerview_baseadapter.R;
import com.jing.recyclerview_baseadapter.model.HotArticle;

import java.util.List;

/**
 * Created by Ding.pengqiang
 * on 2017/3/3.
 *
 * 简单Adapter
 */

public class OneAdapter extends BaseQuickAdapter<HotArticle.StoriesBean,BaseViewHolder> {

    public OneAdapter(int layoutResId, List<HotArticle.StoriesBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, HotArticle.StoriesBean item) {
        viewHolder.setText(R.id.txt,item.getTitle());
        Glide.with(mContext).load(item.getImages().get(0).toString())
                .into((ImageView) viewHolder.getView(R.id.image));
    }
}
