package com.lizhejie.demo.controller;

import com.lizhejie.demo.model.base.BaseResult;
import com.lizhejie.demo.model.ResolvDomain;
import com.lizhejie.demo.model.dto.DomainDto;
import com.lizhejie.demo.service.DnsResolvService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/dns")
public class DnsController {
    @Resource
    private DnsResolvService dnsResolvService;

    @PostMapping("/resolv")
    public BaseResult<List<ResolvDomain>> resolvdomain( @RequestBody @Validated DomainDto domainDto){
        return BaseResult.success(dnsResolvService.resolv(domainDto.getDomain()));
    }
}
