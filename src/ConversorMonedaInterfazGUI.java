import conversores.ConversorMoneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//- Interfaz de Conversor de monedas

public class ConversorMonedaInterfazGUI extends JFrame implements ActionListener {

    //Componentes necesarios para la interfaz
    private JMenuBar mb;
    private JMenu menuOpciones, menuCalcular, menuAcercaDe, menuColorFondo;
    private JMenuItem miRojo, miNegro, miMorado, miElCreador, miSalir, miNuevo, convierteMonedas, calculaTemperatura;
    private JLabel labelLogo, labelBienvenido, labelTitle, labelCantidadMonedaAConvertir,
            labelMonedaOrigen, labelMonedaDestino, labelResultado, labelfooter;
    private JTextField txtCantidadMonedaAConvertir;
    private JComboBox comboMonedaOrigen, comboMonedaDestino;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;

    private JButton botonConvertir;

    //Constructor para el diseño de la interfaz
    public ConversorMonedaInterfazGUI(){
        setLayout(null); //Para coordenadas
        setDefaultCloseOperation(EXIT_ON_CLOSE); //cerrar el programa
        setTitle("Pantalla principal");
        getContentPane().setBackground(new Color(255,0,0));
        setIconImage(new ImageIcon(getClass().getResource("images/icon-monedas.png")).getImage());

        mb = new JMenuBar();
        mb.setBackground(new Color(255,0,0)); //establece color rojo de fondo
        setJMenuBar(mb); //mb se agrega como MenuBar

        menuOpciones = new JMenu("Opciones");
        menuOpciones.setBackground(new Color(255,0,0));
        menuOpciones.setFont(new Font("Andale Mono",1,14));
        menuOpciones.setForeground(new Color(255,255,255));
        mb.add(menuOpciones); //Se agrega menuOpciones al mb (menuBar)

        menuCalcular = new JMenu("Calcular");
        menuCalcular.setBackground(new Color(255,0,0));
        menuCalcular.setFont(new Font("Andale Mono",1,14));
        menuCalcular.setForeground(new Color(255,255,255));
        mb.add(menuCalcular); //Se agrega menuCalcular al mb (menuBar)

        menuAcercaDe = new JMenu("Acerca de");
        menuAcercaDe.setBackground(new Color(255,0,0));
        menuAcercaDe.setFont(new Font("Andale Mono",1,14));
        menuAcercaDe.setForeground(new Color(255,255,255));
        mb.add(menuAcercaDe); //Se agrega menuAcercaDe al mb (menuBar)


        //Submenus
        menuColorFondo = new JMenu("Color de fondo");
        menuColorFondo.setFont(new Font("Andale Mono",1,14));
        menuColorFondo.setForeground(new Color(255,0,0));
        menuOpciones.add(menuColorFondo); //menuColorFOndo es un submenu de menuOpciones

        calculaTemperatura = new JMenuItem("Calcula Temperatura");
        calculaTemperatura.setFont(new Font("Andale Mono", 1, 14));
        calculaTemperatura.setForeground(new Color(255,0,0));
        menuCalcular.add(calculaTemperatura); //calculaTemperatura es un submenu de menuCalcular
        calculaTemperatura.addActionListener(this);  //habilitar para escuchar eventos el submenu

        convierteMonedas = new JMenuItem("Convierte Monedas");
        convierteMonedas.setFont(new Font("Andale Mono", 1,14));
        convierteMonedas.setForeground(new Color(255,0,0));
        convierteMonedas.setEnabled(false); //Submenu Convierte Monedas se verá Inactivo cuando este en la pagina temperatura.
        menuCalcular.add(convierteMonedas);
        convierteMonedas.addActionListener(this);

        miRojo = new JMenuItem("Rojo");
        miRojo.setFont(new Font("Andale Mono",1,14));
        miRojo.setForeground(new Color(255,0,0));
        menuColorFondo.add(miRojo); //miRojo es un submenu de menuColorFondo
        miRojo.addActionListener(this);//habilitar para escuchar eventos

        miNegro = new JMenuItem("Negro");
        miNegro.setFont(new Font("Andale Mono",1,14));
        miNegro.setForeground(new Color(255,0,0));
        menuColorFondo.add(miNegro); //miNegro es un submenu de menuColorFondo
        miNegro.addActionListener(this);//habilitar para escuchar eventos

        miMorado = new JMenuItem("Morado");
        miMorado.setFont(new Font("Andale Mono",1,14));
        miMorado.setForeground(new Color(255,0,0));
        menuColorFondo.add(miMorado); //miMorado es un submenu de menuColorFondo
        miMorado.addActionListener(this);//habilitar para escuchar eventos

        miNuevo = new JMenuItem("Nuevo");
        miNuevo.setFont(new Font("Andale Mono", 1, 14));
        miNuevo.setForeground(new Color(255, 0, 0));
        menuOpciones.add(miNuevo);
        miNuevo.addActionListener(this);

        miElCreador = new JMenuItem("El Creador");
        miElCreador.setFont(new Font("Andale Mono",1,14));
        miElCreador.setForeground(new Color(255,0,0));
        menuAcercaDe.add(miElCreador); //miElCreador es un submenu de menuAcercaDe
        miElCreador.addActionListener(this);//habilitar para escuchar eventos

        miSalir = new JMenuItem("Salir");
        miSalir.setFont(new Font("Andale Mono",1,14));
        miSalir.setForeground(new Color(255,0,0));
        menuOpciones.add(miSalir); //miSalir es un submenu de menuOpciones
        miSalir.addActionListener(this);//habilitar para escuchar eventos

        ImageIcon imagen = new ImageIcon("src/images/conversor-moneda-img.png");
        labelLogo = new JLabel(imagen);
        labelLogo.setBounds(5,2,300,180);
        add(labelLogo);

        labelBienvenido = new JLabel("Bienvenido ");
        labelBienvenido.setBounds(350, 60, 300, 50);
        labelBienvenido.setFont(new Font("Andale Mono", 1,32));
        labelBienvenido.setForeground(new Color(255,255,255));
        add(labelBienvenido);

        labelTitle = new JLabel("Ingresa los datos:");
        labelTitle.setBounds(350,150,900,25);
        labelTitle.setFont(new Font("Andale Mono", 1,22));
        labelTitle.setForeground(new Color(255,255,255));
        add(labelTitle);


        //Label y TextArea para la cantidad de monedas a convertir
        labelCantidadMonedaAConvertir = new JLabel("Cantidad de Monedas");
        labelCantidadMonedaAConvertir.setBounds(25,198,180,25);
        labelCantidadMonedaAConvertir.setFont(new Font("Andale Mono", 1, 12));
        labelCantidadMonedaAConvertir.setForeground(new Color(255,255,255));
        add(labelCantidadMonedaAConvertir);

        txtCantidadMonedaAConvertir = new JTextField();
        txtCantidadMonedaAConvertir.setBounds(25,223,150,25);
        txtCantidadMonedaAConvertir.setBackground(new java.awt.Color(224,224,224));
        txtCantidadMonedaAConvertir.setFont(new java.awt.Font("Andale Mono",1,14));
        txtCantidadMonedaAConvertir.setForeground(new java.awt.Color(255,0,0));
        add(txtCantidadMonedaAConvertir);

        //Botones
        botonConvertir = new JButton("Convertir Moneda");
        botonConvertir.setBounds(30, 285, 145,30);
        botonConvertir.setBackground(new java.awt.Color(224,224,224));
        botonConvertir.setFont(new Font("Andale Mono",1,12));
        botonConvertir.setForeground(new Color(5,3,54));
        add(botonConvertir);
        botonConvertir.addActionListener(this);// Activar escuchar este boton

        //Label y Combox para el nombre y tipo de Moneda Origen

        labelMonedaOrigen = new JLabel("Selecciona la moneda de origen:");
        labelMonedaOrigen.setBounds(220,198,185,25);
        labelMonedaOrigen.setFont(new Font("Andale Mono", 1, 12));
        labelMonedaOrigen.setForeground(new Color(255, 255, 255));
        add(labelMonedaOrigen);

        comboMonedaOrigen = new JComboBox();
        comboMonedaOrigen.setBounds(220,223,220,25);
        comboMonedaOrigen.setBackground(new java.awt.Color(224, 224, 224));
        comboMonedaOrigen.setFont(new java.awt.Font("Andale Mono", 1, 14));
        comboMonedaOrigen.setForeground(new java.awt.Color(255, 0, 0));
        add(comboMonedaOrigen);
        comboMonedaOrigen.addItem("Elige una moneda");
        comboMonedaOrigen.addItem("Quetzal");
        comboMonedaOrigen.addItem("Dólar");
        comboMonedaOrigen.addItem("Euros");
        comboMonedaOrigen.addItem("Libras Esterlinas");
        comboMonedaOrigen.addItem("Yen Japonés");
        comboMonedaOrigen.addItem("Won Sur-Coreano");


        //Label y Combox para la Moneda Destino
        labelMonedaDestino = new JLabel("Selecciona la moneda Destino:");
        labelMonedaDestino.setBounds(220,258,185,25);
        labelMonedaDestino.setFont(new Font("Andale Mono", 1, 12));
        labelMonedaDestino.setForeground(new Color(255, 255, 255));
        add(labelMonedaDestino);

        comboMonedaDestino = new JComboBox();
        comboMonedaDestino.setBounds(220,283,220,25);
        comboMonedaDestino.setBackground(new java.awt.Color(224, 224, 224));
        comboMonedaDestino.setFont(new java.awt.Font("Andale Mono", 1, 14));
        comboMonedaDestino.setForeground(new java.awt.Color(255, 0, 0));
        add(comboMonedaDestino);
        comboMonedaDestino.addItem("Elige una moneda");
        comboMonedaDestino.addItem("Quetzal");
        comboMonedaDestino.addItem("Dólar");
        comboMonedaDestino.addItem("Euros");
        comboMonedaDestino.addItem("Libras Esterlinas");
        comboMonedaDestino.addItem("Yen Japonés");
        comboMonedaDestino.addItem("Won Sur-Coreano");

        //Label y TextArea para el resultado
        labelResultado = new JLabel("Resultado del Cálculo:");
        labelResultado.setBounds(220,317,180,25);
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
        scrollPane1.setBounds(220,343,355,80);
        add(scrollPane1);

        //Label Para el Pie de pagina
        labelfooter = new JLabel("©2023 Derechos reservados | Datos de valor de las monedas fecha 26/07/2023.");
        labelfooter.setBounds(80,445,500,30);
        labelfooter.setFont(new java.awt.Font("Andale Mono", 1, 11));
        labelfooter.setForeground(new java.awt.Color(255, 255, 255));
        add(labelfooter);

    }

