/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.beans.ConjuntoPelicula;
import modelo.beans.Pelicula;

/**
 *
 * @author Esteban
 */
@WebServlet
@MultipartConfig()
public class AgregarPeli extends HttpServlet {

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
        String nombre = request.getParameter("nombre");
        Pelicula peli = new Pelicula();
        peli.setDescripcion(nombre);
        try {
            for (Part part : request.getParts()) {

                String campo = part.getName();
                System.out.printf("Nombre del campo (formulario): '%s'%n", campo);

                String nombreArchivo = part.getSubmittedFileName();

                if (nombreArchivo.isEmpty()) {
                    request.setAttribute("mensaje",
                            "Se omitió la selección del archivo.");
                    break;
                }

                if (ConjuntoPelicula.validar(nombreArchivo)) {
                    ConjuntoPelicula g1 = new ConjuntoPelicula();
                    try {
                        peli.setTamano((int) part.getSize());
                        peli.setEntrada(part.getInputStream());
                        g1.agregarPelicula(peli);
                    } catch (Exception ex) {
                        request.setAttribute("mensaje",
                                String.format("Excepción: '%s'", ex.getMessage()));
                    }
                } else {
                    request.setAttribute("mensaje",
                            "El formato del archivo es incorrecto.");
                    break;
                }
            }
            /*Part filePart = request.getPart("imagen");
            String nombreArchivo = filePart.getSubmittedFileName();
            if (nombreArchivo.isEmpty()) {
                request.setAttribute("mensaje",
                        "Se omitió la selección del archivo.");
            }
            if (ConjuntoPelicula.validar(nombreArchivo)) {
                    ConjuntoPelicula g1 = new ConjuntoPelicula();
                    try {
                        peli.setTamano((int) filePart.getSize());
                        peli.setEntrada(filePart.getInputStream());
                        g1.agregarPelicula(peli);
                    } catch (Exception ex) {
                        request.setAttribute("mensaje",
                                String.format("Excepción: '%s'", ex.getMessage()));
                    }
                } else {
                    request.setAttribute("mensaje",
                            "El formato del archivo es incorrecto.");
                }*/
        } catch (IOException | ServletException ex) {
            request.setAttribute("mensaje",
                    String.format("Ocurrió una excepción: '%s'", ex.getMessage()));
        }

        //getServletContext().getRequestDispatcher("/AgregarPelicula.jsp").forward(request, response);
        response.sendRedirect("AgregarPelicula.jsp");

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
        //processRequest(request, response);
        String nombre = request.getParameter("nombre");
        Pelicula peli = new Pelicula();
        peli.setDescripcion(nombre);
        try {
            Part part = request.getPart("imagen");

                String campo = part.getName();
                System.out.printf("Nombre del campo (formulario): '%s'%n", campo);

                String nombreArchivo = part.getSubmittedFileName();

                if (nombreArchivo.isEmpty()) {
                    request.setAttribute("mensaje",
                            "Se omitió la selección del archivo.");
                    
                }

                if (ConjuntoPelicula.validar(nombreArchivo)) {
                    ConjuntoPelicula g1 = new ConjuntoPelicula();
                    try {
                        peli.setTamano((int) part.getSize());
                        peli.setEntrada(part.getInputStream());
                        g1.agregarPelicula(peli);
                    } catch (Exception ex) {
                        request.setAttribute("mensaje",
                                String.format("Excepción: '%s'", ex.getMessage()));
                    }
                } else {
                    request.setAttribute("mensaje",
                            "El formato del archivo es incorrecto.");
                    
                }
            
            /*Part filePart = request.getPart("imagen");
            String nombreArchivo = filePart.getSubmittedFileName();
            if (nombreArchivo.isEmpty()) {
                request.setAttribute("mensaje",
                        "Se omitió la selección del archivo.");
            }
            if (ConjuntoPelicula.validar(nombreArchivo)) {
                    ConjuntoPelicula g1 = new ConjuntoPelicula();
                    try {
                        peli.setTamano((int) filePart.getSize());
                        peli.setEntrada(filePart.getInputStream());
                        g1.agregarPelicula(peli);
                    } catch (Exception ex) {
                        request.setAttribute("mensaje",
                                String.format("Excepción: '%s'", ex.getMessage()));
                    }
                } else {
                    request.setAttribute("mensaje",
                            "El formato del archivo es incorrecto.");
                }*/
        } catch (IOException | ServletException ex) {
            request.setAttribute("mensaje",
                    String.format("Ocurrió una excepción: '%s'", ex.getMessage()));
        }

        //getServletContext().getRequestDispatcher("/AgregarPelicula.jsp").forward(request, response);
        response.sendRedirect("AgregarPelicula.jsp");
        
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
