package com.xtu.qm.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 名片信息
 * @author feng
 *
 */
@Entity(name="Card")
@Table(name="tbl_card")
public class Card implements Serializable{
	/**
	 * 名片ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cardid")
	private long id;
	/**
	 * 用户给定的备注
	 */
	@Column(name="remarks",unique=false,nullable=true,length=5000)
	private String remarks;
	/**
	 * 来源
	 * 如行为，动态等
	 */
	@Column(name="fromresourse",unique=false,nullable=true,length=5000)
	private String fromresource;
	/**
	 * 发送账户信息
	 */
   @OneToOne(fetch=FetchType.LAZY,cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
   @JoinColumn(name="proaccountid")
	private AccountInfo proAccount;
	/**
	 * 接受账户信息
	 */
    @OneToOne(fetch=FetchType.LAZY,cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="reaccountid")
	private AccountInfo reAccount;
	/**
	 * 发送时间
	 */
    @Column(name="protime",unique=false,nullable=true,length=5000)
	private Date protime;
	/**
	 * 是否公开备注
	 * 0 代表不公开
	 * 1 代表公开
	 * 默认为0
	 */
    @Column(name="ispublic",unique=false,nullable=true,length=5000)
	public int isPublic;
    
    
	public Card() {
		super();
	}
	public Card(long id, String remarks, String fromresource,
			AccountInfo proAccount, AccountInfo reAccount, Date protime,
			int isPublic) {
		super();
		this.id = id;
		this.remarks = remarks;
		this.fromresource = fromresource;
		this.proAccount = proAccount;
		this.reAccount = reAccount;
		this.protime = protime;
		this.isPublic = isPublic;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFromresource() {
		return fromresource;
	}
	public void setFromresource(String fromresource) {
		this.fromresource = fromresource;
	}
	public AccountInfo getProAccount() {
		return proAccount;
	}
	public void setProAccount(AccountInfo proAccount) {
		this.proAccount = proAccount;
	}
	public AccountInfo getReAccount() {
		return reAccount;
	}
	public void setReAccount(AccountInfo reAccount) {
		this.reAccount = reAccount;
	}
	public Date getProtime() {
		return protime;
	}
	public void setProtime(Date protime) {
		this.protime = protime;
	}
	public int getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}
	@Override
	public String toString() {
		return "Card [id=" + id + ", remarks=" + remarks + ", fromresource="
				+ fromresource + ", proAccount=" + proAccount + ", reAccount="
				+ reAccount + ", protime=" + protime + ", isPublic=" + isPublic
				+ "]";
	}
    
    
	
}
