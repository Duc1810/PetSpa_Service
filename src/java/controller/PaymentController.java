/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DT.UI;
import dao.CustomerDAO;
import dao.OrderDAO;
import dto.Account;
import dto.Cabin;
import dto.Customer;
import dto.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class PaymentController extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("User");
            if( acc != null){
                CustomerDAO c = new CustomerDAO();
                String accid = acc.getAccID();
                Customer cusid = c.getCustomer(accid);
                 String total = request.getParameter("txttotal");
                double totalmoney = Double.parseDouble(total);
                HashMap<Cabin,String> giohangcabin = (HashMap<Cabin, String>) session.getAttribute("cartCabin");
                HashMap<Service,String> giohangservice = (HashMap<Service, String>) session.getAttribute("cartService");
                OrderDAO d = new OrderDAO();
                int result = d.insertBooking(cusid.getCussId(), UI.date(), "GOOD", "BAD", totalmoney, giohangcabin, giohangservice);
                if( result> 0){
                    session.removeAttribute("cartCabin");
                    session.removeAttribute("cartService");
                    request.setAttribute("dd", "success");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }else{
                    request.setAttribute("id", accid);
                    request.setAttribute("ERROR", "PAYMENT FAIL");
                    request.getRequestDispatcher("ViewCart.jsp").forward(request, response);                   
                }
            }else {               
                request.setAttribute(("ERROR"), "You need to login");
                request.getRequestDispatcher("index.html").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
