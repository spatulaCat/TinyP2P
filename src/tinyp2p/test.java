/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tinyp2p;

/**
 *
 * @author Nicky
 */


public class test {
    
    public static String reverse(String n){
        
        String n2 = "";
        for (int i = n.length()-1; i > 0  ; i--){
           n2+=n.charAt(i);
           
        }
        return n2;
    }
    
    public static boolean test(String n){

        for (int i = 0; i < n.length(); i++){
            for (int j = i+1; j < n.length(); j++){
                if (n.charAt(i) == n.charAt(j)){
                    return false;
                }
            }
          
        }
          return true;
    }

    
    public static void main(String[] args){
    
        System.out.println(reverse("zxsdfsdfcbdeh"));
    }
    
}
