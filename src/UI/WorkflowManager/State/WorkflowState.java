/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.WorkflowManager.State;

import Model.Interfaces.IStateContext;
import Model.Interfaces.IWorkflowState;

/**
 *
 * @author Maximiliano Herrera
 */
public abstract class WorkflowState implements IWorkflowState {

    @Override
    public void changeStatus(IStateContext context, IWorkflowState state) {
        context.changeStatus(state);
    }
    
     @Override
    public void count(IStateContext context) {
        context.getMediator().patientsRegisteredCount();
    }

    @Override
    public void list(IStateContext context) {
        context.getMediator().listAll();
    }
}
