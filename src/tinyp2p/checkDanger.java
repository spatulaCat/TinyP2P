/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tinyp2p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Nicky
 */
public class checkDanger {
    
    public static String extractExtension(String n){
        String[] parts2 = n.split("\\.(?=[^\\.]+$)");
        return parts2[1];
    }
    
    public static String checkUp(String file){
        String[] bads = {"DOC","DOCX","XLS","DOCM", "DOTM", "XLSM", "XLTM", "XLAM", "PPTM", "POTM", "PPAM", "PPSM", "SLDM", "DBX"};
        //String ext = extractExtension(file);

        if(Arrays.asList(bads).contains(file.toUpperCase())){
            return file;
        }
        return null;
    }
    public static void main(String[] args){
        ArrayList<String> sdf = null  ;
        System.out.println(checkUp("lo.exe"));
        System.out.println(checkUp("lo.doc"));
        System.out.println(checkUp("lo.docx"));
        System.out.println(checkUp("lo.d"));
        sdf.add("sdf");
        
    }
    
}
