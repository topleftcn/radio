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
import dao.TyfcDAO;
import entity.Tyfc;


@WebServlet("/fronttyfcset.do")
public class FrontTyfc extends HttpServlet {

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
		ArrayList<Tyfc> l = t.findAllTyfc();
		 ArrayList<entity.Bottom> b = new BottomDAO().findAllBottom();
		 ArrayList<entity.AllTitle> a = new AllTitleDAO().findAllTitle(4);
		if( list != null && l != null){
			
			int index = t.getTotal();
			int totalPages = ( index%3==0)?(index/3):(index/3+1);
			
			RequestDispatcher rd = request.getRequestDispatcher("/tyfc.jsp");
			 request.setAttribute("alltitle", a);
			request.setAttribute("alltyfc", list);
			request.setAttribute("alltyfcSize", list.size() );
			request.setAttribute("alltyfc1", l);
			request.setAttribute("alltyfcSize1", l.size() );
			request.setAttribute("pages", pages);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("allBottom", b);
			rd.forward(request, response);
		}else{
			
		}
	}

}
