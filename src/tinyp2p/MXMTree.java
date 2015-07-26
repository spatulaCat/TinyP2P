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
public class MXMTree {

    MXMNode root;
    MXMNode commonRoot;

    public MXMTree( MXMNode root ) {
        this.root = root;
        commonRoot = null;
    }

    public void addElement( String elementValue ) { 
        String[] list = elementValue.split("\\\\");

        // latest element of the list is the filename.extrension
        root.addElement(root.incrementalPath, list);

    }

    public void printTree() {
        //I move the tree common root to the current common root because I don't mind about initial folder
        //that has only 1 child (and no leaf)
        getCommonRoot();
        commonRoot.printNode(0);
    }

    public MXMNode getCommonRoot() {
        if ( commonRoot != null)
            return commonRoot;
        else {
            MXMNode current = root;
            while ( current.leafs.size() <= 0 ) {
                current = current.childs.get(0);
            }
            commonRoot = current;
            return commonRoot;
        }

    }


}
