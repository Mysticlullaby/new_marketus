<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>    
$(document).ready(function(){
	let order_id = $('#order_id').val();
	$.ajax({
		type: 'GET',
		dataType: 'json',
		url: 'getCart.do?order_id='+order_id,
		success: refresh
	});
	
    $(document).on('click', '.mystic-plus', function(){
        let count = $(this).prev().text();
        let product_id = $(this).closest('.row').find('.product-id').val();
        let order_id = $(this).closest('.row').find('.order-id').val();
        count++;
        
    	$.ajax({
    		type: 'GET',
    		dataType: 'json',
    		url: 'editCart.do?order_id='+order_id+'&product_id='+product_id+'&product_count='+count,
    		success: refresh
    	});
    });

    $(document).on('click', '.mystic-minus', function(){
        let count = $(this).next().text();
        let product_id = $(this).closest('.row').find('.product-id').val();
        let order_id = $(this).closest('.row').find('.order-id').val();
        if(count>1){
        	count--;
            
        	$.ajax({
        		type: 'GET',
        		dataType: 'json',
        		url: 'editCart.do?order_id='+order_id+'&product_id='+product_id+'&product_count='+count,
        		success: refresh
        	});
        };	
    });
    
    
    $(document).on('click', '.delete-cart', function(){
        let order_id = $(this).next().val();
        let product_id = $(this).next().next().val();
        console.log(order_id);
        console.log(product_id);
        
    	$.ajax({
    		type: 'GET',
    		dataType: 'json',
    		url: 'deleteCart.do?product_id=' + product_id + '&order_id=' + order_id,
    		success: refresh
    	});
    });
    
    $(document).on('click', '.purchase', function(){   	
    	$.ajax({
    		type: 'GET',
    		url: 'purchase.do',
    	});
    	$('#cartList').empty();
    	$('.purchase').addClass('disabled')
    	alert('상품 주문이 접수되었습니다.');
    })
    
    function refresh(cartList){
    	$('#cartList').empty();
		$.each(cartList, function(index, cart){			
			$('#cartList').append(`<div class="container border-bottom my-2 py-3">			
				<div class="row">
					<div class="col-sm-7 container align-self-center">
						<div class="row">
							<div class="col-sm-2 align-self-center">
								<button type="button" class="btn btn-outline-dark delete-cart">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">
										<path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"></path>
									</svg>
								</button>
								<input type="hidden" class="order-id" name="order_id" value=\${cart.order_id}>
								<input type="hidden" class="product-id" name="product_id" value=\${cart.product_id}>
							</div>
							<div class="col-sm-3">
								<img class="img-fluid" src="../resources/image/\${cart.product_id}.jpg" />
							</div>
							<div class="col-sm-6 align-self-center">
								<span>\${cart.shopDTO.product_name}</span>
							</div>
						</div>
					</div>
					<div class="col-sm-2 align-self-center">
						<div class="btn-group" role="group">
								<button type="button" class="btn btn-outline-dark mystic-minus">-</button>
								<button type="button" class="btn btn-outline-dark mystic-content">\${cart.product_count}</button>
								<button type="button" class="btn btn-outline-dark mystic-plus">+</button>
						</div>
					</div>
					<div class="col-sm-3 align-self-center text-end">
						<span class="pricetag" style="font-size:20px">\${cart.shopDTO.price*cart.product_count}</span><span style="font-size:14px">&nbsp;원</span>
					</div>
				</div>			
			</div>`);				
			
    	});
		
		$('.mystic-content').each(function(){
	        if ($(this).text() === '1') {
	            $(this).siblings('.mystic-minus').addClass('disabled');
	        }
	    });
		
		
		let totalPrice = 0;
		
		$('.pricetag').each(function(){
			let price = 0;
			price = $(this).text();
			totalPrice += parseInt(price);
			$(this).text(parseInt(price).toLocaleString());
		})

		$('#totalPrice').empty();
		$('#totalPrice').text(totalPrice.toLocaleString());

    };
});
</script> 


<div class="container">
	<div class="row mx-5">
		<input type="hidden" id="order_id" name="order_id" value="${orderInfo.order_id}"/>
		<div id="cartList" class="col-md-8">
			<!-- ajax로 불러온 장바구니 목록이 들어가는 자리 -->
					
		</div>
		<div class="col-md-4">
			<div class="card" style="position:sticky;top:25%">
				<div class="card-body">
					<div>
						<span style="font-size:16px;font-weight:600">총 결제예정금액</span>
					</div>
					<div class="border-bottom mb-3" style="text-align:right">
						<span style="font-size:32px;font-weight:900" id="totalPrice"></span>
						<span>원</span>
					</div>
					<div>
						<div class="d-grid gap-2">
						  <button class="btn btn-success purchase" type="button" action="">주문하기</button>
						</div>	
					</div>
				</div>
			</div>
		</div>
	</div>
</div>    