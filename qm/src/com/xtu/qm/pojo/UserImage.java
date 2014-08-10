package com.xtu.qm.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * ͼ����Ϣ
 * @author feng
 *
 */
@Entity(name="UserImage")
@Table(name="tbl_userimage")
public class UserImage implements Serializable {

	/**
	 * ͼ��Ψһ��ʶ
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="imageid")
	private long id;
	
	/**
	 * �û���ͼ�������ͼurl
	 */
	@Column(name="smallimageurl",unique=false,nullable=true,length=5000)
	private String smallimageUrl;
	/**
	 * �û���ͼ��Ĵ�ͼ
	 */
	@Column(name="bigimageurl",unique=false,nullable=true,length=5000)
	private String bigimageUrl;
	
	
	public UserImage() {
		super();
	}
	
	
	public UserImage(long id, String smallimageUrl, String bigimageUrl) {
		super();
		this.id = id;
		this.smallimageUrl = smallimageUrl;
		this.bigimageUrl = bigimageUrl;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSmallimageUrl() {
		return smallimageUrl;
	}
	public void setSmallimageUrl(String smallimageUrl) {
		this.smallimageUrl = smallimageUrl;
	}
	public String getBigimageUrl() {
		return bigimageUrl;
	}
	public void setBigimageUrl(String bigimageUrl) {
		this.bigimageUrl = bigimageUrl;
	}
	@Override
	public String toString() {
		return "UserImage [id=" + id + ", smallimageUrl=" + smallimageUrl
				+ ", bigimageUrl=" + bigimageUrl + "]";
	}
	
	
	
	
}
