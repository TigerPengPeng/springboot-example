/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangpeng
 *         date 2018年07月20日
 *         desc
 */
@RestController
public class MonitorController {

    @RequestMapping("/monitor/alive")
    public String monitorAlive() {
        return "ok";
    }
}
