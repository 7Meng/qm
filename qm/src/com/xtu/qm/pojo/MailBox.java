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
 * ˽��
 * @author feng
 *
 */
@Entity(name="MailBox")
@Table(name="tbl_mailbox")
public class MailBox implements Serializable{

	/**
	 * ˽����ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mailboxid")
	private long id;
	/**
	 * ��Ƭ
	 * ��¼������ �ͽ�������Ϣ
	 */
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="cardid")
	private Card card;
	/**
	 * ���
	 * ��(@�ҵ���,δ��ע����˽�ţ�˽�ŵ�)
	 */
	@Column(name="grop",unique=false,nullable=true,length=5000)
	private String grop;
	/**
	 * ��Դ
	 * �綯̬����Ϊ��
	 */
	@Column(name="fromresource",unique=false,nullable=true,length=5000)
	private String fromresource;
	/**
	 * ˽�������б�
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="mailboxid")
	private List<ContentMessage> message;
	
	/**
	 * ˽��״̬
	 * 0 ����δ��
	 * 1 �����Ѷ�
	 */
	@Column(name="state",unique=false,nullable=true,length=5000)
	private int state;
	
	/**
	 * @(�ҵĶ�̬��Ϣ)
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
