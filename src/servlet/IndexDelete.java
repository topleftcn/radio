package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ColumnDAO;
import dao.IndexDAO;
import dao.NewsDAO;
import entity.Index;

@WebServlet("/deleteindex.do")
public class IndexDelete extends HttpServlet {

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
		int index  = new IndexDAO().deleteIndex(i);
		if( index > 0 ){
			response.sendRedirect("/radio/indexset.do");
		}
	}

}
