package com.atguigu.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.atguigu.bean.Member;
import com.atguigu.bean.User;
import com.atguigu.util.Const;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//不需要拦截的路径
		Set<String> uri=new HashSet<>();
		uri.add("/user/reg.do");
		uri.add("/user/reg.htm");
		uri.add("/login.htm");
		uri.add("/doLogin.do");
		uri.add("/logout.do");
		//前台页面
		uri.add("/index.htm");
		String path = request.getServletPath();
		if(uri.contains(path))
			return true;
		//判断是否登录
		User u=(User) request.getSession().getAttribute(Const.LOGIN_USER);
		Member m=(Member) request.getSession().getAttribute(Const.LOGIN_MEMBER);
		if(u!=null||m!=null)
			return true;
		else {
			response.sendRedirect(request.getContextPath()+"/login.htm");
			return false;
		}
	}

}
