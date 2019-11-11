package com.atguigu.listener;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atguigu.bean.Permission;
import com.atguigu.service.manager.PermissionService;
import com.atguigu.util.Const;

public class StartSystemListener implements ServletContextListener {
	//在服务器启动时,创建application对象时需要执行的方法
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//将项目的上下文路径(request.getContextPath())放置到application域
		ServletContext application = sce.getServletContext();
		String path=application.getContextPath();
		application.setAttribute("APP_PATH", path);
		/*
		 * ServletContextListener获取spring注入的bean，
		   * 侦听器、过滤器等不归Spring容器托管，无法用注解注入
		 */
		WebApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(application);
		//注意此Listener必须配置在springListener 后面
		PermissionService permissionService=(PermissionService)ioc.getBean(PermissionService.class);
		
		application.setAttribute(name,object);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
