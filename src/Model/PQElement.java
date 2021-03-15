/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Maximiliano Herrera
 */
public class PQElement {

    private final Person _person;
    private final int _priority;

    public Person getPerson() {
        return _person;
    }

    public int getPriority() {
        return _priority;
    }

    public PQElement(Person element, int priority) {
        _person = element;
        _priority = priority;
    }

    @Override
    public String toString() {
        return "PQElement{" + "element=" + _person + ", key=" + _priority + '}';
    }
}
