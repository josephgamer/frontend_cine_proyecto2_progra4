/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.ConjuntoPelicula;
import modelo.beans.Pelicula;
import utilities.IOUtilities;

/**
 *
 * @author Esteban
 */
public class CargaImagen {

    private ConjuntoPelicula cp;

    public CargaImagen() {
        this.cp = new ConjuntoPelicula();
    }

    public Pelicula cargarImagen(HttpServletResponse response, int id) throws IOException {
        Pelicula peli = this.cp.retrievePelicula(id);
        try (OutputStream out = response.getOutputStream()) {
            IOUtilities.copy(peli.getEntrada(), out);
        } catch (IOException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            throw ex;
        }
        return peli;
    }

}
