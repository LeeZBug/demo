package com.lizhejie.demo.service;

import com.lizhejie.demo.model.ResolvDomain;
import com.lizhejie.demo.model.dto.DomainDto;

public interface DomainService {
    ResolvDomain get(DomainDto domain);
    Boolean add(DomainDto domain);
    Boolean del(DomainDto domain);
}
