package member.dto;

import java.sql.Date;

public class MemberDTO {

	private String member_id; // 회원 아이디
	private String member_name; // 회원 이름
	private String password; // 비밀번호
	private String address; // 주소
	private String gender; // 성별
	private int age; // 나이
	private Date signup_date; // 로그인 날짜
	private String phone_number; // 핸드폰번호
	private String email; // 이메일
	private String grade; // 멤버 등급
	private int point; // 멤버 포인트
	
	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getSignup_date() {
		return signup_date;
	}

	public void setSignup_date(Date signup_date) {
		this.signup_date = signup_date;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public boolean matchPassword(String password) { // 패스워드 일치여부 확인용
		return this.password.equals(password);
	}
	
}//end class
