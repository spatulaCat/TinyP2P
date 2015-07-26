/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinyp2p;

/**
 *
 * @author (._.)
 */
public class Test {

    /**
     * @param args
     */  
    public static void main(String[] args) {

        String slist[] = new String[] { 
//                "/mnt/sdcard/folder1/a/b/file1.file", 
//                "/mnt/sdcard/folder1/a/b/file2.file", 
//                "/mnt/sdcard/folder1/a/b/file3.file", 
//                "/mnt/sdcard/folder1/a/b/file4.file",
//                "/mnt/sdcard/folder1/a/b/file5.file", 
//                "/mnt/sdcard/folder1/e/c/file6.file", 
//                "/mnt/sdcard/folder2/d/file7.file", 
//                "/mnt/sdcard/folder2/d/file8.file", 
//                "/mnt/sdcard/file9.file" 
//                
                "C:\\Users\\(._.)\\Documents\\TinyP2P\\README.md",
               " C:\\Users\\(._.)\\Documents\\TinyP2P\\src",
                "C:\\Users\\(._.)\\Documents\\TinyP2P\\src\\client.conf",
              "  C:\\Users\\(._.)\\Documents\\TinyP2P\\src\\img",
              "  C:\\Users\\(._.)\\Documents\\TinyP2P\\src\\img\\bg1.png",
              "  C:\\Users\\(._.)\\Documents\\TinyP2P\\src\\img\\tiny4.png",
              "  C:\\Users\\(._.)\\Documents\\TinyP2P\\src\\tinyp2p",
               " C:\\Users\\(._.)\\Documents\\TinyP2P\\src\\tinyp2p\\ChooseUsername.form"
        };

        MXMTree tree = new MXMTree(new MXMNode("root", "root"));
        for (String data : slist) {
            tree.addElement(data);
        }

        tree.printTree();
        
    }

}