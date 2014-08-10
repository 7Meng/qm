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
 * 私信
 * @author feng
 *
 */
@Entity(name="MailBox")
@Table(name="tbl_mailbox")
public class MailBox implements Serializable{

	/**
	 * 私信箱ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mailboxid")
	private long id;
	/**
	 * 名片
	 * 记录发送人 和接受者信息
	 */
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="cardid")
	private Card card;
	/**
	 * 组别
	 * 如(@我的人,未关注的人私信，私信等)
	 */
	@Column(name="grop",unique=false,nullable=true,length=5000)
	private String grop;
	/**
	 * 来源
	 * 如动态，行为等
	 */
	@Column(name="fromresource",unique=false,nullable=true,length=5000)
	private String fromresource;
	/**
	 * 私信内容列表
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="mailboxid")
	private List<ContentMessage> message;
	
	/**
	 * 私信状态
	 * 0 代表未读
	 * 1 代表已读
	 */
	@Column(name="state",unique=false,nullable=true,length=5000)
	private int state;
	
	/**
	 * @(我的动态消息)
	 */
	@OneToOne(fetch=FetchType.LAZY,cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="newsID")
	private NewsInformation news;


	public MailBox() {
		super();
	}

	public MailBox(long id, Card card, String grop, String fromresource,
			List<ContentMessage> message, int state, NewsInformation news) {
		super();
		this.id = id;
		this.card = card;
		this.grop = grop;
		this.fromresource = fromresource;
		this.message = message;
		this.state = state;
		this.news = news;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String getGrop() {
		return grop;
	}

	public void setGrop(String grop) {
		this.grop = grop;
	}

	public String getFromresource() {
		return fromresource;
	}

	public void setFromresource(String fromresource) {
		this.fromresource = fromresource;
	}

	public List<ContentMessage> getMessage() {
		if(null==message)
		{
			message=new ArrayList();
		}
		return message;
	}

	public void setMessage(List<ContentMessage> message) {
		this.message = message;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public NewsInformation getNews() {
		return news;
	}

	public void setNews(NewsInformation news) {
		this.news = news;
	}

	@Override
	public String toString() {
		return "MailBox [id=" + id + ", card=" + card + ", grop=" + grop
				+ ", fromresource=" + fromresource + ", message=" + message
				+ ", state=" + state + ", news=" + news + "]";
	}
	
	
	
}
