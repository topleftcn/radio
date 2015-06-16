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
import dao.NewsDAO;
import entity.News;


@WebServlet("/newsprint.do")
public class NewsPrint extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		if( id != null ){
			News n = new NewsDAO().findAllNews1(Integer.parseInt(id));
			ArrayList<entity.Bottom> b = new BottomDAO().findAllBottom();
			ArrayList<entity.AllTitle> a = new AllTitleDAO().findAllTitle(2);
			if( n != null){
				RequestDispatcher rd = request.getRequestDispatcher("/new.jsp");
				request.setAttribute("allnews", n);
				request.setAttribute("alltitle", a);
				request.setAttribute("allBottom", b);
				rd.forward(request, response);
			}else{

			}
		}else{
			
		}


	}

}
