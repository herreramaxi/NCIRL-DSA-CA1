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
public interface ISubject {

    void attach(IObserverPull observer);

    void Notify();
}