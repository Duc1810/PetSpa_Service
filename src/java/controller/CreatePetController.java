/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DT.UI;
import dao.CustomerDAO;
import dao.PetDAO;
import dto.Account;
import dto.Customer;
import dto.Pet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class CreatePetController extends HttpServlet {

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
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("User");
            CustomerDAO c = new CustomerDAO();

            Customer cusid = c.getCustomer(acc.getAccID());
            if(cusid.getCussId()!= null){
            if (acc != null) {
                PetDAO p = new PetDAO();
                String pname = (String) request.getParameter("txtname");
                Date pbirthday = Date.valueOf(request.getParameter("txtbirthday"));
                String pgender = (String) request.getParameter("txtgender");
                String pcolor = (String) request.getParameter("txtcolor");
                Float pheight = Float.parseFloat(request.getParameter("txtheight"));
                Float pwidth = Float.parseFloat(request.getParameter("txtwidth"));
                Float pweight = Float.parseFloat(request.getParameter("txtweight"));
                String ptype =  request.getParameter("txtType");
                int type = Integer.parseInt(ptype);
                ptype = type==1 ? "Chó": "Mèo";
                String id = UI.generateId("PET", p.getIdMax());
                Pet pet = new Pet(id, pname, pbirthday, pgender, pcolor, pheight, pwidth, pweight, " ", 1, ptype, cusid.getCussId());
                if(p.createPet(pet) == 1){
                    request.setAttribute("info", "Resgister new pet in your list pet");
                    request.getRequestDispatcher("MainController?action=petpage").forward(request, response);
                }else{
                    request.setAttribute("info", "Register Pet Fail!");
                    request.getRequestDispatcher("MainController?action=petpage").forward(request, response);
                }           
            } else {
                response.sendRedirect("MainController?action=signin");
            }
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
