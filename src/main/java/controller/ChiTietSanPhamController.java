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
 * Servlet implementation class ChiTietSanPhamController
 */
@WebServlet("/chi-tiet-san-pham")
public class ChiTietSanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietSanPhamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		SanPham sanPham = new SanPham();
		String maSanPham=request.getParameter("maSanPham");
		sanPham.setMaSanPhamString(maSanPham);
		String urlString="";
		sanPham=sanPhamDAO.selectById(sanPham);
		
		SanPham sanPhamHot=new SanPham("SP03", null, null, 0, null, null, null, null, null, null, null);
		sanPhamHot=sanPhamDAO.selectById(sanPhamHot);//truyen 
		request.setAttribute("p", sanPhamHot);//san pham hot
		
		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		ArrayList<TheLoai> arrayList_theLoai = theLoaiDAO.selectAll();
		request.setAttribute("left_TheLoai", arrayList_theLoai);//hien thi list Product truoc khi sang servlet san pham
		
		if(sanPham!=null) {
			request.setAttribute("chiTietSanPham", sanPham);
			urlString="/sanpham/chitietsanpham.jsp";
		}else {
			request.setAttribute("error", "San pham bi loi");
			urlString="/index.jsp";
		}
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(urlString);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
