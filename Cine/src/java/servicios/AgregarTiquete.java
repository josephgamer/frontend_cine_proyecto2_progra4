/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.ConjuntoTiquete;
import modelo.beans.Proyeccion;
import modelo.beans.Tiquete;
import modelo.beans.Usuario;

/**
 *
 * @author Esteban
 */
public class AgregarTiquete extends HttpServlet {

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

        try {
            Integer proyeccion = Integer.parseInt(request.getParameter("proyeccion"));
            String cedula = "";
            if (request.getSession(true).getAttribute("idUsuario").toString() != null) {
                cedula = request.getSession(true).getAttribute("idUsuario").toString();
            }

            if (cedula != null) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(cedula);

                Proyeccion proyeccion1 = new Proyeccion();
                proyeccion1.setNumProyeccion(proyeccion);

                Tiquete tiquete = new Tiquete();
                tiquete.setUsuario(usuario);
                tiquete.setProyeccion(proyeccion1);
                tiquete.setAsiento(0);
                tiquete.setTotalPagar(0);

                ConjuntoTiquete ct = new ConjuntoTiquete();
                ct.agregarTiquete(tiquete);
                response.sendRedirect("PrincipalCliente.jsp");
            }
        } catch (NullPointerException | NumberFormatException ex) {
            response.sendRedirect("index.jsp");
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
