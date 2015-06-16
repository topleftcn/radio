package servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.NewsDAO;
import dao.SongDAO;
import entity.News;
import entity.Song;

@WebServlet("/songinsert.do")
public class SongInsert extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**/
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		String songName = request.getParameter("songName");
		String content = request.getParameter("content");
		String revicer = request.getParameter("revicer");
		String sender = request.getParameter("sender");
		String inserttime = nowTime();

		Song s = new Song(songName, content, revicer, sender, nowTime());
		int index = new SongDAO().SongInsert(s);
		if( index > 0){
			response.sendRedirect("/radio/frontsongset.do");
		}
		
	}

	/*插入数据时的时间*/
	public String nowTime(){
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		return sd.format(date);
	}
}
