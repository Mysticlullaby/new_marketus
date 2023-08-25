<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <style>
      .table {
        border-collapse: collapse;
        width: 100%;
        border: 1px solid #94b9f3;
      }
      .table th,table td {
        border: 1px solid #c5e1de;
        padding: 8px;
        text-align: center;
      }
      .table th {
        background-color: #c5e1de;
      }
  </style>

 <br/>
    <div>
      <table class="table table-hover table-bordered">
        <thead>
          <tr style="background-color: #c5e1de">
            <th>주문상태</th>
            <th>주문번호</th>
            <th>회원 ID</th>
            <th>주문상품</th>
          </tr>
        </thead>
        <tbody id="area_tbody"></tbody></table>
        <script>
    	function viewMessage(res){    	
    		$.each(res, function(index, element){
    	        var statusText = getStatusText(element.status);
    	        var orderID = element.order_id;
    	        var memberID = element.member_id;
    	        var productID = element.product_id;
    		 $('#area_tbody').append('<tr><td>'+element.statusText+'</td><td>'+element.orderID+'</td><td>'+element.memberID+'</td><td>'+element.productID+'</td></tr>');});
    		InOrder InProgress history   	 
    	}
    	
    	function getStatusText(status) {
    	    switch (status) {
    	        case 'InOrder':
    	            return '신규주문';
    	        case 'InProgress':
    	            return '배송중';
    	        case 'history':
    	            return '배송완료';
    	        default:
    	            return '알 수 없는 상태-확인바람';
    	    }
    	}
        </script>
    
     
    </div>
