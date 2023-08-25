<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>    
$(document).ready(function(){
    $('.mystic-plus').click(function(){
        let count = $(this).prev().text();
        count++;
        $(this).prev().text(count);
        $(this).parent().parent().next().children('.pricetag').text('calculation');
        if(count>1){
            $(this).prev().prev().removeClass('disabled')
        };
    });

    $('.mystic-minus').click(function(){
        let count = $(this).next().text();
        if(count>1){
            count--;
            $(this).next().text(count);
            $(this).parent().parent().next().children('.pricetag').text('calculation');
        }
        if(count==1){
            $(this).addClass('disabled')
        }
    });
})
</script> 


<div class="container">
	<div class="row mx-5">
		<div class="col-md-8">
		
			<c:forEach >
			
				<div class="container border-bottom my-2 py-3">
					<div class="row">
						<div class="col-sm-8 container align-self-center">
							<div class="row">
								<div class="col-sm-2 align-self-center">
									<button type="button" class="btn btn-outline-dark">
	                					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">
	  										<path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"></path>
										</svg>
	             					 </button>
								</div>
								<div class="col-sm-3">
									<img class="img-fluid" src="../resources/image/3.jpg" />
								</div>
								<div class="col-sm-6 align-self-center">
									<span>칸을 넘어갈 정도로 길이가 어마어마하게 긴 상품 이름입니다</span>
								</div>
							</div>
						</div>
						<div class="col-sm-2 align-self-center">
							<div class="btn-group" role="group">
							        <button type="button" class="btn btn-outline-dark mystic-minus">-</button>
							        <button type="button" class="btn btn-outline-dark mystic-content">1</button>
							        <button type="button" class="btn btn-outline-dark mystic-plus">+</button>
							</div>
						</div>
						<div class="col-sm-2 align-self-center text-end">
							<span class="pricetag" style="font-size:20px">27,000</span><span style="font-size:14px">&nbsp;원</span>
						</div>
					</div>			
				</div>				
			</c:forEach>
					
		</div>
		<div class="col-md-4">
			<div class="card" style="position:sticky;top:25%">
				<div class="card-body">
					<div>
						<span style="font-size:16px;font-weight:600">총 결제예정금액</span>
					</div>
					<div class="border-bottom mb-3" style="text-align:right">
						<span style="font-size:32px;font-weight:900">67,000</span>
						<span>원</span>
					</div>
					<div>
						<div class="d-grid gap-2">
						  <button class="btn btn-success" type="button">주문하기</button>
						</div>	
					</div>
				</div>
			</div>
		</div>
	</div>
</div>    