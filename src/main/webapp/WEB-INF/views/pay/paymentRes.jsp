<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
</head>

<body>
<h2 align="center">결제완료</h2>

 <div class="col-md-6">
	 <button class="btn btn-secondary btn-lg" id="payment-button" onclick="goToMainPage()">메인 홈으로 돌아가기</button>
 </div>
  
  <script>
  function goToMainPage(){
	  window.location.href = "../mainhome.do"; // 결제취소 버튼 클릭하면 메인화면으로 이동 
  }
  </script>
</body>
</html>