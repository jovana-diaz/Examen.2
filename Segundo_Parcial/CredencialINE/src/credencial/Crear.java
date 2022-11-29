/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package credencial;
//librerias que ocuparemos 

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author Jovana Díaz Garduño
 */
public class Crear extends JFrame {

    private JPanel panel;
    private JTextField nombre;
    private JTextField apellidopaterno;
    private JTextField apellidomaterno;
    private JTextField colonia;
    private JTextField calle;
    private JTextField municipio;
    private JTextField curp;
    private JTextField fecha;
    private JTextField sexo;
    private JTextField clave;
    private JTextField anio;
    private JTextField estado;
    private JTextField localidad;
    private JTextField emision;
    private JTextField seccion;
    private JTextField vigencia;

    private JButton boton;

    public Crear() {

        this.setSize(700, 850);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("--EXAMEN--");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(200, 200));

        Iniciar();

    }

    private void Iniciar() {

        Panel();
        Etiquetas();
        Texto();
        BotonCrear();
        BotonAbrir();
        Imagen1();
        Imagen2();

    }

    private void Panel() {

        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Estas etiquetas son las que apareceran en una ventana donde el usuario comenzara a ingresar los datos correspondientes para crear el pdf
    private void Etiquetas() {

        JLabel etiqueta0 = new JLabel("¡Bienvenido ingresa tus datos!");//texto etiqueta
        panel.add(etiqueta0);//agregamos un panel a la etiqueta
        etiqueta0.setBounds(185, 5, 580, 80);//dimension de la etiqueta x,y,ancho,alto
        etiqueta0.setForeground(Color.MAGENTA);//color del texto
        etiqueta0.setFont(new Font("Baskerville", Font.PLAIN, 24));//tipo de fuente y tamaño de la letra

        // Etiqueta para el Apellido Paterno //
        JLabel etiqueta = new JLabel("Apellido paterno: ");
        panel.add(etiqueta);
        etiqueta.setBounds(50, 60, 200, 80);
        etiqueta.setForeground(Color.DARK_GRAY);
        etiqueta.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para el Apellido Materno //
        JLabel etiqueta1 = new JLabel("Apellido materno: ");
        panel.add(etiqueta1);
        etiqueta1.setBounds(50, 95, 200, 80);
        etiqueta1.setForeground(Color.DARK_GRAY);
        etiqueta1.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para el Nombre(s) //
        JLabel etiqueta2 = new JLabel("Nombre: ");
        panel.add(etiqueta2);
        etiqueta2.setBounds(50, 135, 200, 80);
        etiqueta2.setForeground(Color.DARK_GRAY);
        etiqueta2.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para la Calle y el Numero //
        JLabel etiqueta3 = new JLabel("Calle y No.: ");
        panel.add(etiqueta3);
        etiqueta3.setBounds(50, 175, 200, 80);
        etiqueta3.setForeground(Color.DARK_GRAY);
        etiqueta3.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para la Colonia y el Codigo Postal //
        JLabel etiqueta4 = new JLabel("Colonia Y C.P.: ");
        panel.add(etiqueta4);
        etiqueta4.setBounds(50, 215, 220, 80);
        etiqueta4.setForeground(Color.DARK_GRAY);
        etiqueta4.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para el Municipio //
        JLabel etiqueta5 = new JLabel("Municipio(número): ");
        panel.add(etiqueta5);
        etiqueta5.setBounds(50, 255, 200, 80);
        etiqueta5.setForeground(Color.DARK_GRAY);
        etiqueta5.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para la CURP //
        JLabel etiqueta6 = new JLabel("CURP: ");
        panel.add(etiqueta6);
        etiqueta6.setBounds(50, 295, 200, 80);
        etiqueta6.setForeground(Color.DARK_GRAY);
        etiqueta6.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para la Fecha de Nacimiento //
        JLabel etiqueta7 = new JLabel("Fecha de nacimiento: ");
        panel.add(etiqueta7);
        etiqueta7.setBounds(50, 335, 200, 80);
        etiqueta7.setForeground(Color.DARK_GRAY);
        etiqueta7.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para el Sexo //
        JLabel etiqueta8 = new JLabel("Sexo: ");
        panel.add(etiqueta8);
        etiqueta8.setBounds(50, 375, 200, 80);
        etiqueta8.setForeground(Color.DARK_GRAY);//color del texto
        etiqueta8.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para la clave de elector //
        JLabel etiqueta9 = new JLabel("Clave de elector: ");
        panel.add(etiqueta9);
        etiqueta9.setBounds(50, 415, 200, 80);
        etiqueta9.setForeground(Color.DARK_GRAY);
        etiqueta9.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para el año de registro //
        JLabel etiqueta10 = new JLabel("Año de registro: ");
        panel.add(etiqueta10);
        etiqueta10.setBounds(50, 455, 200, 80);
        etiqueta10.setForeground(Color.DARK_GRAY);
        etiqueta10.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para el estado //
        JLabel etiqueta11 = new JLabel("Estado(número): ");
        panel.add(etiqueta11);
        etiqueta11.setBounds(50, 495, 200, 80);
        etiqueta11.setForeground(Color.DARK_GRAY);
        etiqueta11.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para la localidad //
        JLabel etiqueta12 = new JLabel("Localidad(número): ");
        panel.add(etiqueta12);
        etiqueta12.setBounds(50, 535, 200, 80);
        etiqueta12.setForeground(Color.DARK_GRAY);
        etiqueta12.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para la emision //
        JLabel etiqueta13 = new JLabel("Emision: ");
        panel.add(etiqueta13);
        etiqueta13.setBounds(50, 575, 200, 80);
        etiqueta13.setForeground(Color.DARK_GRAY);
        etiqueta13.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para la seccion //
        JLabel etiqueta14 = new JLabel("Seccion: ");
        panel.add(etiqueta14);
        etiqueta14.setBounds(50, 615, 200, 80);
        etiqueta14.setForeground(Color.DARK_GRAY);
        etiqueta14.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

        // Etiqueta para la vigencia //
        JLabel etiqueta15 = new JLabel("Vigencia: ");
        panel.add(etiqueta15);
        etiqueta15.setBounds(50, 655, 200, 80);
        etiqueta15.setForeground(Color.DARK_GRAY);
        etiqueta15.setFont(new Font("Baskerville", Font.ROMAN_BASELINE, 18));

    }

    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Imagen de fondo en la ventana 
    private void Imagen1() {
        JLabel etiqueta16 = new JLabel();
        ImageIcon imagen = new ImageIcon("imagen1.png");

        panel.add(etiqueta16);//agregamos etiqueta dos al panel 
        etiqueta16.setBounds(340, 300, 480, 450);
        etiqueta16.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta16.getWidth(), etiqueta16.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    
    //Imagen del logo de INE en la ventana 
    private void Imagen2() {
        JLabel etiqueta17 = new JLabel();
        ImageIcon imagen = new ImageIcon("imagen2.jpg");

        panel.add(etiqueta17);//agregamos etiqueta dos al panel 
        etiqueta17.setBounds(520, 20, 150, 130);
        etiqueta17.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta17.getWidth(), etiqueta17.getHeight(), Image.SCALE_SMOOTH)));
    }
    
        
        
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void Texto() {

        // Apellido Paterno 
        apellidopaterno = new JTextField();
        apellidopaterno.setBounds(190, 80, 300, 35);
        panel.add(apellidopaterno);

        // Apellido Materno 
        apellidomaterno = new JTextField();
        apellidomaterno.setBounds(190, 120, 300, 35);
        panel.add(apellidomaterno);

        // Nombre 
        nombre = new JTextField();
        nombre.setBounds(120, 160, 300, 35);
        panel.add(nombre);

        // Calle 
        calle = new JTextField();
        calle.setBounds(140, 200, 300, 35);
        panel.add(calle);

        // Colonia y Codigo Postal 
        colonia = new JTextField();
        colonia.setBounds(170, 240, 300, 35);
        panel.add(colonia);

        // Municipio 
        municipio = new JTextField();
        municipio.setBounds(200, 280, 300, 35);
        panel.add(municipio);

        // CURP 
        curp = new JTextField();
        curp.setBounds(110, 320, 320, 35);
        panel.add(curp);

        // Fecha de Nacimiento 
        fecha = new JTextField();
        fecha.setBounds(215, 360, 280, 35);
        panel.add(fecha);

        // Sexo 
        sexo = new JTextField();
        sexo.setBounds(95, 400, 300, 35);
        panel.add(sexo);

        // Clave de elector 
        clave = new JTextField();
        clave.setBounds(180, 440, 300, 35);
        panel.add(clave);

        // Año de registro 
        anio = new JTextField();
        anio.setBounds(180, 480, 300, 35);
        panel.add(anio);

        // Estado 
        estado = new JTextField();
        estado.setBounds(170, 520, 300, 35);
        panel.add(estado);

        // Localidad 
        localidad = new JTextField();
        localidad.setBounds(190, 560, 300, 35);
        panel.add(localidad);

        // Emision 
        emision = new JTextField();
        emision.setBounds(120, 600, 300, 35);
        panel.add(emision);

        // Emision 
        seccion = new JTextField();
        seccion.setBounds(120, 640, 300, 35);
        panel.add(seccion);

        // Vigencia 
        vigencia = new JTextField();
        vigencia.setBounds(130, 680, 300, 35);
        panel.add(vigencia);

    }

    private void BotonCrear() {
        boton = new JButton("Crear PDF");
        boton.setBounds(100, 720, 120, 40);
        boton.setForeground(java.awt.Color.MAGENTA);
        boton.setFont(new java.awt.Font("Baskerville", java.awt.Font.PLAIN, 15));
        boton.setEnabled(true);

        panel.add(boton);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String imagen = "/Users/jovanadiaz/Desktop/ineVacia.jpg";
                try {
                    PDDocument documento = new PDDocument();
                    PDRectangle mypage = new PDRectangle(800, 850);
                    PDPage pagina = new PDPage(mypage);
                    documento.addPage(pagina);

                    PDImageXObject image = PDImageXObject.createFromFile(imagen, documento);
                    PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                    contenido.drawImage(image, 90, 60, 600, 700);

                    //----------Paterno----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 14);
                    contenido.newLineAtOffset(285, pagina.getMediaBox().getHeight() - 200);
                    contenido.showText(apellidopaterno.getText());
                    contenido.endText();

                    //----------Materno----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 14);
                    contenido.newLineAtOffset(285, pagina.getMediaBox().getHeight() - 214);
                    contenido.showText(apellidomaterno.getText());
                    contenido.endText();

                    //----------Nombre---------- 
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 14);
                    contenido.newLineAtOffset(285, pagina.getMediaBox().getHeight() - 226);
                    contenido.showText(nombre.getText());
                    contenido.endText();

                    //----------Calle----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 14);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(285, pagina.getMediaBox().getHeight() - 270);
                    contenido.showText(calle.getText());
                    contenido.endText();

                    //----------Colonia y Codigo Postal----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 14);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(285, pagina.getMediaBox().getHeight() - 286);
                    contenido.showText(colonia.getText());
                    contenido.endText();

                    //----------Número del municipio----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 11);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(485, pagina.getMediaBox().getHeight() - 360);
                    contenido.showText(municipio.getText());
                    contenido.endText();

                    //----------CURP----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(330, pagina.getMediaBox().getHeight() - 337);
                    contenido.showText(curp.getText());
                    contenido.endText();

                    //----------Fecha de Nacimiento----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 14);
                    contenido.newLineAtOffset(600, pagina.getMediaBox().getHeight() - 200);
                    contenido.showText(fecha.getText());
                    contenido.endText();

                    //----------Sexo----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                    contenido.newLineAtOffset(655, pagina.getMediaBox().getHeight() - 215);
                    contenido.showText(sexo.getText());
                    contenido.endText();

                    //----------Clave de elector----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                    contenido.newLineAtOffset(410, pagina.getMediaBox().getHeight() - 318);
                    contenido.showText(clave.getText());
                    contenido.endText();

                    //----------Año----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(635, pagina.getMediaBox().getHeight() - 335);
                    contenido.showText(anio.getText());
                    contenido.endText();

                    //----------Estado----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(345, pagina.getMediaBox().getHeight() - 360);
                    contenido.showText(estado.getText());
                    contenido.endText();

                    //----------Localidad----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(365, pagina.getMediaBox().getHeight() - 385);
                    contenido.showText(localidad.getText());
                    contenido.endText();

                    //----------Emision----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(482, pagina.getMediaBox().getHeight() - 383);
                    contenido.showText(emision.getText());
                    contenido.endText();

                    //----------Seccion----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(585, pagina.getMediaBox().getHeight() - 360);
                    contenido.showText(seccion.getText());
                    contenido.endText();

                    //----------Vigencia----------
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                    //  contenido.setLeading(14.5f);
                    contenido.newLineAtOffset(585, pagina.getMediaBox().getHeight() - 380);
                    contenido.showText(vigencia.getText());
                    contenido.endText();

                    contenido.close();

                    documento.save("/Users/jovanadiaz/Desktop/INE.pdf");

                } catch (Exception x) {
                    System.out.println("Error: " + x.getMessage().toString());
                }

            }
        });

    }

    private void BotonAbrir() {

        boton = new JButton("Abrir PDF");
        boton.setBounds(405, 720, 120, 40);
        boton.setForeground(java.awt.Color.MAGENTA);
        boton.setFont(new java.awt.Font("Baskerville", java.awt.Font.PLAIN, 15));
        boton.setEnabled(true);

        panel.add(boton);

        ActionListener accion = new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                try {
                    File path = new File("/Users/jovanadiaz/Desktop/INE.pdf");
                    Desktop.getDesktop().open(path);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        };

        boton.addActionListener(accion);

    }

}
