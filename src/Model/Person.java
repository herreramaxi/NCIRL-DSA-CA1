/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Validation;
import com.google.common.base.Strings;
import java.util.Objects;

/**
 *
 * @author Maximiliano Herrera
 */
public class Person {

    private String _name;
    private int _age;
    private boolean _medicalCondition;
    private int _internalId;

    public String getName() {
        return _name;
    }

    public int getAge() {
        return _age;
    }

    public boolean isMedicalCondition() {
        return _medicalCondition;
    }

    public int getInternalId() {
        return _internalId;
    }

    public void setInternalId(int internalId) {
        _internalId = internalId;
    }

    public Person(String name, int age, boolean medicalCondition) {
        _name = name;
        _age = age;
        _medicalCondition = medicalCondition;
    }

    public Validation validate() {
        Validation validation = new Validation();

        if (Strings.isNullOrEmpty(_name))
            return validation.setAsFailed("Patient name is required");

        if (_age <= 0)
            return validation.setAsFailed("Patient age must be greater than zero: " + _age);

        return validation;
    }

    @Override
    public String toString() {
        return "Person{" + "_name=" + _name + ", _age=" + _age + ", _medicalCondition=" + _medicalCondition + '}';
    }

    @Override
    public boolean equals(Object o) {
        // I am considering that name is the way to uniquevocaly idendity to a Person
        if (o == null)
            throw new IllegalArgumentException("Parameter is null");

        Person p = (Person) o;

        return _name.equals(p.getName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this._name);
        return hash;
    }

}
