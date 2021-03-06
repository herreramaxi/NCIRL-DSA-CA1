/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import Model.Interfaces.IPriorityQueue;

/**
 *
 * @author Maximiliano Herrera
 */
public class PriorityQueue implements IPriorityQueue {

    private final ArrayList<PQElement> _internalList;

    public PriorityQueue() {
        _internalList = new ArrayList<>();
    }

    @Override
    public int size() {
        return _internalList.size();
    }

    @Override
    public boolean isEmpty() {
        return _internalList.isEmpty();
    }

    @Override
    public void enqueue(int priority, Patient element) {
        //Insert by high priority first
        PQElement newElement = new PQElement(element, priority);
        int index = findInsertPosition(priority);

        _internalList.add(index, newElement);
    }

    @Override
    public PQElement dequeue() {
        return _internalList.remove(0);
    }

    @Override
    public PQElement peek() {
        return _internalList.size() > 0 ? _internalList.get(0) : null;
    }

    private int findInsertPosition(int priority) {
        int position = 0;

        while (position < _internalList.size()) {
            PQElement element = _internalList.get(position);

            //FIFO for elements with same priority
            if (priority > element.getPriority()) {
                break;
            }

            position++;
        }

        return position;
    }
}
