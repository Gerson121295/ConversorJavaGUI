import conversores.ConversorMoneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//- Interfaz de Conversor de Temperatura

public class ConversorTemperaturaGUI extends JFrame implements ActionListener {

    //Componentes necesarios para la interfaz
    private JMenuBar mb;
    private JMenu menuOpciones, menuCalcular, menuAcercaDe, menuColorFondo;
    private JMenuItem miRojo, miNegro, miMorado, miElCreador, miSalir, miNuevo, convierteMonedas, calculaTemperatura;
    private JLabel labelLogo, labelBienvenido, labelTitle, labelTemperaturaIngresada,
            labelTemperaturaOrigen, labelTemperaturaDestino, labelResultado, labelfooter;
    private JTextField txtTemperaturaIngresada;
    private JComboBox comboTemperaturaOrigen, comboTemperaturaDestino;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;

    private JButton botonConvertir;

    //Constructor para el diseño de la interfaz
    public ConversorTemperaturaGUI() {
        setLayout(null); //Para coordenadas
        setDefaultCloseOperation(EXIT_ON_CLOSE); //cerrar el programa
        setTitle("Pantalla principal");
        getContentPane().setBackground(new Color(105, 102, 102));
        setIconImage(new ImageIcon(getClass().getResource("images/logoTemperatura.png")).getImage());

        mb = new JMenuBar();
        mb.setBackground(new Color(171, 154, 154)); //255, 0, 0   establece color rojo de fondo
        setJMenuBar(mb); //mb se agrega como MenuBar

        menuOpciones = new JMenu("Opciones");
        menuOpciones.setBackground(new Color(255, 0, 0));
        menuOpciones.setFont(new Font("Andale Mono", 1, 14));
        menuOpciones.setForeground(new Color(255, 255, 255));
        mb.add(menuOpciones); //Se agrega menuOpciones al mb (menuBar)

        menuCalcular = new JMenu("Calcular");
        menuCalcular.setBackground(new Color(255, 0, 0));
        menuCalcular.setFont(new Font("Andale Mono", 1, 14));
        menuCalcular.setForeground(new Color(255, 255, 255));
        mb.add(menuCalcular); //Se agrega menuCalcular al mb (menuBar)

        menuAcercaDe = new JMenu("Acerca de");
        menuAcercaDe.setBackground(new Color(255, 0, 0));
        menuAcercaDe.setFont(new Font("Andale Mono", 1, 14));
        menuAcercaDe.setForeground(new Color(255, 255, 255));
        mb.add(menuAcercaDe); //Se agrega menuAcercaDe al mb (menuBar)


        //Submenus
        menuColorFondo = new JMenu("Color de fondo");
        menuColorFondo.setFont(new Font("Andale Mono", 1, 14));
        menuColorFondo.setForeground(new Color(255, 0, 0));
        menuOpciones.add(menuColorFondo); //menuColorFOndo es un submenu de menuOpciones

        calculaTemperatura = new JMenuItem("Calcula Temperatura");
        calculaTemperatura.setFont(new Font("Andale Mono", 1, 14));
        calculaTemperatura.setForeground(new Color(255,0,0));
        calculaTemperatura.setEnabled(false); //Submenu Calcula Temperatura se verá Inactivo cuando este en la pagina temperatura.
        menuCalcular.add(calculaTemperatura); //calculaTemperatura es un submenu de menuCalcular
        calculaTemperatura.addActionListener(this);  //habilitar para escuchar eventos el submenu

        convierteMonedas = new JMenuItem("Convierte Monedas");
        convierteMonedas.setFont(new Font("Andale Mono", 1,14));
        convierteMonedas.setForeground(new Color(255,0,0));
        menuCalcular.add(convierteMonedas);
        convierteMonedas.addActionListener(this);


        miRojo = new JMenuItem("Rojo");
        miRojo.setFont(new Font("Andale Mono", 1, 14));
        miRojo.setForeground(new Color(255, 0, 0));
        menuColorFondo.add(miRojo); //miRojo es un submenu de menuColorFondo
        miRojo.addActionListener(this);//habilitar para escuchar eventos

        miNegro = new JMenuItem("Negro");
        miNegro.setFont(new Font("Andale Mono", 1, 14));
        miNegro.setForeground(new Color(255, 0, 0));
        menuColorFondo.add(miNegro); //miNegro es un submenu de menuColorFondo
        miNegro.addActionListener(this);//habilitar para escuchar eventos

        miMorado = new JMenuItem("Morado");
        miMorado.setFont(new Font("Andale Mono", 1, 14));
        miMorado.setForeground(new Color(255, 0, 0));
        menuColorFondo.add(miMorado); //miMorado es un submenu de menuColorFondo
        miMorado.addActionListener(this);//habilitar para escuchar eventos

        miNuevo = new JMenuItem("Nuevo");
        miNuevo.setFont(new Font("Andale Mono", 1, 14));
        miNuevo.setForeground(new Color(255, 0, 0));
        menuOpciones.add(miNuevo);
        miNuevo.addActionListener(this);

        miElCreador = new JMenuItem("El Creador");
        miElCreador.setFont(new Font("Andale Mono", 1, 14));
        miElCreador.setForeground(new Color(255, 0, 0));
        menuAcercaDe.add(miElCreador); //miElCreador es un submenu de menuAcercaDe
        miElCreador.addActionListener(this);//habilitar para escuchar eventos

        miSalir = new JMenuItem("Salir");
        miSalir.setFont(new Font("Andale Mono", 1, 14));
        miSalir.setForeground(new Color(255, 0, 0));
        menuOpciones.add(miSalir); //miSalir es un submenu de menuOpciones
        miSalir.addActionListener(this);//habilitar para escuchar eventos

        ImageIcon imagen = new ImageIcon("src/images/temperatura-image.png");
        labelLogo = new JLabel(imagen);
        labelLogo.setBounds(5, 5, 300, 135);
        add(labelLogo);

        labelBienvenido = new JLabel("Bienvenido");
        labelBienvenido.setBounds(350, 60, 300, 50);
        labelBienvenido.setFont(new Font("Andale Mono", 1, 32));
        labelBienvenido.setForeground(new Color(255, 255, 255));
        add(labelBienvenido);

        labelTitle = new JLabel("Ingresa los datos:");
        labelTitle.setBounds(60, 150, 900, 25);
        labelTitle.setFont(new Font("Andale Mono", 1, 20));
        labelTitle.setForeground(new Color(255, 255, 255));
        add(labelTitle);


        //Label y TextArea para la Temperatura Ingresada
        labelTemperaturaIngresada = new JLabel("Ingresa la Temperatura");
        labelTemperaturaIngresada.setBounds(25, 188, 180, 25);
        labelTemperaturaIngresada.setFont(new Font("Andale Mono", 1, 12));
        labelTemperaturaIngresada.setForeground(new Color(255, 255, 255));
        add(labelTemperaturaIngresada);

        txtTemperaturaIngresada = new JTextField();
        txtTemperaturaIngresada.setBounds(25, 213, 150, 25);
        txtTemperaturaIngresada.setBackground(new java.awt.Color(224, 224, 224));
        txtTemperaturaIngresada.setFont(new java.awt.Font("Andale Mono", 1, 14));
        txtTemperaturaIngresada.setForeground(new java.awt.Color(255, 0, 0));
        add(txtTemperaturaIngresada);

        //Botones
        botonConvertir = new JButton("Calcular");
        botonConvertir.setBounds(35, 275, 125, 30);
        botonConvertir.setBackground(new java.awt.Color(224,224,224));
        botonConvertir.setFont(new Font("Andale Mono", 1, 12));
        botonConvertir.setForeground(new Color(5, 3, 54));
        add(botonConvertir);
        botonConvertir.addActionListener(this);// Activar escuchar este boton

        //Label y Combox para el nombre y tipo de Moneda Origen

        labelTemperaturaOrigen = new JLabel("Selecciona la temperatura origen:");
        labelTemperaturaOrigen.setBounds(220, 188, 210, 25);
        labelTemperaturaOrigen.setFont(new Font("Andale Mono", 1, 12));
        labelTemperaturaOrigen.setForeground(new Color(255, 255, 255));
        add(labelTemperaturaOrigen);

        comboTemperaturaOrigen = new JComboBox();
        comboTemperaturaOrigen.setBounds(220, 213, 220, 25);
        comboTemperaturaOrigen.setBackground(new java.awt.Color(224, 224, 224));
        comboTemperaturaOrigen.setFont(new java.awt.Font("Andale Mono", 1, 14));
        comboTemperaturaOrigen.setForeground(new java.awt.Color(255, 0, 0));
        add(comboTemperaturaOrigen);
        comboTemperaturaOrigen.addItem("Elige la temperatura");
        comboTemperaturaOrigen.addItem("Celsius");
        comboTemperaturaOrigen.addItem("Fahrenheit");
        comboTemperaturaOrigen.addItem("Kelvin");


        //Label y Combox para la Moneda Destino
        labelTemperaturaDestino = new JLabel("Selecciona la temperatura destino:");
        labelTemperaturaDestino.setBounds(220, 248, 210, 25);
        labelTemperaturaDestino.setFont(new Font("Andale Mono", 1, 12));
        labelTemperaturaDestino.setForeground(new Color(255, 255, 255));
        add(labelTemperaturaDestino);

        comboTemperaturaDestino = new JComboBox();
        comboTemperaturaDestino.setBounds(220, 273, 220, 25);
        comboTemperaturaDestino.setBackground(new java.awt.Color(224, 224, 224));
        comboTemperaturaDestino.setFont(new java.awt.Font("Andale Mono", 1, 14));
        comboTemperaturaDestino.setForeground(new java.awt.Color(255, 0, 0));
        add(comboTemperaturaDestino);
        comboTemperaturaDestino.addItem("Elige la temperatura");
        comboTemperaturaDestino.addItem("Celsius");
        comboTemperaturaDestino.addItem("Fahrenheit");
        comboTemperaturaDestino.addItem("Kelvin");

        //Label y TextArea para el resultado
        labelResultado = new JLabel("Resultado del Cálculo:");
        labelResultado.setBounds(220, 307, 180, 25);
        labelResultado.setFont(new Font("Andale Mono", 1, 12));
        labelResultado.setForeground(new Color(255, 255, 255));
        add(labelResultado);

        textArea1 = new JTextArea();
        textArea1.setEditable(false);
        textArea1.setBackground(new Color(224, 224, 224));
        textArea1.setFont(new Font("Andale Mono", 1, 11));
        textArea1.setForeground(new Color(255, 0, 0));
        textArea1.setText("\n   Aquí aparece el resultado del cálculo de la conversión.");
        scrollPane1 = new JScrollPane(textArea1);
        scrollPane1.setBounds(220, 333, 350, 80);
        add(scrollPane1);

        //Label Para el Pie de pagina
        labelfooter = new JLabel("©2023 Todos los derechos reservados | Fecha 26/07/2023.");
        labelfooter.setBounds(80, 445, 500, 30);
        labelfooter.setFont(new java.awt.Font("Andale Mono", 1, 11));
        labelfooter.setForeground(new java.awt.Color(255, 255, 255));
        add(labelfooter);

    }


