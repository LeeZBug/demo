package com.lizhejie.demo.service;

import com.lizhejie.demo.model.vo.IpInfoVo;

public interface IpService {
    IpInfoVo geo(String ip);
}
