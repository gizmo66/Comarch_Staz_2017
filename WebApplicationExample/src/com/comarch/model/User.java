package com.comarch.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Adam Kołodziejek
 * @since 09-07-2017
 */

@ToString
@EqualsAndHashCode
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String firstName;
    private String lastName;

    public User(String userId, String firstName, String lastName) {
        super();

        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getName() {
        return firstName + " " + lastName;
    }
}
