package com.example.demo.controllers;


import com.example.demo.data.InputTeacher;
import com.example.demo.data.Teacher;
import com.example.demo.data.TeacherRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TeacherController {

    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    @QueryMapping
    public Iterable<Teacher> teachers(){
System.out.println(this.teacherRepository.findAll().size());

        return  this.teacherRepository.findAll();
    }
    @QueryMapping
    public Teacher teacherById(@Argument Long id){
        return  this.teacherRepository.findById(id).orElseThrow(null);
    }
    @QueryMapping
    public Teacher teacherByName(@Argument String name){
        return  this.teacherRepository.findByName(name);
    }
    @MutationMapping
    public Teacher addTeacher(@Argument String id,@Argument String name){
        Teacher t=new Teacher();
        t.setId(Long.valueOf(id));
        t.setName(name);
        t.setActive("A");
        return this.teacherRepository.save(t);
    }
    /*
        deleteTeacher(id:ID):String
     editTeacher(id:String,name:String):Teacher
     */
    @MutationMapping
    public String deleteTeacher(@Argument Long id){
        this.teacherRepository.deleteById(id);
        return "Deleted Success";
    }
    @MutationMapping
    public Teacher editTeacher(@Argument Long id,@Argument String name){
      Teacher teacher=  this.teacherRepository.findById(id).get();
        teacher.setName(name);
        return  this.teacherRepository.save(teacher);

    }

    @MutationMapping
    public Teacher createTeacher(@Argument (name="input") InputTeacher input){
        return  this.teacherRepository.save(  input.getTeacher());
//        return  this.teacherRepository.findById(9l).get();
    }
}
