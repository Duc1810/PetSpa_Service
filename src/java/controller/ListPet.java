/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
import dao.PetDAO;
import dto.Account;
import dto.Customer;
import dto.Pet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class ListPet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String txt = request.getParameter("info");
            HttpSession session = request.getSession();
            Account acc  = (Account)session.getAttribute("User");
            if(acc == null){
               request.setAttribute("error", "You must login for cabin choice");
               request.getRequestDispatcher("Login.jsp").forward(request, response);
            }else{
                String info = request.getParameter("info");
                CustomerDAO dao = new CustomerDAO();
                Customer cus = dao.getCustomer(acc.getAccID().trim());
                
                if( cus != null){
                    PetDAO p = new PetDAO();
                    ArrayList<Pet> list = p.getPetsByCus(cus.getCussId());
                     
                    if(list != null){ 
                        String cabinid = request.getParameter("CabinId");
                        request.setAttribute("CabinId", cabinid);
                        request.setAttribute("txtId", request.getParameter("txtId"));
                        request.setAttribute("listPet", list);
                        request.getRequestDispatcher("ListPet.jsp").forward(request, response);
                    }else {
                        request.setAttribute("erorr", "Danh sách không tồn tại bất kì thú cưng nào");
                        request.getRequestDispatcher("ListPet.jsp").forward(request, response);
                    }
                }else{
                    response.sendRedirect("spa.jsp");
                }
            }
        }}

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
