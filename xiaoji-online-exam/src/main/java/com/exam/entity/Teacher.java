package com.exam.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("教师实体类")
public class Teacher {
    @ApiModelProperty("教师编号")
    private Integer teacherId;

    @ApiModelProperty("姓名")
    private String teacherName;

    @ApiModelProperty("学院")
    private String institute;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("电话号码")
    private String tel;

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("密码")
    private String pwd;

    @ApiModelProperty("身份证号")
    private String cardId;

    @ApiModelProperty("职称")
    private String type;

    @ApiModelProperty("角色（0管理员，1教师，2学生)")
    private String role;
}
