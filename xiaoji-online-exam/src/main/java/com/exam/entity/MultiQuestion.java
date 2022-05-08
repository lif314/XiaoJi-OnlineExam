package com.exam.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("选择题实体类")
public class MultiQuestion {

    @ApiModelProperty("试题编号")
    private Integer questionId;

    @ApiModelProperty("考试科目")
    private String subject;

    @ApiModelProperty("所属章节")
    private String section;

    @ApiModelProperty("选项A")
    private String answerA;

    @ApiModelProperty("选项B")
    private String answerB;

    @ApiModelProperty("选项C")
    private String answerC;

    @ApiModelProperty("选项D")
    private String answerD;

    @ApiModelProperty("问题题目")
    private String question;

    @ApiModelProperty("难度等级")
    private String level;

    @ApiModelProperty("正确答案")
    private String rightAnswer;

    @ApiModelProperty("题目解析")
    private String analysis;

    @ApiModelProperty("分数")
    private Integer score;

}
