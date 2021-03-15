/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.WorkflowManager.State;

import Model.Interfaces.IStateContext;

/**
 *
 * @author Maximiliano Herrera
 */
public class Phase3State extends WorkflowState {

    public Phase3State() {
        super();
    }

    @Override
    public void add(IStateContext context) {
    }

    @Override
    public void count(IStateContext context) {
        context.getMediator().patientsRegisteredCount();
    }

    @Override
    public void list(IStateContext context) {
        context.getMediator().listAll();
    }

    @Override
    public void setPriorities(IStateContext context) {
    }

    @Override
    public void getNextGroup(IStateContext context) {
        context.getMediator().patientsToBeScheduled();

        if (!context.getMediator().areThereMorePatientsToBeScheduled()) {
            context.getMainJFrame().showMessage("There are no more patients to be scheduled");
            context.initialize();
            context.ChangeStatus(new Phase1State());
        }
    }

    @Override
    public String getCurrentPhase() {
        return "Phase 3: Scheduling patients";
    }
}
