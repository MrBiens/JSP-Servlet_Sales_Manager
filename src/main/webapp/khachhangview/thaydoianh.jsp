<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width-device-width, initial-scale=1,shrink-to-fit=no">  <!-- hien thi thanh 1 cuon tren dien thoai --> 
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</head>
<body>
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ request.getContextPath(); 
%>
<style>
	.rq{
		color:red;
	}
</style>
<%			//kiem tra xem khach hang da dang nhap hay chua
        	Object obj=session.getAttribute("khachHang");
        	KhachHang khachHang =null;
        	if(obj!=null){
        		khachHang=(KhachHang) obj; //ep kieu obj sang khach hang
        	}
        	if(khachHang==null){%>
        		<h1>Bạn chưa đăng nhập vào hệ thống.Hãy quay lại trang chủ</h1>
			<a class="btn btn-primary" style="white-space: nowrap;"  href="<%=url%>/index.jsp">Trang chủ</a>
			
			
			<img src="<%=url%>/img/slider/images.jpg">
			<h1>Hãy quay lại trang chủ</h1>
			
			
			<%}else{%>
	<jsp:include page="../header.jsp"></jsp:include>
<%		String duongDanAnh= khachHang.getDuongDanAnh();// hoac khachhang.getDuongDanAnh
%>
<div class="container">
	<form class="form" action="<%=url%>/khach-hang-thay-doi-anh" method="POST" enctype="multipart/form-data">  <!--  ../ di ra phia truoc 1 thu muc roi moi goi toi khach hang controller -->
	<input type="hidden" name="hanhDong" value="thay-doi-anh">
	
		<div class="row"> 
			<div class="col-md-6"> 
				<div class="text-center">
					<h3>Ảnh đại diện</h3>
					<img src="<%=url%>/khachhangview/avatar/<%=duongDanAnh%>">
					<div class="mb-3">
						<label for="duongDanAnh" class="form-label">Đường dẫn ảnh</label>
						<input type="file" class="form-control" id="duongDanAnh" name="duongDanhAnh">
					</div>
				</div>
				<input class="btn btn-primary form-control" type="submit" value="Thay đổi ảnh" id="submit" name="submit">
			</div>
		</div>
	</form>
	
</div>
</body>
<%}%>
<%@include file="../footer.jsp" %> 

</html>