<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<header>
    <div class="container d-flex flex-wrap justify-content-center">
      <a href="/"
        class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto link-body-emphasis text-decoration-none">
        <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use>
        </svg>
        <span class="fs-4">MarketUs</span>
      </a>
    </div>

  <style>
      .table {
        border-collapse: collapse;
        width: 100%;
        border: 1px solid #94b9f3;
      }
      .table th,
      table td {
        border: 1px solid #c5e1de;
        padding: 8px;
        text-align: center;
      }
      .table th {
        background-color: #c5e1de;
      }
  </style>

</header>
<body>
    <nav class="py-2 border-bottom" style="background-color: #b6c3a2">
      <div class="container d-flex flex-wrap">
        <ul class="nav me-auto">
          <p class="mg" style="color: white; font-size: 30px">Management</p>
          <div>
            <a href="#"
              class="nav-link px-2"
              style="color: white; font-weight: 600; padding: 10px">주문관리</a>

            <a href="#"
              class="nav-link px-2"
              style="color: white; font-weight: 600">리뷰관리</a>
          </div>
        </ul>
      </div>
    </nav>

    <div>
      <br />
      <table>
        <thead>
          <tr style="background-color: #c5e1de">
            <th>주문상태</th>
            <th>주문번호</th>
            <th>회원 ID</th>
            <th>주문상품</th>
          </tr>
        </thead>
        <tbody></tbody>
      </table>
    </div>
</body>
</html>