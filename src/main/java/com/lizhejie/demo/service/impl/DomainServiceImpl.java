package com.lizhejie.demo.service.impl;

import com.lizhejie.demo.model.dao.DomainMapper;
import com.lizhejie.demo.model.dto.DomainDto;
import com.lizhejie.demo.model.entity.Domain;
import com.lizhejie.demo.model.vo.ResolvDomainVo;
import com.lizhejie.demo.service.DomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class DomainServiceImpl implements DomainService {

    @Resource
    DomainMapper domainMapper;
    @Override
    public Boolean add(DomainDto domainDto) {
        Domain domain = new Domain();
        domain.setDomain(domainDto.getDomain());
        int isinsert = domainMapper.insert(domain);
        return true;
    }

    @Override
    public Boolean del(DomainDto domain) {
        return null;
    }

    @Override
    public Boolean update(DomainDto domain) {
        return null;
    }

    @Override
    public ResolvDomainVo list(DomainDto domain) {
        return null;
    }
}
