package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ApiResult;
import com.exam.service.AnswerService;
import com.exam.service.impl.AnswerServiceImpl;
import com.exam.util.ApiResultHandler;
import com.exam.vo.AnswerVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "试卷答案接口")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @ApiOperation("分页查询所有题库与答案")
    @GetMapping("/answers/{page}/{size}")
    public ApiResult findAllQuestion(@PathVariable("page") @Parameter(description = "页码") Integer page, @PathVariable("size") @Parameter(description = "每页大小") Integer size){
       Page<AnswerVO> answerVOPage = new Page<>(page,size);
       IPage<AnswerVO> answerVOIPage = answerService.findAll(answerVOPage);
       return ApiResultHandler.buildApiResult(200,"查询所有题库",answerVOIPage);

    }
}
