package cn.rootadmin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.rootadmin.pojo.User;
import cn.rootadmin.service.UserService;

@Controller
@RequestMapping("Users")
public class AllUserController {


    @Autowired
    private UserService userService;
    


    

	@RequestMapping("/userList")
    public ModelAndView getUserList() {
    	ModelAndView modelAndView = new ModelAndView("User/userList");
    	List<User> queryAll = this.userService.queryAll();
    	modelAndView.addObject("userList", queryAll);
    	
  
    	
    	return modelAndView;
	}


    

	@RequestMapping("/apiUserList")
    public ModelAndView getApiUserList(HttpServletRequest request) {
    	ModelAndView modelAndView = new ModelAndView("User/apiUserList");
    	
    	
    	User record = new User();
    	record.setUserRole("接口用户");
		List<User> queryAll = this.userService.queryListByWhere(record );
    	modelAndView.addObject("userList", queryAll);
    	
      	String headerReferer = request.getHeader("Referer");
    		String[] split = headerReferer.split("/");
    		String basePath = "";
    		if (split.length > 3) {
    			basePath = split[0] + "//" + split[1] + split[2];
    		}
    		modelAndView.addObject("basePath", basePath);
    	return modelAndView;
	}

    

	@RequestMapping("/userAdd")
    public ModelAndView addUser() {
    	ModelAndView modelAndView = new ModelAndView("User/userAdd");
    	return modelAndView;
	}
	
	

	@RequestMapping("/updete/{uuid}")
	public ModelAndView showPage(@PathVariable String uuid) {
		

    	ModelAndView modelAndView = new ModelAndView("User/userEdit");
    	User record = new User();
    	record.setUuid(uuid);
    	User user = this.userService.queryOne(record );
    	modelAndView.addObject("user", user);
    	return modelAndView;
	}
	


	@RequestMapping("/delete/{uuid}")
	public ModelAndView deleteUser(@PathVariable String uuid,HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute("user");
		ModelAndView modelAndView = new ModelAndView("redirect:/Users/userList.html");
		
		if (uuid.equals(user.getUuid())) {
	    	return modelAndView;
		}


    	User record = new User();
    	record.setUuid(uuid);
    	this.userService.deleteByWhere(record);
    	return modelAndView;
	}
	


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ModelAndView login(User updeteUser,String endTimeStr, HttpServletRequest request, HttpServletResponse response) {
    	

    	ModelAndView modelAndView = new ModelAndView("redirect:/Users/userList.html");
    	
    	if(updeteUser.getPassword().length()<4){
    		updeteUser.setPassword(null);
    	}

    	updeteUser.setUuid( UUID.randomUUID().toString().replaceAll("-", ""));
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Date date = format.parse(endTimeStr);
			updeteUser.setEndTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	
    	this.userService.updateSelective(updeteUser);
    	List<User> queryAll = this.userService.queryAll();
    	modelAndView.addObject("userList", queryAll);
    	return modelAndView;
	}
	
	


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView add(User user, String endTimeStr,HttpServletRequest request, HttpServletResponse response) {
     	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    		try {
    			Date date = format.parse(endTimeStr);
    			user.setEndTime(date);
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}

    	ModelAndView modelAndView = new ModelAndView("redirect:/Users/userList.html");
    	List<User> queryAll = this.userService.queryAll();
    	modelAndView.addObject("userList", queryAll);
    	
    	if(user.getPassword().length()<4){
    		return modelAndView;
    	}
    	
    	user.setUuid( UUID.randomUUID().toString().replaceAll("-", ""));
    	this.userService.save(user);
    	return modelAndView;
	}
	
	
	
    
	
	
}
