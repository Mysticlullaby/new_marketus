<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<header class="py-3 mb-4 border-bottom">
    <div class="container d-flex flex-wrap justify-content-center">
      <a href="http://localhost:8090/marketus/mainhome.do" class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto link-body-emphasis text-decoration-none">
        <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
        <span class="fs-4">MarketUs</span>
      </a>
    </div>
</header>

    <nav class="py-2 border-bottom" style="background-color: #b6c3a2">
      <div class="container d-flex flex-wrap">
        <ul class="nav me-auto">
          <p style="color: white; font-size: 25px; padding-right:20px;">Management</p>
          <div>
            <a href="http://localhost:8090/marketus/MgPage.do"
              class="nav-link px-2"
              style="color: white; font-weight: 600; padding 10px; padding-right:10px;">주문관리</a>
		  </div>
		  <div>
            <a href="http://localhost:8090/marketus/mgreview.do"
              class="nav-link px-2"
              style="color: white; font-weight: 600; padding 10px;">리뷰관리</a>
          </div>
        </ul>
      </div>
    </nav>
