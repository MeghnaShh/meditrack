package com.airtribe.meditrack.util;

import com.airtribe.meditrack.exception.InvalidDataException;

public class Validator {

    public void validateName(String name){
        if(name== null || name.trim().isEmpty()){
            System.out.println("Name cannot be empty!");
            throw new InvalidDataException("Name cannot be empty!");
        }
    }

    public void validateAge(int age){
        if(age<= 0 || age>= 110){
            System.out.println("Invalid age!");
            throw new InvalidDataException("Invalid age!");
        }
    }

    public void validateAmount(int amount){
        if(amount<= 0 ){
            System.out.println("Invalid amount, less than zero!");
            throw new InvalidDataException("Invalid amount, less than zero!");
        }
    }
}
