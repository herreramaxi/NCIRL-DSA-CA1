/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinationschedulesystem;

import java.util.ArrayList;

/**
 *
 * @author Maximiliano Herrera
 */
public class MyPQ implements PQInterface {

    private final ArrayList<PQElement> _pq;

    public MyPQ() {
        _pq = new ArrayList<>();
    }

    @Override
    public int size() {
        return _pq.size();
    }

    @Override
    public boolean isEmpty() {
        return _pq.isEmpty();
    }

    @Override
    public void enqueue(int key, Person element) {
//Insert by decreasing key order
        PQElement newElement = new PQElement(element, key);
        int index = findInsertPosition(key);

         _pq.add(index, newElement);
//        if (index > _pq.size()) {
//            _pq.add(newElement);
//        } else {
//            _pq.add(index, newElement);
//        }
    }

    @Override
    public PQElement dequeue() {
        return _pq.remove(0);
    }

    public ArrayList<PQElement> dequeueGroup() {
        ArrayList<PQElement> list = new ArrayList<>();
        PQElement firsElement = this.peek();

        if (firsElement == null)
            return list;

        for (PQElement pQElement : _pq) {
            if (pQElement.getKey() != firsElement.getKey()) {
                break;
            }

            list.add(pQElement);
        }

        return list;
    }

    public PQElement peek() {
        return _pq.size() > 0 ? _pq.get(0) : null;
    }

    @Override
    public void printPQ() {
        System.out.println("Queue: ");
        for (PQElement pQElement : _pq) {
            System.out.println(pQElement);
        }

    }

    private int findInsertPosition(int key) {
        boolean found = false;

        PQElement element;
        int position = 0;

        while (position < _pq.size() && !found) {
            element = _pq.get(position);

            //>= for FIFO within same priority
            if (element.getKey() >= key) {
                position = position + 1;
            } else {
                found = true;
            }
        }

        return position;
    }

    void allocateInPriorityQueue(Person person) {
        int priority = getPriority(person);
        this.enqueue(priority, person);
    }

    private int getPriority(Person person) {
        int age = person.getAge();
        boolean medicalCondition = person.isMedicalCondition();

        if (age >= 90)
            return 10;
        if (age >= 80)
            return 9;
        if (age >= 70)
            return 8;
        if (age >= 65 && age <= 69)
            return 7;
        if (age >= 18 && age <= 64 && medicalCondition)
            return 6;
        if (age >= 55 && age <= 64)
            return 5;
        if (age >= 45 && age <= 54)
            return 4;
        if (age >= 30 && age <= 44)
            return 3;
        if (age >= 18 && age <= 29)
            return 2;

        //age < 18
        return 1;
    }
}
