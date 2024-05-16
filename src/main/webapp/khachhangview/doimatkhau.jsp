<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</head>
<%			//kiem tra xem khach hang da dang nhap hay chua
			String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); 

        	Object obj=session.getAttribute("khachHang");
        	KhachHang khachHang =null;
        	if(obj!=null){
        		khachHang=(KhachHang) obj; //ep kieu obj sang khach hang
        	}
        	if(khachHang==null){%>
			<h1>Bạn chưa đăng nhập vào hệ thống.Hãy quay lại trang chủ</h1>
			<a class="btn btn-primary" style="white-space: nowrap;"  href="<%=url%>/index.jsp">Trang chủ</a>
			<% String url_1=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); %>
			
			<img src="<%=url_1%>/img/slider/images.jpg">
			<h1>Hãy quay lại trang chủ</h1>
			
			
			<%}else{%>
				
	 <% 
 	String error=request.getAttribute("error")+"";
	 error=error.equals("null")?"":error;

	

	%>
<link href="<%=url%>/css/signin.css" rel="stylesheet">
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container mt-5">
	<form class="form" action="<%=url%>/khach-hang" method="POST"> <!--  ../ di ra phia truoc 1 thu muc roi moi goi toi khach hang controller -->
	<input type="hidden" name="hanhDong" value="doi-mat-khau">
			<div class="text-center">
			<h1>Đổi mật khẩu</h1>
			</div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">Mật khẩu hiện tại:</label>
			    <input type="password" class="form-control" id="matKhauHienTai" name="matKhauHienTai">
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">Mật khẩu mới:</label>
			    <input type="password" class="form-control" id="matKhauMoi" name="matKhauMoi">
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">Nhập lại mật khẩu mới:</label>
			    <input type="password" class="form-control" id="matKhauMoiNhapLai" name="matKhauMoiNhapLai">
			  </div>
			  <div class="mb-3 form-check">
			    <input type="checkbox" class="form-check-input" id="exampleCheck1">
			    <label class="form-check-label" for="exampleCheck1">Lưu mật khẩu</label>
			  </div>
			  
			  <div class="rq"><span>*<%=error%></span></div>
			  
			  <button type="submit" class="btn btn-primary">Đổi mật khẩu</button>
	</form>
</div>
<%@include file="../footer.jsp" %>

</body>
<%}%>

</html>