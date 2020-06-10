package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.bean;
import Dao.dao;



/**
 * Servlet implementation class TopServlet
 */
//①最初にアクセスされるURL
@WebServlet("/toukou2")
public class toukou2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public toukou2Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("toukouname");
		String mail = request.getParameter("mail");
		String naiyou = request.getParameter("naiyou");

		//日付
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("GGGGy： MM/dd (E) a hh: mm: ss秒");
		String strDate = dateFormat.format(date);



		if(name != null && mail != null  ){
			bean a = new bean(null,name,naiyou,mail,strDate,null);

			dao.insertToukou(a);


		}


		ArrayList<bean> b = new ArrayList<bean>();

		b =dao.selectAlltoukou();



		request.setAttribute("list",b);




		//②サーブレットからJSPの呼び出し
		String view = "/WEB-INF/view/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		doGet(request, response);

	}

}
