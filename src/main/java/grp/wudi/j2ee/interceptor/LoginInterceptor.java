package grp.wudi.j2ee.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import grp.wudi.j2ee.entity.Admin;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/**
		 * 	获取admin的session
		 * 	存在放行，不存在拦截
		 */
		Admin admin = (Admin) request.getSession().getAttribute("adminInfo");
		if(null == admin) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return false;
		}
		return true;
	}
	

}
