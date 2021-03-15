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
public class Phase2State extends WorkflowState {

    public Phase2State() {
        super();
    }

    @Override
    public void add(IStateContext context) {
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
    }

    @Override
    public void getNextGroup(IStateContext context) {
        this.ChangeStatus(context, new Phase3State());
        context.getNextGroup();
    }

    @Override
    public String getCurrentPhase() {
        return "Phase 2: Patient priorities allocated";
    }
}
