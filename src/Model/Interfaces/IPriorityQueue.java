/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

import Model.PQElement;
import Model.Person;

/**
 *
 * @author Maximiliano Herrera
 */
public interface IPriorityQueue {

    public int size();

    public boolean isEmpty();

    public void enqueue(int priority, Person element);

    public PQElement dequeue();

    public PQElement peek();
}
