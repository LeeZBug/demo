package com.lizhejie.demo.service;

import com.lizhejie.demo.model.dto.DomainDto;
import com.lizhejie.demo.model.vo.ResolvDomainVo;

public interface DomainService {

    Boolean add(DomainDto domain);

    Boolean del(DomainDto domain);

    Boolean update(DomainDto domain);

    ResolvDomainVo list(DomainDto domain);
}
