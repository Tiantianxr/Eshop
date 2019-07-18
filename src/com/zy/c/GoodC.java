package com.zy.c;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.service.GoodService;

@WebServlet("/good")
public class GoodC extends HttpServlet{

	private GoodService goodService=new GoodService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String cmd = req.getParameter("cmd");
		
		if("add_cart".equals(cmd)) {
			String good_id = req.getParameter("good_id");
			String good_number = req.getParameter("good_number");
			System.out.println(good_id+":"+good_number);
			
			//业务逻辑
			int result=goodService.addCart(good_id, Integer.parseInt(good_number));
			String data="";
			if(result>0) {//注册成功
				data="{\"result\":\"1\"}";
			}else {//注册失败
				data="{\"result\":\"0\"}";
			}
			
			//返回数据
			resp.setContentType("text/json;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.write(data);
			out.close();
		}else if("cart_list".equals(cmd)) {
			Map<String, Object> map = goodService.queryCartGoods();
			
			req.getSession().setAttribute("map", map);
			req.getRequestDispatcher("cart.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
