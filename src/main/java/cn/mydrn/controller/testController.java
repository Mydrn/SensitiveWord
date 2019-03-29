package cn.mydrn.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 测试 Controller
 * @Author: nican
 * @Date: 2019/3/29
 */
@RestController
@RequestMapping
public class testController {

    @GetMapping("/test1")
    @ResponseBody
    public String test1(@RequestParam(value = "data") String data, HttpServletRequest request) {
        return data;
    }


}