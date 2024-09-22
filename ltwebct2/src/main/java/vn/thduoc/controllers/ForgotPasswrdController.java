package vn.thduoc.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.thduoc.services.IUserService;
import vn.thduoc.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/resetpassword")
public class ForgotPasswrdController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/resetpassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// mã hóa dữ liệu tiếng Việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// lấy dữ liệu của tham số từ view
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirmpsw = req.getParameter("password-repeat");
		String alertMsg = "";

		// gọi Service để lấy toàn bộ các hàm trong Service
		IUserService service = new UserServiceImpl();

		// kiểm tra username có tồn tại không
		if (!service.checkExistUsername(username)) {
			alertMsg = "Tên đăng nhập không tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
			return;
		} else if (!password.equals(confirmpsw)) {
			alertMsg = "Mật khẩu không trùng khớp!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
			return;
		} else {
			service.updatePassword(username, password);
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}
