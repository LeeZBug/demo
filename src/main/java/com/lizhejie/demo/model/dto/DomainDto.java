package com.lizhejie.demo.model.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class DomainDto {
    @NotBlank(message = "域名不能为空")
    private String domain;
}
