package com.lizhejie.demo.service.impl;

import com.lizhejie.demo.model.vo.IpInfoVo;
import com.lizhejie.demo.service.IpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO 高德的API只能定位大多数的国内IP，可优化
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class IpServiceImpl implements IpService {

    @Value("${gaode.url}")
    private String gaodeUrl;
    @Value("${gaode.key}")
    private String gaodeKey;

    private final RestTemplate restTemplate;


    @Override
    public IpInfoVo geo(String ip) {
        Map<String,String> params = new HashMap<>();
        params.put("key",gaodeKey);
        params.put("ip",ip);
        String geoUrl = gaodeUrl+"?key={key}&ip={ip}";
        IpInfoVo ipInfoVo = restTemplate.getForObject(geoUrl, IpInfoVo.class,params);
        if (ipInfoVo.getProvince() instanceof String) {
            return ipInfoVo;
        }
        ArrayList hasNoGeo = (ArrayList)ipInfoVo.getProvince();
        if (hasNoGeo.size() == 0){
            throw new RuntimeException("无法获取IP地址的地理信息");
        }
        return ipInfoVo;
    }
}
