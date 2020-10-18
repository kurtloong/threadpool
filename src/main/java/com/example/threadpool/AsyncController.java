package com.example.threadpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kurtl
 */
@Controller
@RequestMapping("/")
public class AsyncController {
    @Autowired
    private AsyncService asyncService;
    @PostMapping("/asyncSimpleExample")
    @ResponseBody
    public void  asyncSimpleExample(){
        asyncService.asyncSimpleExample();
    }
}
