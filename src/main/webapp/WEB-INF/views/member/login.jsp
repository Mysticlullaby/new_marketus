<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <div style= "text-align : center" >
    <img class = "image-fruid rounded" src="image/login_main.jpg" alt="" />         
</div> -->

<div class="login-wrapper">
  <h2>로그인</h2>
    <form method="post" action="login.do" id="login-form"> 
       <input type="text" name="member_id" placeholder="아이디를 입력해주세요"> <!-- dto에 입력된 멤버변수 이름과 동일한 네임값을 가져옴 -->
       <input type="password" name="password" placeholder="비밀번호를 입력해주세요">
       	 <label for="remember-check">
          <input type="checkbox" id="remember-check"> 아이디 저장하기
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
