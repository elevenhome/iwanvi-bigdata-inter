package com.iwanvi.bigdata.inter.controller;


import com.iwanvi.bigdata.inter.common.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 健康检查
 * @author zzw
 * @since 2020年10月27日11:37:30
 */
@Api(description = "健康检查")
@RestController
public class CheckHealthController {

    @ApiOperation(value = "健康检查", httpMethod = "GET")
    @ApiResponses({@ApiResponse(code = 600, message = "")})
    @GetMapping("/checkHealth")
    public String checkHealth(String name) {
        if (Utils.isEmpty(name))  name = "bigdata";
        return new StringBuffer("Hello ").append(name).append(" I am healthy!!!").toString();
    }

}
