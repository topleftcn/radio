package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDAO;
import dao.TyfcDAO;


@WebServlet("/tyfcset.do")
public class Tyfc extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=utf8");
		String page = request.getParameter("pages");
		
		int pages = 0;
		if( page == null){
			pages = 1;
		}else{
			pages = Integer.parseInt(page)+1;
		}
		
		TyfcDAO t = new TyfcDAO();
		ArrayList<entity.Tyfc> list =t.findAllTyfc(pages);
		
		if( list != null){
			
			int index = t.getTotal();
			int totalPages = ( index%8==0)?(index/8):(index/8+1);
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/tyfcset.jsp");
			request.setAttribute("alltyfc", list);
			request.setAttribute("alltyfcSize", list.size() );
			request.setAttribute("pages", pages);
			request.setAttribute("totalPages", totalPages);
			rd.forward(request, response);
		}else{
			
		}
	}

}
