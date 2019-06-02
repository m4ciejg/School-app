package com.maciejg.School03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciejg.School03.model.LoginForTeachers;

public interface LoginForTeachersRepository extends JpaRepository<LoginForTeachers, Long> {

}
