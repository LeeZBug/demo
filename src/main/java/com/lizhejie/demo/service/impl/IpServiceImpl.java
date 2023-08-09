package com.lizhejie.demo.service.impl;

import com.lizhejie.demo.model.IpInfo;
import com.lizhejie.demo.service.IpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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
    public IpInfo geo(String ip) {
        Map<String,String> params = new HashMap<>();
        params.put("key",gaodeKey);
        params.put("ip",ip);
        String geoUrl = gaodeUrl+"?key={key}&ip={ip}";
        IpInfo ipinfo = restTemplate.getForObject(geoUrl,IpInfo.class,params);
        if (ipinfo.getCity() == null || ipinfo.getCity().isEmpty()){
            throw new RuntimeException("无法获取IP地址的地理信息");
        }
        return ipinfo;
    }
}
