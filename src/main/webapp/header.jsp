<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); %>
<!-- Star Navbar -->
<%@page import="model.KhachHang"%>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
    <img alt="" src="img/logo/logofull 2.png" height="36">
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=url%>/index.jsp">Trang chủ</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Liên kết</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Danh mục
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Hoạt động</a></li>
            <li><a class="dropdown-item" href="#">Hoạt động khác</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Khác</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" aria-disabled="true">Vô hiệu hóa</a>
        </li>
      </ul>
      <form class="d-flex" action="<%=url%>/tim-kiem" method="POST">
        <input class="form-control me-2" name="search" type="search" placeholder="Nội dung tìm kiếm" aria-label="Search">
        <button class="btn btn-outline-success" style="white-space: nowrap;" type="submit">Tìm kiếm</button>
        <!-- Dang nhap -->
        <%
        	Object obj=session.getAttribute("khachHang");
        	KhachHang khachHang =null;
        	if(obj!=null){
        		khachHang=(KhachHang) obj; //ep kieu obj sang khach hang
        	}
        	if(khachHang==null){
        %>
        	 <a class="btn btn-primary" style="white-space: nowrap;margin-left:5px"  href="khachhangview/dangnhap.jsp">
        	 Đăng nhập
        	</a>
      	 <%} else{%>
      	 
      	 <div style="margin-left: 3px">
				<ul class="btn btn-primary ;navbar-nav me-auto mb-2 mb-lg-0 bg-infor ">
					<li class="nav-item dropdown dropstart"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">Tài khoản<br/><b><%=khachHang.getTenDangNhapString()%></b></a>
						
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
							<li><a class="dropdown-item" href="#">Thông báo</a></li>
							<li><a class="dropdown-item" href="<%=url%>/khachhangview/thaydoianh.jsp">Thay đổi ảnh đại diện</a></li>
   			   			 	<li><a class="dropdown-item" href="<%=url%>/khachhangview/thaydoithongtin.jsp">Thay đổi thông tin</a></li>
   			  			  	<li><a class="dropdown-item" href="<%=url%>/khachhangview/doimatkhau.jsp">Thay đổi mật khẩu</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="khach-hang?hanhDong=dang-xuat">Thoát tài khoản</a></li>
						</ul></li>
				</ul>	
		</div>
	</form>
       	 <%} %>
       	 <!-- End dang nhap -->

    </div>
  </div>
</nav>
<!-- End Navbar -->