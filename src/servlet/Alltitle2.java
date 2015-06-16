package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AllTitleDAO;
import entity.AllTitle;

@WebServlet("/alltitleupdate1.do")
public class Alltitle2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		ArrayList<AllTitle> all = new AllTitleDAO().findAllTitle(Integer.parseInt(type));
		if( type != null){
			RequestDispatcher rd = request.getRequestDispatcher("/admin/alltitleupdate.jsp?type="+Integer.parseInt(type));
			request.setAttribute("alltitle", all);
			request.setAttribute("alltype", Integer.parseInt(type));
			rd.forward(request, response);
		}
	}

}
