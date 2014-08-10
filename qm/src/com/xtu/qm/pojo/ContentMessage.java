package com.xtu.qm.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 短消息信息
 * @author feng
 *
 */
@Entity(name="ContetnMessage")
@Table(name="tbl_contentmassage")
public class ContentMessage implements Serializable{

	/**
	 * 短消息ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ctmsid")
	private long id;
	/**
	 * 短消息内容
	 */
	@Column(name="content",unique=false,nullable=true,length=5000)
	private String content;
	/**
	 * 短消息产生时间
	 */
	@Column(name="time",unique=false,nullable=true,length=5000)
	private Date time;
	/**
	 * 信息状态
	 * 0 未读
	 * 1 已读
	 */
	@Column(name="state",unique=false,nullable=true,length=5000)
	private int state;
	
	
	public ContentMessage() {
		super();
	}

	public ContentMessage(long id, String content, Date time, int state) {
		super();
		this.id = id;
		this.content = content;
		this.time = time;
		this.state = state;
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ContentMessage [id=" + id + ", content=" + content + ", time="
				+ time + ", state=" + state + "]";
	}
	
	
}
