package com.MIniProject.model;

import com.MIniProject.constant.StatusConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Status {

    public Integer code;

    public String message;

    public Status(StatusConstant.HttpConstant httpConstant) {
        this.code = httpConstant.getCode();
        this.message = httpConstant.getDesc();
    }
}
