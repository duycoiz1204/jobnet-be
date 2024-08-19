package com.jobnet.post.config;

import com.jobnet.post.dtos.requests.PostsGetRequest;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class PostsGetRequestKeyGenerator implements KeyGenerator {

    @Override
    @NotNull
    public Object generate(@NotNull Object target, @NotNull Method method, Object... params) {
        if (params.length > 0 && params[0] instanceof PostsGetRequest request) {
            return request.toString();
        }
        return StringUtils.EMPTY;
    }
}