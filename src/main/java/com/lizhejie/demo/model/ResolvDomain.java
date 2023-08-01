package com.lizhejie.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class ResolvDomain {
    private String domain;
    private List<String> ips;
    private List<String> cnames;

}
