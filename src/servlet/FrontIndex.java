package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BottomDAO;
import dao.IndexDAO;
import dao.NewsDAO;
import dao.SongDAO;
import entity.News;
import entity.Song;

@WebServlet("/index")
public class FrontIndex extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IndexDAO i = new IndexDAO();
        ArrayList<entity.Index> list = i.findAllIndex();
		
        NewsDAO n = new NewsDAO();
        ArrayList<News> nall = n.findAllNews();
        ArrayList<entity.Bottom> b = new BottomDAO().findAllBottom();
        ArrayList<Song> s = new SongDAO().findAllSong();
        
		if( list != null && nall != null){
			int index = i.getTotal();
			int totalPages = ( index%3==0)?(index/3):(index/3+1);

			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("allNew", nall);
			request.setAttribute("allSong", s);
			request.setAttribute("allSongSize", s.size());
			request.setAttribute("allBottom", b);
			request.setAttribute("allIndex", list);
			request.setAttribute("allIndexSize", list.size() );
			request.setAttribute("totalPages", totalPages);
			String[] t = nowTime().split("-");
			request.setAttribute("time1", t[2]);
			request.setAttribute("time2", t[1]+"/"+t[0]);
			rd.forward(request, response);
		}else{

		}
	}
	
	/*插入数据时的时间*/
	public String nowTime(){
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		return sd.format(date);
	}

}
