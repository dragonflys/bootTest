package edu.xidian.boot.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("学生基本信息")
public class Student implements Serializable {
    private static final long serialVersionUID = -8581120389973521772L;

    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "学生名称")
    private String name;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty("邮箱")
    private String email;

}
