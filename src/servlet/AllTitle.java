package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AllTitleDAO;
import dao.BottomDAO;
import dao.IndexDAO;

@WebServlet("/alltitle.do")
public class AllTitle extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");
		System.out.println( type );
		ArrayList<entity.AllTitle> a = new AllTitleDAO().findAllTitle(Integer.parseInt(type));
		if( a != null){
			RequestDispatcher rd = request.getRequestDispatcher("/admin/alltitle.jsp");
			request.setAttribute("alltitle",a);
			rd.forward(request, response);
		}else{

		}
	}

}
