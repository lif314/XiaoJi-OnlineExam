package com.exam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("留言实体类")
public class Message {

    @ApiModelProperty("留言编号")
    private Integer id;

    @ApiModelProperty("解决id为null创建的一个临时id")
    private Integer temp_id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date time;

    @ApiModelProperty("评论信息：一对多关系")
    List<Replay> replays;
}
