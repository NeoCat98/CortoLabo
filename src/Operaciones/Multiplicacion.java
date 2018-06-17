/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

/**
 *
 * @author LN710Q
 */
public class Multiplicacion implements Aritmetica{
    @Override
    public String calcular(float n, float m){
        String resultado = ""+(n*m);
        return resultado;
    }
}
