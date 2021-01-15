package controller;

import dao.ProductDAO;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = "/product")

public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init(){
        productDAO = new ProductDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "create":
                    insertProduct(request,response);
                    break;
                case "edit":
                    updateProduct(request,response);
                    break;
            }
        } catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "create":
                    showNewProduct(request,response);
                    break;
                case "edit":
                    showEditProduct(request,response);
                    break;
                case "delete":
                    deleteProduct(request,response);
                    break;
                default:
                    listProduct(request,response);
            }
        } catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
    private void listProduct(HttpServletRequest request,HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        List<Product> listProduct = productDAO.selectAllProduct();
        request.setAttribute("listCustomer", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showNewProduct(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditProduct(HttpServletRequest request,HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingCustomer = productDAO.selectProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("product", existingCustomer);
        dispatcher.forward(request,response);
    }

    private void insertProduct(HttpServletRequest request,HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String status = request.getParameter("status");
        Product newProduct = new Product(name,price,quantity,color,status);
        productDAO.insertProduct(newProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request,response);
    }
    private void updateProduct(HttpServletRequest request,HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String status = request.getParameter("status");
        Product product = new Product(id, name, price, quantity, color, status);
        productDAO.updateProduct(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteProduct(HttpServletRequest request,HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(id);
        List<Product> listProduct = productDAO.selectAllProduct();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request,response);
    }
}
