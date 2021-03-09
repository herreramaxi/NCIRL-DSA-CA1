package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maximiliano Herrera
 */
public class Validation {

    private boolean successful;
    private String errorMessage;

    public boolean isSuccessful() {
        return successful;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Validation() {
        successful = true;
    }

    public Validation setAsFailed(String errorMessage) {
        this.successful = false;
        this.errorMessage = errorMessage;

        return this;
    }
}
