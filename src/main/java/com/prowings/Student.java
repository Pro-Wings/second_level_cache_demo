package com.prowings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@NamedQuery(name = "my_first_named_query", query = "From Student")
@NamedNativeQuery(name = "my_first_named_native_query", query = "select * from MY_STUDENT",resultClass=Student.class)

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="student")
@Table(name = "MY_STUDENT")
public class Student {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long studentId;
	@Column(name = "FNAME")
	private String firstName;
	@Column(name = "LNAME")
	private String lastName;
	@Column(name = "CONTACT_NO")
	private String contactNo;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNo=" + contactNo + "]";
	}

}