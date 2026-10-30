package com.example.springbootdemo.crud_Project.controller;

import com.example.springbootdemo.crud_Project.entity.Students;
import com.example.springbootdemo.crud_Project.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public  StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

      @PostMapping
    public ResponseEntity<Students> createStudent(@RequestBody
      Students student){
          System.out.println("Inside StudentController");

       Students craetedstudent =studentService.createStudent(student);
       return ResponseEntity.status(HttpStatus.CREATED).body(craetedstudent);
    }
 @GetMapping("/get")
    public ResponseEntity<Students> getStudent(@RequestParam Integer id){
        Students studentresp=studentService.getStudent(id);
        if(studentresp==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentresp);
 }

    @GetMapping("/getAll")
    public ResponseEntity<List<Students>> getAllStudent(){
        List<Students> studentresp=studentService.getAllStudent();
        if(studentresp==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentresp);
    }
    @PutMapping("/update")
    public ResponseEntity<Students> updateStudent(@RequestParam Integer id, @RequestBody Students studentReq){
        Students studentResp=studentService.updateStudent(id,studentReq);
        if(studentResp==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteStudent(@RequestParam Integer id){
        Boolean isDeleted=studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(isDeleted);
    }
    @PatchMapping("/delete-soft")
    public ResponseEntity<Boolean> deleteStudentSoft(@RequestParam Integer id){
        boolean isdeleted=studentService.deleteStudentsoftly(id);
        if(!isdeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

}
