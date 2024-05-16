<%@page import="java.util.List"%>
<%@page import="model.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Full-stack Developer</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<body>
<%String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ request.getContextPath(); 
%>
<!--  header -->
<jsp:include page="header.jsp"></jsp:include>
<!-- Can le , viet o giua -->
<div class="container mt-4">
	<div class=" text-center">
	<!-- Tao dong(row)- trong dong co nhieu cot(col) -->
	  	<div class="row">
	  	<!--  Menu left -->
	  	<jsp:include page="left.jsp"></jsp:include>
	  	<!-- End menu left -->
	    <!-- Slider(slider) and products -->
	    <!-- col-lg-9 bg-warning(mau vang) -->
		   	 <div class="col ">
		   	 <!-- Cot 2 dong 1 -->
			      	<div id="carouselExampleIndicators" class="carousel slide">
					  <div class="carousel-indicators">
						   <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
						   <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
						   <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
				  	<div class="carousel-inner">
					   	 <div class="carousel-item active">
					      <img src="img/slider/banner1.png " class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="img/slider/banner2.png" class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="img/slider/banner3.png" class="d-block w-100" alt="...">
				    </div>
		 			 </div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
				  </div>	
			  
			   <!--  End Slider -->
			   <!--  Product(card) -->
			   <!-- -lg-4(maytinh) col-md-7(ipad) mb-4(mobile)  -->
			  		<!-- Cot 2 dong 2 --> 
			<div class="row">
				<c:forEach items="${listSanPham}" var="o">
					<div class="col-lg-4 ">
					    <div class="card" style="width: 20rem;">
							  <img src="img/product/suit/1.png" class="card-img-top" alt="...">
							  <div class="card-body">
							    <h5 class="card-title">${o.tenSanPhamString}</h5>
							    <p class="card-text">${o.motaString}</p>
							    <a href="#" class="btn btn-primary">Buy</a>
						 	</div>
						</div>
					</div>
				</c:forEach>		
			</div>
		
		
	

		
		
				
				<!-- End product 3 -->
				
			 	</div>
			 	<!-- Het cot 2 dong 2 -->
		     </div>   
		     <!-- Het dong 2 cot 1 -->
		</div>
		 <!-- End slider and product-->      
		
</div>
	
<!-- footer -->
<%@include file="footer.jsp" %> <!-- phu hop cho trang tinh, khong thay doi va can tinh toan -->
<!-- End page content -->
</body>
</html>