package com.jing.recyclerview_baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.jing.recyclerview_baseadapter.adapter.OneAdapter;
import com.jing.recyclerview_baseadapter.adapter.TwoAdapter;
import com.jing.recyclerview_baseadapter.api.UrlService;
import com.jing.recyclerview_baseadapter.model.Dailyheme;
import com.jing.recyclerview_baseadapter.model.HotArticle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TwoActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TwoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        initView();
        getData();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.two_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new TwoAdapter(null);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnItemTouchListener(new SimpleClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Dailyheme.StoriesBean item = (Dailyheme.StoriesBean)adapter.getItem(position);
                Toast.makeText(TwoActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
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
        Call<Dailyheme> call = service.getDailyTheme("11");
        call.enqueue(new Callback<Dailyheme>() {
            @Override
            public void onResponse(Call<Dailyheme> call, Response<Dailyheme> response) {
                Dailyheme body = response.body();
                List<Dailyheme.StoriesBean> list = body.getStories();
                adapter.addData(list);
            }

            @Override
            public void onFailure(Call<Dailyheme> call, Throwable t) {

            }
        });

    }
}
