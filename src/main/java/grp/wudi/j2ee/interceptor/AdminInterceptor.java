package grp.wudi.j2ee.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import grp.wudi.j2ee.entity.Admin;

public class AdminInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/**
		 * 	获取admin的session
		 * 	超级管理员放行，普通管理员拦截
		 */
		Admin admin = (Admin) request.getSession().getAttribute("adminInfo");
		if(1 != admin.getType()) {
			response.sendRedirect("/main.do");
			return false;
		}
		return true;
	}
}
