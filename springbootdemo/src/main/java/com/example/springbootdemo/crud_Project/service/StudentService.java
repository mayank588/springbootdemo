package com.example.springbootdemo.crud_Project.service;

import com.example.springbootdemo.crud_Project.entity.Students;

import com.example.springbootdemo.crud_Project.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentrepository;

    public StudentService(StudentRepository studentrepository){
        this.studentrepository=studentrepository;
    }


    public Students createStudent(Students studentReq) {
        //buisnnes logic
        // works like a manager b/w the controller and repositiory
        System.out.println("Inside StudentService");

        studentReq.setDeleted(false);//soft delete key

        Students studentResp=studentrepository.save(studentReq); // save() method is JPA method
         return studentResp;

    }

    public Students getStudent(Integer id){
        Optional<Students> studentResp=studentrepository.findByIdAndDeletedFalse(id);
        if(studentResp.isPresent()){
            return studentResp.get();
        }
        return null;
    }
    public List<Students> getAllStudent(){

        return studentrepository.findByDeletedFalseOrDeletedNull();

    }
    public Students updateStudent(Integer  id,Students  studentReq){
        Optional<Students> existingStudent=studentrepository.findByIdAndDeletedFalse(id);
        if(existingStudent.isEmpty()){
            return null;
        }
        Students studentToSave=existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setRoll_no(studentReq.getRoll_no());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setDeleted(false);

        return studentrepository.save(studentToSave);
    }
    public boolean deleteStudent(Integer id){
        Boolean exist=studentrepository.existsById(id);
        if(!exist){
            return false;
        }
            studentrepository.deleteById(id);
            return true;

    }
    public boolean deleteStudentsoftly(Integer id){
        // get reocord
        //delete=1
        //save
Optional<Students> existingStudent=
        studentrepository.findByIdAndDeletedFalse(id);
if(existingStudent.isEmpty()){
    return false;
}
Students studentTosave=existingStudent.get();
studentTosave.setDeleted(true);

studentrepository.save(studentTosave);
return true;
    }

}
