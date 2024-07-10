/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class UpdateCusController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             String id = request.getParameter("txtCusId");
            String first = request.getParameter("txtfirst");
            String last = request.getParameter("txtlast");
            String birthday = request.getParameter("txtbirthday");
            String gender = request.getParameter("txtgender");
            String phone = request.getParameter("txtphone");
            String address = request.getParameter("txtaddress");
            CustomerDAO p = new CustomerDAO();
            int r1 = p.updateFirstName(id, first);
            int r2 = p.updateGender(id, gender);
            int r3 = p.updateLastName(id, last);
            int r4 = p.updateBirth(id, Date.valueOf(birthday));
            int r5 = p.updatePhone(id, phone);
            int r6 = p.updateAddress(id, address);
            
            if (r1 == 1 && r2 == 1 && r3 == 1 && r4 == 1 && r5 ==1 && r6 == 1 ) {
                request.setAttribute("info", "updated success");
                request.getRequestDispatcher("ManageCustomerController").forward(request, response);
            }else {
                request.setAttribute("info", "update failed");
                request.getRequestDispatcher("ManageCustomerController").forward(request, response);
            }
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
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
        request.setCharacterEncoding("UTF-8");
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
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
