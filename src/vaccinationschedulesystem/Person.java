/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinationschedulesystem;

/**
 *
 * @author Maximiliano Herrera
 */
public class Person {

    private String _name;
    private int _age;
    private boolean _medicalCondition;
  
    public String getName() {
        return _name;
    }

    public int getAge() {
        return _age;
    }
    
    public boolean isMedicalCondition() {
        return _medicalCondition;
    }

    public Person(String name, int age, boolean medicalCondition) {
        _name = name;
        _age = age;
        _medicalCondition = medicalCondition;
    }

    @Override
    public String toString() {
        return "Person{" + "_name=" + _name + ", _age=" + _age + ", _medicalCondition=" + _medicalCondition + '}';
    }
}
