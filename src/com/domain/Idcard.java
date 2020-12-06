package com.domain;

import java.util.Date;

/**
 * Idcard entity. @author MyEclipse Persistence Tools
 */

public class Idcard implements java.io.Serializable {

	// Fields

	private Integer id;
	private Person person;
	private Date validateDte;

	// Constructors

	/** default constructor */
	public Idcard() {
	}

	/** minimal constructor */
	public Idcard(Person person) {
		this.person = person;
	}

	/** full constructor */
	public Idcard(Person person, Date validateDte) {
		this.person = person;
		this.validateDte = validateDte;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getValidateDte() {
		return this.validateDte;
	}

	public void setValidateDte(Date validateDte) {
		this.validateDte = validateDte;
	}

}