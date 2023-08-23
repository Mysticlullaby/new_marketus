package member.dto;

// 로그인 성공 후 인증상태 정보를 세션에 보관할 때 사용
public class AuthInfo {  
	private String member_id;
	private String member_name;
	private String password;

	public AuthInfo() {
	}
	
	public AuthInfo(String member_id, String member_name) {
		super();
		this.member_id = member_id;
		this.member_name = member_name;
	}
	
	public AuthInfo(String member_id, String member_name, String password) {
		super();
		this.member_id = member_id;
		this.member_name = member_name;
		this.password = password;
	}
	
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
	
}//end class
