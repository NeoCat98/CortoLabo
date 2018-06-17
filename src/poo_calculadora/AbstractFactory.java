/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_calculadora;

import Convertor.Convertor;
import Operaciones.Aritmetica;

/**
 *
 * @author LN710Q
 */
public interface AbstractFactory {
    Convertor getConvertor(String Type);
    Aritmetica getOperacion(String type);
}
