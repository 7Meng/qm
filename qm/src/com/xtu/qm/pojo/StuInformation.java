package com.xtu.qm.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * ѧ����Ϣ
 * @author feng
 *
 */
@Entity(name="StuInformation")
@Table(name="tbl_stuInfo")
public class StuInformation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ѧ����ϢID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stuInforid")
	private long id;
	
	/**
	 * �û�����ѧԺ
	 */
	@Column(name="department",unique=false,nullable=true,length=5000)
	private String department;
	/**
	 * �û�����רҵ
	 */
	@Column(name="major",unique=false,nullable=true,length=5000)
	private String major;
	/**
	 * �û�ѧ��
	 */
	@Column(name="studentId",unique=false,nullable=true,length=5000)
	private String StudentId;
	/**
	 * �û���ѧ���
	 */
	@Column(name="entranceyear",unique=false,nullable=true,length=5000)
	private String entranceYear;
	
	
	public StuInformation() {
		super();
	}
	public StuInformation(long id, String department, String major,
			String studentId, String entranceYear) {
		super();
		this.id = id;
		this.department = department;
		this.major = major;
		StudentId = studentId;
		this.entranceYear = entranceYear;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	public String getEntranceYear() {
		return entranceYear;
	}
	public void setEntranceYear(String entranceYear) {
		this.entranceYear = entranceYear;
	}
	@Override
	public String toString() {
		return "StuInformation [id=" + id + ", department=" + department
				+ ", major=" + major + ", StudentId=" + StudentId
				+ ", entranceYear=" + entranceYear + "]";
	}
	
	
}
