package com.xtu.qm.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 账户信息
 * @author feng
 *
 */

@Entity(name="AccountInfo")
@Table(name="tbl_accountInfo")
public class AccountInfo implements Serializable{

	/**
	 * 账户ID
	 * 主键(唯一标识)
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="accountid")
	private long id;
	/**
	 * 昵称(唯一)
	 */
	@Column(name="username",unique=false,nullable=true,length=5000)
	private String username;
	
	
	/**
	 * 用户性别
	 */
	@Column(name="sex",unique=false,nullable=true,length=5000)
	private String sex;
	
	
	/**
	 * 用户登录密码
	 */
	@Column(name="password",unique=false,nullable=true,length=5000)
	private String password;
	/**
	 * 邮箱(唯一)
	 */
	@Column(name="email",unique=false,nullable=true,length=5000)
	private String email;
	/**
	 * 组别
	 */
	@Column(name="grouptype",unique=false,nullable=true,length=5000)
	private String grouptype;
	
	/**
	 * 用户财富值
	 */
	@Column(name="wealthvalue",unique=false,nullable=true,length=5000)
	private int wealthvalue;
	
	/**
	 * 角色(如管理员,普通用户,特权用户等)
	 */
	@Column(name="role",unique=false,nullable=true,length=5000)
	private String role;
	/**
	 * 信用值
	 */
	@Column(name="creditvalue",unique=false,nullable=true,length=5000)
	private int creditvalue;
	
	/**
	 * 1代表已注册
	 * 2代表用户被封
	 */
	@Column(name="state",unique=false,nullable=true,length=5000)
	private int state;
	/**
	 * 用户注册时间
	 */
	@Column(name="registertime",unique=false,nullable=true,length=5000)
	private Date registerTime;
	
	/**
	 * 用户被封时间
	 */
	@Column(name="blocktime",unique=false,nullable=true,length=5000)
	private Date blockedTime;
	
	/**
	 * 连续签到记录
	 */
	@Column(name="signnumber",unique=false,nullable=true,length=5000)
	private int signnumber;
	/**
	 * 用户信息
	 * 账户中有一个封装自己的用户个人信息
	 * one to one
	 */
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
	private UserInfo userinfo;
	/**
	 * 勋章图
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="accountid")
	private List<UserImage> image;
	
	public AccountInfo() {
		super();
	}
	
	
	public AccountInfo(long id, String username, String sex, String password,
			String email, String grouptype, int wealthvalue, String role,
			int creditvalue, int state, Date registerTime, Date blockedTime,
			int signnumber, UserInfo userinfo, List<UserImage> image) {
		super();
		this.id = id;
		this.username = username;
		this.sex = sex;
		this.password = password;
		this.email = email;
		this.grouptype = grouptype;
		this.wealthvalue = wealthvalue;
		this.role = role;
		this.creditvalue = creditvalue;
		this.state = state;
		this.registerTime = registerTime;
		this.blockedTime = blockedTime;
		this.signnumber = signnumber;
		this.userinfo = userinfo;
		this.image = image;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getWealthvalue() {
		return wealthvalue;
	}
	public void setWealthvalue(int wealthvalue) {
		this.wealthvalue = wealthvalue;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getCreditvalue() {
		return creditvalue;
	}
	public void setCreditvalue(int creditvalue) {
		this.creditvalue = creditvalue;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public Date getBlockedTime() {
		return blockedTime;
	}
	public void setBlockedTime(Date blockedTime) {
		this.blockedTime = blockedTime;
	}
	public int getSignnumber() {
		return signnumber;
	}
	public void setSignnumber(int signnumber) {
		this.signnumber = signnumber;
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public List<UserImage> getImage() {
		if(null==image)
		{
			image=new ArrayList();
		}
		return image;
	}
	
	public void setImage(List<UserImage> image) {
		this.image = image;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getGrouptype() {
		return grouptype;
	}
	public void setGrouptype(String grouptype) {
		this.grouptype = grouptype;
	}
	
	@Override
	public String toString() {
		return "AccountInfo [id=" + id + ", username=" + username + ", sex="
				+ sex + ", password=" + password + ", email=" + email
				+ ", grouptype=" + grouptype + ", wealthvalue=" + wealthvalue
				+ ", role=" + role + ", creditvalue=" + creditvalue
				+ ", state=" + state + ", registerTime=" + registerTime
				+ ", blockedTime=" + blockedTime + ", signnumber=" + signnumber
				+ ", userinfo=" + userinfo + ", image=" + image + "]";
	}

}
