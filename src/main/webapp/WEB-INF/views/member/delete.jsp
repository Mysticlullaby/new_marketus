<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
  
<style type="text/css">
table {
	margin-left: auto;
	margin-right: auto;
	border: 2px solid black;
}
td {
	border: 2px solid black
}
#title {
	background-color: black
}
</style>

<body>
	<h2 align="center">회원탈퇴</h2>
	<br>
	<br>
	<br>
	<br>
	<br>	
	<form method="post" action="delete.do" name="delete" onsubmit="return checkValue()">
		<table>
			<tr>
				<td bgcolor="#ffbf2a">비밀번호 입력</td>
				<td><input type="password" name="password" maxlength="50"></td>
			</tr>
		</table>
	<br>
	<br>
	<br>
	<br>
		<input type="submit" class="btn btn-secondary" value="탈퇴" onclick="leave('member_id')"/> 
		<input type="button" value="취소" class="btn btn-warning" onclick="javascript:window.location='../mainhome.do'" />
	</form>
	
<script type="text/javascript">
	function checkValue() {
		if (!document.deleteform.password.value) {
			alert("비밀번호를 입력하지 않았습니다.");
			return false;
		}
	}
</script>

<script>
function leave(member_id) {
	if(window.confirm(member_id + "님 탈퇴되었습니다.")){
	location.href="mainhome.do";
	}
}
</script>

</body>

