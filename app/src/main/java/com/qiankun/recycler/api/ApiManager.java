package com.qiankun.recycler.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by xcy on 2017/8/12.
 */

public class ApiManager {
    private static ApiManager apiManager;

    public ApiManager() {
    }

    public static ApiManager getInstence() {
        if (apiManager == null) {
            synchronized (ApiManager.class) {
                if (apiManager == null) {
                    apiManager = new ApiManager();
                }
            }
        }
        //请求配置 在这里完成
        OkHttpClient mClent = new OkHttpClient.Builder()
                .addInterceptor(new CustomInterceptor())
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
        return apiManager;
    }


}
