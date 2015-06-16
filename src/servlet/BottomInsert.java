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

import dao.BottomDAO;
import dao.IndexDAO;
import dao.NewsDAO;
import entity.Bottom;
import entity.Index;
import entity.News;

@WebServlet("/bottominsert.do")
public class BottomInsert extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**/
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		String year = request.getParameter("year");
		String phonenumber = request.getParameter("phonenumber");
		String about = request.getParameter("about");
		String twittwr = request.getParameter("twittwr");
		
		int index = new BottomDAO().update(0, phonenumber, about, year, twittwr);
		if( index > 0){
			response.sendRedirect("/radio/bottom.do");
		}
	}
}
