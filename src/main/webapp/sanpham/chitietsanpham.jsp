<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>

</head>
<%String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); 
String error=request.getAttribute("error")+"";
error=error.equals("null")?"":error;
%>
<link href="<%=url%>/css/signin.css" rel="stylesheet">

<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container mt-4">
		<div class=" text-center">
		<div class="row">
		<jsp:include page="../left.jsp"></jsp:include>
		
						<div class="col-lg-4 ">
						    <div class="card" style="width: 20rem;">
								  <img src="<%=url%>/img/product/suit/1.png" class="card-img-top" alt="...">
								  <div class="card-body">
								    <h5 class="card-title">${chiTietSanPham.tenSanPhamString}</h5>
								    <p class="card-text">${chiTietSanPham.motaString}</p>
								    <a href="#" class="btn btn-primary">Buy</a>
								    <h5><%=error%></h5>
							 	</div>
							</div>
						</div>
				</div>
			</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>