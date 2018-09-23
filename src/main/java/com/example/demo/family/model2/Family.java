package com.example.demo.family.model2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Family extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade=CascadeType.ALL)
    private Father father;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Child> childrenList = new ArrayList<>();

    public List<Child> getChildrenList() {
        return childrenList;
    }

    public Family(){
        this.father = new Father();
    }

    @Override
    public void add(Child child) {
        childrenList.add(child);
    }

    @Override
    public void remove(Child child) {
        childrenList.remove(child);
    }

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
