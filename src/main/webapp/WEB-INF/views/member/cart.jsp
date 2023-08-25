<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
			
			<div class="container border-bottom my-2 py-3">
				<div class="row">
					<div class="col-sm-7 container align-self-center">
						<div class="row">
							<div class="col-sm-3">
								<img class="img-fluid" src="../resources/image/3.jpg" />
							</div>
							<div class="col-sm-9 align-self-center">
								<span>내가 주문한 상품</span>
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
					<div class="col-sm-3 align-self-center text-end">
						<span class="pricetag" style="font-size:20px">27,000</span><span style="font-size:14px">&nbsp;원</span>
					</div>
				</div>			
			</div>
			
			<div class="container border-bottom my-2 py-3">
				<div class="row">
					<div class="col-sm-7 container align-self-center">
						<div class="row">
							<div class="col-sm-3">
								<img class="img-fluid" src="../resources/image/3.jpg" />
							</div>
							<div class="col-sm-9 align-self-center">
								<span>내가 주문한 상품</span>
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
					<div class="col-sm-3 align-self-center text-end">
						<span class="pricetag" style="font-size:20px">27,000</span><span style="font-size:14px">&nbsp;원</span>
					</div>
				</div>			
			</div>
			
			<div class="container border-bottom my-2 py-3">
				<div class="row">
					<div class="col-sm-7 container align-self-center">
						<div class="row">
							<div class="col-sm-3">
								<img class="img-fluid" src="../resources/image/3.jpg" />
							</div>
							<div class="col-sm-9 align-self-center">
								<span>내가 주문한 상품</span>
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
					<div class="col-sm-3 align-self-center text-end">
						<span class="pricetag" style="font-size:20px">27,000</span><span style="font-size:14px">&nbsp;원</span>
					</div>
				</div>			
			</div>
					
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