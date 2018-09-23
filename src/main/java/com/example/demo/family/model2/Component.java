package com.example.demo.family.model2;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import java.util.Iterator;
import java.util.List;

@MappedSuperclass
public abstract class Component {
    public void add(Child child){};
    public void remove(Child child){};
}
