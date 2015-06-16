package servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/bottominsert1.do")
public class BottomInsert1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<entity.Bottom> b = new BottomDAO().findAllBottom();
		if( b!=null){
			 RequestDispatcher rd = request.getRequestDispatcher("/admin/bottominsert.jsp");
			 request.setAttribute("allbottom", b);
			 rd.forward(request, response);
		}else{
			
		}
	}
}
