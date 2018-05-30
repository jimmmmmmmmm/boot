package com.jkwy.boot.TestController;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxinghao on 2018/3/22.
 */
@RestController
public class TestController {

    @RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
    public String index(){













        return "hello word";
    }
}
