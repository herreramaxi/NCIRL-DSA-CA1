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
    private final MyPQ _priorityList;

    public VaccinationListManager() {
        _peopleToBeVaccinated = new ArrayList<>();
        _priorityList = new MyPQ();
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
        if (!_priorityList.isEmpty())
            throw new PrioritiesAlreadyAssignedException();

        if (_peopleToBeVaccinated.isEmpty())
            throw new NoRegisteredPatientsException();

        _peopleToBeVaccinated.forEach((person) -> {
            _priorityList.allocateInPriorityQueue(person);
        });
    }

    public ArrayList<Person> getNextGroupToBeScheduled() {
        ArrayList<Person> group = new ArrayList<>();
        ArrayList<PQElement> pqElements = _priorityList.dequeueGroup();

        for (PQElement pqElement : pqElements) {
            Person person = pqElement.getElement();

            _peopleToBeVaccinated.removeIf(x -> x.getInternalId() == person.getInternalId());
            group.add(person);
        }

        return group;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}
