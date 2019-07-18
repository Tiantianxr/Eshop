package com.zy.c;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.bean.Good;
import com.zy.bean.User;
import com.zy.service.UserService;

@WebServlet("/user")
public class UserC extends HttpServlet{

	private UserService userService=new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String cmd = req.getParameter("cmd");
		if("add".equals(cmd)) {//ע��
			//��ȡ����
			String id = req.getParameter("id");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String mobile = req.getParameter("mobile");
			User user = new User(id, username, password, mobile);
			System.out.println(user);		
			
			//ҵ���߼�
			int result=userService.addUser(user);
			String data="";
			if(result>0) {//ע��ɹ�
				data="{\"result\":\"1\"}";
			}else {//ע��ʧ��
				data="{\"result\":\"0\"}";
			}
			
			//��������
			resp.setContentType("text/json;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.write(data);
			out.close();
		}else if("query".equals(cmd)) {//��¼
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			System.out.println(username);
			System.out.println(password);
			
			User user = userService.queryUser(username, password);
			if(user!=null) {//��¼�ɹ�
				req.getSession().setAttribute("user", user);
				resp.sendRedirect("index.jsp");
			}else {//��¼ʧ��
				resp.sendRedirect("login.html");
			}
		}else if("quit".equals(cmd)) {
			req.getSession().removeAttribute("user");
			resp.sendRedirect("index.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
