<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
	<div id="bodywrap">
		
		<table class="table table-border mt-1">
			<tr>
				<th class="col-md-1 text-center">번호</th>
				<th class="col-md-1 text-left">제목</th>
				<th class="col-md-2 text-center">작성자</th>
				<th class="col-md-2 text-center">조회수</th>
			</tr>
			
			<c:forEach items="${boardList}" var="dto">
			<!-- 제목 시작 -->
				<tr>
					<td class="text-center">${dto.board_id}</td>
					<td class="text-left"><c:url var="path" value="view.do">
							<c:param name="board_id" value="${dto.board_id}" />
							<c:param name="currentPage" value="${pv.currentPage}" />
						</c:url><c:if test="${dto.re_level > 0}">
					 		<img src="../resources/image/level.gif"
					 			width="${10*dto.re_level}" height="15" />
					 		<img src="../resources/images/re.gif" />
						</c:if><a href="${path}">${dto.subject}</a></td>
					<!-- 제목출력 -->
					<td class="text-center">${dto.memberDTO.member_id}</td>
					<td class="text-center">${dto.readcount}</td>
				</tr>
			<!-- 제목끝 -->
		
			</c:forEach>
		</table>
		
		<ul class="pagination justify-content-center mt-5 mb-4">
		
			<!-- 이전 출력 시작 -->
			<li><a class="page-link"
				href="list.do?currentPage=${pv.startPage-1}">Prev</a>
			</li>
			<!-- 이전 출력 끝 -->
			<!-- 페이지 출력 시작 -->
			<c:forEach var="i" begin="${pv.startPage}" end="${pv.endPage}">
				<li><c:choose>
						<c:when test="${i==pv.currentPage}">
							<a class="page-link page-item active"
								href="list.do?currentPage=${i}">${i}</a>
						</c:when>
						<c:otherwise>
							<a class="page-link" href="list.do?currentPage=${i}">${i}</a>
						</c:otherwise>
					</c:choose></li>
			</c:forEach>
			<!-- 페이지 출력끝 -->
			
			<!-- 다음 출력 시작 -->
			<c:if test="${pv.endPage < pv.totalPage}">
				<li><a class="page-link"
					href="list.do?currentPage=${pv.startPage + pv.blockPage}">Next</a></li>
			</c:if>
			<!-- 다음 출력 끝 -->
		</ul>
		
		<ul class="nav justify-content-center mb-1 mt-1">
		<form id="frm" method="get" action="write.do">
			<input type="submit" id="btnWrite" class="btn btn-outline-warning" value="글쓰기" />
		</form>
		</ul>
	</div>
</body>
</html>