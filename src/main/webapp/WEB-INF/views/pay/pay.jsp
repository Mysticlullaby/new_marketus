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
        <p>
          1. 성함 : ${member.member_name}<br/>
          2. 핸드폰 번호 : ${member.phone_number}<br/>
          3. 주소
        <input
          type="address"
          class="form-control form-control-sm"
          id="address"
          placeholder="원하는 배송지를 입력하세요."/>
        </p> <br/>

        <h4>상품목록</h4>
        <div class="col-md-6">
          <p>
            &#x25CF; 포인트 할인 : <br/>
            &#x25CF; 총 금액 :
          </p>
        </div>
        <br/>

        <h4>구매 후 적립포인트</h4>
        <div class="col-md-6">
          <p>${member.point}</p>
        </div>
        <br/>

        <h4>결제수단</h4>
         <div class="form-check">
          <input
            class="form-check-input"
            type="checkbox"
            value=""
            id="flexCheckChecked" checked/>
          신용카드
        </div>
        
        <div class="form-check">
          <input
            class="form-check-input"
            type="checkbox"
            value=""
            id="flexCheckChecked"/>
          계좌 간편결제
        </div>
        <div class="form-check">
          <input
            class="form-check-input"
            type="checkbox"
            value=""
            id="flexCheckDefault"/>
          네이버 페이
        </div>
        <div class="form-check">
          <input
            class="form-check-input"
            type="checkbox"
            value=""
            id="flexCheckDefault">
          카카오 페이
        </div> <br/>
        <button type="button" class="btn btn-outline-warning">결제하기</button><br/>
        <input class="addressee_input" value="${member.member_Name}" type="hidden">
		<input class="address_input" type="hidden" value="${member.memberAddr1}">
      </div>  
    </div>
    
  </body>
