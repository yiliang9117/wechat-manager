package cn.rootadmin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.rootadmin.pojo.User;
import cn.rootadmin.service.UserService;

@Controller
@RequestMapping("User")
public class UserController {


    @Autowired
    private UserService userService;
    
    

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin() {
        return "index";
    }
    
    


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User loginUser, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (StringUtils.isEmpty(loginUser.getUserQq()) || StringUtils.isEmpty(loginUser.getPassword())) {
                request.setAttribute("msg", "用户名或密码不能为空");
                return "index";
            }
            /*String host = request.getRemoteHost();// 返回发出请求的客户机的主机名
            int port = request.getRemotePort();// 返回发出请求的客户机的端口号。
            String fromUrl = request.getHeader("Referer");*/

  
            
            User user = userService.doLogin(loginUser.getUserQq(), loginUser.getPassword());
            if (null == user) {
                request.setAttribute("msg", "用户名密码错误");
                return "index";
            }
        
            if (!StringUtils.isEmpty(user.getUserQq()) || !StringUtils.isEmpty(user.getPassword())) {
             
                if (null != user.getUserStatus() ) {
                    if ( "3" == user.getUserStatus()) {
                        request.setAttribute("msg", "账号未激活");
                        return "index";
                    }
                }

                request.getSession().setAttribute("user", user);
                request.getSession().setMaxInactiveInterval(60 * 60 * 2);

        		return "redirect:/Main/index.html";
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        request.setAttribute("msg", "请重新登录");
        return "index";
    }
    
	
	
}
