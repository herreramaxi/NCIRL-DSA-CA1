/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Exceptions.NoPatientsToBeScheduled;
import Model.Exceptions.NoRegisteredPatientsException;
import Model.Exceptions.PrioritiesAlreadyAssignedException;
import java.util.ArrayList;

/**
 *
 * @author Maximiliano Herrera
 */
public class VaccinationListManager {

    private final ArrayList<Patient> _peopleToBeVaccinated;
    private final PriorityQueue _priorityQueue;

    public VaccinationListManager() {
        _peopleToBeVaccinated = new ArrayList<>();
        _priorityQueue = new PriorityQueue();
    }

    public void addPatient(Patient patient) {
        //InternalId is used to identify an instance unequivocally.        
        patient.setInternalId(_peopleToBeVaccinated.size() + 1);

        _peopleToBeVaccinated.add(patient);
    }

    public int size() {
        return _peopleToBeVaccinated.size();
    }

    public ArrayList<Patient> getAllRegisteredPatients() {
        return _peopleToBeVaccinated;
    }

    public void setPriorities() throws PrioritiesAlreadyAssignedException, NoRegisteredPatientsException {
        if (!_priorityQueue.isEmpty())
            throw new PrioritiesAlreadyAssignedException();

        if (_peopleToBeVaccinated.isEmpty())
            throw new NoRegisteredPatientsException();

        _peopleToBeVaccinated.forEach((patient) -> {
            this.allocateInPriorityQueue(patient);
        });
    }

    public PQGroup getNextGroupToBeScheduled() throws NoPatientsToBeScheduled {
       PQGroup scheduledGroup = this.dequeueGroup();        

        scheduledGroup.getPatients().forEach((patient) -> {
            _peopleToBeVaccinated.removeIf(x -> x.getInternalId() == patient.getInternalId());
        });

        return scheduledGroup;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    private PQGroup dequeueGroup() throws NoPatientsToBeScheduled {
        PQElement firsElement = _priorityQueue.peek();

        if (firsElement == null)
            throw new NoPatientsToBeScheduled();

        PQGroup group = new PQGroup(firsElement.getPriority());

        for (int i = 0, size = _priorityQueue.size(); i < size; i++) {
            PQElement pQElement = _priorityQueue.peek();

            if (pQElement == null || pQElement.getPriority() != firsElement.getPriority())
                break;

            group.addPatient(_priorityQueue.dequeue().getPatient());
        }

        return group;
    }

    private void allocateInPriorityQueue(Patient patient) {
        int priority = this.getPriority(patient);
        _priorityQueue.enqueue(priority, patient);
    }

    private int getPriority(Patient patient) {
        int age = patient.getAge();
        boolean medicalCondition = patient.isMedicalCondition();

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
