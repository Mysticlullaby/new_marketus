<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <head>
    <style>
      .custom-container {
        padding: 40px;
      }
    </style>
  </head>
  
  <body class="p-3 m-0 border-0 bd-example m-0 border-0">
    <div class="border border-2 border-warning custom-container">
      <div class="col-sm-10">
        <h4>배송지 정보</h4>
        <label> 1. 성함 : ${member.member_name}</label><br/>
		<label> 2. 연락처 : ${member.phone_number}</label><br/>
          3. 주소
        <input
          type="address"
          class="form-control form-control-sm"
          id="address"
          placeholder="원하는 배송지를 입력하세요."/>
        <br/>
  	  </div>
  	   
        <h4>상품목록</h4>
        <div class="col-md-6">     
            <strong>총 금액 :</strong>
        </div>
        <br/>

        <h4>구매 후 적립포인트</h4>
        <div class="col-md-6">
          <p>${member.point}</p>
        </div>
        <br/>

        <button type="button" class="btn btn-outline-warning">결제하기</button><br/>    
    </div>
    
  </body>
