<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


		 <script type="text/javascript">
		$('document').ready(function() {
		 var area0 = ["시/도 선택","서울특별시","인천광역시","대전광역시","광주광역시","대구광역시","울산광역시","부산광역시","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주도"];
		  var area1 = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
		   var area2 = ["계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
		   var area3 = ["대덕구","동구","서구","유성구","중구"];
		   var area4 = ["광산구","남구","동구","북구","서구"];
		   var area5 = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"];
		   var area6 = ["남구","동구","북구","중구","울주군"];
		   var area7 = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
		   var area8 = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
		   var area9 = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
		   var area10 = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
		   var area11 = ["계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
		   var area12 = ["군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
		   var area13 = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
		   var area14 = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
		   var area15 = ["거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
		   var area16 = ["서귀포시","제주시","남제주군","북제주군"];
		
		 
		
		 // 시/도 선택 박스 초기화
		
		 $("select[name^=sido]").each(function() {
		  $selsido = $(this);
		  $.each(eval(area0), function() {
		   $selsido.append("<option value='"+this+"'>"+this+"</option>");
		  });
		  $selsido.next().append("<option value=''>구/군 선택</option>");
		 });
		
		 
		
		 // 시/도 선택시 구/군 설정
		
		 $("select[name^=sido]").change(function() {
		  var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 구군 Array
		  var $gugun = $(this).next(); // 선택영역 군구 객체
		  $("option",$gugun).remove(); // 구군 초기화
		
		  if(area == "area0")
		   $gugun.append("<option value=''>구/군 선택</option>");
		  else {
		   $.each(eval(area), function() {
		    $gugun.append("<option value='"+this+"'>"+this+"</option>");
		   });
		  }
		 });
		
		
		});
		</script>
        <style>
          .container-fluid {
            width: 100%;
            height: 100%;
            clear: both;
            border-style: dashed;
            border-width: 2px;
            padding: 20px;
            margin: 20px auto;
            box-sizing: border-box;
            color: #ffbf2a;
          }

          .content-search-btm-area {
            margin-top: 10px;
          }

          /* Styling for the search buttons */
          .search-area-btn {
            background-color: #ffbf2a;
            color: black;
            height: 38px;
            padding: 5px 10px; 
            text-decoration: none; 
            margin-right: 10px; 
            border-radius: 5px;
          }

          select {
            width: 200px;
            padding: 5px;
            margin-right: 10px;
          }

          input {
            width: 417px;
            padding: 5px;
            margin-right: 10px;
          }

          .table {
            border-collapse: collapse;
            width: 100%;
            border: 1px solid #ffbf2a;
          }
          .table th, table td{
            border: 1px solid #ffbf2a;
            padding: 8px;
            text-align: center;
          }
          .table th {
            background-color: #ffbf2a;
          }

        </style>
        
        <h2 style="margin-bottom: 20px; margin-top: 20px;">제휴 매장안내</h2>
        <div class="container-fluid">
          <select name="sido1" id="sido1"></select>
          <select name="gugun1" id="gugun1"></select>

          <div class="content-search-btm-area">
<!--             <input
              type="text"
              id="srhKeyword"
              name="srhKeyword"
              style="ime-mode: active"
              class="input-keyword"
              width="500px"
              placeholder="매장명을 검색하세요."
              value=""
              onkeypress="if(event.keyCode==13){dataSetSearch();}"/> -->
            <a href="javascript:dataSetSearch();"
              id="searchBtn"
              class="search-area-btn search-btn"
              >검색</a>
          </div>
        </div>

        <div>
          <br/>
          <table class="table table-hover table-bordered">
            <thead>
              <tr style="background-color:#ffbf2a;">
                <th>번호</th>
                <th>매장명</th>
                <th>전화번호</th>
                <th>주소</th>
              </tr>
            </thead>
            <tbody id='area_tbody'>
             
              
            </tbody>
          </table>
        </div><br/>

      <%--   <div class="text-center">
          <ul class="pagination justify-content-center mt-5 mb-5">
          	<li><a class="page-link" href="store_info.do?currentPage=${pv.startPage-1}">Prev</a></li>
            <c:forEach var="i" begin="${pv.startPage}" end="${pv.endPage }">
			<li>
			 <c:choose>
			  <c:when test="${i==pv.currentPage}">
			 	<a class="page-link page-item active" href=".do?currentPage=${i}">${i}</a>
			  </c:when>
			 <c:otherwise>
			<a class="page-link" href="store_info.do?currentPage=${i}">${i}</a>
			 </c:otherwise>
			</c:choose>
			</li>
		</c:forEach>
		<!-- 페이지 출력 끝 -->
	
	<!-- 다음 출력 시작 -->
	<c:if test="${pv.endPage < pv.totalPage}">
	 <li>
	   <a class="page-link" href="store_info.do?currentPage=${pv.startPage+pv.blockPage}">Next</a>
	 </li>
	</c:if>
	<!-- 다음 출력 끝 -->
		
          </ul> 
        </div> --%>
        
        <script>
        	function dataSetSearch(){
        		let sido = $('#sido1').val();
        		let gugun = $('#gugun1').val();
        		console.log(sido,gugun);
        		
        		$.ajax({
        			type:'GET',
        			dataType:'json',
        			url:'searchad.do?data='+sido +' ' + gugun,
        			success:viewMessage
        			});        		      	
        	}
        	
        	/*게시글목록 출력*/
        	function viewMessage(res){        		
        		$('#area_tbody').empty();
        		$.each(res, function(index, element){        			      			
        		 $('#area_tbody').append('<tr><td>'+element.store_id+'</td><td>'+element.store_name+'</td><td>'+(element.store_number===null ? ' ': element.store_number )+'</td><td>'+element.store_address+'</td></tr>');});
        	 
        	}//end viewMessege

        </script>
     