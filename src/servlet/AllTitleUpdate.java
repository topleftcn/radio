package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.AllTitleDAO;
import dao.BottomDAO;
import dao.ColumnDAO;
import entity.AllTitle;

/**
 * 对节目的删除操作
 * @author Administrator
 *
 */
@WebServlet("/alltitleupdate.do")
@MultipartConfig(location="/tmp",fileSizeThreshold=1024)
public class AllTitleUpdate extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**/
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		/*文件上传*/

		Part p = request.getPart("fileName");
		String pp = null;
		if( p.getSize() != 0){
			String path = this.getServletContext().getRealPath("/");
			path = path + "\\scimage\\";
			File file = new File(path);
			if( !file.exists() )
				file.mkdirs();

			String h = p.getHeader("content-disposition");
			String fname = h.substring(h.lastIndexOf("=")+2,h.length()-1);
			path = path+"/"+fname;
			pp = "scimage/"+nowTime1()+fname;
			p.write(path);
		}else{
			pp=null;
		}
		
		String filename = request.getParameter("filename"); 
		String type = request.getParameter("type");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if( pp == null){
			ArrayList<AllTitle> all = new AllTitleDAO().findAllTitle(Integer.parseInt(type));
			for (AllTitle a : all) {
				if( Integer.parseInt(type) == a.getType() ){
					pp = a.getPicture();
				}
			}
		}
		
		int index  = new AllTitleDAO().update(Integer.parseInt(type), title, content, pp);
		if( index > 0 ){
			response.sendRedirect("/radio/alltitle.do?type="+Integer.parseInt(type));
		}
	}
	
	/*插入数据时的时间*/
	public String nowTime1(){
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sd.format(date);
	}

}
