package com.lizhejie.demo.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
    @TableId(type = IdType.AUTO)
    private String id;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String createUser;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifiedTime;
    @TableField(fill = FieldFill.INSERT)
    private String isDeleted;
}
