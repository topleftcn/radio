package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BottomDAO;
import dao.IndexDAO;

@WebServlet("/bottom.do")
public class Bottom extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<entity.Bottom> b = new BottomDAO().findAllBottom();
		if( b != null){
			RequestDispatcher rd = request.getRequestDispatcher("/admin/bottom.jsp");
			request.setAttribute("allBottom", b);
			rd.forward(request, response);
		}else{

		}
	}

}
