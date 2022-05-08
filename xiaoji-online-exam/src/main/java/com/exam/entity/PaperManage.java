package com.exam.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("试卷信息实体类")
public class PaperManage {

    @ApiModelProperty("试卷编号")
    private Integer paperId;

    @ApiModelProperty("题目类型")
    private Integer questionType;

    @ApiModelProperty("题目编号")
    private Integer questionId;
}
