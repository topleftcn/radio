package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BottomDAO;
import dao.ColumnDAO;

/**
 * 对节目的删除操作
 * @author Administrator
 *
 */
@WebServlet("/bottomdelete.do")
public class BottomDelete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf8");
		request.setCharacterEncoding("utf8");

		String id = request.getParameter("id");
		
		int index  = new BottomDAO().deleteBottom(Integer.parseInt(id));
		if( index > 0 ){
			response.sendRedirect("/radio/bottom.do");
		}
	}

}
