package com.jing.recyclerview_baseadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.jing.recyclerview_baseadapter.adapter.OneAdapter;
import com.jing.recyclerview_baseadapter.api.UrlService;
import com.jing.recyclerview_baseadapter.model.HotArticle;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 今日热文
 */
public class OneActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private OneAdapter adapter;
    private Banner mBanner;
    private List<String> images;
    private List<String> titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        initView();
        getData();
    }



    private void initView() {
        images = new ArrayList<>();
        titles = new ArrayList<>();

        mBanner = (Banner) findViewById(R.id.banner);
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);

        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);



        mRecyclerView = (RecyclerView) findViewById(R.id.one_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new OneAdapter(R.layout.item_one,null);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnItemTouchListener(new SimpleClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                HotArticle.StoriesBean item = (HotArticle.StoriesBean)adapter.getItem(position);
                Toast.makeText(OneActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

            }

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }

            @Override
            public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }
    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UrlService service = retrofit.create(UrlService.class);
        Call<HotArticle> call = service.getHotArticle();
        call.enqueue(new Callback<HotArticle>() {
            @Override
            public void onResponse(Call<HotArticle> call, Response<HotArticle> response) {
                HotArticle hotArticle = response.body();
                List<HotArticle.StoriesBean> list = hotArticle.getStories();
                adapter.addData(list);

                for (HotArticle.StoriesBean s:list) {
                    List<String> images1 = s.getImages();
                    images.addAll(images1);
                    String title = s.getTitle();
                    titles.add(title);
                }
                //设置图片集合
                mBanner.setImages(images);
                //设置标题集合（当banner样式有显示title时）
                mBanner.setBannerTitles(titles);
                //banner设置方法全部调用完毕时最后调用
                mBanner.start();

            }

            @Override
            public void onFailure(Call<HotArticle> call, Throwable t) {
                Log.e("  ", "onFailure: "+t.getMessage());
            }
        });

    }
    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */


            //Glide 加载图片简单用法
            Glide.with(context).load(path).into(imageView);

//            //Picasso 加载图片简单用法
//            Picasso.with(context).load(path).into(imageView);
//
//            //用fresco加载图片简单用法，记得要写下面的createImageView方法
//            Uri uri = Uri.parse((String) path);
//            imageView.setImageURI(uri);
        }
//
//        //提供createImageView 方法，如果不用可以不重写这个方法，主要是方便自定义ImageView的创建
//        @Override
//        public ImageView createImageView(Context context) {
//            //使用fresco，需要创建它提供的ImageView，当然你也可以用自己自定义的具有图片加载功能的ImageView
//            SimpleDraweeView simpleDraweeView=new SimpleDraweeView(context);
//            return simpleDraweeView;
//        }
    }
}
