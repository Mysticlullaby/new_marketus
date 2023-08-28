<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	$(document).ready(
			function(){
				$('#btnList').click(function(){
					$('#frm').attr('action','list.do');
					$('#frm').submit();
				});
				$("btnSave").click(
						function(){
							$('[name=content]').val(
									$('[name=content]').val().replace(/\n/gi,
											'<br/>'));
							$('#frm').attr('action,'write.do').submit();
						});
			});
</script>

<div class="container">
	<form name="frm" id="frm" method="post" enctype="multipart/form-data"></form>
	
		<table class="table table-border mt-1">
		
			<tr>
				<td width="20%" align="center">writer</td>
				<td><input type="hidden" name="member_id" value=""/><input
					type="text" name="member_id" size="30" maxlength="30"
					readonly="readonly" value="${sessionScope.authInfo.member_id}"/></td>
			</tr>
			
			<tr>
				<td width="20%" align="center">제목</td>
				<td><c:if test="${dto.ref !=0}">답변</c:if><input
					type="text" name="subject" size="40" /></td>
			</tr>
			
			<tr>
				<td width="20%" align="center">내용</td>
				<td><textarea name="content" rows="13" style="width: 100%"></textarea></td>
			</tr>
			
			<tr>
				<td width="20%" align="center">첨부파일</td>
				<td><input type="file" name="filename" id="filepath"/>
			</tr>		
		</table>
		
		<!-- 답변글일 때 -->
		<c:if test="${dto!=null}">
			<input type="hidden" name="board_id" value="${dto.board_id}"/>
			<input type="hidden" name="ref" value="${dto.ref}"/>
			<input type="hidden" name="re_step" value="${dto.re_step}"/>
			<input type="hidden" name="re_level" value="${dto.re_level}"/>
			<input type="hidden" name="currentPage" value="${pv.currentPage}"/>
		</c:if>
		
		<div class="text-center mt-5 mb-5">
			<input type="button" id="btnList" value="리스트"/><input
				type="button" id="btnSave" value="저장"/>
		</div>
	</form>
</div>
