package com.jing.recyclerview_baseadapter.adapter;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.jing.recyclerview_baseadapter.R;
import com.jing.recyclerview_baseadapter.model.Dailyheme;
import com.jing.recyclerview_baseadapter.model.HotArticle;

import java.util.List;

/**
 * Created by Ding.pengqiang
 * on 2017/3/3.
 *
 * 多布局Adapter
 * onCreateDefViewHolder
 * getLayoutId
 */

public class TwoAdapter extends BaseMultiItemQuickAdapter<Dailyheme.StoriesBean,BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */

    public TwoAdapter(List<Dailyheme.StoriesBean> data) {
        super(data);

        addItemType(0, R.layout.item_one);
        addItemType(2, R.layout.item_two);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Dailyheme.StoriesBean item) {
        int type = viewHolder.getItemViewType();
        switch (type) {
            case 0:
                viewHolder.setText(R.id.txt,item.getTitle());
                Glide.with(mContext).load(item.getImages().get(0).toString())
                        .into((ImageView) viewHolder.getView(R.id.image));
                break;
            case 2:
                viewHolder.setText(R.id.txt,item.getTitle());
                break;
        }
    }
}
