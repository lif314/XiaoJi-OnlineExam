package com.exam.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("分数管理实体类")
public class Score {
    @ApiModelProperty("考试编号")
    private Integer examCode;

    @ApiModelProperty("学号")
    private Integer studentId;

    @ApiModelProperty("课程名称")
    private String subject;

    @ApiModelProperty("平时成绩")
    private Integer ptScore;

    @ApiModelProperty("期末成绩")
    private Integer etScore;

    @ApiModelProperty("总成绩")
    private Integer score;

    @ApiModelProperty("分数编号")
    private Integer scoreId;

    @ApiModelProperty("答题日期")
    private String answerDate;
}
