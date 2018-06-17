/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Convertor.Convertor;
import Operaciones.Aritmetica;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import poo_calculadora.AbstractFactory;
import poo_calculadora.FactoryProducer;

/**
 *
 * @author LN710Q
 */
public class Ventana extends JPanel {
    public int WIDTH = 300, widthTF = 120, widthB = 80;
    public int HEIGHT = 300, heightTF = 30, heightB = 30;
    public JTextField textF1,textF2,textF3;
    public JButton buttonSuma, buttonResta, buttonDivision, buttonMultiplicacion, buttonConversion;
    
    public Ventana(){
        AbstractFactory factoryOperacion,factoryConversion;
        factoryOperacion = FactoryProducer.getFactory("Operacion");
        factoryConversion = FactoryProducer.getFactory("Conversion");
        textF1 = new JTextField();
        textF1.setBounds(new Rectangle(25,40,widthTF,heightTF));
        
        textF2 = new JTextField();
        textF2.setBounds(new Rectangle(175,40,widthTF,heightTF));
        
        textF3 = new JTextField();
        textF3.setBounds(new Rectangle(75,250,widthTF,heightTF));
        
        buttonSuma = new JButton("Suma");
        buttonSuma.setBounds(new Rectangle(100,100,widthB,heightB));
        
        buttonResta = new JButton("Resta");
        buttonResta.setBounds(new Rectangle(100,125,widthB,heightB));
        
        buttonDivision = new JButton("Division");
        buttonDivision.setBounds(new Rectangle(100,150,widthB,heightB));
        
        buttonMultiplicacion = new JButton("Multiplicacion");
        buttonMultiplicacion.setBounds(new Rectangle(100,175,widthB,heightB));
        
        buttonConversion = new JButton("Binario");
        buttonConversion.setBounds(new Rectangle(100,200,widthB,heightB));
        
        textF1.setEditable(true);
        textF2.setEditable(true);
        textF3.setEditable(false);
        
        buttonSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(textF1.getText() != null && textF2.getText() != null){
                    Aritmetica suma = factoryOperacion.getOperacion("suma");
                    float numero1 = Float.parseFloat(textF1.getText()), numero2 = Float.parseFloat(textF2.getText());
                    String Resultado;
                    Resultado = suma.calcular(numero1, numero2);
                    textF3.setText(Resultado);
                }
                else{
                    textF3.setText("Error");
                }
            }
        });
        
        buttonResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(textF1.getText() != null && textF2.getText() != null){
                    Aritmetica resta = factoryOperacion.getOperacion("Resta");
                    textF3.setText(""+resta.calcular(Float.parseFloat(textF1.getText()),Float.parseFloat(textF2.getText())));
                }
            }
        });
        
        buttonDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Aritmetica division = factoryOperacion.getOperacion("Division");
                textF3.setText(""+division.calcular(Float.parseFloat(textF1.getText()),Float.parseFloat(textF2.getText())));
            }
        });
        
        buttonMultiplicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Aritmetica multiplicacion = factoryOperacion.getOperacion("Multiplicacion");
                textF3.setText(""+multiplicacion.calcular(Float.parseFloat(textF1.getText()),Float.parseFloat(textF2.getText())));
            }
        });
        
        buttonConversion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Convertor binario = factoryConversion.getConvertor("Binario");
                textF3.setText(""+binario.Convertir(Integer.parseInt(textF1.getText())));
            }
        });
        
        add(textF1);
        add(textF2);
        add(textF3);
        add(buttonSuma);
        add(buttonResta);
        add(buttonDivision);
        add(buttonMultiplicacion);
        add(buttonConversion);
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }
}