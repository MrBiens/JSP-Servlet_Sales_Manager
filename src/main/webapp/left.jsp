<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 	<!-- Menu left(list group) -->
 	<!-- col-lg-3(widgt) bg-primary(mau xanh) -->
 	<!--  danh sach danh muc  -->
    <div class="col-lg-3  mb-3">
		<div class="list-group">
			  <a href="#" class="list-group-item list-group-item-action active" >
					Product
			  </a>
			  <c:forEach items="${left_TheLoai}" var="o"><!-- tro den sanphamcontroller -->
				<a href="san-pham?maTheLoai=${o.maTheLoaiString}"  class="list-group-item list-group-item-action ${tag==o.maTheLoaiString?"active":""}" > ${o.tenTheLoaiString} </a> <!--  truyen the loai -->
			  </c:forEach>
			  
			  <a class="list-group-item list-group-item-action disabled" aria-disabled="true">Khac</a>
		</div>
		<!--  load product -->
		<div class="card-header bg-success text-white text-uppercase"> Last product
    	<div class="card-body">
    		<img class="img-fluid" src="img/product/suit/2.png">
    		<h5 class="card-title">${p.tenSanPhamString}</h5>
    		<p class="card-text">${p.motaString}</p>
    		<p class="card-text">${p.giaBanDouble}</p>
    	</div>
    	</div>
    </div>
   
    
  <!-- End menu left -->