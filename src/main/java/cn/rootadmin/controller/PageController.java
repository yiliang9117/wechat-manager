package cn.rootadmin.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.rootadmin.pojo.User;
import cn.rootadmin.pojo.WegameOpenUrlTicket;
import cn.rootadmin.service.OpenLinkService;
import cn.rootadmin.service.UserService;
import cn.rootadmin.service.WegameOpenUrlTicketService;

@Controller
public class PageController {
	

	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
	
	
	@Autowired
	private WegameOpenUrlTicketService wegameOpenUrlTicketService;

	@Autowired
	private OpenLinkService openLinkService;
	
	


    @Autowired
    private UserService userService;

	@RequestMapping("/t/{uuid}")
    public ModelAndView wxJunp(@PathVariable String uuid) {
    	ModelAndView modelAndView = new ModelAndView("WegameOpenUrlTicket/toWechat");
    	WegameOpenUrlTicket record = new WegameOpenUrlTicket();
    	record.setUuid(uuid);
		WegameOpenUrlTicket queryOne = this.wegameOpenUrlTicketService.queryOne(record);
		
	
		Integer userId = queryOne.getUserId();
		
		User user = new User();

		user.setId(userId);
		User queryOne2 = this.userService.queryOne(user );
		
		
		if (null==queryOne2) {
			modelAndView.addObject("msg", "请注册");
	    	return modelAndView;
		}
		
		
		
		
		if (queryOne.getEndTime().getTime()< new Date().getTime()||queryOne2.getEndTime().getTime()< new Date().getTime()) {
			modelAndView.addObject("msg", "服务已到期");
	    	return modelAndView;
		}
		queryOne.setStatisticsTimes(queryOne.getStatisticsTimes()+1);
		this.wegameOpenUrlTicketService.updateSelective(queryOne);
    	String ticketFromWeGameByTopicId = this.openLinkService.getTicketFromWeGameByTopicId(queryOne.getWegameId());
    	modelAndView.addObject("ticket", ticketFromWeGameByTopicId);
    	return modelAndView;
	}
	


	

}
