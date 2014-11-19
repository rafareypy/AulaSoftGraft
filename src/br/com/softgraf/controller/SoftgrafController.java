/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.softgraf.controller;

import br.com.softgraf.model.command.InterfaceCommand;
import br.com.softgraf.model.helper.SoftGrafHelper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "SoftgrafController", urlPatterns = {"/SoftgrafController"})
public class SoftgrafController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public SoftgrafController () {
        super ();
           
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
        System.out.println("Processar Request");
        this.processarRequisicao(request, response);
    }
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processarRequisicao(request, response);
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processarRequisicao(request, response);
    }
    
    private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cmd =request.getParameter("cmd");
        System.out.println("Comando passado cmd");
         SoftGrafHelper softGrafHelper = new SoftGrafHelper(request);
         InterfaceCommand command = softGrafHelper.getCommnand();
         
         String pagina = command.execute(request, response);
         //String pagina = "SoftgrafController?cmd=iniciarSoftgraf";
         
         request.getRequestDispatcher(pagina).forward(request, response);
         
         
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
   

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

}
