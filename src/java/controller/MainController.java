/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class MainController extends HttpServlet {

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
            String action = request.getParameter("action");
            String url = "index.jsp";

            if (action == null) {
                action = "home";
            }
            switch (action) {
                case "updateCus":
                    url="UpdateCusController";
                    break;
                case "Disable":
                    url = "DisableController";
                    break;
                 case "updatePet":
                    url = "UpdatePetController";
                    break;
                case "listPetCust":
                    url="listPetCus.jsp";
                    break;
                case "listpetCus":
                    url = "ListPetCustController";
                    break;
                case "petpage":
                    url="Pet.jsp";
                    break;
                case "listPet":
                    url = "ListPet.jsp";
                    break;
                case "listCabin":
                    url = "listRent.jsp";
                    break;
                case "typecabin":
                    url = "CatergoryController";
                    break;
                case "sizepage":
                    url="SizeContronller";
                    break;
                case "Choice":
                    url="ChoicePetCabinController";
                    break;
                case "viewcart":
                    url="ShoppingCart.jsp";
                    break;
                case "logout":
                    url="LogoutController";
                    break;
                case "serviceMenu":
                    url="listServiceController";
                    break;
                case "cabinMenu":
                    url = "DividePageController";
                    break;
                case "Signup Now":
                    url="RegisterController";
                    break;
                case "Login":
                    url = "LoginController";
                    break;
                case "signin":
                    url = "Login.jsp";
                    break;
                case "Signup":
                    url = "Register.jsp";
                    break;
                case "home":
                    url = "index.jsp";
                    break;
                case "cabin":
                    url = "cabinpage.jsp";
                    break;
                case "Submit":
                    url = "findCabinController";
                    break;
                case "service":
                    url = "servicepage.jsp";
                    break;
                case "Search":
                    url = "findServiceController";
                    break;
                case "header":
                    url = "header.jsp";
                    break;
                case "updateCB":
                    url = "updateCBController";
                    break;
                case "removeCB":
                    url = "removeCBController";
                    break;
                case "updateSV":
                    url = "updateSVController";
                    break;
                case "removeSV":
                    url = "removeSVController";
                    break;
                case "account":
                    url = "account.jsp";
                    break;
                case "Lock/Unlock":
                    url = "lockAccountController";
                    break;
                case "manageSV":
                    url="ManageServiceController";
                    break;
                case "UnabkeS":
                    url = "removeServiceController";
                    break;
            }
            request.getRequestDispatcher(url).forward(request, response);
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
