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
+ request.getContextPath(); %>
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
        	
<%

	String error_updateInfo=request.getAttribute("error_updateInfo")+"";
	error_updateInfo=error_updateInfo.equals("null")?"":error_updateInfo;
	
	String hoVaTen=khachHang.getHoVaTenString();
	hoVaTen=hoVaTen.equals("null")?"":hoVaTen;
	
	String gioiTinh=khachHang.getgioiTinhString();
	gioiTinh=gioiTinh.equals("null")?"":gioiTinh;
	
	String ngaySinh=khachHang.getNgaySinhDate().toString();
	ngaySinh=ngaySinh.equals("null")?"":ngaySinh;
	
	String diaChiKhachHang=khachHang.getDiaChiString();
	diaChiKhachHang=diaChiKhachHang.equals("null")?"":diaChiKhachHang;
	
	String diaChiMuaHang=khachHang.getDiaChiMuaHangString();
	diaChiMuaHang=diaChiMuaHang.equals("null")?"":diaChiMuaHang;
	
	String diaChiNhanHang=khachHang.getDiaChiNhanHangString();
	diaChiNhanHang=diaChiNhanHang.equals("null")?"":diaChiNhanHang;
	
	String soDienThoai=khachHang.getSoDienThoaiString();
	soDienThoai=soDienThoai.equals("null")?"":soDienThoai;
	
	String email=khachHang.getEmailString();
	email=email.equals("null")?"":email;
	
	String dongYNhanMail=khachHang.getDangKyNhanEmailString().toString();
	dongYNhanMail=dongYNhanMail.equals("null")?"":dongYNhanMail;
	
	
	
	
%>
	<jsp:include page="../header.jsp"></jsp:include>

<div class="container">
	<form class="form" action="<%=url%>/khach-hang" method="POST"> <!--  ../ di ra phia truoc 1 thu muc roi moi goi toi khach hang controller -->
	<input type="hidden" name="hanhDong" value="thay-doi-thong-tin">
	
	<div class="row"> 
		<div class="col-md-6"> 
			<div class="text-center">
				<h1>Thay đổi thông tin</h1>
			</div>
				<h3>Thông tin tài khoản</h3>
				<div class="mb-3">
					<label for="hoVaTen" class="form-label">Ho va ten:</label>
					<input type="text" class="form-control" id="hoVaTen" name="hoVaTen" value="<%=hoVaTen%>">
				</div>
				<div class="mb-3">
					<label for="gioiTinh" class="form-label">Gioi tinh:</label>
					<select class="form-control" id="gioiTinh" name="gioiTinh" >
						<option value="nam" <%=(gioiTinh.equals("Nam"))?"selected='selected'":"" %> >Nam</option>
						<option value="nu" <%=gioiTinh.equals("Nu")?"selected='selected'":"" %> >Nu</option>
						<option value="khac" <%=gioiTinh.equals("Khac")?"selected='selected'":"" %> >Khac</option>
					</select>
				</div>
				<div class="mb-3">
					<label for="ngaySinh" class="form-label">Ngay sinh:</label>
					<input type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="<%=ngaySinh%>" >
				</div>
				
			</div>
			<div class="col-md-6"> 
				<h3>Địa chỉ khách hàng</h3>
				<div class="mb-3">
					<label for="diaChiKhachHang" class="form-label">Dia chi khach hang:</label>
					<input type="text" class=form-control id="diaChiKhachHang" name="diaChiKhachHang" value="<%=diaChiKhachHang%>" >
				</div>
				<div class="mb-3">
					<label for="diaChiMuaHang" class="form-label">Dia chi mua hang:</label>
					<input type="text" class=form-control id="diaChiMuaHang" name="diaChiMuaHang" value="<%=diaChiMuaHang%>"> 
				</div>
				<div class="mb-3">
					<label for="diaChiNhanHang" class="form-label">Dia chi nhan hang:</label>
					<input type="text" class=form-control id="diaChiNhanHang" name="diaChiNhanHang" value="<%=diaChiNhanHang%>">
				</div>
				<div class="mb-3">
					<label for="soDienThoai" class="form-label">So dien thoai:</label>
					<input type="text" class=form-control id="soDienThoai" name="soDienThoai" value="<%=soDienThoai%>">
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">Email:</label>
					<input type="email" class=form-control id="email" name="email" value="<%=email%>">
				</div>
			
				<div class="mb-3">
					<label for="dongYNhanMail" class="form-label">Đồng ý nhận Email</label>
					<input type="checkbox" class="form-check-input" id="dongYNhanMail" name="dongYNhanMail" value="<%=dongYNhanMail%>">
				</div>
				<div>
				<div class="row">
					<div class="col">
					<input type="submit" class="btn btn-primary" value="Lưu thông tin" id="submit" name="submit"  >
					</div>
				</div>
				<div class="rq"><span>*<%=error_updateInfo %></span></div>
			</div>
			
		</div>
		</div>
		</form>
	
</div>
<%@include file="../footer.jsp" %>
</body>
<%}%>

</html>