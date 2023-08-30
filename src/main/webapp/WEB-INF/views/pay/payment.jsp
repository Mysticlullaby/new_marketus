<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
  <meta charset="utf-8" />
  <!-- 결제위젯 SDK 추가 -->
  <script src="https://js.tosspayments.com/v1/payment-widget"></script>
</head>

<body>
<h3 align="center">주문/결제</h3>
  <!-- 결제위젯, 이용약관 영역 -->
  <div id="payment-method"></div>
  <div id="agreement"></div>
  <!-- 결제하기 버튼 -->
  <div class="col-md-6">
  <button class="btn btn-secondary btn-lg" id="payment-button">결제하기</button>
  <button class="btn btn-light btn-lg" id="payment-button" onclick="goToMainPage()">결제취소</button>
  </div>
  
  <script>
  function goToMainPage(){
	  window.location.href = "../mainhome.do"; // 결제취소 버튼 클릭하면 메인화면으로 이동 
  }
  </script>
  
  <script>
    const clientKey = "test_ck_GjLJoQ1aVZJYL9qJ7qwVw6KYe2RN"
    const customerKey = "6_tF_Twxamf0jKI_VZ7KL" // 내 상점에서 고객을 구분하기 위해 발급한 고객의 고유 ID
    const button = document.getElementById("payment-button")
    // ------  결제위젯 초기화 ------ 
    // 비회원 결제에는 customerKey 대신 ANONYMOUS를 사용하세요.
    const paymentWidget = PaymentWidget(clientKey, customerKey) // 회원 결제
    // const paymentWidget = PaymentWidget(clientKey, PaymentWidget.ANONYMOUS) // 비회원 결제
    // ------  결제위젯 렌더링 ------ 
    // 결제수단 UI를 렌더링할 위치를 지정합니다. `#payment-method`와 같은 CSS 선택자와 결제 금액 객체를 추가하세요.
    // DOM이 생성된 이후에 렌더링 메서드를 호출하세요.
    // https://docs.tosspayments.com/reference/widget-sdk#renderpaymentmethods선택자-결제-금액-옵션
    paymentWidget.renderPaymentMethods("#payment-method", { value: 15000 })
    // ------  이용약관 렌더링 ------
    // 이용약관 UI를 렌더링할 위치를 지정합니다. `#agreement`와 같은 CSS 선택자를 추가하세요.
    // https://docs.tosspayments.com/reference/widget-sdk#renderagreement선택자
    paymentWidget.renderAgreement('#agreement')
    // ------ '결제하기' 버튼 누르면 결제창 띄우기 ------
    // 더 많은 결제 정보 파라미터는 결제위젯 SDK에서 확인하세요.
    // https://docs.tosspayments.com/reference/widget-sdk#requestpayment결제-정보
    button.addEventListener("click", function () {
      paymentWidget.requestPayment({
        orderId: "Maus-ZWekZU2QoCo6wZ0Kj",            // 주문 ID
        orderName: "다진 돼지고기 외 2건",                // 주문명
        successUrl: "http://localhost:8090/marketus/pay/paymentRes.do",  // 결제에 성공하면 이동하는 페이지
        failUrl: "http://localhost:8090/marketus/pay/payment.do",       // 결제에 실패하면 이동하는 페이지
        customerEmail: "customer123@gmail.com",
        customerName: "김토스"
      })
    })
  </script>
</body>
