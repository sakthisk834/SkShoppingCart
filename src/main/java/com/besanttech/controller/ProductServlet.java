package com.besanttech.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besanttech.beans.Product;
import com.besanttech.dao.ProductDao;
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		  res.setContentType("text/html"); 
		 // PrintWriter out=res.getWriter();
		  ProductDao pd=new ProductDao();
		  req.setAttribute("products", pd.getAllProducts());
		req.getRequestDispatcher("views/products.jsp").forward(req, res);
}
}