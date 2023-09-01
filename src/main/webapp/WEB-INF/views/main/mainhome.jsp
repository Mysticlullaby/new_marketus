<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <style>
        #ig {
            width:1200px;
            hight:100%;}
    </style>

<div class="div">
        <img id="ig" src="resources/image/mainhome.png">
    </div>
    
    <div class="mt-5">
   	  <p style="margin-top: 30px; color: white; background: gold; font-size: 20px;">주간 인기상품</p>
</div>
    
  <!--  상품 카드 출력 -->

	<div class="container" style="margin-top: 30px;">
	  <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-md-4 g-4">
	     <c:forEach items="${shopList}" var="dto">
	      <div class="col">
	        <div class="card shadow-sm" style="width: 100%">
	          <div style="overflow: hidden; height: 300px; margin: 0 auto;">
	            <c:url var="path" value="shop/product.do">
	              <c:param name="product_id" value="${dto.product_id}" />
	            </c:url>
	            <a href="${path}" class="strected-link">
	              <img class="card-img-top" src="./resources/image/${dto.product_id}.jpg" alt="${dto.product_name}" 
	                style="width: 100%; height: 100%; object-fit: cover;" />
	            </a>
	          </div>
	          <div class="card-body">
	            <h6 class="card-title">
	              <strong>${dto.product_name}</strong>
	            </h6>
	            <p class="card-text">${dto.price} \</p>
	          </div>
	        </div>
	      </div>
	     </c:forEach>
	  </div>
	</div>

    <div>
   	  <p style="margin-top: 30px; color: white; background: gold; font-size: 20px;">월간 인기상품</p>
    </div>
    
    <div class="container" style="margin-top: 30px;">
  	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-md-4 g-4">
     <c:forEach items="${shopList}" var="dto">
      <div class="col">
        <div class="card shadow-sm" style="width: 100%">
          <div style="overflow: hidden; height: 300px; margin: 0 auto;">
            <c:url var="path" value="shop/product.do">
              <c:param name="product_id" value="${dto.product_id}" />
            </c:url>
            <a href="${path}" class="strected-link">
              <img class="card-img-top" src="./resources/image/${dto.product_id}.jpg" alt="${dto.product_name}" 
                style="width: 100%; height: 100%; object-fit: cover;" />
            </a>
          </div>
          <div class="card-body">
            <h6 class="card-title">
              <strong>${dto.product_name}</strong>
            </h6>
            <p class="card-text">${dto.price} \</p>
          </div>
        </div>
      </div>
     </c:forEach>
  </div>
</div>

    
    <div class="mt-5">
   	  <p style="margin-top: 30px; color: white; background: gold; font-size: 20px;">월간 인기상품</p>
</div>
    
  	<!--  상품 카드 출력 -->

<div class="container" style="margin-top: 30px;">
  <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-md-4 g-4">
    <c:forEach items="${shopListM}" var="dto">
      <div class="col">
        <div class="card shadow-sm" style="width: 100%">
          <div style="overflow: hidden; height: 300px; margin: 0 auto;">
            <c:url var="path" value="shop/product.do">
              <c:param name="product_id" value="${dto.product_id}" />
            </c:url>
            <a href="${path}" class="strected-link">
              <img class="card-img-top" src="./resources/image/${dto.product_id}.jpg" alt="${dto.product_name}" 
                style="width: 100%; height: 100%; object-fit: cover;" />
            </a>
          </div>
          <div class="card-body">
            <h6 class="card-title">
              <strong>${dto.product_name}</strong>
            </h6>
            <p class="card-text">${dto.price} \</p>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>

