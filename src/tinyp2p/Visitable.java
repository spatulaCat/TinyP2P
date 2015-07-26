package tinyp2p;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author (._.)
 */
interface Visitor<T> {

    Visitor<T> visitTree(MyTree<T> tree);

    void visitData(MyTree<T> parent, T data);
}

interface Visitable<T> {

    void accept(Visitor<T> visitor);
}
