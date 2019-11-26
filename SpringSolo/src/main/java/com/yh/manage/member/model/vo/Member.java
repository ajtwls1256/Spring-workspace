package com.yh.manage.member.model.vo;

import java.sql.Date;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberCompany;
	private Date memberEnrolldate;
	private String memberGrade;
	private String memberState;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Member(int memberNo, String memberId, String memberPw, String memberName, String memberPhone,
			String memberCompany, Date memberEnrolldate, String memberGrade, String memberState) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberCompany = memberCompany;
		this.memberEnrolldate = memberEnrolldate;
		this.memberGrade = memberGrade;
		this.memberState = memberState;
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberCompany() {
		return memberCompany;
	}
	public void setMemberCompany(String memberCompany) {
		this.memberCompany = memberCompany;
	}
	public Date getMemberEnrolldate() {
		return memberEnrolldate;
	}
	public void setMemberEnrolldate(Date memberEnrolldate) {
		this.memberEnrolldate = memberEnrolldate;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	public String getMemberState() {
		return memberState;
	}
	public void setMemberState(String memberState) {
		this.memberState = memberState;
	}

	

	
	
	
}
