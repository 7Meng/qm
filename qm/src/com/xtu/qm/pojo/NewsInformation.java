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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 动态等消息
 * @author feng
 *
 */
@Entity(name="NewsInformation")
@Table(name="tbl_news")
public class NewsInformation implements Serializable{

	/**
	 * 消息ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="newsid")
	private long id;
	
	/**
	 * 发布者
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="accountId")
	private AccountInfo author;
	
	/**
	 * 发布时间
	 */
	@Column(name="releasetime",unique=false,nullable=true,length=5000)
	private Date releasetime;
	/**
	 * 发布图片列表
	 */
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="newsid")
	private List<UserImage> userimage;
	/**
	 * 阅读量
	 */
	@Column(name="readnumber",unique=false,nullable=true,length=5000)
	private int readnumber;
	/**
	 * 发布内容
	 */
	@Column(name="content",unique=false,nullable=true,length=5000)
	private String content;
	/**
	 * 发布类型
	 * 如动态 失物招领
	 */
	public enum NewsInfoType {
		DYNAMIC
	}
	@Column(name="type",unique=false,nullable=true,length=5000)
	private NewsInfoType type;
	/**
	 * 发布者名片信息
	 */
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="cardid")
	private Card card;
	/**
	 * 赞列表
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="newsid")
	private List<zanInformation> zaninform;
	
	/**
	 * 回复列表
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="newsid")
	private List<responseInformation> response;

	
	public NewsInformation() {
		super();
	}

	public NewsInformation(long id, Date releasetime,
			List<UserImage> userimage, int readnumber, String content,
			NewsInfoType type, Card card, List<zanInformation> zaninform,
			List<responseInformation> response, AccountInfo author) {
		super();
		this.id = id;
		this.releasetime = releasetime;
		this.userimage = userimage;
		this.readnumber = readnumber;
		this.content = content;
		this.type = type;
		this.card = card;
		this.zaninform = zaninform;
		this.response = response;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getReleasetime() {
		return releasetime;
	}

	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}

	public List<UserImage> getUserimage() {
		if(null==userimage)
		{
			userimage=new ArrayList();
		}
		return userimage;
	}

	public void setUserimage(List<UserImage> userimage) {
		this.userimage = userimage;
	}

	public int getReadnumber() {
		return readnumber;
	}

	public void setReadnumber(int readnumber) {
		this.readnumber = readnumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public NewsInfoType getType() {
		return type;
	}

	public void setType(NewsInfoType type) {
		this.type = type;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public List<zanInformation> getZaninform() {
		if(null==zaninform)
		{
			zaninform=new ArrayList();
		}
		return zaninform;
	}

	public void setZaninform(List<zanInformation> zaninform) {
		this.zaninform = zaninform;
	}

	public List<responseInformation> getResponse() {
		if(null==response)
		{
			response=new ArrayList();
		}
		return response;
	}

	public void setResponse(List<responseInformation> response) {
		this.response = response;
	}
	
	public void setAuthor(AccountInfo author) {
		this.author = author;
	}
	
	public AccountInfo getAuthor() {
		return this.author;
	}

	@Override
	public String toString() {
		return "NewsInformation [id=" + id + ", releasetime=" + releasetime
				+ ", userimage=" + userimage + ", readnumber=" + readnumber
				+ ", content=" + content + ", type=" + type + ", card=" + card
				+ ", zaninform=" + zaninform + ", response=" + response + "]";
	}
	
	
}
