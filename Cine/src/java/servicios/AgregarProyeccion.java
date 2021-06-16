/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.ConjuntoHorario;
import modelo.beans.ConjuntoProyeccion;
import modelo.beans.Horario;
import modelo.beans.Pelicula;
import modelo.beans.Proyeccion;
import modelo.beans.Sala;

/**
 *
 * @author Esteban
 */
public class AgregarProyeccion extends HttpServlet {

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
        String hora = request.getParameter("hora");
        Horario h = new Horario();
        Proyeccion proyeccion = new Proyeccion();
        Pelicula peli = new Pelicula();
        Sala sala = new Sala();
        ConjuntoHorario ch = new ConjuntoHorario();
        ConjuntoProyeccion cpr = new ConjuntoProyeccion();
        h.setHora(Integer.parseInt(hora));
        try {
            h.setDia(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha")));
        } catch (ParseException ex) {
            Logger.getLogger(AgregarProyeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sala.setNumSala(Integer.parseInt(request.getParameter("sala")));
        h.setNumHorario(ch.returnLastHorario());
        peli.setNumpelicula(Integer.parseInt(request.getParameter("peli")));
        proyeccion.setHorario(h);
        proyeccion.setPelicula(peli);
        proyeccion.setSala(sala);
        ch.addSchedule(h);
        cpr.addProyeccion(proyeccion);
        response.sendRedirect("AgregarProyeccion.jsp");
        
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
