package com.example.demo.family;

//import com.example.demo.family.model.Family;
import com.example.demo.family.model2.Family;
import org.springframework.data.repository.CrudRepository;

public interface FamilyRepository extends CrudRepository<Family,Long> {
}
