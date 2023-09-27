package com.lizhejie.demo.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class Domain extends BaseEntity implements Serializable {

    private String domain;
    private String recordA;
    private String recordCname;
}