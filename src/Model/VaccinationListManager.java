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

    public int count() {
        return _peopleToBeVaccinated.size();
    }

    public ArrayList<Person> getAllRegisteredPatients() {
        return _peopleToBeVaccinated;
    }

    public void setPriorities() {
        _peopleToBeVaccinated.forEach((person) -> {
            _priorityList.allocateInPriorityQueue(person);
        });
    }

    public ArrayList<Person> getPatientsWithHighestPriority() {
        ArrayList<Person> group = new ArrayList<>();
        ArrayList<PQElement> pqElements = _priorityList.dequeueGroup();

        for (PQElement pqElement : pqElements) {
            Person person = pqElement.getElement();

            _peopleToBeVaccinated.removeIf(x -> x.getInternalId() == person.getInternalId());
            group.add(person);
        }

        return group;
    }

}
