package cn.rootadmin.pojo;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "wegame_open_url_ticket")
public class WegameOpenUrlTicket extends BasePojo {
	@Id
	private Integer id;

	private Integer userId;

	private String wegameId;
	private String uuid;

	private String wechatAccount;

	private String wechatName;

	private String ticketUrl;

	private Date getticketTime;
	
	private Date endTime;

	private Integer statisticsTimes;

	private Integer restrictionsTimes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getWegameId() {
		return wegameId;
	}

	public void setWegameId(String wegameId) {
		this.wegameId = wegameId;
	}

	public String getWechatAccount() {
		return wechatAccount;
	}

	public void setWechatAccount(String wechatAccount) {
		this.wechatAccount = wechatAccount == null ? null : wechatAccount.trim();
	}

	public String getWechatName() {
		return wechatName;
	}

	public void setWechatName(String wechatName) {
		this.wechatName = wechatName == null ? null : wechatName.trim();
	}

	public String getTicketUrl() {
		return ticketUrl;
	}

	public void setTicketUrl(String ticketUrl) {
		this.ticketUrl = ticketUrl == null ? null : ticketUrl.trim();
	}

	public Date getGetticketTime() {
		return getticketTime;
	}

	public void setGetticketTime(Date getticketTime) {
		this.getticketTime = getticketTime;
	}

	public Integer getStatisticsTimes() {
		return statisticsTimes;
	}

	public void setStatisticsTimes(Integer statisticsTimes) {
		this.statisticsTimes = statisticsTimes;
	}

	public Integer getRestrictionsTimes() {
		return restrictionsTimes;
	}

	public void setRestrictionsTimes(Integer restrictionsTimes) {
		this.restrictionsTimes = restrictionsTimes;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	

}