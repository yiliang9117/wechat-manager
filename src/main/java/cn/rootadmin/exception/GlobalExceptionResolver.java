package cn.rootadmin.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, 
			Object handler,	Exception e) {
		
		String message = e.getMessage();
		System.out.println(message);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "您的电脑有问题，请稍后重试。");
		modelAndView.setViewName("/User/login.html");
		return modelAndView;
	}

}
