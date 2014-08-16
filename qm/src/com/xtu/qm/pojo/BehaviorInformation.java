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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 发布的行为消息
 * @author feng
 *
 */
@Entity(name="BehaviorInformation")
@Table(name="tbl_behavior")
public class BehaviorInformation implements Serializable{

	/**
	 * 行为ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="behaviorid")
	private long id;
	/**
	 * 发布内容
	 */
	@Column(name="content",unique=false,nullable=true,length=5000)
	private String content;
	/**
	 * 发布时间
	 */
	@Column(name="releasetime",unique=false,nullable=true,length=5000)
	private Date releasetime;
	/**
	 * 发布图片
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@Column(name="behaviorid")
	private List<UserImage> image;
	/** 
	 * 阅读量
	 */
	@Column(name="readnumber",unique=false,nullable=true,length=5000)
	private int readnumber;
	/**
	 * 有效时间
	 */
	@Column(name="effectivetime",unique=false,nullable=true,length=5000)
	private int effectivetime;
	/**
	 *匿名发布
	 */
	@Column(name="name",unique=false,nullable=true,length=5000)
	private String name;
	
	public BehaviorInformation() {
		super();
	}
	
	public BehaviorInformation(long id, String content, Date releasetime,
			List<UserImage> image, int readnumber, int effectivetime,
			String name) {
		super();
		this.id = id;
		this.content = content;
		this.releasetime = releasetime;
		this.image = image;
		this.readnumber = readnumber;
		this.effectivetime = effectivetime;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReleasetime() {
		return releasetime;
	}
	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
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
	public int getReadnumber() {
		return readnumber;
	}
	public void setReadnumber(int readnumber) {
		this.readnumber = readnumber;
	}
	public int getEffectivetime() {
		return effectivetime;
	}
	public void setEffectivetime(int effectivetime) {
		this.effectivetime = effectivetime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "BehaviorInformation [id=" + id + ", content=" + content
				+ ", releasetime=" + releasetime + ", image=" + image
				+ ", readnumber=" + readnumber + ", effectivetime="
				+ effectivetime + ", name=" + name + "]";
	}
	
	
}
