package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * @JsonIgnoreProperties is used to mark a property or list of
 * properties to be ignored. So that the code doesn't break.
 * 
 * i.e. if the App is consuming JSON from a REST web service,
 * and tomorrow a new field is added into JSON, then the 
 * code would break, because Jackson will throw UnrecognizedPropertyException
 * and stop pasing JSON.
 * 
 * IF @JsonIgnoreProperties is not used properly, it could be troublesome and 
 * cause problems in production.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dog {
    private String message;
    private String status;

    /*
     * Empty constructor:
     * If you don't provide any additional constructors with arguments
     * for the class, you don't need to provide an empty constructor 
     * because you get one per default. 
     * 
     * more info: https://stackoverflow.com/questions/18099127/java-entity-why-do-i-need-an-empty-constructor
     */
    public Dog(){}

    // Getters
    public String getMessage(){ return message; }
    public String getStatus(){ return status; }

    // Setters
    public void setMessage(String message){ this.message = message; }
    public void setStatus(String status){ this.status = status; }

    public String toString(){
        return "Image URL of a random dog: " + message;
    }
}
