<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<head>
	<script defer src="../resources/js/passwordCheck.js"/></script>
</head>

<body>
<h2 align="center">회원정보수정</h2>
	<form class="row g-3" action="edit.do" method="post">
      <div class="col-md-7">
        <label for="member_id" class="form-label">회원 아이디</label>
        <input
          type="text" class="form-control" id="member_id" name="member_id" value="${memberDTO.member_id}" 
          readonly>
      </div>
	
	<div class="col-md-6">
        <label for="password" class="form-label">비밀번호</label>
        <input
          type="password" class="form-control" id="password" name="password"
          pattern="[a-zA-Z0-9]{8,15}" 
          placeholder=" 변경할 비밀번호를 입력해주세요(영문,숫자 8~15자)" required>
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
          type="text" class="form-control" id="member_name" name="member_name" value="${memberDTO.member_name}"
          pattern="[가-힣]{3,7}" required />
      </div>
      
      <div class="col-md-6">
        <label for="phone_number" class="form-label">휴대폰</label>
        <input
          type="text" class="form-control" id="phone_number" name="phone_number" value="${memberDTO.phone_number}"
          required />
      </div>
      
      <div class="col-md-6">
        <label for="address" class="form-label">주소</label>
        <input
          type="text" class="form-control" id="address" name="address" value="${memberDTO.address}"
          required />
      </div>
      
      <div class="col-md-6">
        <label for="email" class="form-label">이메일</label>
        <input
          type="text" class="form-control" id="email" name="email" value="${memberDTO.email}"
          pattern="[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}"
          required />
      </div>
	  
	   <div class="col-12">
		 <input type="submit" class="btn btn-warning" value="수정하기" />
		 <button type="button" class="btn btn-secondary" onclick="javascript:window.location='./delete.do'">탈퇴하기</button>
		</div>
	</form>

</body>
