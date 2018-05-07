package cn.rootadmin.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "open_link")
public class OpenLink extends BasePojo{

	@Id
    private Integer id;
    private String openUrl;
    private Integer statisticsTimes;
    private String visitorIp;
	private String userQq;
	private String ticket;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVisitorIp() {
		return visitorIp;
	}
	public void setVisitorIp(String visitorIp) {
		this.visitorIp = visitorIp;
	}
	public String getUserQq() {
		return userQq;
	}
	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}
	public String getOpenUrl() {
		return openUrl;
	}
	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Integer getStatisticsTimes() {
		return statisticsTimes;
	}
	public void setStatisticsTimes(Integer statisticsTimes) {
		this.statisticsTimes = statisticsTimes;
	}
	
	
	
	

	
	
	
	

}
