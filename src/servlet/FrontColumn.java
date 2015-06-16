package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AllTitleDAO;
import dao.BottomDAO;
import dao.ColumnDAO;

@WebServlet("/frontjmznset.do")
public class FrontColumn extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		
		ColumnDAO u = new ColumnDAO();
		ArrayList<entity.Column> list = u.findAllColumn();
		 ArrayList<entity.Bottom> b = new BottomDAO().findAllBottom();
		 ArrayList<entity.AllTitle> a = new AllTitleDAO().findAllTitle(1);
		if( list != null){
			
			int index = u.getTotal();
			
			RequestDispatcher rd = request.getRequestDispatcher("/jmzn.jsp");
			request.setAttribute("allColumn", list);
			request.setAttribute("alltitle", a);
			request.setAttribute("allColumnSize", list.size() );
			request.setAttribute("allBottom", b);
			rd.forward(request, response);
		}else{
			
		}
		
	}

}
