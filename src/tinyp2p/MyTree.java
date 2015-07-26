package tinyp2p;


import java.util.LinkedHashSet;
import java.util.Set;
import tinyp2p.Visitor;
import tinyp2p.Visitable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author (._.)
 */
class MyTree<T> implements Visitable<T> {

    // NB: LinkedHashSet preserves insertion order
    private final Set<MyTree> children = new LinkedHashSet<MyTree>();
    private final T data;

    MyTree(T data) {
        this.data = data;
    }

    public void accept(Visitor<T> visitor) {
        visitor.visitData(this, data);

        for (MyTree child : children) {
            Visitor<T> childVisitor = visitor.visitTree(child);
            child.accept(childVisitor);
        }
    }

    MyTree child(T data) {
        for (MyTree child: children ) {
            if (child.data.equals(data)) {
                return child;
            }
        }

        return child(new MyTree(data));
    }

    MyTree child(MyTree<T> child) {
        children.add(child);
        return child;
    }
}
