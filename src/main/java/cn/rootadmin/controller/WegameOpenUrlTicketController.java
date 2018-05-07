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
import cn.rootadmin.pojo.WegameOpenUrlTicket;
import cn.rootadmin.service.WegameOpenUrlTicketService;

@Controller
@RequestMapping(value = "WegameOpenUrlTicket")
public class WegameOpenUrlTicketController {

	@Autowired
	private WegameOpenUrlTicketService wegameOpenUrlTicketService;



	@RequestMapping("/openLinkAdd")
	public ModelAndView addUser() {
		ModelAndView modelAndView = new ModelAndView("WegameOpenUrlTicket/openLinkAdd");
		return modelAndView;
	}
	
	



	@RequestMapping("/delete/{uuid}")
	public ModelAndView deleteUser(@PathVariable String uuid) {
		

		ModelAndView modelAndView = new ModelAndView("redirect:/WegameOpenUrlTicket/openLinkListMy.html");
    	WegameOpenUrlTicket record = new WegameOpenUrlTicket();
    	record.setUuid(uuid);
    	this.wegameOpenUrlTicketService.deleteByWhere(record);
    	return modelAndView;
	}
	

	@RequestMapping("/openLinkListMy")
	public ModelAndView getUserList(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("WegameOpenUrlTicket/openLinkList");
		User user = (User) request.getSession().getAttribute("user");

		String headerReferer = request.getHeader("Referer");

		String[] split = headerReferer.split("/");

		String basePath = "";
		if (split.length > 3) {
			basePath = split[0] + "//" + split[1] + split[2];
		}

		WegameOpenUrlTicket record = new WegameOpenUrlTicket();
		record.setUserId(user.getId());
		List<WegameOpenUrlTicket> queryAll = this.wegameOpenUrlTicketService.queryListByWhere(record);

		modelAndView.addObject("basePath", basePath);
		modelAndView.addObject("wegameOpenUrlTicketList", queryAll);
		return modelAndView;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(WegameOpenUrlTicket wegameOpenUrlTicket, String endTimeStr, HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("redirect:/WegameOpenUrlTicket/openLinkListMy.html");

		if (null == wegameOpenUrlTicket.getWegameId() 
				|| "" == wegameOpenUrlTicket.getWegameId()
				|| "" == wegameOpenUrlTicket.getWechatAccount() 
				|| "" == wegameOpenUrlTicket.getWechatName()
				|| "" == endTimeStr) {
			return modelAndView;
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Date date = format.parse(endTimeStr);
			wegameOpenUrlTicket.setEndTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		User user = (User) request.getSession().getAttribute("user");
		String uuidStr = UUID.randomUUID().toString().replace("-", "");
		wegameOpenUrlTicket.setUuid(uuidStr);
		wegameOpenUrlTicket.setGetticketTime(new Date());
		wegameOpenUrlTicket.setUserId(user.getId());
		wegameOpenUrlTicket.setStatisticsTimes(0);
		wegameOpenUrlTicket.setRestrictionsTimes(0);
		this.wegameOpenUrlTicketService.save(wegameOpenUrlTicket);

		return modelAndView;
	}

}
