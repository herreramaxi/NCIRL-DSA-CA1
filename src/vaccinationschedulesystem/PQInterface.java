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
public interface PQInterface {

    public int size();

    public boolean isEmpty();

    public void enqueue(int key, Person element);

    public PQElement dequeue();

    public void printPQ();
}
