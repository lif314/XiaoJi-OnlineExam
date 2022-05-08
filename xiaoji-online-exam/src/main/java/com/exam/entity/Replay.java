package com.exam.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("评论回复实体类")
public class Replay {

    @ApiModelProperty("留言编号")
    private Integer messageId;

    @ApiModelProperty("回复编号")
    private Integer replayId;

    @ApiModelProperty("回复内容")
    private String replay;

    @ApiModelProperty("回复时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date replayTime;
}
