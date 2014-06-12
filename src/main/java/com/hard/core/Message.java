package com.hard.core;

import java.io.Serializable;


public class Message implements Serializable 
{   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
    private String firstName;
    private String lastName;
    private int age;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", age=" + age + "]";
    }            
}
