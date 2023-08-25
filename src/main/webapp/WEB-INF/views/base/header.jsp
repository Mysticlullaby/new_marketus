<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<header class="py-3 mb-4 border-bottom">
    <div class="container flex-wrap justify-content-center">
      <a href="${pageContext.request.contextPath}/mainhome.do" class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto link-body-emphasis text-decoration-none">
        <span class="fs-4">MarketUs</span>
      </a>
    </div>
</header>

<nav class="py-2 border-bottom" style="background-color: #ffbf2a;">
  <div class="container d-flex flex-wrap">
    <ul class="nav me-auto">
      <li class="nav-item">
        <form class="col-12 col-lg-auto mb-3 mb-lg-0" role="search">
                <input type="search" class="form-control" placeholder="상품 찾기" aria-label="Search">
        </form>        
      </li>   
      <li class="nav-item"><a href="#" class="nav-link px-2 active" aria-current="page" style="color: white;font-weight: 600;" ></a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2" style="color: white;font-weight: 600;">레시피</a></li>
      <li class="nav-item"><a href="${pageContext.request.contextPath}/shop.do" class="nav-link px-2" style="color: white;font-weight: 600;">마켓</a></li>
      <li class="nav-item"><a href="${pageContext.request.contextPath}/store_info.do" class="nav-link px-2" style="color: white;font-weight: 600;">매장안내</a></li>

    </ul>
    <ul class="nav">
    	<c:choose>
    		<c:when test="${sessionScope.authInfo == null}">
    			<li class="nav-item"><a href="${pageContext.request.contextPath}/member/login.do" class="nav-link px-2" style="color: white;font-weight: 700;">로그인</a></li>
      			<li class="nav-item"><a href="${pageContext.request.contextPath}/member/signup.do" class="nav-link px-2" style="color: white;font-weight: 700;">회원가입</a></li>
    		</c:when>
    		<c:otherwise>
    			<li class="nav-item"><span class="nav-link px-2" style="color: white;font-weight: 700;">어서오세요, ${sessionScope.authInfo.member_id}님!</span></li>
    			<li class="nav-item"><a href="${pageContext.request.contextPath}/member/logout.do" class="nav-link px-2" style="color: white;font-weight: 700;">로그아웃</a></li>
				<li class="nav-item"><a href="${pageContext.request.contextPath}/member/edit.do" class="nav-link px-2" style="color: white;font-weight: 700;">회원정보 수정</a></li>
      			<li class="nav-item">
      				<button type="button" onclick="location.href='${pageContext.request.contextPath}/member/cart.do';" class="btn btn-success ms-3">
                		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-fill" viewBox="0 0 16 16">
  							<path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"></path>
						</svg>
             		</button>
      			</li>    		
    		</c:otherwise>    
    	</c:choose>
    
      
    </ul>
  </div>
</nav>