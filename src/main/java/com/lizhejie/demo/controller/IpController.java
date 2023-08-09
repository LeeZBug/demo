package com.lizhejie.demo.controller;

import com.lizhejie.demo.model.IpInfo;
import com.lizhejie.demo.model.base.BaseResult;
import com.lizhejie.demo.model.dto.IpDto;
import com.lizhejie.demo.service.IpService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ip")
public class IpController {
    @Resource
    IpService ipService;

    @PostMapping("/geo")
    public BaseResult<IpInfo> geo(@RequestBody @Validated IpDto ipDto){
        return BaseResult.success(ipService.get(ipDto.getIp()));
    }

}
