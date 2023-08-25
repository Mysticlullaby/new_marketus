<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script type="text/javascript">
$(document).ready(function(){
	fn_login();
	fn_displayrememberChech();
});

	function fn_login() {
		$('#frm_login').submit(function(event){ // submit을 취소할 수 있게끔 event 객체를 잡아줌
			
			if($('#rememberCheck').is(':checked')) { // Java에서 쿠키를 처리하려면 Service에서 Cookie 클래스를 이용하여 request에 저장해주는 방식
				$.cookie('rememberCheck', $('#member_id').val()); // 쿠키이름, 값 순으로 저장
			} else {
				$.cookie('rememberCheck', '');
			}
		});
	}
	
	function fn_displayrememberCheck() {
		let rememberCheck = $.cookie('rememberCheck');
		if(rememberCheck == '') {
			$('#member_id').val('');
			$('#rememberCheck').prop('checked', false); // check 해제
		} else {
			$('#member_id').val('rememberCheck');
			$('rememberCheck').prop('checked', true);
		}
	}
</script>

<div class="login-wrapper">
  <h2>로그인</h2>
    <form method="post" action="login.do" id="login-form"> 
       <input type="text" name="member_id" placeholder="아이디를 입력해주세요"> <!-- dto에 입력된 멤버변수 이름과 동일한 네임값을 가져옴 -->
       <input type="password" name="password" placeholder="비밀번호를 입력해주세요">
       	 <label for="remember-check">
          <input type="checkbox" name="rememberCheck" id="rememberCheck"> 아이디 저장하기
         </label>
           <input type="submit" value="로그인">
           <button type="button" class="btn btn-secondary" onclick="goToSignupPage()">회원가입</button>
    </form>
</div>

<script>
function goToSignupPage() {
  window.location.href = "signup.do"; // 회원가입 버튼 클릭 시 signup page로 이동
}
</script> 

<c:if test="${not empty errorMessage}">
    <script>
    alert('${errorMessage}');
    </script>
</c:if>
