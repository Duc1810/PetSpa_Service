/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PetDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class UpdatePetController extends HttpServlet {

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
            
            String id = request.getParameter("txtPetId");
            String name = request.getParameter("txtname");
            String gender = request.getParameter("txtgender");
            String color = request.getParameter("txtcolor");
            String height = request.getParameter("txtheight");
            String width = request.getParameter("txtwidth");
            String weight = request.getParameter("txtweight");
            PetDAO p = new PetDAO();
            int r1 = p.updatePetName(id, name);
            int r2 = p.updateGender(id, gender);
            int r3 = p.updateColor(id, color);
            int r4 = p.updateHeight(id, Float.parseFloat(height));
            int r5 = p.updateWidth(id, Float.parseFloat(width));
            int r6 = p.updateWeight(id, Float.parseFloat(weight));
            if (r1 == 1 && r2 == 1 && r3 == 1 && r4 == 1 && r5 == 1 && r6 == 1) {
                request.setAttribute("info", "updated success");
                request.getRequestDispatcher("MainController?action=listpetCus").forward(request, response);
            }else {
                request.setAttribute("info", "update failed");
                request.getRequestDispatcher("MainController?action=listpetCus").forward(request, response);
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
