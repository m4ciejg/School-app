package com.maciejg.School03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciejg.School03.model.LoginForStudents;

public interface LoginForsStudentsRepository extends JpaRepository<LoginForStudents, Long> {

}
