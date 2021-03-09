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
        boolean groupExtracted = context.getMediator().patientsToBeScheduled();
        
        if (!groupExtracted) {
            context.initialize();
            context.ChangeStatus(new Phase1State());
        }
    }
}
