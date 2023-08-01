package com.lizhejie.demo.controller;

import com.lizhejie.demo.model.base.BaseResult;
import com.lizhejie.demo.model.ResolvDomain;
import com.lizhejie.demo.model.dto.DomainDto;
import com.lizhejie.demo.service.DomainService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/domain")
public class DomainController {
    @Resource
    private DomainService domainService;

    @PostMapping("/get")
    public BaseResult<ResolvDomain> get(@RequestBody @Validated DomainDto domain){
        return BaseResult.success(domainService.get(domain));
    }

    @PostMapping("/add")
    public BaseResult<Boolean> add(@RequestBody @Validated DomainDto domain){
        return BaseResult.success(domainService.add(domain));
    }

    @PostMapping("/delete")
    public BaseResult<Boolean> del(@RequestBody @Validated DomainDto domain){
        return BaseResult.success(domainService.del(domain));
    }
}
