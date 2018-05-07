package cn.rootadmin.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.rootadmin.pojo.OpenLink;
import cn.rootadmin.pojo.User;
import cn.rootadmin.pojo.WegameOpenUrlTicket;
import cn.rootadmin.service.OpenLinkService;
import cn.rootadmin.service.UserService;
import cn.rootadmin.service.WegameOpenUrlTicketService;
import cn.rootadmin.vo.OpenLinkVo;

@Controller
@RequestMapping(value = "OpenLink")
public class OpenlinkController {


	@Autowired
	private OpenLinkService openLinkService;
	
	
	
	@Autowired
	private WegameOpenUrlTicketService wegameOpenUrlTicketService;
	
	
	
	
	


    @Autowired
    private UserService userService;

	@RequestMapping(value = "getOpenLink", method = RequestMethod.GET)
	public ResponseEntity<OpenLinkVo> getOpenLink(@RequestParam(value = "key", defaultValue = "admin") String key,
			@RequestParam(value = "userQq", defaultValue = "1") String userQq,
			@RequestParam(value = "topicId", defaultValue = "30994077") String wxGameId,
			HttpServletRequest request) {
		
		String visitorIp = request.getRemoteHost();
		
		OpenLink openlink = new OpenLink();
		openlink.setOpenUrl(wxGameId);
		openlink.setUserQq(userQq);
		
		OpenLink queryOne = this.openLinkService.queryOne(openlink);
		if (null!= queryOne) {
			int statisticsTimes = openlink.getStatisticsTimes()+1;
			openlink.setStatisticsTimes(statisticsTimes);
			this.openLinkService.updateSelective(openlink);
		}else {
			openlink.setStatisticsTimes(0);
			this.openLinkService.updateSelective(openlink);
		}
		
		User user = new User();
		user.setUserQq(userQq);
		User queryOne2 = this.userService.queryOne(user );
		
		OpenLinkVo openlinkVo = new OpenLinkVo();
		openlinkVo.setTopicId(wxGameId);
		openlinkVo.setVisitorIp(visitorIp);
		openlinkVo.setUserQq(userQq);
		if (null==queryOne2) {
			openlinkVo.setRemark("请注册");
			return ResponseEntity.ok(openlinkVo);
		}
		
		if (queryOne2.getEndTime().getTime()< new Date().getTime()) {
			openlinkVo.setRemark("服务已到期");
			return ResponseEntity.ok(openlinkVo);
		}

		String ticket = this.openLinkService.getTicketFromWeGameByTopicId(wxGameId);
		openlinkVo.setTicket(ticket);
		return ResponseEntity.ok(openlinkVo);
	}
	
	@RequestMapping("/openLinkAdd")
    public ModelAndView addUser() {
    	ModelAndView modelAndView = new ModelAndView("OpenLink/openLinkAdd");
    	return modelAndView;
	}
	
	@RequestMapping("/openLinkListMy")
    public ModelAndView getUserList(HttpServletRequest request) {

    	ModelAndView modelAndView = new ModelAndView("/OpenLink/openLinkList");
    	User user = (User) request.getSession().getAttribute("user");
    	OpenLink record = new OpenLink();
    	record.setUserQq(user.getUserQq());
		List<OpenLink> queryAll = this.openLinkService.queryListByWhere(record );
    	modelAndView.addObject("openLinkList", queryAll);
    	return modelAndView;
	}

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView add(WegameOpenUrlTicket wegameOpenUrlTicket,HttpServletRequest request, HttpServletResponse response) {

    	ModelAndView modelAndView = new ModelAndView("redirect:/OpenLink/openLinkList.html");
    	User user = (User) request.getSession().getAttribute("user");
    	
    	wegameOpenUrlTicket.setGetticketTime(new Date());
    	wegameOpenUrlTicket.setUserId(user.getId());
    	wegameOpenUrlTicket.setStatisticsTimes(0);
    	wegameOpenUrlTicket.setRestrictionsTimes(0);
		this.wegameOpenUrlTicketService.save(wegameOpenUrlTicket );
    	
    	OpenLink record = new OpenLink();
    	record.setUserQq(user.getUserQq());
		List<OpenLink> queryAll = this.openLinkService.queryListByWhere(record );
    	modelAndView.addObject("openLinkList", queryAll);
    	return modelAndView;
	}
	
	
	
	
	
	

	

}
