package com.lizhejie.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class TimeInterceptor implements HandlerInterceptor {
    private Long starttime;
    private Long endtime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        starttime=System.currentTimeMillis();
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        endtime=System.currentTimeMillis();
        long cost = endtime-starttime;
        log.info(request.getServletPath()+" 接口耗时："+ Long.toString(cost) +"ms");
    }
}
