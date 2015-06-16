package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IndexDAO;

@WebServlet("/indexset.do")
public class Index extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = request.getParameter("pages");

		int pages = 0;
		if( page == null){
			pages = 1;
		}else{
			pages = Integer.parseInt(page)+1;
		}

		IndexDAO i = new IndexDAO();
        ArrayList<entity.Index> list = i.findAllIndex(pages);
		
		if( list != null){
			int index = i.getTotal();
			int totalPages = ( index%3==0)?(index/3):(index/3+1);

			RequestDispatcher rd = request.getRequestDispatcher("/admin/indexset.jsp");
			request.setAttribute("allIndex", list);
			request.setAttribute("allIndexSize", list.size() );
			request.setAttribute("pages", pages);
			request.setAttribute("totalPages", totalPages);
			rd.forward(request, response);
		}else{

		}
	}

}
