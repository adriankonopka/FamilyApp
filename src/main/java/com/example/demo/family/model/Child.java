package com.example.demo.family.model;

import java.util.Date;

public class Child extends Component {
    @Override
    public void setBirthDate(Date birthDate) {
        System.out.println("Can not set this variable.");
    }

    @Override
    public Date getBirthDate() {
        return null;
    }
}
