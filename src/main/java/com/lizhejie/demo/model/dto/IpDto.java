package com.lizhejie.demo.model.dto;

import com.lizhejie.demo.annotation.Regex;
import lombok.Data;


@Data
public class IpDto {
    @Regex(value = "((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}", message = "IP地址格式不正确")
    private String ip;
}
