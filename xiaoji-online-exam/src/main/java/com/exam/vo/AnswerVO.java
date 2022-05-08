package com.exam.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("试题信息")
public class AnswerVO {
    @ApiModelProperty("试题")
    private String question;

    @ApiModelProperty("科目")
    private String subject;

    @ApiModelProperty("分数")
    private String score;

    @ApiModelProperty("所属章节")
    private String section;

    @ApiModelProperty("试题难度")
    private String level;

    @ApiModelProperty("试题类型")
    private String type;
}
