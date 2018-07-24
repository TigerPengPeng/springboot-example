/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.app.mybatis.plus;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MybatisCodeGenerator {

    private AutoGenerator autoGenerator;

    private String basePackage;

    public MybatisCodeGenerator(AutoGenerator autoGenerator, String basePackage){
        this.autoGenerator = autoGenerator;
        this.basePackage = basePackage;
    }

    public void execute() throws Exception {
        AbstractTemplateEngine templateEngine = autoGenerator.getTemplateEngine();
        List<TableInfo> tableInfoList = templateEngine.getConfigBuilder().getTableInfoList();

        for (TableInfo tableInfo : tableInfoList) {
            Map<String, Object> objectMap = templateEngine.getObjectMap(tableInfo);
            Map<String, String> pathInfo = templateEngine.getConfigBuilder().getPathInfo();
            TemplateConfig template = templateEngine.getConfigBuilder().getTemplate();

            String entityName = tableInfo.getEntityName();

            String formClassPackage = basePackage + ".common.dao";
            String formClassName = Objects.toString(objectMap.get("entity")) + "Do";
            String baseClassPath = pathInfo.get(ConstVal.CONTROLLER_PATH);
            String formClassPath = StrUtil.subBefore(baseClassPath, File.separator, true) + File.separator + "model" + File.separator + "dao" + File.separator + formClassName + ConstVal.JAVA_SUFFIX;
            String vuePath = StrUtil.subBefore(baseClassPath, File.separator, true) + File.separator + "vue" + File.separator + entityName + ".vue";

            objectMap.put("formClassPackage", formClassPackage);
            objectMap.put("formClassName", formClassName);

            // *DO.java
            if (null != formClassName && null != formClassPath) {
                String formFile = String.format(formClassPath, entityName);
                if (isCreate(formFile)) {
                    templateEngine.writer(objectMap, templateEngine.templateFilePath("/templates/mybatisPlusForm.java"), formFile);
                }
            }
        }
    }

    protected boolean isCreate(String filePath) {
        File file = new File(filePath);
        boolean exist = file.exists();
        if (!exist) {
            mkDir(file.getParentFile());
        }
        return !exist || autoGenerator.getTemplateEngine().getConfigBuilder().getGlobalConfig().isFileOverride();
    }

    protected void mkDir(File file) {
        if (null != file) {
            if (file.getParentFile().exists()) {
                file.mkdir();
            } else {
                mkDir(file.getParentFile());
                file.mkdir();
            }
        }
    }

}
