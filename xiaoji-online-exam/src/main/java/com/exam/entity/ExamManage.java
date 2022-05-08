package com.exam.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("考试管理实体类")
public class ExamManage {

    @ApiModelProperty("考试编号")
    private Integer examCode;

    @ApiModelProperty("该次考试介绍")
    private String description;

    @ApiModelProperty("课程名称")
    private String source;

    @ApiModelProperty("试卷编号")
    private Integer paperId;

    @ApiModelProperty("考试日期")
    private String examDate;

    @ApiModelProperty("持续时长")
    private Integer totalTime;

    @ApiModelProperty("年级")
    private String grade;

    @ApiModelProperty("学期")
    private String term;

    @ApiModelProperty("专业")
    private String major;

    @ApiModelProperty("学院")
    private String institute;

    @ApiModelProperty("总分")
    private Integer totalScore;

    @ApiModelProperty("考试类型")
    private String type;

    @ApiModelProperty("考生须知")
    private String tips;
}
