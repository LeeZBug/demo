package com.lizhejie.demo.service;

import com.lizhejie.demo.model.vo.ResolvDomainVo;

import java.util.List;

public interface DnsResolvService {

    List <ResolvDomainVo> resolv(String domain);

}
