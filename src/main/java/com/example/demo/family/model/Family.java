package com.example.demo.family.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Family extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne(cascade=CascadeType.ALL)
    private Father father;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Component> children = new ArrayList<>();

    public Family(){
        this.father = new Father();
    }

    @Override
    public long getId() {
        return id;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }
}
