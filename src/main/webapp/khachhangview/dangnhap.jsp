<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<% String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); 

	String error_login=request.getAttribute("error_login")+"";
	error_login=error_login.equals("null")?"":error_login;
	
	String baoLoi=request.getAttribute("baoLoi")+"";
	baoLoi=baoLoi.equals("null")?"":baoLoi;

	
%>
<link href="<%=url%>/css/signin.css" rel="stylesheet">

</head>
<body>
<main class="form-signin w-100 m-auto">
	<form class="text-center" action="<%=url%>/khach-hang" method="POST"> <!--  ../ di ra phia truoc 1 thu muc roi moi goi toi khach hang controller -->
		<input type="hidden" name="hanhDong" value="dang-nhap"/>
		
		<img class="mb-4" src="<%=url%>/img/logo/logofull 2.png"
			alt="" width="72">
		<%=baoLoi%>
		<h1 class="h3 mb-3 fw-norm al">ĐĂNG NHẬP</h1>
		<div class="text-center"> <span class="rq"><%=error_login %></span></div>
		<div class="form-floating">
			<input type="text" class="form-control" id="tenDangNhap"
				placeholder="Tên đăng nhập" name="tenDangNhap"> <label for="tenDangNhap">Tên đăng nhập</label>
		</div>
		<div class="form-floating">
			<input type="password" class="form-control" id="matKhau"
				placeholder="Mật khẩu" name="matKhau"> <label for="matKhau">Mật khẩu</label>
		</div>

		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				Ghi nhớ tài khoản này
			</label>
		</div>
		<button class="w-100 btn btn-lg btn-primary" type="submit">Đăng nhập</button>
		
		<%if (error_login.length()==0){%>
			<a href="dangky.jsp">Đăng ký tài khoản mới</a>
		<% }else{%>
			<a href="<%=url%>/khachhangview/dangky.jsp">Đăng ký tài khoản mới</a>
		<%} %>
		
		<p class="mt-5 mb-3 text-muted">&copy; 2017–2025</p>
	</form>
</main>

</body>
</html>