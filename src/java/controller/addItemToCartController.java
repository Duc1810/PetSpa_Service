/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CabinDAO;
import dao.PetDAO;
import dao.ServiceDAO;
import dto.Cabin;
import dto.Pet;
import dto.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
public class addItemToCartController extends HttpServlet {

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
            String petId = request.getParameter("txtPetId");
            String id = request.getParameter("txtId");
            //1.lấy giiỏ hàng trong session memory
            //tạo obj 
            String url = null;
            String info = null;
            String error = null;
            HttpSession session = request.getSession();
            if (id.contains("CB")) {
                HashMap<Cabin, String> giohangcabin = (HashMap<Cabin, String>) session.getAttribute("cartCabin");
                if (giohangcabin == null) {
                    giohangcabin = new HashMap<>();
                }
                String idpet = null;
                for (HashMap.Entry<Cabin, String> entry : giohangcabin.entrySet()) {
                    if (entry.getValue().equals(petId)) {
                        idpet = petId;
                        info = "Your pet was registered in system";
                        url = "ListPet";
                        request.setAttribute("txtId", id);
                        break;
                    }
                }
                if (idpet == null) {
                    PetDAO p = new PetDAO();
                    Pet pet = p.getPet(petId);
                    if (pet != null) {
                        CabinDAO dao = new CabinDAO();
                        Cabin item = dao.getItem(id.trim());
                        if (item != null) {
                            giohangcabin.put(item, pet.getPetID());
                            session.setAttribute("cartCabin", giohangcabin);
                            info="Success";
                            url = "DividePageController";
                        }
                    }
                }
            }if(id.contains("SV")){
                HashMap<Service, String> giohangservice = (HashMap<Service, String>) session.getAttribute("cartService");
                if (giohangservice == null) {
                    giohangservice = new HashMap<>();
                }
                String idpet = null;
                
                for (HashMap.Entry<Service, String> entry : giohangservice.entrySet()) {
                    if (entry.getValue().equals(petId) && entry.getKey().getServiceID().equals(id.trim())) {
                        idpet = petId;
                        info ="Your pet was registered with this service in system";
                        request.setAttribute("txtId", id);
                        url = "ListPet";
                        break;
                    }
                }
                if (idpet == null) {
                    PetDAO p = new PetDAO();
                    Pet pet = p.getPet(petId);
                    if (pet != null) {
                        ServiceDAO dao = new ServiceDAO();
                        Service item = dao.getService(id.trim());
                        if (item != null) {
                            giohangservice.put(item, pet.getPetID());
                            session.setAttribute("cartService", giohangservice);
                           info ="Success";
                            url = "listServiceController";
                        }
                    }
                }
            }
            request.setAttribute("info", info);
            request.getRequestDispatcher(url).forward(request, response);
            //3. lưu giỏ hàng vào session memory
            //4. mở trang index.jsp hoặc mở trang kế tiếp
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
            Logger.getLogger(addItemToCartController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(addItemToCartController.class.getName()).log(Level.SEVERE, null, ex);
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
