/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

/**
 *
 * @author Maximiliano Herrera
 */
public interface IWorkflowState {

    public void changeStatus(IStateContext context, IWorkflowState state);

    public void add(IStateContext context);

    public void count(IStateContext context);

    public void list(IStateContext context);

    public void setPriorities(IStateContext context);

    public void getNextGroup(IStateContext context);
    
    public String getCurrentPhase();
}
