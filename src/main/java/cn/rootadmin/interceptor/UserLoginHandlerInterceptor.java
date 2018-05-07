package cn.rootadmin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.rootadmin.pojo.User;

public class UserLoginHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		/*
		 * String host = request.getRemoteHost();// 返回发出请求的客户机的主机名 int port =
		 * request.getRemotePort();// 返回发出请求的客户机的端口号。 String fromUrl =
		 * request.getHeader("Referer");
		 */

		User user = (User) request.getSession().getAttribute("user");
		if (null == user || StringUtils.isEmpty(user.getUserName())) {
			request.setAttribute("msg", "登录超时");
			response.sendRedirect("/User/login.html");
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
