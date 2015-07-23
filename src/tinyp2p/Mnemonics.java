/*
* The MIT License
*
* Copyright 2015 Nicky.
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/
package tinyp2p;

import java.util.Arrays;


/**
 *
 * @author Nicky
 */
public class Mnemonics {

    
     private static String[] words = {"zip", "ace",
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
            "rat",
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
    
//    public static void main (String args[]){
//        System.out.println(getMnemonics("127.0.0.1"));
//        
//    }
}
