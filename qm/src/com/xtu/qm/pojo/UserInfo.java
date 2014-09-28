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
 * 用户信息
 * @author feng
 *
 */
@Entity(name="UserInfo")
@Table(name="tbl_userinfo")
public class UserInfo implements Serializable {

	/**
	 * 用于用户的唯一标识
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userinfoid")
	private long id;
	/**
	 * 用户年龄
	 */
	@Column(name="age",unique=false,nullable=true,length=5000)
	private int age;
	/**
	 * 用户生日
	 */
	@Column(name="birthday",unique=false,nullable=true,length=5000)
	private Date birthday;
	/**
	 * 用户生日历法
	 * 如公历 阴历
	 */
	@Column(name="birthdaytype",unique=false,nullable=true,length=5000)
	private String birthdayType;
	
	/**
	 * 学籍信息
	 */
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "stuInfoId")
	private StuInformation stuInfo;
	/**
	 * 用户个性签名
	 */
	@Column(name="signature",unique=false,nullable=true,length=5000)
	private String signature;

	/**
	 * 家乡住址
	 * 字符串格式：province&&city
	 */
	@Column(name="homeaddress",unique=false,nullable=true,length=5000)
	private String HomeAddress;
	
	/**
	 * 用户兴趣爱好
	 * 字符串格式：A&&B&&C
	 */
	@Column(name="interests",unique=false,nullable=true,length=5000)
	private String interests;
	/**
	 * 用户个人标签
	 * 如 娇小型
	 * 字符串格式：TypeA&&TypeB&&TypeC
	 */
	@Column(name="type",unique=false,nullable=true,length=5000)
	private String type;
	
	/**
	 * 用户真实姓名
	 */
	@Column(name="realname",unique=false,nullable=true,length=5000)
	private String realname;
	
	/**
	 * 用户有一个属于自己的个人空间
	 */
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="pspaceid")
    private PersonalSpace personalspace;
	/**
	 * 一个用户有一个属于自己的头像
	 * 相当于生活照
	 */
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="userimageid")
	private UserImage userimage;
	
	/**
	 * 用户头像，区别于生活照
	 */
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="userLogoid")
	private UserImage userLogo;
	
	/**
	 * 已关注列表
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="userinfoid")
	private List<Card> hasConcern;
	
	/**
	 * 被关注列表
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="userinfoid")
	private List<Card> isConcern;
	/**
	 * 相互关注列表
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="userinfoid")
	private List<Card> mutualConcern;
	
	/**
	 * 喜欢列表
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="userinfoid")
	private List<Card> likelist;
	/**
	 * 相互喜欢列表
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="userinfoid")
	private List<Card> mutuallikelist;
	/**
	 * 被喜欢列表
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="userinfoid")
	private List<Card> islikelist;
	/**
	 * 黑名单
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="userinfoid")
	private List<Card> blacklist;
	
	
	public UserInfo() {
		super();
	}
	public UserInfo(long id, int age, Date birthday, String birthdayType,
			String signature, String homeAddress, String interests,
			String type, String realname, PersonalSpace personalspace,
			UserImage userimage, List<Card> hasConcern, List<Card> isConcern,
			List<Card> mutualConcern, List<Card> likelist,
			List<Card> mutuallikelist, List<Card> islikelist,
			List<Card> blacklist, UserImage userLogo) {
		super();
		this.id = id;
		this.age = age;
		this.birthday = birthday;
		this.birthdayType = birthdayType;
		this.signature = signature;
		HomeAddress = homeAddress;
		this.interests = interests;
		this.type = type;
		this.realname = realname;
		this.personalspace = personalspace;
		this.userimage = userimage;
		this.hasConcern = hasConcern;
		this.isConcern = isConcern;
		this.mutualConcern = mutualConcern;
		this.likelist = likelist;
		this.mutuallikelist = mutuallikelist;
		this.islikelist = islikelist;
		this.blacklist = blacklist;
		this.userLogo = userLogo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getBirthdayType() {
		return birthdayType;
	}
	public void setBirthdayType(String birthdayType) {
		this.birthdayType = birthdayType;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getHomeAddress() {
		return HomeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		HomeAddress = homeAddress;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public PersonalSpace getPersonalspace() {
		return personalspace;
	}
	public void setPersonalspace(PersonalSpace personalspace) {
		this.personalspace = personalspace;
	}
	public UserImage getUserimage() {
		return userimage;
	}
	public void setUserimage(UserImage userimage) {
		this.userimage = userimage;
	}
	public List<Card> getHasConcern() {
		if(hasConcern==null)
		{
			hasConcern=new ArrayList();
		}
		return hasConcern;
	}
	public void setHasConcern(List<Card> hasConcern) {
		this.hasConcern = hasConcern;
	}
	public List<Card> getIsConcern() {
		if(null==isConcern)
		{
			isConcern=new ArrayList();
		}
		return isConcern;
	}
	public void setIsConcern(List<Card> isConcern) {
		this.isConcern = isConcern;
	}
	public List<Card> getMutualConcern() {
		if(null==mutualConcern)
		{
			mutualConcern=new ArrayList();
		}
		return mutualConcern;
	}
	public void setMutualConcern(List<Card> mutualConcern) {
		this.mutualConcern = mutualConcern;
	}
	public List<Card> getLikelist() {
		if(null==likelist)
		{
			likelist=new ArrayList();
		}
		return likelist;
	}
	public void setLikelist(List<Card> likelist) {
		this.likelist = likelist;
	}
	public List<Card> getMutuallikelist() {
		if(mutuallikelist==null)
		{
			mutuallikelist=new ArrayList();
		}
		return mutuallikelist;
	}
	public void setMutuallikelist(List<Card> mutuallikelist) {
		this.mutuallikelist = mutuallikelist;
	}
	public List<Card> getIslikelist() {
		if(null==islikelist)
		{
			islikelist=new ArrayList();
		}
		return islikelist;
	}
	public void setIslikelist(List<Card> islikelist) {
		this.islikelist = islikelist;
	}
	public List<Card> getBlacklist() {
		if(null==blacklist)
		{
			blacklist=new ArrayList();
		}
		return blacklist;
	}
	public void setBlacklist(List<Card> blacklist) {
		this.blacklist = blacklist;
	}
	
	public void setUserLogo(UserImage logo) {
		this.userLogo = logo;
	}
	
	public UserImage getUserLogo() {
		return this.userLogo;
	}
	
	public StuInformation getStuInfo() {
		return this.stuInfo;
	}
	
	public void setStuInfo(StuInformation info) {
		this.stuInfo = info;
	}
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", age=" + age + ", birthday=" + birthday
				+ ", birthdayType=" + birthdayType + ", signature=" + signature
				+ ", HomeAddress=" + HomeAddress
				+ ", interests=" + interests + ", type=" + type + ", realname="
				+ realname + ", personalspace=" + personalspace
				+ ", userimage=" + userimage + ", hasConcern=" + hasConcern
				+ ", isConcern=" + isConcern + ", mutualConcern="
				+ mutualConcern + ", likelist=" + likelist
				+ ", mutuallikelist=" + mutuallikelist + ", islikelist="
				+ islikelist + ", blacklist=" + blacklist + "]";
	}	
}
