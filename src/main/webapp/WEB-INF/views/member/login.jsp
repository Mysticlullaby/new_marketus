<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> -->
<script src="https://code.jquery.com/jquery-1.10.2.min.js"/></script>

<script>
	$(document).ready(function() {
		if ($.cookie("RememberId")) {
			$("#member_id").val($.cookie("RememberId"));
			$("#rememberCheck").prop('checked', true);
		}

		$('#rememberCheck').click(function() {
			let chk = $(this).is(":checked");
			console.log(chk);
			if (!chk) {
				$.removeCookie('RememberId', {path : '/'});
			}
		});
	});
</script>

<div class="login-wrapper">
  <h2>로그인</h2>
    <form method="post" action="login.do" id="login-form">
       <input type="text" name="member_id" id="member_id" value="${cookie.RememberId.value}" placeholder="아이디를 입력해주세요"> <!-- dto에 입력된 멤버변수 이름과 동일한 네임값을 가져옴 -->
       <input type="password" name="password" id="password" placeholder="비밀번호를 입력해주세요">
       	 <label for="rememberCheck">
          <input type="checkbox" name="rememberCheck"> 아이디 저장하기
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
