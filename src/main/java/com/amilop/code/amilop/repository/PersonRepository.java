package com.amilop.code.amilop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amilop.code.amilop.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

}
