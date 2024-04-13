package org.devemanuel.dao;

import org.devemanuel.model.Ciudad;
import org.devemanuel.model.Ciudad_Table;

import java.util.List;

public interface CiudadDAO {
    List<Ciudad> obtenerTodasCiudades();
    List<Ciudad> obtenerCiudadesPorNombre(String nombre);
    boolean agregarCiudad(Ciudad ciudad);
    List<Ciudad_Table> mostrarCiudades2();

}
