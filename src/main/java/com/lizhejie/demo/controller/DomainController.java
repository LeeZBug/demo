package com.lizhejie.demo.controller;

import com.lizhejie.demo.model.dto.DomainDto;
import com.lizhejie.demo.model.entity.Domain;
import com.lizhejie.demo.service.DomainService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/domain/")
public class DomainController {

    @Resource
    DomainService domainService;

    @PostMapping("add")
    public void add(@RequestBody @Validated DomainDto domainDto) {
        domainService.add(domainDto);
    }

    @PostMapping("delete")
    public void delete() {
    }

    @PostMapping("update")
    public void update() {
    }

    @PostMapping("list")
    public void list() {

    }

    @PostMapping("listall")
    public void listall() {

    }
}

