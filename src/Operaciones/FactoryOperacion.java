/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Convertor.Convertor;
import poo_calculadora.AbstractFactory;

/**
 *
 * @author LN710Q
 */
public class FactoryOperacion implements AbstractFactory {
    @Override
    public Aritmetica getOperacion(String Type){
        switch(Type){
            case "suma":
                return new Suma();
            case "Resta":
                return new Resta();
            case "Division":
                return new Division();
            case "Multiplicacion":
                return new Multiplicacion();
        }
        return null;
    }
    @Override
    public Convertor getConvertor(String Type){
        return null;
    }
    
}
