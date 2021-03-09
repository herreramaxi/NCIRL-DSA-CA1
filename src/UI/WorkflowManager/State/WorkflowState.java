/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.WorkflowManager.State;

import UI.UIMediator;
import Model.Interfaces.IStateContext;
import Model.Interfaces.IWorkflowState;
import Model.Person;

/**
 *
 * @author Maximiliano Herrera
 */
public abstract class WorkflowState implements IWorkflowState {

    @Override
    public void ChangeStatus(IStateContext context, IWorkflowState state) {
        context.ChangeStatus(state);
    }
}
