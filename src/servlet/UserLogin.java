package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

/**
 * �û���¼��֤����
 * @author xc_computer
 *
 */
@WebServlet("/login.do")
public class UserLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf8");
		request.setCharacterEncoding("UTF-8");
		
		//��ô��ݹ���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if( username == null || password == null){
			RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");
			request.setAttribute("flag", "true");
			rd.forward(request, response);
			return;
		}
		
		//����û�User�������
		User u = new UserDAO().findByName(username);
		
		if( u != null){
			//�Ƚ� �û����������Ƿ�ƥ��
			if( u.getUsername().equals(username) && u.getPassword().equals(password)){
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
					response.sendRedirect("/radio/admin/index.jsp");
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");
				request.setAttribute("flag", "true");
				rd.forward(request, response);
			}
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");
			request.setAttribute("flag", "true");
			rd.forward(request, response);
		}
	}

}
