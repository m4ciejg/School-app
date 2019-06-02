package com.maciejg.School03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciejg.School03.model.Students;

public interface StudentsRepository extends JpaRepository<Students, Long> {

}
