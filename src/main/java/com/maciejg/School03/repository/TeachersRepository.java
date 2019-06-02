package com.maciejg.School03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciejg.School03.model.Teachers;

public interface TeachersRepository extends JpaRepository<Teachers, Long> {

}
