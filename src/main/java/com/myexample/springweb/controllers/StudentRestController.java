package com.myexample.springweb.controllers;

import com.myexample.springweb.entities.Student;
import com.myexample.springweb.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    private StudentRepository repository;
    @RequestMapping(value="/students",method= RequestMethod.GET)
    public List<Student> getStudents(){
        return repository.findAll();
    }
    @RequestMapping(value="/students/{id}",method= RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){
        return repository.findById(id).get();
    }
    @RequestMapping(value="/students",method= RequestMethod.POST)
    public Student insertStudent(@RequestBody Student student){return repository.save(student);}

    @RequestMapping(value="/students",method= RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student student){return repository.save(student);}

    @RequestMapping(value="/students/{id}",method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id){
        repository.deleteById(id);
    }
}