    //Programar los evento
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonConvertir) {
            double cantidadMonedaAConvertirNum = 0;
            //String cantidadMonedaAConvertirText = txtCantidadMonedaAConvertir.getText(); //no
            //cantidadMonedaAConvertirNum = Double.parseDouble(txtCantidadMonedaAConvertir.getText()); //funciona

            String cantidadMonedaAConvertirText = txtCantidadMonedaAConvertir.getText(); //no

            String MonedaOrigen = comboMonedaOrigen.getSelectedItem().toString();
            String MonedaDestino = comboMonedaDestino.getSelectedItem().toString();

            //validar que los campos no esten vacios
            if(cantidadMonedaAConvertirText.equals("") ||
                    MonedaOrigen.equals("") || MonedaDestino.equals("")){

                JOptionPane.showMessageDialog(null,"Debes de llenar todos los campos.");

            } else {

                //Los campos estan llenos
                if(MonedaOrigen.equals("Quetzal")){ //si se selecciono Atención al Cliente

                    if(MonedaDestino.equals("Dólar")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Quetzal", "Dólar",0.12741079, cantidadMonedaAConvertirNum));
                        //String resultadoString = String.valueOf(guadaResultado); //parseo de double a String
                        textArea1.setText("\n   " + guardaResultado+ " Dolares");
                    }
                    if(MonedaDestino.equals("Quetzal")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Quetzal", "Quetzal",1, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Quetzales");
                    }

                    if(MonedaDestino.equals("Euros")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Quetzal", "Euros",0.11523409, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Euros");
                    }

                    if(MonedaDestino.equals("Libras Esterlinas")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Quetzal", "Libras Esterlinas",0.098799983, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Libras Esterlinas");
                    }

                    if(MonedaDestino.equals("Yen Japonés")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Quetzal", "Yen Japonés",17.967637, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Yen Japonés");
                    }

                    if(MonedaDestino.equals("Won Sur-Coreano")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Quetzal", "Won Sur-Coreano",162.68388, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Won Sur-Coreano");
                    }

                }


                //Condicional para el Dólar
                if(MonedaOrigen.equals("Dólar")){
                    if(MonedaDestino.equals("Quetzal")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Dólar", "Quetzal",7.84868, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Quetzales");
                    }
                    if(MonedaDestino.equals("Dólar")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Dólar", "Dólar",1, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Dolares");
                    }
                    if(MonedaDestino.equals("Euros")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Dólar", "Euros",0.904014, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Euros");
                    }
                    if(MonedaDestino.equals("Libras Esterlinas")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Dólar", "Libras Esterlinas",0.77548506, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Libras Esterlinas");
                    }
                    if(MonedaDestino.equals("Yen Japonés")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Dólar", "Yen Japonés",140.97223, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Yen Japonés");
                    }
                    if(MonedaDestino.equals("Won Sur-Coreano")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Dólar", "Won Sur-Coreano",1276.0013, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Won Sur-Coreano");
                    }


                }


                //Condicional para Moneda Origen Euros
                if(MonedaOrigen.equals("Euros")){

                    if(MonedaDestino.equals("Quetzal")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Euros", "Quetzales",8.6783713, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Quetzales");
                    }
                    if(MonedaDestino.equals("Dólar")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Euros", "Dólar",1.1060905, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Dólares");
                    }
                    if(MonedaDestino.equals("Euros")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Euros", "Euros",1, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Euros");
                    }
                    if(MonedaDestino.equals("Libras Esterlinas")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Euros", "Libras Esterlinas",0.85789132, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Libras Esterlinas");
                    }
                    if(MonedaDestino.equals("Yen Japonés")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Euros", "Yen Japonés",155.86897, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Yen Japonés");
                    }
                    if(MonedaDestino.equals("Won Sur-Coreano")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Euros", "Won Sur-Coreano",1411.2488, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Won Sur-Coreano");
                    }

                }

                //Condicional para Moneda Origen Libras Esterlinas
                if(MonedaOrigen.equals("Libras Esterlinas")){

                    if(MonedaDestino.equals("Quetzal")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Libras Esterlinas", "Quetzal",10.122481, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Quetzales");
                    }
                    if(MonedaDestino.equals("Dólar")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Libras Esterlinas", "Dólar",1.2895994, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Dólares");
                    }
                    if(MonedaDestino.equals("Euros")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Libras Esterlinas", "Euros",1.1657373, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Euros");
                    }
                    if(MonedaDestino.equals("Libras Esterlinas")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Libras Esterlinas", "Libras Esterlinas",1, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Libras Esterlinas");
                    }
                    if(MonedaDestino.equals("Yen Japonés")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Libras Esterlinas", "Yen Japonés",181.42924, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Yen Japonés");
                    }
                    if(MonedaDestino.equals("Won Sur-Coreano")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Libras Esterlinas", "Won Sur-Coreano",1644.4623, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Won Sur-Coreano");
                    }

                }

                //Condicional para Moneda Origen Yen Japones
                if(MonedaOrigen.equals("Yen Japonés")){

                    if(MonedaDestino.equals("Quetzal")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Yen Japonés", "Quetzales",0.055651113, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Quetzales");
                    }
                    if(MonedaDestino.equals("Dólar")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Yen Japonés", "Dólar",0.0070940476, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Dólares");
                    }
                    if(MonedaDestino.equals("Euros")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Yen Japonés", "Euros",0.00641808, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Euros");
                    }
                    if(MonedaDestino.equals("Libras Esterlinas")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Yen Japonés", "Libras Esterlinas",0.005511619, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Libras Esterlinas");
                    }
                    if(MonedaDestino.equals("Yen Japonés")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Yen Japonés", "Yen Japonés",1, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Yen Japonés");
                    }
                    if(MonedaDestino.equals("Won Sur-Coreano")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Yen Japonés", "Won Sur-Coreano",9.064092, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Won Sur-Coreano");
                    }

                }

                //Condicional para Moneda Origen Won Sur-Coreano
                if(MonedaOrigen.equals("Won Sur-Coreano")){

                    if(MonedaDestino.equals("Quetzal")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Won Sur-Coreano", "Quetzales",0.0061475491, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Quetzales");
                    }
                    if(MonedaDestino.equals("Dólar")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Won Sur-Coreano", "Dólares",0.0007839003, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Dólares");
                    }
                    if(MonedaDestino.equals("Euros")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Won Sur-Coreano", "Euros",0.00070864186, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Euros");
                    }
                    if(MonedaDestino.equals("Libras Esterlinas")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Won Sur-Coreano", "Libras Esterlinas",0.00060804299, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Libras Esterlinas");
                    }
                    if(MonedaDestino.equals("Yen Japonés")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Won Sur-Coreano", "Yen Japonés",0.11032095, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Yen Japonés");
                    }
                    if(MonedaDestino.equals("Won Sur-Coreano")){
                        cantidadMonedaAConvertirNum = Double.parseDouble(cantidadMonedaAConvertirText); //Parseo de dato de entrada Esta en String pasa a  double
                        Double guardaResultado = (double) (ConversorMoneda.conversionDeMonedaGUI("Won Sur-Coreano", "Won Sur-Coreano",1, cantidadMonedaAConvertirNum));
                        textArea1.setText("\n   " + guardaResultado+ " Won Sur-Coreano");
                    }

                }

            }
        }

        if (e.getSource() == miRojo){
            getContentPane().setBackground(new Color(255,0,0));
        }
        if (e.getSource() == miNegro){
            getContentPane().setBackground(new Color(0,0,0));
        }
        if (e.getSource() == miMorado){
            getContentPane().setBackground(new Color(51,0,51));
        }
        if (e.getSource() == miNuevo){

            //Se limpia los campos de texto
            txtCantidadMonedaAConvertir.setText("");
            comboMonedaOrigen.setSelectedIndex(0);
            comboMonedaDestino.setSelectedIndex(0);
            textArea1.setText("\n   Aquí aparece el resultado de la conversion.");

        }

        //Esta no se utiliza ya que estando en la ventana de Monedas no permitira seleccionar el submenu Convertir monedas
        if(e.getSource() == convierteMonedas ){
            //Será visible la ventana de Convertir Monedas
            ConversorMonedaInterfazGUI ventanaConversorMoneda = new ConversorMonedaInterfazGUI();
            ventanaConversorMoneda.setBounds(0,0,640,535);
            ventanaConversorMoneda.setVisible(true);
            ventanaConversorMoneda.setResizable(false);//Evitar que el user pueda modificar el tamaño de la interfaz
            ventanaConversorMoneda.setLocationRelativeTo(null); //Agregar la interfaz al centro de la pantalla

        }

        if(e.getSource() == calculaTemperatura){
            ConversorTemperaturaGUI ventanaTemperatura = new ConversorTemperaturaGUI();
            ventanaTemperatura.setBounds(0, 0, 640, 535);
            ventanaTemperatura.setVisible(true);
            ventanaTemperatura.setResizable(false);//Evitar que el user pueda modificar el tamaño de la interfaz
            ventanaTemperatura.setLocationRelativeTo(null); //Agregar la interfaz al centro de la pantalla

            this.setVisible(false); //Esta ventana de temperatura no será Visible

        }


        if (e.getSource() == miSalir){
            JOptionPane.showMessageDialog(null, "Que pena! saliendo del programa ...");
            System.exit(0);//salir

        }

        if (e.getSource() == miElCreador){
            JOptionPane.showMessageDialog(null,"Desarrollado por Gerson Ep\n"+
                    "       https://github.com/Gerson121295/\n " +
                    "       Challenge Oracle One");
        }

    }

    //Diseño de la interfaz
    public static void main(String[] args) {
        ConversorMonedaInterfazGUI ventanaConversorMoneda = new ConversorMonedaInterfazGUI();
        ventanaConversorMoneda.setBounds(0,0,640,535);
        ventanaConversorMoneda.setVisible(true);
        ventanaConversorMoneda.setResizable(false);//Evitar que el user pueda modificar el tamaño de la interfaz
        ventanaConversorMoneda.setLocationRelativeTo(null); //Agregar la interfaz al centro de la pantalla
    }

}
