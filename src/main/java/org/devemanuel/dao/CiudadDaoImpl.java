package org.devemanuel.dao;

import org.devemanuel.model.Ciudad;
import org.devemanuel.model.Ciudad_Table;
import org.devemanuel.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CiudadDaoImpl implements CiudadDAO {

    @Override
    public List<Ciudad> obtenerTodasCiudades() {
        // Creamos una lista donde vamos a almacenar las ciudades
        List<Ciudad> listCiudades = new ArrayList<>();

        // conseguimos una conexión
        try(Connection connection = DatabaseUtil.getConnection()){
            // consulta SQL
            String sql = "SELECT * FROM city";
            //  Creamos una declaración
            try (Statement statement = connection.createStatement() ){
                // ejecutamos la query y obtenemos los resultados
                try (ResultSet resultSet = statement.executeQuery(sql)){
                    while (resultSet.next()){
                        // obtenemos  los datos
                        int id = resultSet.getInt("ID");
                        String nombreCiudad = resultSet.getString("Name");
                        String codigoCiudad = resultSet.getString("CountryCode");
                        String distritoCiudad = resultSet.getString("District");
                        int population = resultSet.getInt("Population");
                        // agreamos a la lista
                        listCiudades.add(new Ciudad(id,nombreCiudad,codigoCiudad,distritoCiudad,population));

                    }

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listCiudades;
    }

    @Override
    public List<Ciudad> obtenerCiudadesPorNombre(String nombre) {
        // Creamos una lista donde vamos a almacenar las ciudades
        List<Ciudad> listaCiudadesPorNombre = new ArrayList<>();
        try(Connection connection = DatabaseUtil.getConnection()){
            // consulta SQL preparada
            String sql = "SELECT * FROM city WHERE District = ? ";
            //  Creamos una declaración
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql) ){
                // pasamos el parametro de la consulta
                preparedStatement.setString(1,nombre);
                // ejecutamos la query y obtenemos los resultados
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    while (resultSet.next()){
                        // obtenemos  los datos
                        int id = resultSet.getInt("ID");
                        String nombreCiudad = resultSet.getString("Name");
                        String codigoCiudad = resultSet.getString("CountryCode");
                        String distritoCiudad = resultSet.getString("District");
                        int population = resultSet.getInt("Population");
                        // agreamos a la lista
                        listaCiudadesPorNombre.add(new Ciudad(id,nombreCiudad,codigoCiudad,distritoCiudad,population));

                    }

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCiudadesPorNombre;
    }

    @Override
    public boolean agregarCiudad(Ciudad ciudad) {
        boolean resultado = false;
        try(Connection connection = DatabaseUtil.getConnection()){
            // consulta SQL preparada
            String sql = "INSERT INTO city(Name,CountryCode,District,Population) VALUES(?,?,?,?) ";
            //  Creamos una declaración
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql) ){
                // pasamos el parametro de la consulta
                preparedStatement.setString(1,ciudad.getNombreCiudad());
                preparedStatement.setString(2,ciudad.getCodigoCiudad());
                preparedStatement.setString(3, ciudad.getDistrito());
                preparedStatement.setInt(4,ciudad.getPoblacion());
                // ejecutamos la Query y guardamos el num de filas afectadas
                int i = preparedStatement.executeUpdate();
                if(i>0){
                    // si no afecto a ninguan es decir no se inserto nada se queda como false
                    resultado = true;

                }

            }

        } catch (SQLException e) {
            return false;
//            throw new RuntimeException(e);
        }
        return resultado;
    }


    @Override
    public List<Ciudad_Table> mostrarCiudades2() {
        // Creamos una lista donde vamos a almacenar las ciudades
        List<Ciudad_Table> listCiudades = new ArrayList<>();

        // conseguimos una conexión
        try(Connection connection = DatabaseUtil.getConnection()){
            // consulta SQL
            String sql = "SELECT * FROM Nueva_Tabla";
            //  Creamos una declaración
            try (Statement statement = connection.createStatement() ){
                // ejecutamos la query y obtenemos los resultados
                try (ResultSet resultSet = statement.executeQuery(sql)){
                    while (resultSet.next()){
                        // obtenemos  los datos
                        //int id = resultSet.getInt("ID");
                        String Ciudad = resultSet.getString("Ciudad");
                        String pais = resultSet.getString("Pais");
                        String idioma = resultSet.getString("Idioma");
                        // agreamos a la lista
                        listCiudades.add(new Ciudad_Table(Ciudad,pais,idioma) );

                    }

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listCiudades;
    }
}
