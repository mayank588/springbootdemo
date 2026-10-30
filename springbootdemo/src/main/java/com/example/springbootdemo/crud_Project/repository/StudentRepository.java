
package com.example.springbootdemo.crud_Project.repository;

import com.example.springbootdemo.crud_Project.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Students, Integer> {

    Optional<Students> findByIdAndDeletedFalse(Integer id);

    List<Students> findByDeletedFalseOrDeletedNull();
}
