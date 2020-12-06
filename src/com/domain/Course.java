package com.domain;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String cname;
	private String ccredit;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(Integer cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Course(Integer cid, String cname, String ccredit) {
		this.cid = cid;
		this.cname = cname;
		this.ccredit = ccredit;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCcredit() {
		return this.ccredit;
	}

	public void setCcredit(String ccredit) {
		this.ccredit = ccredit;
	}

}