package org.example.demo2.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class Writer {
    //id
    private String id;
    //序号
    private String xuhao;
   //日期
    private String date;

    private String name;

    private String province;

    private String city;

    private String address;

    private String emailcode;
}
