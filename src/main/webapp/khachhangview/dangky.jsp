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
<style>
	.rq{
		color:red;
	}
</style>

<%
	String error_username =request.getAttribute("error_username")+"";
	error_username=error_username.equals("null")?"":error_username;
	String error_password =request.getAttribute("error_password")+"";
	error_password=error_password.equals("null")?"":error_password;
	
	
	String tenDangNhap=request.getAttribute("tenDangNhap")+"";
	tenDangNhap=tenDangNhap.equals("null")?"":tenDangNhap;
	
	String hoVaTen=request.getAttribute("hoVaTen")+"";
	hoVaTen=hoVaTen.equals("null")?"":hoVaTen;
	
	String gioiTinh=request.getAttribute("gioiTinh")+"";
	gioiTinh=gioiTinh.equals("null")?"":gioiTinh;
	
	String ngaySinh=request.getAttribute("ngaySinh")+"";
	ngaySinh=ngaySinh.equals("null")?"":ngaySinh;
	
	String diaChiKhachHang=request.getAttribute("diaChiKhachHang")+"";
	diaChiKhachHang=diaChiKhachHang.equals("null")?"":diaChiKhachHang;
	
	String diaChiMuaHang=request.getAttribute("diaChiMuaHang")+"";
	diaChiMuaHang=diaChiMuaHang.equals("null")?"":diaChiMuaHang;
	
	String diaChiNhanHang=request.getAttribute("diaChiNhanHang")+"";
	diaChiNhanHang=diaChiNhanHang.equals("null")?"":diaChiNhanHang;
	
	String soDienThoai=request.getAttribute("soDienThoai")+"";
	soDienThoai=soDienThoai.equals("null")?"":soDienThoai;
	
	String email=request.getAttribute("email")+"";
	email=email.equals("null")?"":email;
	
	String dongYNhanMail=request.getAttribute("dongYNhanMail")+"";
	dongYNhanMail=dongYNhanMail.equals("null")?"":dongYNhanMail;
	
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath();
	
%>
<div class="container">
	<form action="<%=url%>/khach-hang" method="POST"> <!--  ../ di ra phia truoc 1 thu muc roi moi goi toi khach hang controller -->
	<input type="hidden" name="hanhDong" value="dang-ky">
	<jsp:include page="../header.jsp"></jsp:include>
	
	<div class="row"> 
		<div class="col-md-6"> 
			<div class="text-center">
				<h1>Dang ky tai khoan</h1>
			</div>
			
				<div class="mb-3">
					<label for="tenDangNhap" class="form-label" >Ten dang nhap:</label><span class="rq">*</span>
					<input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" value="<%=tenDangNhap%>" required="required">
					<div class="rq"><%=error_username%></div>
				</div>
				<div class="mb-3">
					<label for="matKhau" class="form-label">Mat khau:</label><span class="rq">*</span>
					<input type="password" class="form-control" id="matKhau" name="matKhau" required="required" onkeyup="kiemTraMatKhau()">
					
				</div>
				<div class="mb-3">
					<label for="matKhauNhapLai" class="form-label">Nhap lai mat khau:</label><span class="rq">*</span> <span id="msg" class="rq"></span>
					<input type="password" class="form-control" id="matKhauNhapLai" name="matKhauNhapLai" required="required" onkeyup="kiemTraMatKhau()">
					<div class="rq"><%=error_password %></div>
				</div>
				<h3>Thong tin khach hang</h3>
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
				<h3>Dia chi khach hang</h3>
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
					<label for="dongYDieuKhoan" class="form-label">Đồng ý với <a> điều khoản của công ty:</a></label><span class="rq">*</span>
					<input type="checkbox" class="form-check-input" id="dongYDieuKhoan" name="dongYDieuKhoan" required="required" onchange="xuLyChonDongY()">
					<div>
					<label for="dongYDieuKhoan" class="form-label"><b>Vui lòng chọn đồng ý điều khoản để thực hiện đăng ký</b></label><span class="rq">*</span>
					</div>
				</div>
				<div class="mb-3">
					<label for="dongYNhanMail" class="form-label">Đồng ý nhận Email</label>
					<input type="checkbox" class="form-check-input" id="dongYNhanMail" name="dongYNhanMail" value="<%=dongYNhanMail%>">
				</div>
				<div>
				<div class="row">
					<div class="col">
					<input type="submit" class="btn btn-primary" value="Đăng ký" id="submit" name="submit" style="visibility: hidden" >
					</div>
				</div>
				
			</div>
		</div>
		</div>
		</form>
		
</div>
<%@include file="../footer.jsp" %>

</body>
<script>
	function kiemTraMatKhau(){
		matKhau = document.getElementById("matKhau").value;
		matKhauNhapLai = document.getElementById("matKhauNhapLai").value;
		if(matKhau!=matKhauNhapLai){
			document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
			return false;
		}else{
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
	
	function xuLyChonDongY(){
		dongYDieuKhoan = document.getElementById("dongYDieuKhoan");
		if(dongYDieuKhoan.checked==true){
			document.getElementById("submit").style.visibility="visible";
		} else {
			document.getElementById("submit").style.visibility="hidden";
		}
	}
	
</script>
</html>