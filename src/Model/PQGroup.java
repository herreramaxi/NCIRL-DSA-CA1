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
public class PQGroup {

    private final int _priority;
    private final ArrayList<Patient> _patients;

    public int getPriority() {
        return _priority;
    }

    public ArrayList<Patient> getPatients() {
        return _patients;
    }

    public boolean isEmpty() {
        return _patients.isEmpty();
    }

    public int size() {
        return _patients.size();
    }

    public PQGroup(int _priority) {
        this._priority = _priority;
        _patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        _patients.add(patient);
    }
}
