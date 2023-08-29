<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script defer src="../resources/js/passwordCheck.js"/></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
 $(document).ready(function() {
	 let idDupAvailable = false;
	 
	 $("#member_id").keyup(function(){
		 let member_id = $("#member_id").val();	 
		 
		 $.ajax({
			 url : "http://localhost:8090/marketus/member/idCheck.do",
			 type : "post",
			 data : {member_id: member_id},
			 dataType : 'json',
			 success : function(result){
				 if(result == 1){
					 $("#idCheck").html('중복된 아이디입니다.');
					 $("#idCheck").attr('color', 'red');
				 } else {
					 $("#idCheck").html('사용가능한 아이디입니다.');
					 $("#idCheck").attr('color', 'green');
				 }
			 },
			 error : function(){
				 alert("서버 요청 실패");
			 }
		 })
	 })

 	// 아이디 입력필드를 벗어날 때 중복 알림을 초기화
    $("#member_id").focusout(function() {
        $("#idCheck").html(''); // 알림 초기화
        idDupAvailable = false; // 아이디 중복 여부 초기화
    });  
	 
	// 회원가입 버튼 클릭 이벤트 처리
	    $("#signupSubmit").click(function() {
	        if (!idDupAvailable) {
	            alert("아이디가 중복되어 회원가입할 수 없습니다.");
	            return false; // 회원가입 불가능 상태로 폼 제출 방지
	        }
	    })
	})
</script>

<form class="row g-3" action="signup.do" method="post">
  <div class="col-md-7">
    <label for="member_id" class="form-label">아이디</label>
    <input
      type="text" class="form-control" id="member_id" name="member_id"
      pattern="[A-Za-z0-9]{3,8}"
      placeholder="아이디를 입력해주세요(영문,숫자 3~8자)" required>
      <font id="idCheck" size="2"></font>
  </div>
  
  <div class="col-md-6">
    <label for="password" class="form-label">비밀번호</label>
    <input
      type="password" class="form-control" id="password" name="password"
      pattern="[a-zA-Z0-9]{8,15}"
      placeholder="비밀번호를 입력해주세요(영문,숫자 8~15자)" required>
  </div>
  
  <div class="col-md-6">
    <label for="passwordcheck" class="form-label">비밀번호 확인</label>
    <input
      type="password" class="form-control" id="passwordcheck"
      placeholder="비밀번호를 한번 더 입력해주세요" required>
      <div id="passwordMismatch" style="color: red;"></div>
     </div>
           
     <div class="col-md-6">
       <label for="member_name" class="form-label">이름</label>
       <input
         type="text" class="form-control" id="member_name" name="member_name"
         pattern="[가-힣]{3,7}"
         placeholder="이름을 입력해주세요(한글 3~7자)" required/>
     </div>
     
     <div class="col-md-6">
       <label for="phone_number" class="form-label">휴대폰</label>
       <input
         type="text" class="form-control" id="phone_number" name="phone_number"
         pattern="[0-9]{10,11}"
         placeholder="예) 01012345678" required/>
     </div>
     
     <div class="col-md-6">
       <label for="address" class="form-label">주소</label>
       <input
         type="text" class="form-control" id="address" name="address"
         placeholder="예) 서울특별시 서초구 서초대로 77길 54 서초터블유타워 13층" required/>
     </div>
     
     <div class="col-md-6">
       <label for="email" class="form-label">이메일</label>
       <input
         type="text" class="form-control" id="email" name="email"
         pattern="[A-Za-z0-9]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}"
         placeholder="예) MarketUS@marketus.com" required>
     </div>
     
     <div class="col-md-3">
       <label for="age" class="form-label">나이</label>
       <input
         type="text" class="form-control" id="age" name="age"
         pattern=[0-9]{2,3}
         placeholder="나이를 입력해주세요(숫자 2~3자)" required>
  </div>
        
 	<label class="form-label">성별</label>
   <div class="col-md-3">
   	<input type='radio' name='gender' value='남' checked="checked" />남성
	<input type='radio' name='gender' value='여' />여성
</div>
     
     <div class="col-12">
       <button type="submit" class="btn btn-warning" id="signupSubmit">가입하기</button>
     </div>
   </form>
