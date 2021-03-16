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
    public void setPriorities(IStateContext context) {
    }

    @Override
    public void getNextGroup(IStateContext context) {
        context.getMediator().patientsToBeScheduled();

        if (!context.getMediator().areThereMorePatientsToBeScheduled()) {
            context.getMainJFrame().showMessage("There are no more patients to be scheduled");
            context.initialize();
            context.changeStatus(new Phase1State());
        }
    }

    @Override
    public String getCurrentPhase() {
        return "Phase 3: Scheduling patients";
    }
}
