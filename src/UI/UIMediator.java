/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Model.Exceptions.NoPatientsToBeScheduled;
import Model.PQGroup;
import Model.Validation;
import Model.Patient;
import Model.VaccinationListManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maximiliano Herrera
 */
public class UIMediator {

    private final MainJFrame _mainFrame;
    private final VaccinationListManager _listManager;

    UIMediator(MainJFrame mainFrame) {
        _mainFrame = mainFrame;
        _listManager = new VaccinationListManager();
    }

    public void addPatient() {
        String name = _mainFrame.getPatientName();
        int age = _mainFrame.getPatientAge();
        boolean medicalCondition = _mainFrame.getMedicalCondition();

        Patient patient = new Patient(name, age, medicalCondition);
        Validation validation = patient.validate();

        if (!validation.isSuccessful()) {
            _mainFrame.showErrorMessageDialog(validation.getErrorMessage());
            return;
        }

        _listManager.addPatient(patient);

        _mainFrame.resetIntputControls();
        _mainFrame.appendTextToTextArea("Patient added: ");
        _mainFrame.appendTextToTextArea(patient.toString());
    }

    public void patientsRegisteredCount() {
        int count = _listManager.size();
        _mainFrame.appendTextToTextArea("Patients registered: " + count);
    }

    public void listAll() {
        if (_listManager.size() == 0) {
            _mainFrame.showMessage("There are not registered patients");
            return;
        }

        _mainFrame.appendTextToTextArea("Patients registered: ");
        _listManager.getAllRegisteredPatients().forEach((patient) -> {
            _mainFrame.appendTextToTextArea(" * " + patient.toString());
        });
    }

    public boolean setPriorities() {
        if (_listManager.size() == 0) {
            _mainFrame.showMessage("There are not patients registered");
            return false;
        }

        try {
            _listManager.setPriorities();
            _mainFrame.showMessage("Priorities were assigned successfully");
            return true;
        } catch (Exception ex) {
            Logger.getLogger(UIMediator.class.getName()).log(Level.SEVERE, null, ex);
            _mainFrame.showErrorMessage("Error when setting priorities: " + ex.getMessage());
        }

        return false;
    }

    public void patientsToBeScheduled() {
        PQGroup scheduledGroup;
        try {
            scheduledGroup = _listManager.getNextGroupToBeScheduled();
        } catch (NoPatientsToBeScheduled ex) {
            _mainFrame.showMessage("There are no more patients to be scheduled");
            return;
        }

        _mainFrame.appendTextToTextArea("Patients to be scheduled - priority " + scheduledGroup.getPriority());
        scheduledGroup.getPatients().forEach((patient) -> {
            _mainFrame.appendTextToTextArea(" * " + patient.toString());
        });
    }

    public void setPrioritiesButtonSetEnable(boolean enabled) {
        _mainFrame.priorityButtonSetEnable(enabled);
    }

    public void addButtonSetEnable(boolean enabled) {
        _mainFrame.addButtonSetEnable(enabled);
    }

    public void getNextGroupButtonSetEnable(boolean enabled) {
        _mainFrame.getNextGroupButtonSetEnable(enabled);
    }

    public boolean areThereMorePatientsToBeScheduled() {
        return !_listManager.isEmpty();
    }
}
