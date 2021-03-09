/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Maximiliano Herrera
 */
public class PQElement {

    private final Person element;
    private final int key;

    public Person getElement() {
        return element;
    }

    public int getKey() {
        return key;
    }

    public PQElement(Person element, int key) {
        this.element = element;
        this.key = key;
    }

    
    //todo: check this
    @Override
    public String toString() {
        return "PQElement{" + "element=" + element + ", key=" + key + '}';
    }
}
