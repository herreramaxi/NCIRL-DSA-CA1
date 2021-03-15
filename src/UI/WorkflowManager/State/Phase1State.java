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
public class Phase1State extends WorkflowState {

    @Override
    public void add(IStateContext context) {
        context.getMediator().addPerson();
        context.getMediator().setPrioritiesButtonSetEnable(true);
    }

    @Override
    public void count(IStateContext context) {
        context.getMediator().patientsregisteredCount();
    }

    @Override
    public void list(IStateContext context) {
        context.getMediator().listAll();
    }

    @Override
    public void setPriorities(IStateContext context) {
        if (!context.getMediator().setPriorities())
            return;

        context.getMediator().setPrioritiesButtonSetEnable(false);
        context.getMediator().addButtonSetEnable(false);
        context.getMediator().getNextGroupButtonSetEnable(true);

        this.ChangeStatus(context, new Phase2State());
    }

    @Override
    public void getNextGroup(IStateContext context) {
    }

    @Override
    public String getCurrentPhase() {
        return "Phase 1: Loading confirmed patients";
    }
}
