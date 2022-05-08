package com.exam.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("填空题实体类")
public class FillQuestion {
    @ApiModelProperty("试题编号")
    private Integer questionId;

    @ApiModelProperty("考试科目")
    private String subject;

    @ApiModelProperty("试题内容")
    private String question;

    @ApiModelProperty("正确答案")
    private String answer;

    @ApiModelProperty("分数")
    private Integer score;

    @ApiModelProperty("难度等级")
    private String level;

    @ApiModelProperty("所属章节")
    private String section;

    @ApiModelProperty("题目解析")
    private String analysis;
}
