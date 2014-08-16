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
 * �˻���Ϣ
 * @author feng
 *
 */

@Entity(name="AccountInfo")
@Table(name="tbl_accountInfo")
public class AccountInfo implements Serializable{

	/**
	 * �˻�ID
	 * ����(Ψһ��ʶ)
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="accountid")
	private long id;
	/**
	 * �ǳ�(Ψһ)
	 */
	@Column(name="username",unique=false,nullable=true,length=5000)
	private String username;
	
	
	/**
	 * �û��Ա�
	 */
	@Column(name="sex",unique=false,nullable=true,length=5000)
	private String sex;
	
	
	/**
	 * �û���¼����
	 */
	@Column(name="password",unique=false,nullable=true,length=5000)
	private String password;
	/**
	 * ����(Ψһ)
	 */
	@Column(name="email",unique=false,nullable=true,length=5000)
	private String email;
	/**
	 * ���
	 */
	@Column(name="grouptype",unique=false,nullable=true,length=5000)
	private String grouptype;
	
	/**
	 * �û��Ƹ�ֵ
	 */
	@Column(name="wealthvalue",unique=false,nullable=true,length=5000)
	private int wealthvalue;
	
	/**
	 * ��ɫ(�����Ա,��ͨ�û�,��Ȩ�û���)
	 */
	@Column(name="role",unique=false,nullable=true,length=5000)
	private String role;
	/**
	 * ����ֵ
	 */
	@Column(name="creditvalue",unique=false,nullable=true,length=5000)
	private int creditvalue;
	
	/**
	 * 1������ע��
	 * 2�����û�����
	 */
	@Column(name="state",unique=false,nullable=true,length=5000)
	private int state;
	/**
	 * �û�ע��ʱ��
	 */
	@Column(name="registertime",unique=false,nullable=true,length=5000)
	private Date registerTime;
	
	/**
	 * �û�����ʱ��
	 */
	@Column(name="blocktime",unique=false,nullable=true,length=5000)
	private Date blockedTime;
	
	/**
	 * ����ǩ����¼
	 */
	@Column(name="signnumber",unique=false,nullable=true,length=5000)
	private int signnumber;
	/**
	 * �û���Ϣ
	 * �˻�����һ����װ�Լ����û�������Ϣ
	 * one to one
	 */
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
	private UserInfo userinfo;
	/**
	 * ѫ��ͼ
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
