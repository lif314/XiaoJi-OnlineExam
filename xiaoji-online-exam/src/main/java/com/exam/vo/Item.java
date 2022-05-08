package com.exam.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("出卷题目模型")
public class Item {

    @ApiModelProperty("科目")
    private String subject;

    @ApiModelProperty("试卷id")
    private Integer paperId;

    @ApiModelProperty("选择题数量")
    private Integer changeNumber;

    @ApiModelProperty("填空题数量")
    private Integer fillNumber;

    @ApiModelProperty("判断题数量")
    private Integer judgeNumber;
}
