/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Iterator;
import java.util.LinkedList;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Noreddine
 */
public class LinkedListCompFant<CompFant> extends LinkedList<CompFant> {

    @Override
    public boolean add(CompFant t) {

        boolean b;

        synchronized (this) {
            b = super.add(t);
        }

        return b;
    }

    @Override
    public CompFant remove() {

        CompFant t;

        synchronized (this) {
            t = super.remove();
        }

        return t;
    }

    @Override
    public Iterator<CompFant> iterator() {

        final LinkedListCompFant<CompFant> adap = this;

        return new Iterator<CompFant>() {

            private Iterator<CompFant> iter;

            {
                synchronized (adap) {
                    iter = LinkedListCompFant.this.getIterator();
                }
            }

            @Override
            public boolean hasNext() {

                boolean b;

                synchronized (adap) {
                    b = iter.hasNext();
                }

                return b;
            }

            @Override
            public CompFant next() {

                CompFant t;

                synchronized (adap) {
                    t = iter.next();
                }

                return t;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterator<CompFant> getIterator() {

        Iterator<CompFant> iter;

        synchronized (this) {
            iter = super.iterator();
        }

        return iter;
    }
}

