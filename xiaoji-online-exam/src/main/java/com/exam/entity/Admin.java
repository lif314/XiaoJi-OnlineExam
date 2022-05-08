package com.exam.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("管理员实体类")
public class Admin {

    @ApiModelProperty("唯一标识符，Id")
    private Integer adminId;

    @ApiModelProperty("姓名")
    private String adminName;

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

    @ApiModelProperty("角色(0管理员，1教师，2学生)")
    private String role;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}
