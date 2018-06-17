/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Convertor;

/**
 *
 * @author LN710Q
 */
public class Binario implements Convertor{
    @Override
    public String Convertir(int n){
        String m="";
        while(n>1){
            m = n%2+m;
            n = n/2;        
        }
        m= n+m;
        return m;
    }
}
