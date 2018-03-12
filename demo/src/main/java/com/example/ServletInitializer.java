package com.example;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * SpringBootServletInitializer这个类是springboot提供的web程序初始化的入口，
 * 当我们使用外部容器（后期文章讲解使用外部tomcat如何运行项目）运行项目时会自动加载并且装配。
 实现了SpringBootServletInitializer的子类需要重写一个configure方法，
 方法内自动根据LessontwoApplication.class的类型创建一个SpringApplicationBuilder交付给springboot框架来完成初始化运行配置。
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

}
