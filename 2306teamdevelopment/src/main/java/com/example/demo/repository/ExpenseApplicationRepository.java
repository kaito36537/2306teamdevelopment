package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;


@Repository
public interface ExpenseApplicationRepository extends JpaRepository<UserEntity, Integer> {

}