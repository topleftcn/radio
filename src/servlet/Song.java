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
import dao.SongDAO;


@WebServlet("/songset.do")
public class Song extends HttpServlet {

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
		
	    SongDAO s = new SongDAO();
		ArrayList<entity.Song> list = s.findAllSong(pages);
		
		if( list != null){
			
			int index = s.getTotal();
			int totalPages = ( index%8==0)?(index/8):(index/8+1);
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/songset.jsp");
			request.setAttribute("allSong", list);
			request.setAttribute("allSongSize", list.size() );
			request.setAttribute("pages", pages);
			request.setAttribute("totalPages", totalPages);
			rd.forward(request, response);
		}else{
			
		}
	}

}
