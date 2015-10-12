
package tinyp2p;

import java.util.Arrays;

/**
 *
 * @author Nicky
 */
public class Mnemonics {
    
     public static String[] words = {"zip", "ace",
            "two",
            
            "add",
            "age",
            "aim",
            "six",
            "and",
            "ant",
            "ape",
            "ten",
            "art",
            "ash",
            "ask",
            "bad",
            "bag",
            "ban",
            "bar",
            "bat",
            "bay",
            "bed",
            "bet",
            "bid",
            "big",
            "bin",
            "bit",
            "bog",
            "boo",
            "box",
            "bud",
            "bug",
            "bun",
            "bus",
            "cab",
            "can",
            "cap",
            "car",
            "cat",
            "cop",
            "cot",
            "cow",
            "cry",
            "cub",
            "cup",
            "cut",
            "day",
            "den",
            "did",
            "die",
            "dig",
            "dim",
            "dip",
            "dog",
            "dry",
            "dub",
            "dud",
            "dug",
            "ear",
            "eat",
            "eel",
            "egg",
            "elf",
            "elk",
            "elm",
            "end",
            "fan",
            "far",
            "fat",
            "fed",
            "few",
            "fib",
            "fig",
            "fin",
            "fit",
            "fix",
            "fly",
            "fog",
            "foo",
            "fox",
            "fry",
            "fun",
            "gab",
            "gag",
            "gap",
            "gas",
            "gel",
            "gem",
            "get",
            "gin",
            "got",
            "gum",
            "gut",
            "had",
            "has",
            "hat",
            "hen",
            "hex",
            "hid",
            "hip",
            "hit",
            "hog",
            "hop",
            "hot",
            "how",
            "hub",
            "hug",
            "hum",
            "hut",
            "ice",
            "ill",
            "imp",
            "ink",
            "irk",
            "jab",
            "jam",
            "jar",
            "jaw",
            "jet",
            "jig",
            "job",
            "jog",
            "jot",
            "joy",
            "key",
            "kid",
            "kin",
            "kit",
            "lab",
            "lag",
            "lap",
            "law",
            "lax",
            "lay",
            "leg",
            "let",
            "lid",
            "lip",
            "lit",
            "lot",
            "low",
            "mad",
            "map",
            "mat",
            "men",
            "met",
            "mix",
            "mob",
            "moo",
            "mop",
            "mud",
            "mug",
            "nab",
            "nag",
            "nap",
            "net",
            "new",
            "nil",
            "nip",
            "nod",
            "nor",
            "now",
            "nut",
            "oak",
            "oat",
            "odd",
            "off",
            "old",
            "orb",
            "out",
            "owl",
            "own",
            "pad",
            "pal",
            "pan",
            "pay",
            "pen",
            "pet",
            "pie",
            "pig",
            "pin",
            "pit",
            "ply",
            "pod",
            "pop",
            "pot",
            "pox",
            "pry",
            "pun",
            "pup",
            "put",
            "rag",
            "ran",
            "lol",
            "raw",
            "red",
            "rid",
            "rig",
            "rip",
            "rot",
            "row",
            "rub",
            "rug",
            "run",
            "rut",
            "rye",
            "sad",
            "sag",
            "sap",
            "sat",
            "saw",
            "say",
            "set",
            "shy",
            "sip",
            "sit",
            "ski",
            "sky",
            "sly",
            "sob",
            "soy",
            "spa",
            "spy",
            "tab",
            "tag",
            "tan",
            "tap",
            "tar",
            "tax",
            "the",
            "tie",
            "tin",
            "tip",
            "top",
            "toy",
            "try",
            "tub",
            "tug",
            "use",
            "van",
            "vat",
            "vex",
            "vow",
            "wag",
            "war",
            "was",
            "wax",
            "web",
            "wet",
            "who",
            "wig",
            "win",
            "wit",
            "yes",
            "yet",
            "zoo",
            "all"};
    
    public Mnemonics(){    
    }

    private static int[] format(String k){
        int[] ip = new int[4];
        String[] parts = k.split("\\.");       
        for (int i = 0; i < 4; i++) {
            ip[i] = Integer.parseInt(parts[i]);
        } 
        return ip;
    }
    
    private static String convert(int[] j){
        String mne = "";
        for (int elem: j){
            mne = mne + words[elem] + " ";       
        }     
        return mne; 
    }
    
    public static String getMnemonics(String ip){
        return convert(format(ip));   
    }
    
    public static String getIP(String mne){
        int[] ipparts = new int[4];
        String[] m = mne.split(" ");       
        for (int i = 0; i < 4; i++) {
            ipparts[i] = Arrays.asList(words).indexOf(m[i]);
        } 
        String ip = "";
        for (int elem: ipparts){
            ip = ip + elem+".";       
        }     
        return ip.substring(0,ip.length()-1);
    }
    
//    
        public static String extractFname(String path){
        //System.out.println(path);
        String[] parts = path.split("\\\\");
        String fname = parts[parts.length-1];
       // System.out.println(fname);
        String[] parts2 = fname.split("\\.");
        fname="";
        for(int i = 0; i<parts2.length-1;i++){
            fname += parts2[i];
        }
        
       // fname = parts2[0];
        //System.out.println(Arrays.toString(parts2));
        return fname.toLowerCase();
    }
    
    public static void main (String args[]){
    //  System.out.println(extractFname("01.11 - Catbug.mp4"));
//        System.out.println(getMnemonics("127.0.0.1"));
//        System.out.println(getMnemonics("192.168.123.213"));
//        System.out.println(getMnemonics("146.18.6.99"));
        
//       
//        String ms  = "[hiCHTMSGCHTMSGCHTMSGCHTMSG]";
//        
//       while(ms.endsWith("]")){
//           ms = ms.substring(0, ms.length()-1);
//       }
//        while(ms.substring(0,1).equalsIgnoreCase("[")){
//           ms = ms.substring(1, ms.length());
//       }
//       while(ms.endsWith("CHTMSG")){
//           ms = ms.substring(0, ms.length()-6);
//       }
//       System.out.println(ms);
//        String myDir = "C:\\Users\\Nicky\\Documents\\Uni stuff";
//        String reqFile = "Uni stuff\\AI\\AI paper 1 references.bak";
//        
//        String[] xcvxcv = myDir.split("\\\\");
//        String[] qweqwe = reqFile.split("\\\\");
//        if(xcvxcv[xcvxcv.length-1].equalsIgnoreCase(qweqwe[0])){
//            String[] newp = new String[qweqwe.length-1];
//            System.arraycopy(qweqwe, 1, newp, 0, qweqwe.length -1);
//            //Arrays.copyOf(qweqwe, qweqwe.length-2);
//            //new String[reqFile.length-2];
//            //System.arraycopy( qweqwe, 1, newp, 0, qweqwe.length-2 );
//            System.out.println(Arrays.toString(newp));
//        }
        String pt = "\\ \\Shared\\Documents\\GitHub\\";
         if(pt.substring(0,3).equalsIgnoreCase("\\ \\")){
                    pt = pt.substring(3,pt.length()-1);
                System.out.println(pt);
         }
        
       
    }
      
        
        
        
    
    
}
