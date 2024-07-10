/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DT.UI;
import dao.AccountDAO;
import dao.CustomerDAO;
import dto.Account;
import dto.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String email = request.getParameter("txtemail");
            String phone = (String) request.getParameter("txtphone");
            String username = (String) request.getParameter("txtlusername");
            String fname = (String) request.getParameter("txtfname");
            String lname = (String) request.getParameter("txtlname");
            String gender = (String) request.getParameter("txtgender");
            String password = (String) request.getParameter("txtpassword");
            String address = (String) request.getParameter("txtaddress");
            AccountDAO dao = new AccountDAO();
            CustomerDAO cao = new CustomerDAO();
            if (dao.checkEmail(email) == null && cao.checkPhone(phone) == null
                    && dao.checkUsername(phone) == null && dao.checkUsername(username) == null) {
//                    create account

                String accid = UI.generateId("ACC", dao.getIdMax());
                System.out.println(fname + lname + phone + gender + password + address);

                Account acc = new Account(accid, username, password, UI.date(), email, "Customer");
//                            Account acc = new Account("ACC00011", "Duck323", "ducnguyen1111", UI.date(), "kimloan2024@gmail.com", "Customer");
                int result = dao.createAccount(acc, Boolean.TRUE);
                if (true) {
                    CustomerDAO d = new CustomerDAO();
                    Customer cus = new Customer(UI.generateId("CUS", d.getIdMax()), fname, lname, "bede", UI.date(), address, phone, accid);
                    int res = d.createCustomer(cus, Boolean.TRUE);
                    HttpSession session = request.getSession();
//                       session.setAttribute("User", acc);
                    response.sendRedirect("index.jsp");
//                       request.getRequestDispatcher("mainController?name=home").forward(request, response);
                } else {
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }
            } else {

                request.setAttribute("email", email);
                request.setAttribute("fname", fname);
                request.setAttribute("lname", lname);
                request.setAttribute("phone", phone);
                request.setAttribute("password", password);
                request.setAttribute("address", address);
                request.setAttribute("username", username);
                request.setAttribute("error", "Email or Phone or Username is exit");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