    //Programar los evento
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonConvertir) {
            double temperaturaIngresadaNum = 0;
            //String cantidadMonedaAConvertirText = txtCantidadMonedaAConvertir.getText(); //no
            //cantidadMonedaAConvertirNum = Double.parseDouble(txtCantidadMonedaAConvertir.getText()); //funciona

            String temperaturaIngresadaTxt = txtTemperaturaIngresada.getText();

            String temperaturaOrigen = comboTemperaturaOrigen.getSelectedItem().toString();
            String temperaturaDestino = comboTemperaturaDestino.getSelectedItem().toString();

            //validar que los campos no esten vacios
            if (temperaturaIngresadaTxt.equals("") || temperaturaOrigen.equals("") || temperaturaDestino.equals("")) {
                JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos.");

            } else {

                temperaturaIngresadaNum = Double.parseDouble(temperaturaIngresadaTxt); //Parseo de dato de entrada Esta en String pasa a  double
                double gradosFahrenheit = 0, gradosCelsius = 0, gradosKelvin = 0;

                //Condicional para Celsius
                if (temperaturaOrigen.equals("Celsius")) { //si se selecciono Atención al Cliente

                    if (temperaturaDestino.equals("Celsius")) {
                        //temperaturaIngresadaNum = Double.parseDouble(temperaturaIngresadaTxt); //Parseo de dato de entrada Esta en String pasa a  double
                        textArea1.setText("\n   " + temperaturaIngresadaNum + " Celsius");
                    }
                    if (temperaturaDestino.equals("Fahrenheit")) {
                        gradosFahrenheit = (1.8 * temperaturaIngresadaNum) + 32; // F= 9/5 * c +32
                        textArea1.setText("\n   " + gradosFahrenheit + " Fahrenheit");
                    }
                    if (temperaturaDestino.equals("Kelvin")) {
                        gradosKelvin = temperaturaIngresadaNum + 273.15; // C + 273.15 = K
                        textArea1.setText("\n   " + gradosKelvin + " Kelvin");
                    }


                }


                //Condicional para Fahrenheit
                if (temperaturaOrigen.equals("Fahrenheit")) {

                    if (temperaturaDestino.equals("Fahrenheit")) {
                        textArea1.setText("\n   " + temperaturaIngresadaNum + " Fahrenheit");
                    }
                    if (temperaturaDestino.equals("Celsius")) {
                        gradosCelsius = (5 * (temperaturaIngresadaNum - 32)) / 9;  //  C = (5 (F-32)/9) + 32
                        textArea1.setText("\n   " + gradosCelsius + " Celsius");
                    }
                    if (temperaturaDestino.equals("Kelvin")) {
                        gradosKelvin = (0.55555 * (temperaturaIngresadaNum - 32)) + 273.15;  // K = 5/9 (ºF – 32) + 273.15
                        textArea1.setText("\n   " + gradosKelvin + " Kelvin");
                    }

                }


                //Condicional para Kelvin
                if (temperaturaOrigen.equals("Kelvin")) {

                    if (temperaturaDestino.equals("Kelvin")) {
                        textArea1.setText("\n   " + temperaturaIngresadaNum + " Kelvin");
                    }
                    if (temperaturaDestino.equals("Celsius")) {
                        gradosCelsius = temperaturaIngresadaNum - 273.15; //C = K - 273.15
                        textArea1.setText("\n   " + gradosCelsius + " Celsius");
                    }
                    if (temperaturaDestino.equals("Fahrenheit")) {
                        gradosFahrenheit = ((temperaturaIngresadaNum - 273.15) * 1.8) + 32; //(K − 273.15) × 9/5 + 32 = °F
                        textArea1.setText("\n   " + gradosFahrenheit + " Fahrenheit");
                    }

                }

            }
        }

        if (e.getSource() == miRojo) {
            getContentPane().setBackground(new Color(255, 0, 0));
        }
        if (e.getSource() == miNegro) {
            getContentPane().setBackground(new Color(0, 0, 0));
        }
        if (e.getSource() == miMorado) {
            getContentPane().setBackground(new Color(51, 0, 51));
        }
        if (e.getSource() == miNuevo) {

            //Se limpia los campos de texto
            txtTemperaturaIngresada.setText("");
            comboTemperaturaOrigen.setSelectedIndex(0);
            comboTemperaturaDestino.setSelectedIndex(0);
            textArea1.setText("\n   Aquí aparece el resultado de la conversion.");

        }

        if(e.getSource() == convierteMonedas ){
            //Será visible la ventana de Convertir Monedas
            ConversorMonedaInterfazGUI ventanaConversorMoneda = new ConversorMonedaInterfazGUI();
            ventanaConversorMoneda.setBounds(0,0,640,535);
            ventanaConversorMoneda.setVisible(true);
            ventanaConversorMoneda.setResizable(false);//Evitar que el user pueda modificar el tamaño de la interfaz
            ventanaConversorMoneda.setLocationRelativeTo(null); //Agregar la interfaz al centro de la pantalla

            this.setVisible(false); //Esta ventana de temperatura no será Visible
        }

        //Esta no se utiliza ya que estando en la ventana de Temperaturas no permitira seleccionar el submenu Convertir calcular temperatura
        if(e.getSource() == calculaTemperatura){
            ConversorTemperaturaGUI ventanaTemperatura = new ConversorTemperaturaGUI();
            ventanaTemperatura.setBounds(0, 0, 640, 535);
            ventanaTemperatura.setVisible(true);
            ventanaTemperatura.setResizable(false);//Evitar que el user pueda modificar el tamaño de la interfaz
            ventanaTemperatura.setLocationRelativeTo(null); //Agregar la interfaz al centro de la pantalla

        }

        if (e.getSource() == miSalir){
            JOptionPane.showMessageDialog(null, "Que pena! saliendo del programa ...");
            System.exit(0);//salir
        }

        if (e.getSource() == miElCreador) {
            JOptionPane.showMessageDialog(null, "Desarrollado por Gerson Ep\n" +
                    "       https://github.com/Gerson121295/\n " +
                    "       Challenge Oracle One");
        }


    }

    //Diseño de la interfaz
    public static void main(String[] args) {
        ConversorTemperaturaGUI ventanaTemperatura = new ConversorTemperaturaGUI();
        ventanaTemperatura.setBounds(0, 0, 640, 535);
        ventanaTemperatura.setVisible(true);
        ventanaTemperatura.setResizable(false);//Evitar que el user pueda modificar el tamaño de la interfaz
        ventanaTemperatura.setLocationRelativeTo(null); //Agregar la interfaz al centro de la pantalla
    }


}

