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


 <br/>
    <div>
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
