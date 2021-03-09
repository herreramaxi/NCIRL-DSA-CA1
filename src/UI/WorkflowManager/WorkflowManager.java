/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.WorkflowManager;

import Model.Interfaces.IWorkflowState;
import Model.Interfaces.IStateContext;
import UI.WorkflowManager.State.Phase1State;
import UI.MainJFrame;
import UI.UIMediator;

/**
 *
 * @author Maximiliano Herrera
 */
public class WorkflowManager implements IStateContext {

    private final MainJFrame _mainJFrame;
    private final UIMediator _mediator;
    private IWorkflowState _state;

    public MainJFrame getMainJFrame() {
        return _mainJFrame;
    }

    public UIMediator getMediator() {
        return _mediator;
    }

    public WorkflowManager(MainJFrame mainJFrame, UIMediator mediator) {
        _mainJFrame = mainJFrame;
        _mediator = mediator;
        _state = new Phase1State();      
    }

    @Override
    public void addPerson() {
        _state.add(this);
    }

    @Override
    public void patientsRegisteredCount() {
        _state.count(this);
    }

    @Override
    public void list() {
        _state.list(this);
    }

    @Override
    public void setPriorities() {
        _state.setPriorities(this);
    }

    @Override
    public void getNextGroup() {
        _state.getNextGroup(this);
    }

    @Override
    public void ChangeStatus(IWorkflowState state) {
        _state = state;
    }

    @Override
    public void initialize() {
        _mediator.addButtonSetEnable(true);
        _mediator.setPrioritiesButtonSetEnable(false);
        _mediator.getNextGroupButtonSetEnable(false);
    }
}
