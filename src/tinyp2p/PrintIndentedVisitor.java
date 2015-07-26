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
class PrintIndentedVisitor implements Visitor<String> {

    private final int indent;

    PrintIndentedVisitor(int indent) {
        this.indent = indent;
    }

    public Visitor<String> visitTree(MyTree<String> tree) {
        return new PrintIndentedVisitor(indent + 2);
    }

    public void visitData(MyTree<String> parent, String data) {
        for (int i = 0; i < indent; i++) { // TODO: naive implementation
            System.out.print(" ");
        }

        System.out.println(data);
    }
}