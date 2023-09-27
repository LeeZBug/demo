package com.lizhejie.demo.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class ResolvDomainVo {
    private String domain;
    private List<String> ips;
    private List<String> cnames;

}
