/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.Usuario;

/**
 *
 * @author Esteban
 */
public class ServicioLogin extends HttpServlet {

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
            String user = request.getParameter("uname");
            String password = request.getParameter("psw");
            modelo.beans.ConjuntoUsuario cu = new modelo.beans.ConjuntoUsuario();
            modelo.beans.ConjuntoLogin lu = new modelo.beans.ConjuntoLogin();
            
            if (lu.existeUsuario(user, Integer.parseInt(password))) {
            modelo.beans.Usuario u = new modelo.beans.Usuario();
            u = cu.obtenerRol(user);
            switch(u.getRol().getNumRol()){
                case 1: 
                    response.sendRedirect("PrincipalAdmin.jsp");
                    break;
                case 2:
                    request.getSession(true).setAttribute("cedula", user);
                    response.sendRedirect("PrincipalCliente.jsp");
                    break;
                default:
                    response.sendRedirect("index.jsp");
        }
            
        } else {
            response.sendRedirect("index.jsp");
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