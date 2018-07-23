/*
 * Copyright (c) 2010-2015
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.app.controller;

import com.greek.mythology.cerberus.app.annotation.HttpResponseAnnotation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangpeng
 *         date 2018年07月20日
 *         desc
 */
@RestController
public class LoginController {

    @HttpResponseAnnotation
    @PostMapping("/login")
    public Object login() {
        return "login";
    }

    @HttpResponseAnnotation
    @PostMapping("/logout")
    public Object logout() {
        return "logout";
    }
}
