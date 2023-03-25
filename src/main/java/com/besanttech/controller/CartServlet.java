package com.besanttech.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besanttech.dao.ProductDao;
import com.besanttech.beans.Product;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null) {
			request.getRequestDispatcher("views/cart.jsp").forward(request, response);
		} else if (action.equals("add")) {
			HttpSession session = request.getSession(false);
			List<Product> cartProducts = (List<Product>) session.getAttribute("cartProducts");
			if (cartProducts == null) {
				cartProducts = new ArrayList<>();
			}
			ProductDao pd = new ProductDao();
			Product p = pd.getProductById(Integer.parseInt(request.getParameter("id")));
			if (p != null) {
				cartProducts.add(p); 
				session.setAttribute("cartProducts", cartProducts);
				updateCartPrice(cartProducts,session);
			}
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/products");
			rd.forward(request, response);

		} else if (action.equals("remove")) {
			HttpSession session = request.getSession(false);
			List<Product> cartProducts = (List<Product>) session.getAttribute("cartProducts");
			for (Product p : cartProducts) {
				if (p.getProductid() == Integer.parseInt(request.getParameter("id"))) {
					cartProducts.remove(p);
					session.setAttribute("cartProducts", cartProducts);
					updateCartPrice(cartProducts,session);
					break;
				}
			}

			RequestDispatcher rd = request.getRequestDispatcher("views/cart.jsp");
			rd.forward(request, response);
		}
	}
	
	public void updateCartPrice(List<Product> cartProducts, HttpSession session) {
		float price =0;
		for(Product product: cartProducts) {
			price = (float) (price + product.getProductprice());
		}
	
		session.setAttribute("cartPrice", price);
	}
}