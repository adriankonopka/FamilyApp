package com.example.demo.family.controller;

import com.example.demo.family.FamilyRepository;
//import com.example.demo.family.model.Family;
//import com.example.demo.family.model.Father;
import com.example.demo.family.model2.Child;
import com.example.demo.family.model2.Family;
import com.example.demo.family.model2.Father;
import com.sun.xml.internal.ws.api.pipe.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.List;


@RestController
public class FamilyController {

    @Autowired
    private FamilyRepository familyRepository;

    final String webApiAddress = "http://192.168.1.2:4200";

//    @CrossOrigin(origins = webApiAddress )
////    @RequestMapping(value = "/AddFatherToFamily", method = RequestMethod.GET)
////    public @ResponseBody Family addFatherToFamily(@RequestParam(value = "familyId") Long familyId,
////                          @RequestParam(value = "firstName") String firstName,
////                          @RequestParam(value = "secondName") String secondName,
////                          @RequestParam(value = "pesel") String pesel,
////                          @RequestParam(value = "birthDate") Date birthDate){
////        Family family;
////        if (familyId!=null && familyRepository.count() > 0){
////            family = familyRepository.findById(familyId).get();
////        }else family = new Family();
////        family.getFather().setFirstName(firstName);
////        family.getFather().setSecondName(secondName);
////        family.getFather().setPesel(pesel);
////        family.getFather().setBirthDate(birthDate);
////        familyRepository.save(family);
////        return family;
////    }

    @CrossOrigin(origins = webApiAddress)
    @RequestMapping(value = "/aftf", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<?> createFather(@RequestBody Father father, UriComponentsBuilder uriComponentsBuilder){
        Family family = new Family();
        family.setFather(father);
        familyRepository.save(family);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/aftf/family/{id}").buildAndExpand(family.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = webApiAddress)
    @RequestMapping(value = "/aftf/family/{familyId}", method = RequestMethod.PUT)
    public ResponseEntity<?> addChildToFamily(@PathVariable("familyId") long id, @RequestBody Child child){
        Family family = familyRepository.findById(id).get();

        if (family == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Family not found");
        }
        family.getChildrenList().add(child);
        familyRepository.save(family);;
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @RequestMapping("/AddChildToFamily")
    public Family addChildToFamily(@RequestParam(value = "familyId") Long familyId,
                           @RequestParam(value = "firstName") String firstName,
                           @RequestParam(value = "secondName") String secondName,
                           @RequestParam(value = "pesel") String pesel,
                           @RequestParam(value = "sex") String sex){
        Family family;
        if (familyRepository.findById(familyId).isPresent()) {
            family = familyRepository.findById(familyId).get();
        }else {
            family = new Family();
        }
            Child child = new Child();
            child.setFirstName(firstName);
            child.setSecondName(secondName);
            child.setPesel(pesel);
            child.setSex(sex);
            family.add(child);
            familyRepository.save(family);
        return family;

    }

    @CrossOrigin(origins = webApiAddress)
    @RequestMapping("/all")
    @ResponseBody
    public Iterable<Family> getAllTemp(){
        return familyRepository.findAll();
    }

    @CrossOrigin(origins = webApiAddress)
    @RequestMapping("/CreateFamily")
    public void createFamily(){
        familyRepository.save(new Family());
    }

    @CrossOrigin(origins = webApiAddress)
    @RequestMapping("/ReadFamily")
    public Family readFamily(@RequestParam(value = "familyId") Long familyId){
        return familyRepository.findById(familyId).get();
    }

    @CrossOrigin(origins = webApiAddress)
    @RequestMapping("/ReadFather")
    public Father getFather(@RequestParam(value = "familyId") Long familyId){
        return familyRepository.findById(familyId).get().getFather();
    }

    @CrossOrigin(origins = webApiAddress)
    @RequestMapping("/ReadChild")
    public Child getChild(@RequestParam(value = "familyId") Long familyId, @RequestParam(value = "childId") Long childId){
        List<Child> children = familyRepository.findById(familyId).get().getChildrenList();
        for (Child child: children) {
            if (child.getId() == childId) return child;
        }
        return null;
    }

//    @RequestMapping("/SearchChild")
//    public String searchChild(@RequestParam(value = "childId") List childId){
//        for ()
//    }

}
