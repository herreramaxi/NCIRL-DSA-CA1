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

    //I am considering that the properties name, age medicalCondition identify uniquevocaly a Person
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this._name);
        hash = 83 * hash + this._age;
        hash = 83 * hash + (this._medicalCondition ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Person other = (Person) obj;
        if (this._age != other._age)
            return false;
        if (this._medicalCondition != other._medicalCondition)
            return false;
        if (!Objects.equals(this._name, other._name))
            return false;
        return true;
    }
}
