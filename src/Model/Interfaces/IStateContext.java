/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

import UI.MainJFrame;
import UI.UIMediator;

/**
 *
 * @author Maximiliano Herrera
 */
public interface IStateContext {

    public void changeStatus(IWorkflowState state);

    public void addPerson();

    public void patientsRegisteredCount();

    public void list();

    public void setPriorities();

    public void getNextGroup();

    public void initialize();

    public MainJFrame getMainJFrame();

    public UIMediator getMediator();
}
