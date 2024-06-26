package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDAO;
import DAO.TheLoaiDAO;
import model.SanPham;
import model.TheLoai;

/**
 * Servlet implementation class SanPhamController
 */
@WebServlet("/san-pham")
public class SanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String maTheLoai = request.getParameter("maTheLoai");//tro den bien maSanPhamString cua left.jsp
		request.setAttribute("tag", maTheLoai);//doi mau khi chon the loai san pham
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		ArrayList<SanPham> arrayList =sanPhamDAO.getSanPhamByTheLoai(maTheLoai);//truyen ma the loai de thuc hien select where
		request.setAttribute("listSanPham", arrayList);//thay the cho listSanPham o servlet khachhang

		SanPham sanPhamHot=new SanPham("SP03", null, null, 0, null, null, null, null, null, null, null);
		sanPhamHot=sanPhamDAO.selectById(sanPhamHot);//truyen 
		request.setAttribute("p", sanPhamHot);//san pham hot

		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		ArrayList<TheLoai> arrayList_theLoai = theLoaiDAO.selectAll();
		request.setAttribute("left_TheLoai", arrayList_theLoai);//menu ten the loai san pham
	
		
		String url = "/index.jsp";
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
		requestDispatcher.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
//	private void chiTietSanPham(HttpServletRequest request, HttpServletResponse response) {
//		
//		
//	}
//	
	

}
