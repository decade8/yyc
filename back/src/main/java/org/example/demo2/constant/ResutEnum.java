package org.example.demo2.constant;

import lombok.Getter;

@Getter
//后端返回给前端的信息
public enum ResutEnum {
    OK(2000,"成功"),
    Error(5000,"失败");
    ResutEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
    Integer code;
    String message;
}
