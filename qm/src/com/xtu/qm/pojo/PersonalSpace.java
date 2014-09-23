package com.xtu.qm.pojo;

import java.io.Serializable;
import java.util.ArrayList;
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
 * 个人空间
 * @author feng
 *
 */
@Entity(name="PersonlSpace")
@Table(name="tbl_personalspace")
public class PersonalSpace implements Serializable{

	/**
	 * 个人空间唯一的标识
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pspaceid")
	private long id;
	
	/**
	 * 用户个人空间封面配图
	 * 手机版
	 */
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="phoneimageid")
	private UserImage phoneimage;
	/**
	 * 电脑版封面图
	 */
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="computerimageid")
	private UserImage computerimage;
	/**
	 * 电脑版背景颜色
	 */
	@Column(name="bgcolor",unique=false,nullable=true,length=5000)
	private String bgcolor;
	/**
	 * 个人空间有多个动态
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="author")
	private List<NewsInformation> news;
	/**
	 * 个人空间有多个行为
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="pspaceid")
	private List<BehaviorInformation> behavior;
	
	
	public PersonalSpace() {
		super();
	}
	public PersonalSpace(long id, UserImage phoneimage,
			UserImage computerimage, String bgcolor,
			List<NewsInformation> news, List<BehaviorInformation> behavior) {
		super();
		this.id = id;
		this.phoneimage = phoneimage;
		this.computerimage = computerimage;
		this.bgcolor = bgcolor;
		this.news = news;
		this.behavior = behavior;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UserImage getPhoneimage() {
		return phoneimage;
	}
	public void setPhoneimage(UserImage phoneimage) {
		this.phoneimage = phoneimage;
	}
	public UserImage getComputerimage() {
		return computerimage;
	}
	public void setComputerimage(UserImage computerimage) {
		this.computerimage = computerimage;
	}
	public String getBgcolor() {
		return bgcolor;
	}
	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}
	public List<NewsInformation> getNews() {
		if(null==news)
		{
			news=new ArrayList();
		}
		return news;
	}
	public void setNews(List<NewsInformation> news) {
		this.news = news;
	}
	public List<BehaviorInformation> getBehavior() {
		if(null==behavior)
		{
			behavior=new ArrayList();
		}
		return behavior;
	}
	public void setBehavior(List<BehaviorInformation> behavior) {
		this.behavior = behavior;
	}
	
	@Override
	public String toString() {
		return "PersonalSpace [id=" + id + ", phoneimage=" + phoneimage
				+ ", computerimage=" + computerimage + ", bgcolor=" + bgcolor
				+ ", news=" + news + ", behavior=" + behavior + "]";
	}
	
	
}
