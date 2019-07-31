package com.matt.mattdemo.okhttp;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Author:Created by jiaguofeng on 2019/7/20.
 * Email:jiaguofeng@inno72.com
 */
public class LogInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().build());
    }
}
