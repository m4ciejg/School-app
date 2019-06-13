package com.maciejg.School03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciejg.School03.model.Grades;

public interface GradesRepository extends JpaRepository<Grades, Long> {

}
