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
 * Servlet implementation class TimKiemController
 */
@WebServlet("/tim-kiem")
public class TimKiemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimKiemController() {
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
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		SanPham sanPham = new SanPham();

		String search=request.getParameter("search");
		ArrayList<SanPham>	search_sanPham =sanPhamDAO.searchByName(search);
		
		request.setAttribute("listSanPham", search_sanPham);//thay the cho listSanPham o servlet khachhang

		
		String maSanPham=request.getParameter("maSanPham");
		sanPham.setMaSanPhamString(maSanPham);
		sanPham=sanPhamDAO.selectById(sanPham);
		request.setAttribute("chiTietSanPham", sanPham);

		SanPham sanPhamHot=new SanPham("SP03", null, null, 0, null, null, null, null, null, null, null);
		sanPhamHot=sanPhamDAO.selectById(sanPhamHot);//truyen 
		request.setAttribute("p", sanPhamHot);//san pham hot
		
		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		ArrayList<TheLoai> arrayList_theLoai = theLoaiDAO.selectAll();//menu left
		request.setAttribute("left_TheLoai", arrayList_theLoai);//hien thi list Product truoc khi sang servlet san pham
		
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

}
