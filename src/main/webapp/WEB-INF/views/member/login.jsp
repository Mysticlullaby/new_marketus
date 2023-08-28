<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js" integrity="sha512-3gJwYpMe3QewGELv8k/BX9vcqhryRdzRMxVfq6ngyWXwo03GFEzjsUm8Q7RZcHPHksttq7/GFoxjCVUjkjvPdw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> 
<script type="text/javascript" src="../resources/js/jquery.cookie.js"></script>

<script>
	$(document).ready(function() {
		if ($.cookie("SAVE")) {
			$("#member_id").val($.cookie("SAVE"));
			$("#saveId").prop('checked', true);
		}

		$('#saveId').click(function() { //checkbox id값 지정
			let chk = $(this).is(":checked");
			console.log(chk);
			if (!chk) {
				$.removeCookie('SAVE', {path : '/'});
			}
		});
	});
</script>

<div class="login-wrapper">
  <h2>로그인</h2>
    <form method="post" action="login.do" id="login-form">
       <input type="text" name="member_id" id="member_id" placeholder="아이디를 입력해주세요"> <!-- dto에 입력된 멤버변수 이름과 동일한 네임값을 가져옴 -->
       <input type="password" name="password" id="password" placeholder="비밀번호를 입력해주세요">
       	 <label for="rememberCheck">
          <input type="checkbox" name="rememberId" id="saveId"> 아이디 저장하기
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
