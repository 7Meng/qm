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
@Entity(name="responseInformation")
@Table(name="tbl_response")
public class responseInformation implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="responseid")
	private long id;
	/**
	 * 回复者名片
	 */
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="cardid")
	private Card card;
	
	/** 
	 * 回复时间
	 */
	@Column(name="responsetime",unique=false,nullable=true,length=5000)
	private Date responsetime;
 
	/**
	 * 回复信息列表
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="responseid")
	private List<ContentMessage> message;

	public responseInformation() {
		super();
	}

	public responseInformation(long id, Card card, Date responsetime,
			List<ContentMessage> message) {
		super();
		this.id = id;
		this.card = card;
		this.responsetime = responsetime;
		this.message = message;
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

	public Date getResponsetime() {
		return responsetime;
	}

	public void setResponsetime(Date responsetime) {
		this.responsetime = responsetime;
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

	@Override
	public String toString() {
		return "responseInformation [id=" + id + ", card=" + card
				+ ", responsetime=" + responsetime + ", message=" + message
				+ "]";
	}
	
	
}
