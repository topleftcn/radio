package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ColumnDAO;
import entity.Column;

@WebServlet("/columninsert.do")
public class ColumnInsert extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf8");
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String columntime = request.getParameter("columntime");
		String content = request.getParameter("content");
		String inserttime = nowTime();
		
		Column c = new Column(title, content, columntime, inserttime);
		int index = new ColumnDAO().ColumnInsert(c);
		if( index > 0){
			response.sendRedirect("/radio/jmznset.do");
		}
	}
	
	/*插入数据时的时间*/
	public String nowTime(){
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		return sd.format(date);
	}

}
