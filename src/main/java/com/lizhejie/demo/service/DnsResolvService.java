package com.lizhejie.demo.service;

import com.lizhejie.demo.model.ResolvDomain;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

public interface DnsResolvService {

    List <ResolvDomain> resolv(String domain);

}
