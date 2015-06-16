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

import dao.IndexDAO;
import dao.NewsDAO;
import entity.Index;
import entity.News;

@WebServlet("/indexinsert.do")
public class IndexInsert extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**/
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		String english = request.getParameter("english");
		String gonggao = request.getParameter("gonggao");
		String zhongwen = request.getParameter("zhongwen");
		String inserttime = nowTime();

		Index i = new Index(english, gonggao, inserttime, zhongwen);
		int index = new IndexDAO().IndexInsert(i);
		if( index > 0){
			response.sendRedirect("/radio/indexset.do");
		}
	}

	/*插入数据时的时间*/
	public String nowTime(){
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		return sd.format(date);
	}
}
