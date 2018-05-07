package cn.rootadmin.pojo;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
public class User extends BasePojo {

	@Id
	private Integer id;

	private String uuid;

	private String userName;

	private String userQq;

	private String password;

	private String userRole;

	private String requestIp;

	private Integer totalRequestsNumber;

	private String userStatus;
	
	private Date endTime;

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
		this.uuid = uuid == null ? null : uuid.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserQq() {
		return userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq == null ? null : userQq.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole == null ? null : userRole.trim();
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp == null ? null : requestIp.trim();
	}

	public Integer getTotalRequestsNumber() {
		return totalRequestsNumber;
	}

	public void setTotalRequestsNumber(Integer totalRequestsNumber) {
		this.totalRequestsNumber = totalRequestsNumber;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus == null ? null : userStatus.trim();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uuid=" + uuid + ", userName=" + userName + ", userQq=" + userQq + ", password="
				+ password + ", userRole=" + userRole + ", requestIp=" + requestIp + ", totalRequestsNumber="
				+ totalRequestsNumber + ", userStatus=" + userStatus + "]";
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	

}