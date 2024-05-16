<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 	<!-- Menu left(list group) -->
 	<!-- col-lg-3(widgt) bg-primary(mau xanh) -->
    <div class="col-lg-3  mb-3">
		<div class="list-group">
			  <a href="#" class="list-group-item list-group-item-action active" >
					Book
			  </a>
			  <c:forEach items="${left_TheLoai}" var="o">
			  <a href="#" class="list-group-item list-group-item-action">${o.tenTheLoaiString}</a>
			  </c:forEach>
			  <a class="list-group-item list-group-item-action disabled" aria-disabled="true">Khac</a>
		</div>
    </div>
    
  <!-- End menu left -->