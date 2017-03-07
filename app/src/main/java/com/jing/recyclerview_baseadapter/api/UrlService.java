package com.jing.recyclerview_baseadapter.api;

import com.jing.recyclerview_baseadapter.model.Dailyheme;
import com.jing.recyclerview_baseadapter.model.HotArticle;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Ding.pengqiang
 * on 2017/3/3.
 */

public interface UrlService {

    @GET("api/4/news/latest")
    Call<HotArticle> getHotArticle();
/**
 * * http://news-at.zhihu.com/api/4/theme/11
 */
    @GET("api/4/theme/{id}")
    Call<Dailyheme> getDailyTheme(@Path("id") String id);
}
