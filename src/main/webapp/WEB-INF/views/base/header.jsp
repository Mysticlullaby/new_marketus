<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<header class="py-3 mb-4 border-bottom">
    <div class="container d-flex flex-wrap justify-content-center">
      <a href="/" class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto link-body-emphasis text-decoration-none">
        <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
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
      <li class="nav-item"><a href="#" class="nav-link px-2" style="color: white;font-weight: 600;">마켓</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2" style="color: white;font-weight: 600;">매장안내</a></li>

    </ul>
    <ul class="nav">
      <li class="nav-item"><a href="#" class="nav-link px-2" style="color: white;font-weight: 700;">로그인</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2" style="color: white;font-weight: 700;">회원가입</a></li>
    </ul>
  </div>
</nav>