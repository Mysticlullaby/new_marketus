<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<script>
	$(document).ready(function(){
		$('#list').click(function(){
			$('#frm').attr('action','list.do').submit(); //리스트
		}); //The action attribute in jQuery is used to specify the URL that a form will be submitted to. 
		    //The action attribute can be set using the attr() method.
		
		$('#answer').click(function(){
			$('#frm').attr('action','write.do').submit(); //답변
		});
		
		$('#update').click(function(){
			$('#frm').attr('action','update.do').submit();
		});
		
		$('#delete').click(function(){
			$('#frm').attr('action','delete.do').submit();
		});
	});
</script>
<div class="container">
	<table class="table table-bordered">
		<tr>
			<th width="20%">작성자</th>
			<td>${dto.memberDTO.member_id}</td>
			<th width="20%">조회수</th>
			<td>${dto.readcount}</td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td colspan="3">${dto.content}</td>
		</tr>
		
		<tr>
			<th>파일</th>
			<td colspan="3"><c:choose>
				<c:when test="">
					<c:out value="첨부파일 없음" />
				</c:when>
				
				<c:otherwise>
					<a href="contentsdownload.do?board_id=${dto.board_id}">${fn:substringAfter(dto.attachment,"_")}</a>
					<!-- 첨부파일명의 랜덤 스트링을 없애준다. -->
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
	</table>
	
	<div class="text-center mt-5 mb-5">
		<form name="frm" id="frm" method="get">
			<input type="hidden" name="board_id" value="${dto.board_id}" /><input
				type="hidden" name="currentPage" id="currentPage"
				value="${currentPage}" />
			<c:if test="${dto.ref !=0}">
				<input type="hidden" name="ref" value="${dto.ref}" />
				<input type="hidden" name="re_step" value="${dto.re_step}" />
				<input type="hidden" name="re_level" value="${dto.re_level}" />
			</c:if>
			
			<input type="button" id="list" value="리스트" /><input type="button"
				id="answer" value="답변" />
				
			<c:if 
				test="${sessionScope.authInfo !=null && sessionScope.authInfo.member_id==dto.member_id}">
				<input type="button" id="update" value="수정" />	
			</c:if>
		</form>
	</div>
</div>
