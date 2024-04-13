package org.devemanuel;

import org.devemanuel.dao.CiudadDaoImpl;
import org.devemanuel.model.Ciudad;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HomeFrame  extends JFrame {
    private JPanel mainPanel;
    private JButton explorarTodosLosRegistrosButton;
    private JButton anteriorButton;
    private JTextField textFieldAnterior;
    private JTextField textFieldSiguiente;
    private JButton siguienteButton;
    private JPanel tabla;
    private JTextField textFieldID;
    private JTextField textFieldNombre;
    private JTextField textFieldCode;
    private JTextField textFieldPoblacion;
    private JPanel idJLabel;
    private JPanel nameJLabel;
    private JPanel codeJLabel;
    private JPanel poblaJLabel;
    private JPanel distJLabel;
    private JPanel panel1;
    private JTextField textFieldBuscar;
    private JButton buscarButton;
    private JButton agregarButton;
    private JTextField textFieldDistrito;
    private JTextField textFieldAgregarNombre;
    private JTextField textFieldAgregarCode;
    private JTextField textFieldAgregarDistrito;
    private JTextField textFieldAgregarPoblacion;
    private JLabel textVerifica;
    private JButton anteriorBuscarButton;
    private JButton siguienteBuscarButton;
    private JTextField textFieldAnteriorBuscar;
    private JTextField textFieldSiguienteBuscar;
    private JTextField textFieldBuscarID;
    private JTextField textFieldBuscarNombre;
    private JTextField textFieldBuscarCode;
    private JTextField textFieldBuscarDistrito;
    private JTextField textFieldBuscarPoblacion;
    private JLabel verificaListBuscar;
    private static  int  indice = 0;
    private static  int indiceDis = 0;
    private static List<Ciudad> ciudadsDistrito;


    /*
    Podemos agregar en el constructor de homeFrame o en un metodo
    para inicializar los componentes
     */
    public HomeFrame() {
        initComponents();

    }

    private void initComponents() {
        CiudadDaoImpl dao =  new CiudadDaoImpl();
        List<Ciudad> ciudads = dao.obtenerTodasCiudades();
//        List<Ciudad> ciudadsDistrito;
        //int  indice = 0;
        explorarTodosLosRegistrosButton.addActionListener(e-> {
            System.out.println("Boton Explorar Todos Los Registros");
            //List<Ciudad> ciudads = dao.obtenerTodasCiudades();
            int totalRegistro = ciudads.size();
            textFieldAnterior.setText("1");
            textFieldSiguiente.setText(Integer.toString(totalRegistro));
            Ciudad city1 = ciudads.get(indice);
            textFieldID.setText(String.valueOf(city1.getIdentificador()));
            textFieldNombre.setText(city1.getNombreCiudad());
            textFieldCode.setText(city1.getCodigoCiudad());
            textFieldDistrito.setText(city1.getDistrito());
            textFieldPoblacion.setText(String.valueOf(city1.getPoblacion()));
            textFieldAnterior.setText(String.valueOf(indice+1));

        });

        anteriorButton.addActionListener(e-> {
            System.out.println("Boton Anterior");
            indice = indice-1;
            if (indice < 0){
                indice = 0;
            }
            
            Ciudad city = ciudads.get(indice);
            textFieldID.setText(String.valueOf(city.getIdentificador()));
            textFieldNombre.setText(city.getNombreCiudad());
            textFieldCode.setText(city.getCodigoCiudad());
            textFieldDistrito.setText(city.getDistrito());
            textFieldPoblacion.setText(String.valueOf(city.getPoblacion()));
            textFieldAnterior.setText(String.valueOf(indice+1));

        });

        siguienteButton.addActionListener(e->{
            System.out.println("Boton siguiente");
            indice = indice + 1;
            Ciudad city = ciudads.get(indice);
            textFieldID.setText(String.valueOf(city.getIdentificador()));
            textFieldNombre.setText(city.getNombreCiudad());
            textFieldCode.setText(city.getCodigoCiudad());
            textFieldDistrito.setText(city.getDistrito());
            textFieldPoblacion.setText(String.valueOf(city.getPoblacion()));
            textFieldAnterior.setText(String.valueOf(indice+1));


        });


        buscarButton.addActionListener(e-> {
            System.out.println("Boton buscar ");

            String distrito = textFieldBuscar.getText();
            ciudadsDistrito = dao.obtenerCiudadesPorNombre(distrito);
            // verificamos si la lista esta vacia, si lo esta es que el distrito no esta
            if(ciudadsDistrito.isEmpty()){
                verificaListBuscar.setText("No se encontro ningun registro o esta escrito incorrectamente");
                verificaListBuscar.setForeground(Color.RED);
            }
            else{
                verificaListBuscar.setText("");
                int totalRegistro = ciudadsDistrito.size();
                textFieldAnteriorBuscar.setText("1");
                textFieldSiguienteBuscar.setText(Integer.toString(totalRegistro));
                Ciudad city1 = ciudadsDistrito.get(indiceDis);
                textFieldBuscarID.setText(String.valueOf(city1.getIdentificador()));
                textFieldBuscarNombre.setText(city1.getNombreCiudad());
                textFieldBuscarCode.setText(city1.getCodigoCiudad());
                textFieldBuscarDistrito.setText(city1.getDistrito());
                textFieldBuscarPoblacion.setText(String.valueOf(city1.getPoblacion()));
                textFieldAnteriorBuscar.setText(String.valueOf(indiceDis+1));

            }



        });

        siguienteBuscarButton.addActionListener(e -> {
            System.out.println("Boton Buscar siguiente");
            indiceDis = indiceDis + 1;
//            System.out.println(ciudadsDistrito.size());
            if (indiceDis >= ciudadsDistrito.size()){
                indiceDis = ciudadsDistrito.size()-1;
            }
            Ciudad city = ciudadsDistrito.get(indiceDis);
            textFieldBuscarID.setText(String.valueOf(city.getIdentificador()));
            textFieldBuscarNombre.setText(city.getNombreCiudad());
            textFieldBuscarCode.setText(city.getCodigoCiudad());
            textFieldBuscarDistrito.setText(city.getDistrito());
            textFieldBuscarPoblacion.setText(String.valueOf(city.getPoblacion()));
            textFieldAnteriorBuscar.setText(String.valueOf(indiceDis+1));
        });

        anteriorBuscarButton.addActionListener(e-> {
            System.out.println("Boton Buscar Anterior");
            indiceDis = indiceDis-1;
            if (indiceDis < 0){
                indiceDis = 0;
            }

            Ciudad city = ciudadsDistrito.get(indiceDis);
            textFieldBuscarID.setText(String.valueOf(city.getIdentificador()));
            textFieldBuscarNombre.setText(city.getNombreCiudad());
            textFieldBuscarCode.setText(city.getCodigoCiudad());
            textFieldBuscarDistrito.setText(city.getDistrito());
            textFieldBuscarPoblacion.setText(String.valueOf(city.getPoblacion()));
            textFieldAnteriorBuscar.setText(String.valueOf(indiceDis+1));

        });



        agregarButton.addActionListener(e-> {
            System.out.println("Boton agregar");
            String name = textFieldAgregarNombre.getText();
            String code = textFieldAgregarCode.getText();
            String distrito = textFieldAgregarDistrito.getText();
            int poblacion = Integer.parseInt(textFieldAgregarPoblacion.getText());
            Ciudad city = new Ciudad(name,code,distrito,poblacion);
            boolean b = dao.agregarCiudad(city);
            if (b){
                textVerifica.setText("Registro agregado correctamente");
                textVerifica.setForeground(Color.GREEN);
            }
            else {
                textVerifica.setText("Hubo algun error");
                textVerifica.setForeground(Color.RED);
            }

        });

        textFieldAnterior.addActionListener(e -> {
            String textoIngresado = textFieldAnterior.getText();
            System.out.println("Texto en textFieldAnterior: " + textoIngresado);
        });




    }





    public static void main(String[] args) {
        JFrame frame = new JFrame("Ciudades");
        frame.setContentPane(new HomeFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

