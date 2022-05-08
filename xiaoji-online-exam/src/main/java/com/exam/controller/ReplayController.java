package com.exam.controller;

import com.exam.entity.ApiResult;
import com.exam.entity.Replay;
import com.exam.service.impl.ReplayServiceImpl;
import com.exam.util.ApiResultHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "留言评论接口")
public class ReplayController {

    @Autowired
    private ReplayServiceImpl replayService;

    @ApiOperation("发布评论")
    @PostMapping("/replay")
    public ApiResult add(@RequestBody Replay replay) {
        int data = replayService.add(replay);
        if (data != 0) {
            return ApiResultHandler.buildApiResult(200,"添加成功！",data);
        } else {
            return ApiResultHandler.buildApiResult(400,"添加失败！",null);
        }
    }

    @ApiOperation("根据留言id查询所有的评论信息")
    @GetMapping("/replay/{messageId}")
    public ApiResult findAllById(@PathVariable("messageId") @Parameter(description = "留言消息id") Integer messageId) {
        List<Replay> res = replayService.findAllById(messageId);
        return ApiResultHandler.buildApiResult(200,"根据messageId查询",res);
    }
}
