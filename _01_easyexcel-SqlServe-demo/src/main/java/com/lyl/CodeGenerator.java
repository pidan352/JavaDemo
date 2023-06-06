package com.lyl;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.IFill;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.querys.SqlServerQuery;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 功能：mybatisplus新版代码生成器
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2023/6/5 0005
 */

public class CodeGenerator {
	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir")+"/_01_easyexcel-SqlServe-demo";

		//数据源配置
		DataSourceConfig dsc = new DataSourceConfig.Builder(
				"jdbc:sqlserver://localhost;DatabaseName=text", "sa",
				"admin1552412358")
				.dbQuery(new SqlServerQuery())
				.schema("easy-excel-test")
				.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
					// 自定义类型转换
					int typeCode = metaInfo.getJdbcType().TYPE_CODE;
					if (typeCode == Types.SMALLINT) {
						return DbColumnType.INTEGER;
					}
					return typeRegistry.getColumnType(metaInfo);
				})
				.build();

		AutoGenerator autoGenerator = new AutoGenerator(dsc);

		//全局配置
		GlobalConfig globalConfig = new GlobalConfig.Builder()
				.author("lyl")
				//.enableSwagger()  开启swagger，需要添加swagger依赖并配置
				//.fileOverride()  该方法已迁移到策略配置中
				//输出目录
				.outputDir(projectPath + "/src/main/java")
				.build();

		//包配置
		PackageConfig packageConfig = new PackageConfig.Builder()
				.parent("com")// 设置父包名
				.moduleName("lyl") // 设置父包模块名
				// 设置mapperXml生成路径
				.pathInfo(Collections.singletonMap(OutputFile.xml,
												   projectPath + "/src/main/resources/xml/"))
				.build();

		// 如果模板引擎是 freemarker  从依赖包的 templates下查找模板
		//String templatePath = "/templates/mapper.java.ftl";
		// 如果模板引擎是 velocity
		// String templatePath = "/templates/mapper.xml.vm";

		//模板配置
		TemplateConfig templateConfig = new TemplateConfig.Builder()
				//.disable()//禁用所有模板
				//.disable(TemplateType.ENTITY)//禁用指定模板
				//.service(filePath + "/service.java")//service模板路径
				//.serviceImpl(filePath + "/service/impl/serviceImpl.java")//实现类模板路径
				//.mapper(filePath + "/mapper.java")//mapper模板路径
				//.mapperXml("/templates/mapper.xml")//xml文件模板路路径
				//.controller(filePath + "/controller")//controller层模板路径
				.build();


		//注入配置
		//InjectionConfig injectionConfig = new InjectionConfig.Builder()
		//        //.customMap(map)
		//        .build();

		//策略配置
		ArrayList<IFill> iFills = new ArrayList<>();
		iFills.add(new Column("update_date",FieldFill.INSERT_UPDATE));
		iFills.add(new Column("create_date",FieldFill.INSERT));
		iFills.add(new Column("del_flag",FieldFill.INSERT));
		iFills.add(new Column("is_delete",FieldFill.INSERT));
		StrategyConfig strategyConfig = new StrategyConfig.Builder()
				.addInclude() // 设置需要生成的表名，不指定为所有
				.addTablePrefix("t_", "c_")// 设置过滤表前缀
				//.enableSchema()

				//Entity配置策略
				.entityBuilder()
				.enableChainModel()//开启链式模型
				.enableFileOverride() //覆盖旧文件
				.enableLombok()
				//.enableRemoveIsPrefix()//开启 Boolean 类型字段移除 is 前缀
				//.enableTableFieldAnnotation()//开启生成实体时生成字段注解
				//.logicDeleteColumnName("IS_DELETE") //数据库逻辑删除字段
				.naming(NamingStrategy.underline_to_camel) //数据库表映射到实体的命名策略
				.columnNaming(
						NamingStrategy.underline_to_camel) //默认为 null，未指定按照 naming 执行
				.addTableFills(iFills)//添加表字段填充
				.idType(IdType.ASSIGN_UUID)
				.formatFileName("%s")//格式化实体名称，%s取消首字母I
				.build()

				//Controller配置策略
				.controllerBuilder()
				.enableFileOverride()
				.enableRestStyle()//开启生成@RestController
				.formatFileName("%sController")
				.build()

				//Service配置策略
				.serviceBuilder()
				.enableFileOverride()
				.formatServiceFileName("%sService")
				.formatServiceImplFileName("%sServiceImpl")
				.build()

				//Mapper配置策略
				.mapperBuilder()
				.enableFileOverride()
				.enableBaseResultMap() //启用xml文件中的BaseResultMap 生成
				.enableBaseColumnList()//启用xml文件中的BaseColumnList
				//.cache() //设置缓存实现类
				.formatMapperFileName("%sMapper")//格式化mapper类名称
				.formatXmlFileName("%sMapper")//格式化xml文件名称
				.build();

		autoGenerator.global(globalConfig)
				.packageInfo(packageConfig)
				.template(templateConfig)
				//.injection(injectionConfig)
				.strategy(strategyConfig)
				.execute(new FreemarkerTemplateEngine());//指定模板为freemark


	}
}
