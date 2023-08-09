package com.lizhejie.demo.controller;

import com.lizhejie.demo.model.IpInfo;
import com.lizhejie.demo.model.ResolvDomain;
import com.lizhejie.demo.model.base.BaseResult;
import com.lizhejie.demo.model.dto.DomainDto;
import com.lizhejie.demo.model.dto.IpDto;
import com.lizhejie.demo.service.DnsResolvService;
import com.lizhejie.demo.service.IpService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/network")
public class NetworkController {
    @Resource
    private DnsResolvService dnsResolvService;

    @Resource
    private IpService ipService;

    @PostMapping("/resolv")
    public BaseResult<List<ResolvDomain>> resolvdomain(@RequestBody @Validated DomainDto domainDto){
        return BaseResult.success(dnsResolvService.resolv(domainDto.getDomain()));
    }
    @PostMapping("/ipgeo")
    public BaseResult<IpInfo> geo(@RequestBody @Validated IpDto ipDto){
        return BaseResult.success(ipService.geo(ipDto.getIp()));
    }
}
