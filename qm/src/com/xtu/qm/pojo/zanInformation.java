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
import javax.persistence.Table;
/**
 * 点赞信息
 * @author feng
 *
 */
@Entity(name="zanInformation")
@Table(name="tbl_zaninfo")
public class zanInformation implements Serializable{

	/**
	 * 点赞ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="zaninfoid")
	private long id;
	/**
	 * 点赞数量
	 */
	@Column(name="zannumber",unique=false,nullable=true,length=5000)
	private int zannumber;
	/**
	 * 点赞用户信息列表
	 */
	@OneToMany(fetch=FetchType.LAZY,cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="zaninfoid")
	private List<AccountInfo> accountInfo;
	
	
	
	public zanInformation() {
		super();
	}
	public zanInformation(long id, int zannumber, List<AccountInfo> accountInfo) {
		super();
		this.id = id;
		this.zannumber = zannumber;
		this.accountInfo = accountInfo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getZannumber() {
		return zannumber;
	}
	public void setZannumber(int zannumber) {
		this.zannumber = zannumber;
	}
	public List<AccountInfo> getAccountInfo() {
		if(accountInfo==null)
		{
			accountInfo=new ArrayList();
		}
		return accountInfo;
	}
	public void setAccountInfo(List<AccountInfo> accountInfo) {
		this.accountInfo = accountInfo;
	}
	@Override
	public String toString() {
		return "zanInformation [id=" + id + ", zannumber=" + zannumber
				+ ", accountInfo=" + accountInfo + "]";
	}
	
	
}
