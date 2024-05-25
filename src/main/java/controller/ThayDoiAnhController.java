package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DAO.KhachHangDAO;
import model.KhachHang;

/**
 * Servlet implementation class ThayDoiAnhController
 */
@WebServlet("/khach-hang-thay-doi-anh")
public class ThayDoiAnhController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThayDoiAnhController() {
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

//		String hanhDong = request.getParameter("hanhDong");
//		if (hanhDong.equals("dang-nhap")) {
//			dangNhap(request, response);
//		} else if (hanhDong.equals("dang-xuat")) {
//			dangXuat(request, response);
//		} else if (hanhDong.equals("dang-ky")) {
//			dangKy(request, response);
//		} else if (hanhDong.equals("doi-mat-khau")) {
//			doiMatKhau(request, response);
//		} else if (hanhDong.equals("thay-doi-thong-tin")) {
//			thayDoiThongTin(request, response);
//		}else if(hanhDong.equals("xac-thuc")) {
//			xacThucTaiKhoan(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Object object = request.getSession().getAttribute("khachHang");//lay thong tin khach hang tu session
			KhachHang khachHang = null;
			if(object!=null) {
				khachHang = (KhachHang) object;
			}
			if(khachHang!=null) {
				try {
					//duong dan chua thu muc luu anh
					String folder=getServletContext().getRealPath("/khachhangview/avatar");// (getInitParameter("avatar"));
					
					System.out.println(folder);
					File file;
					int maxFileSize=5000*1024;
					int maxMemSize=5000*1024;
					String contentType=request.getContentType();
					if(contentType.indexOf(contentType)>=0) {
						DiskFileItemFactory factory = new DiskFileItemFactory();
						//quy dinh dung luong toi da cho 1 file
						factory.setSizeThreshold(maxMemSize);
						//tao file upload
						ServletFileUpload upload = new ServletFileUpload(factory);
						upload.setSizeMax(maxFileSize);
						
						List<FileItem> files=upload.parseRequest(request);
						for (FileItem fileItem : files) {
							if(!fileItem.isFormField()) {
								String fileName =System.currentTimeMillis()+fileItem.getName();
								String path=folder+"\\"+fileName;
								file = new File(path);
								fileItem.write(file);
								
								khachHang.setDuongDanAnh(fileName);
								KhachHangDAO khachHangDAO = new KhachHangDAO();
								khachHangDAO.updateAnhDaiDien(khachHang);
								
								khachHang=khachHangDAO.selectById(khachHang);
							}else {
								String name = fileItem.getFieldName();
								String value=fileItem.getString();
								System.out.println(name+value);
							}
							
						}
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	

}
