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
import dao.SongDAO;
import entity.Song;


@WebServlet("/frontsongset.do")
public class FrontSong extends HttpServlet {

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
		ArrayList<Song> list = s.findAllSong1(pages);
		ArrayList<entity.Bottom> b = new BottomDAO().findAllBottom();
		ArrayList<entity.AllTitle> a = new AllTitleDAO().findAllTitle(3);

		if( list != null){

			int index = s.getTotal();
			int totalPages = ( index%5==0)?(index/5):(index/5+1);
			RequestDispatcher rd = request.getRequestDispatcher("/dgt.jsp");
			request.setAttribute("alltitle", a);
			request.setAttribute("allSong", list);
			request.setAttribute("allSongSize", list.size() );
			request.setAttribute("pages", pages);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("allBottom", b);
			rd.forward(request, response);
		}else{

		}
	}

}
