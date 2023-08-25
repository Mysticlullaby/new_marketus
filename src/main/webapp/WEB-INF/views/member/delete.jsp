<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>	
</head>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#submit").on("click", function(){
				if($("#password").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#password").focus();
					return false;
				}
			});
		})
	</script>
	<body>
	<h2 align="center">회원탈퇴</h2>
		<section id="container">
			<form action="delete.do" method="post">
				<div class="form-group has-feedback">
					<label class="control-label" for="member_id">아이디</label>
					<input class="form-control" type="text" id="member_id" name="member_id" value="${authInfo.member_id}" readonly />
				</div>
				<br>
				<div class="form-group has-feedback">
					<label class="control-label" for="password">비밀번호</label>
					<input class="form-control" type="password" id="password" name="password" />
				</div>
				<div>
				<c:if test="${msg == false}">
					비밀번호가 맞지 않습니다.
				</c:if>
				</div>
				<br>				
				<div class="form-group has-feedback">
					<label class="control-label" for="member_name">이름</label>
					<input class="form-control" type="text" id="member_name" name="member_name" value="${authInfo.member_name}" readonly />
				</div>
				<br>
				<div class="form-group has-feedback">
					<button type="submit" id="submit" class="btn btn-secondary">회원탈퇴</button>
					<button type="button" class="btn btn-warning" onclick="javascript:window.location='../mainhome.do'">취소</button>
				</div>
			</form>
			
		</section>		
	</body>	
</html>