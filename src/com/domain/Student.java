package com.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer sid;
	private String sname;
	private String ssex;
	private String sdept;
	private Integer sage;
	private String saddress;
	private Set studcourses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Integer sid) {
		this.sid = sid;
	}

	/** full constructor */
	public Student(Integer sid, String sname, String ssex, String sdept,
			Integer sage, String saddress, Set studcourses) {
		this.sid = sid;
		this.sname = sname;
		this.ssex = ssex;
		this.sdept = sdept;
		this.sage = sage;
		this.saddress = saddress;
		this.studcourses = studcourses;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSsex() {
		return this.ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public String getSdept() {
		return this.sdept;
	}

	public void setSdept(String sdept) {
		this.sdept = sdept;
	}

	public Integer getSage() {
		return this.sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public String getSaddress() {
		return this.saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public Set getStudcourses() {
		return this.studcourses;
	}

	public void setStudcourses(Set studcourses) {
		this.studcourses = studcourses;
	}

}