package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ColumnDAO;
import dao.NewsDAO;

/**
 * �����ŵ�ɾ������
 * @author Administrator
 *
 */
@WebServlet("/deletenews.do")
public class NewsDelete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf8");
		request.setCharacterEncoding("utf8");

		String id = request.getParameter("id");
		int i = 0;
		if( id != null){
			i = Integer.parseInt(id);
		}else{
		}
		int index  = new NewsDAO().deleteNews(i);
		if( index > 0 ){
			response.sendRedirect("/radio/newsset.do");
		}
	}

}
