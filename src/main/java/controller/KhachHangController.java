package controller;

//import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DAO.KhachHangDAO;
import DAO.SanPhamDAO;
import DAO.TheLoaiDAO;
import model.KhachHang;
import model.SanPham;
import model.TheLoai;
import util.Email;
import util.MaHoa;
import util.MaXacThuc;

/**
 * Servlet implementation class KhachHang
 */
@WebServlet("/khach-hang")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KhachHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String hanhDong = request.getParameter("hanhDong");
		if (hanhDong.equals("dang-nhap")) {
			dangNhap(request, response);
		} else if (hanhDong.equals("dang-xuat")) {
			dangXuat(request, response);
		} else if (hanhDong.equals("dang-ky")) {
			dangKy(request, response);
		} else if (hanhDong.equals("doi-mat-khau")) {
			doiMatKhau(request, response);
		} else if (hanhDong.equals("thay-doi-thong-tin")) {
			thayDoiThongTin(request, response);
		}else if(hanhDong.equals("xac-thuc")) {
			xacThucTaiKhoan(request, response);
		}
//		else if(hanhDong.equals("thay-doi-anh")) {
//			upLoadFile(request, response);
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void dangNhap(HttpServletRequest request, HttpServletResponse response) {
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");

			matKhau = MaHoa.toSHA256(matKhau);// ma hoa

			KhachHang khachHang = new KhachHang();
			khachHang.setTenDangNhapString(tenDangNhap);
			khachHang.setMatKhauString(matKhau);

			KhachHangDAO khachHangDAO = new KhachHangDAO();
			khachHang = khachHangDAO.selectByUserNameAndPassWord(khachHang);
			String url = "";

			if (khachHang != null && khachHang.isTrangThaiXacThuc()) {//&&khachHang.isTrangThaiXacThuc()
				HttpSession session = request.getSession();
				session.setAttribute("khachHang", khachHang);
				// load san pham tu database
				SanPhamDAO sanPhamDAO = new SanPhamDAO();
				ArrayList<SanPham> list = sanPhamDAO.selectAll();
				request.setAttribute("listSanPham", list);// hien thi toan bo san pham truoc khi sang servlet san pham

				SanPham sanPhamHot = new SanPham("SP03", null, null, 0, null, null, null, null, null, null, null);
				sanPhamHot = sanPhamDAO.selectById(sanPhamHot);// truyen
				request.setAttribute("p", sanPhamHot);// san pham hot

				TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
				ArrayList<TheLoai> arrayList_theLoai = theLoaiDAO.selectAll();
				request.setAttribute("left_TheLoai", arrayList_theLoai);// hien thi list Product truoc khi sang servlet san pham
																		

				url = "/index.jsp";
			} else {
				request.setAttribute("error_login", "Tên đăng nhập hoặc mật khẩu không đúng hoặc tài khoản chưa xác thực ");
				url = "/khachhangview/dangnhap.jsp";
			}
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void dangXuat(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
			response.sendRedirect(url + "/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void dangKy(HttpServletRequest request, HttpServletResponse response) {
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			String matKhauNhapLai = request.getParameter("matKhauNhapLai");
			String hoVaTen = request.getParameter("hoVaTen");
			String gioiTinh = request.getParameter("gioiTinh");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
			String diaChiMuaHang = request.getParameter("diaChiMuaHang");
			String diaChiNhanHang = request.getParameter("diaChiNhanHang");
			String soDienThoai = request.getParameter("soDienThoai");
			String email = request.getParameter("email");
			String dongYNhanMail = request.getParameter("dongYNhanMail");

			request.setAttribute("tenDangNhap", tenDangNhap);
			request.setAttribute("hoVaTen", hoVaTen);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("diaChiKhachHang", diaChiKhachHang);
			request.setAttribute("diaChiMuaHang", diaChiMuaHang);
			request.setAttribute("diaChiNhanHang", diaChiNhanHang);
			request.setAttribute("soDienThoai", soDienThoai);
			request.setAttribute("email", email);
			request.setAttribute("dongYNhanMail", dongYNhanMail);

			String url = "";
			String error_username = "";
			String error_password = "";

			KhachHangDAO khachHangDAO = new KhachHangDAO();
			/*
			 * Lấy tên đăng nhập từ parameter .Truyền vào kiểm tra đăng nhập: Nếu có sẽ trả
			 * về true và ngược lại True đồng nghĩa là error_username sẽ được thực hiện,
			 * false thì if(false) sẽ không được thực hiện.
			 */
			if (khachHangDAO.kiemTraTenDangNhap(tenDangNhap)) {
				error_username += "Tên đăng nhập " + tenDangNhap + " đã tồn tại.Vui lòng nhập tên đăng nhập khác";
			}

			if (!matKhau.equals(matKhauNhapLai)) {
				error_password += "Mật khẩu và mật khẩu nhập lại phải khớp nhau";

			} else {
				matKhau = MaHoa.toSHA256(matKhau);
			}

			request.setAttribute("error_username", error_username);
			request.setAttribute("error_password", error_password);

			if (error_username.length() > 0 || error_password.length() > 0) {
				url = "/khachhangview/dangky.jsp";
			} else {
				Random rd = new Random();
				String maKhachHang = "KH" + rd.nextInt(1000) + "";
				KhachHang khachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh,
						diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), soDienThoai, email,
						dongYNhanMail != null);

				// dong y nhan email !=null
//				khachHangDAO.insert(khachHang);
				if (khachHangDAO.insert(khachHang) > 0) {
					String maXacThuc = MaXacThuc.maXacThuc();
					Date toDayDate = new Date(new java.util.Date().getTime());
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(toDayDate);
					calendar.add(Calendar.DATE, 1);// ngay hien tai + 1
					Date thoiGianHieuLucXacThuc = new Date(calendar.getTimeInMillis());

					boolean trangThaiXacThuc = false;

					khachHang.setMaXacThucString(maXacThuc);
					khachHang.setThoiGianHieuLucCuaMaXacThucDate(thoiGianHieuLucXacThuc);
					khachHang.setTrangThaiXacThuc(trangThaiXacThuc);

					if (khachHangDAO.updateTrangThaiXacThuc(khachHang) > 0) {
						Email.sendEmail(khachHang.getEmailString(), "Xác thực đăng ký tài khoản",
								getNoiDung(khachHang));
					}
				}

				url = "/khachhangview/dangnhap.jsp";
			}

			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void doiMatKhau(HttpServletRequest request, HttpServletResponse response) {
		try {
			String matKhauHienTai = request.getParameter("matKhauHienTai");
			String matKhauMoi = request.getParameter("matKhauMoi");
			String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");
			String error = null;

			String url = "";
			// ma hoa mat khau hien tai de so sanh
			String matKhauHienTai_SHA256 = MaHoa.toSHA256(matKhauHienTai);
			// lay session tu dangnhap
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("khachHang");
			KhachHang khachHang = null;
			// neu lay duoc session thi obj se khong null,nen se ep kieu
			if (obj != null) {
				khachHang = (KhachHang) obj; // ep kieu obj sang khach hang
			}
			// neu khach hang khong ton tai
			if (khachHang == null) {
				error = "Bạn chưa đăng nhập vào hệ thống";
				// url="/doimatkhau.jsp";
			} else {// neu khach hang ton tai
				if (!matKhauHienTai_SHA256.equals(khachHang.getMatKhauString())) {// neu phu dinh cua mat khau khong
																					// bang mat khau hien tai -nhap lai
																					// mat khau hien tai
					error = "Mật khẩu hiện tại không chính xác.Vui lòng nhập lại!";
					// url="/doimatkhau.jsp";
				} else {// neu phu dinh cua mat khau bang mat khau hien tai
					if (!matKhauMoi.equals(matKhauMoiNhapLai)) {// neu mat khau moi khong bang nhap lai mat khau moi
						error = "Mật khẩu mới phải giống mật khẩu nhập lại.";
						// url="/doimatkhau.jsp";
					} else {// neu mat khau moi bang nhap lai mat khau moi
						String matKhauMoi_SHA256 = MaHoa.toSHA256(matKhauMoi);// ma hoa mat khau moi
						if (matKhauHienTai_SHA256.equals(matKhauMoi_SHA256)) {// kiem tra mat khau moi co voi mat khau
																				// cu trung nhau
							error = "Mật khẩu mới không thể trùng với mật khẩu cũ";
						} else {
							khachHang.setMatKhauString(matKhauMoi_SHA256);
							KhachHangDAO khachHangDAO = new KhachHangDAO();
							if (khachHangDAO.changePassword(khachHang)) {// neu thay doi mat khau thanh cong
								error = "Mật khẩu đã thay đổi thành công";
								// url="/doimatkhau.jsp";
							} else {// neu khong thay doi mat khau thanh cong
								error = "Thay đổi mật khẩu thất bại";
								// url="/doimatkhau.jsp";
							}
						}
					}
				}
			}
			// vi tat ca url bat loi deu giong nhau nen se gan ra ngoai de code gon hon
			url = "/khachhangview/doimatkhau.jsp";
			request.setAttribute("error", error);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void thayDoiThongTin(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");

			String hoVaTen = request.getParameter("hoVaTen");
			String gioiTinh = request.getParameter("gioiTinh");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
			String diaChiMuaHang = request.getParameter("diaChiMuaHang");
			String diaChiNhanHang = request.getParameter("diaChiNhanHang");
			String soDienThoai = request.getParameter("soDienThoai");
			String email = request.getParameter("email");
			String dongYNhanMail = request.getParameter("dongYNhanMail");

			request.setAttribute("hoVaTen", hoVaTen);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("diaChiKhachHang", diaChiKhachHang);
			request.setAttribute("diaChiMuaHang", diaChiMuaHang);
			request.setAttribute("diaChiNhanHang", diaChiNhanHang);
			request.setAttribute("soDienThoai", soDienThoai);
			request.setAttribute("email", email);
			request.setAttribute("dongYNhanMail", dongYNhanMail);

			String url = "";
			String error_updateInfo = "";
			Object obj = request.getSession().getAttribute("khachHang");

//		HttpSession session = request.getSession();
//		session.getAttribute(error_updateInfo);
			KhachHang khachHang = null;
			if (obj != null) {
				khachHang = (KhachHang) obj; // ep kieu obj sang khach hang
			}

			if (khachHang == null) {
				error_updateInfo = "Bạn chưa đăng nhập vào hệ thống";
			} else {
				KhachHangDAO khachHangDAO = new KhachHangDAO();
				String maKhachHang = khachHang.getMaKhachHangString();
				String username = khachHang.getTenDangNhapString();
				String password = khachHang.getMatKhauString();
				khachHang = new KhachHang(maKhachHang, username, password, hoVaTen, gioiTinh, diaChiKhachHang,
						diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), soDienThoai, email,
						dongYNhanMail != null);

				// dong y nhan email !=null
				khachHangDAO.updateInfo(khachHang);

				// vi session moi nen se bi mat ten ten tai khoan o lan dang nhap tam thoi do
				// username null
//			KhachHang khachHang2=khachHangDAO.selectById(khachHang);//gan 1 khach hang khac bang khach hang de thay doi
				request.getSession().setAttribute("khachHang", khachHang);// co the tim bang ma khach hang

				error_updateInfo = "Cập nhật thông tin thành công";
				url = "/khachhangview/thaydoithongtin.jsp";
				request.setAttribute("error_updateInfo", error_updateInfo);

			}
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void xacThucTaiKhoan(HttpServletRequest request, HttpServletResponse response) {
		try {
			String maKhachHang = request.getParameter("maKhachHang");// o phan getNoiDung
			String maXacThuc = request.getParameter("maXacThuc");// o phan getNoiDung 

			String url="";
			KhachHang khachHang = new KhachHang();
			khachHang.setMaKhachHangString(maKhachHang);
			khachHang.setMaXacThucString(maXacThuc);
			KhachHangDAO khachHangDAO = new KhachHangDAO();
			khachHang = khachHangDAO.selectById(khachHang);//select bang object khach hang
			String msg="";
			//neu khong co se tra ve null
			if (khachHang!=null) {//nghia la co
				//kiem tra ma xac thuc co giong nhau hay khong
				if(khachHang.getMaXacThucString().equals(maXacThuc)) {
					//kiem tra hieu luc ma xac thuc
					khachHang.setTrangThaiXacThuc(true);
					khachHangDAO.updateTrangThaiXacThuc(khachHang);
					 msg="Xác thực thành công";
					 url = "/khachhangview/dangnhap.jsp";

				}else {
					 msg="Xác thực không thành công";
					 url = "/khachhangview/dangky.jsp";
				}

			}else {
				 msg="Tài khoản không tồn tại";
				 url = "/khachhangview/dangky.jsp";

			}
			
			request.setAttribute("baoLoi", msg);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getNoiDung(KhachHang khachHang) {
		// http://localhost:8080/Bai14_BookStore/khach-hang/xac-thuc?maKhachHang=abc&maxacthuc=123456
		String link = "http://localhost:8080/Bai14_BookStore/khach-hang?hanhDong=xac-thuc&"
				+ "maKhachHang="+ khachHang.getMaKhachHangString() + "&maXacThuc=" + khachHang.getMaXacThucString() + "";
		String noiDung = "<p>Xin ch&agrave;o bạn " + khachHang.getHoVaTenString() + ".</p>\r\n"
				+ "<p>Vui l&ograve;ng x&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;ch nhập m&atilde; "
				+ khachHang.getMaXacThucString() + ", hoặc click trực tiếp v&agrave;o đường link sau đ&acirc;y:</p>\r\n"
				+ "<p><a href=\"" + link + "\">" + link + "</a></p>\r\n"
				+ "<p>Đ&acirc;y l&agrave; email tự động. Vui l&ograve;ng kh&ocirc;ng phản hồi lại !</p>\r\n"
				+ "<p>Xin cảm ơn.</p>\r\n" + "<p>From Admin Mr Alias</p>";
		return noiDung;
	}
//	private void upLoadFile(HttpServletRequest request, HttpServletResponse response) {
//		Object object = request.getSession().getAttribute("khachHang");//lay thong tin khach hang tu session
//		KhachHang khachHang = null;
//		if(object!=null) {
//			khachHang = (KhachHang) object;
//		}
//		if(khachHang!=null) {
//			try {
//				String folder=getServletContext().getRealPath("avatar");// (getInitParameter("avatar"));
//				System.out.println(folder);
//				File file;
//				int maxFileSize=5000*1024;
//				int maxMemSize=5000*1024;
//				String contentType=request.getContentType();
//				if(contentType.indexOf(contentType)>=0) {
//					DiskFileItemFactory factory = new DiskFileItemFactory();
//					//quy dinh dung luong toi da cho 1 file
//					factory.setSizeThreshold(maxMemSize);
//					//tao file upload
//					ServletFileUpload upload = new ServletFileUpload(factory);
//					upload.setSizeMax(maxFileSize);
//					
//					List<FileItem> files=upload.parseRequest(request);
//					for (FileItem fileItem : files) {
//						String fileName =System.currentTimeMillis()+fileItem.getName();
//						String path=folder+"\\"+fileName;
//						file = new File(path);
//						fileItem.write(file);
//						
//						khachHang.setDuongDanAnh(fileName);
//						KhachHangDAO khachHangDAO = new KhachHangDAO();
//						khachHangDAO.updateAnhDaiDien(khachHang);
//						
//						khachHang=khachHangDAO.selectById(khachHang);
//						
//					}
//					
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}

}
