/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Exceptions.NoRegisteredPatientsException;
import Model.Exceptions.PrioritiesAlreadyAssignedException;
import java.util.ArrayList;

/**
 *
 * @author Maximiliano Herrera
 */
public class VaccinationListManager {

    private final ArrayList<Person> _peopleToBeVaccinated;
    private final PriorityQueue _priorityQueue;

    public VaccinationListManager() {
        _peopleToBeVaccinated = new ArrayList<>();
        _priorityQueue = new PriorityQueue();
    }

    public void addPerson(Person person) {
        //InternalId is used to identify an instance unequivocally.        
        person.setInternalId(_peopleToBeVaccinated.size() + 1);

        _peopleToBeVaccinated.add(person);
    }

    public int size() {
        return _peopleToBeVaccinated.size();
    }

    public ArrayList<Person> getAllRegisteredPatients() {
        return _peopleToBeVaccinated;
    }

    public void setPriorities() throws PrioritiesAlreadyAssignedException, NoRegisteredPatientsException {
        if (!_priorityQueue.isEmpty())
            throw new PrioritiesAlreadyAssignedException();

        if (_peopleToBeVaccinated.isEmpty())
            throw new NoRegisteredPatientsException();

        _peopleToBeVaccinated.forEach((person) -> {
            this.allocateInPriorityQueue(person);
        });
    }

    public ArrayList<Person> getNextGroupToBeScheduled() {
        ArrayList<Person> scheduledGroup = this.dequeueGroup();

        scheduledGroup.forEach((person) -> {
            _peopleToBeVaccinated.removeIf(x -> x.getInternalId() == person.getInternalId());
        });

        return scheduledGroup;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    private ArrayList<Person> dequeueGroup() {
        ArrayList<Person> list = new ArrayList<>();
        PQElement firsElement = _priorityQueue.peek();

        if (firsElement == null)
            return list;

        for (int i = 0, size = _priorityQueue.size(); i < size; i++) {
            PQElement pQElement = _priorityQueue.peek();

            if (pQElement == null || pQElement.getPriority() != firsElement.getPriority())
                break;

            list.add(_priorityQueue.dequeue().getPerson());
        }

        return list;
    }

    private void allocateInPriorityQueue(Person person) {
        int priority = this.getPriority(person);
        _priorityQueue.enqueue(priority, person);
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
