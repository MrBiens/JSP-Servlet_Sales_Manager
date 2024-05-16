package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDAO;
import model.SanPham;

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
		
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		ArrayList<SanPham> list = sanPhamDAO.selectAll();
		
		request.setAttribute("listSanPham", list);
		String urlString="/index.jsp";
		RequestDispatcher requestDispatcher =this.getServletContext().getRequestDispatcher(urlString);
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
//	private void loadSanPham(HttpServletRequest request, HttpServletResponse response) {
//		
//	}
	
	public static void main(String[] args) {
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		List<SanPham> list = sanPhamDAO.selectAll();
		for (SanPham sanPham : list) {
			System.out.println(sanPham);
		}
	
	}
	

}
