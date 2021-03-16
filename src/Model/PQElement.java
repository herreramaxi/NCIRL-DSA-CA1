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

    private final Patient _patient;
    private final int _priority;

    public Patient getPatient() {
        return _patient;
    }

    public int getPriority() {
        return _priority;
    }

    public PQElement(Patient element, int priority) {
        _patient = element;
        _priority = priority;
    }

    @Override
    public String toString() {
        return "PQElement{" + "element=" + _patient + ", priority=" + _priority + '}';
    }
}
