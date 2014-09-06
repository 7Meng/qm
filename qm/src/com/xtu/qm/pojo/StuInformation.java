package com.xtu.qm.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 学籍信息
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
	 * 学籍信息ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stuInforid")
	private long id;
	
	/**
	 * 用户所在学院
	 */
	@Column(name="department",unique=false,nullable=true,length=5000)
	private String department;
	/**
	 * 用户所在专业
	 */
	@Column(name="major",unique=false,nullable=true,length=5000)
	private String major;
	/**
	 * 用户学号
	 */
	@Column(name="studentId",unique=false,nullable=true,length=5000)
	private String StudentId;
	/**
	 * 用户入学年份
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
