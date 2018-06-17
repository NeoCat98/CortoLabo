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
public class Division implements Aritmetica{
    @Override
    public String calcular(float n, float m){
        if(m==0){
            System.out.println("No se puede dividir entre 0");
        }
        else{
            String resultado = ""+(n/m);
            return resultado;
        }
        return "";
    }
}
