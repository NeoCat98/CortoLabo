/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_calculadora;

import Convertor.FactoryConvertir;
import Operaciones.FactoryOperacion;

/**
 *
 * @author LN710Q
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String type){
        switch (type){
            case "Operacion":
                return new FactoryOperacion();
            case "Conversion":
                return new FactoryConvertir();
        }
        return null;
    }
}
