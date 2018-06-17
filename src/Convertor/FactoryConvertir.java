/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Convertor;

import Operaciones.Aritmetica;
import poo_calculadora.AbstractFactory;
/**
 *
 * @author LN710Q
 */
public class FactoryConvertir implements AbstractFactory{
    
    @Override
    public Aritmetica getOperacion(String Type){
        return null;
    }
    
    @Override
    public Convertor getConvertor(String Type){
        switch(Type){
            case "Binario":
                return new Binario();
        }
        return null;
    }
}
