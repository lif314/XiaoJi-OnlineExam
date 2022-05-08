package com.exam.controller;

import com.exam.entity.Admin;
import com.exam.entity.ApiResult;
import com.exam.service.AdminService;
import com.exam.util.ApiResultHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags = "管理员系统接口")
public class AdminController {
    @Autowired
    AdminService adminService;

    @ApiOperation(value = "查询管理员列表")
    @GetMapping("/admins")
    public ApiResult findAll(){
        return ApiResultHandler.success(adminService.findAll());
    }

    @ApiOperation(value = "根据id查找管理员信息")
    @GetMapping("/admin/{adminId}")
    public ApiResult findById(@Parameter(description = "管理员id") @PathVariable("adminId") Integer adminId){
        return ApiResultHandler.success(adminService.findById(adminId));
    }

    @ApiOperation(value = "根据Id删除管理员")
    @DeleteMapping("/admin/{adminId}")
    public ApiResult deleteById(@Parameter(description = "管理员id") @PathVariable("adminId") Integer adminId){
        adminService.deleteById(adminId);
        return ApiResultHandler.success();
    }

    @ApiOperation(value = "根据Id更新管理员信息")
    @PutMapping("/admin/{adminId}")
    public ApiResult update(@Parameter(description = "管理员id") @PathVariable("adminId") Integer adminId,@Parameter(description = "管理员实体类") Admin admin){
        return ApiResultHandler.success(adminService.update(admin));
    }

    @ApiOperation("添加管理员")
    @PostMapping("/admin")
    public ApiResult add(@Parameter(description = "管理员实体类") Admin admin){
        return ApiResultHandler.success(adminService.add(admin));
    }
}
