package com.greek.mythology.cerberus.app.mybatis.plus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisCodeGeneratorApplication {

	public static void main(String[] args) throws Exception {
		generateCode();
	}

	public static void generateCode() throws Exception {
		String packageName = "com.greek.mythology.cerberus.common";
        //user -> UserService, 设置成true: user -> IUserService
		boolean serviceNameStartWithI = false;
		generateByTables(serviceNameStartWithI, packageName, "cerberus_user", "cerberus_user_token");
	}

	private static void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) throws Exception {
		GlobalConfig config = new GlobalConfig();
		config.setEnableCache(false);
		String dbUrl = "jdbc:mysql://localhost:3306/test";
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.MYSQL)
				.setUrl(dbUrl)
				.setUsername("root")
				.setPassword("1")
				.setDriverName("com.mysql.jdbc.Driver");
		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig
				.setCapitalMode(true)
				.setEntityLombokModel(false)
				.setDbColumnUnderline(true)
				.setEntityLombokModel(true)
				.setNaming(NamingStrategy.underline_to_camel)
				.setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组

		config.setActiveRecord(false)
				.setAuthor("huangpeng")
				.setOutputDir("./")
				.setFileOverride(true);

		if (!serviceNameStartWithI) {
			config.setServiceName("%sService");
		}

		AutoGenerator autoGenerator = new AutoGenerator().setGlobalConfig(config)
				.setDataSource(dataSourceConfig)
				.setStrategy(strategyConfig)
				.setTemplateEngine(new FreemarkerTemplateEngine())
				.setPackageInfo(
						new PackageConfig()
								.setParent(packageName)
								.setXml("xml")
								.setController("controller")
								.setEntity("model")
				);
		autoGenerator.execute();

		//自定义生成controller与vue页面
		MybatisCodeGenerator cmcCodeGenerator = new MybatisCodeGenerator(autoGenerator, packageName);
		cmcCodeGenerator.execute();




	}

	private static void generateByTables(String packageName, String... tableNames) throws Exception {
		generateByTables(true, packageName, tableNames);
	}
}
