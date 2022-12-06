package com.abujava.springbootjavers.repository;

import com.abujava.springbootjavers.entity.Person;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface not documented :(
 *
 * @author Muhammad Muminov
 * @since 12/6/2022
 */
@JaversSpringDataAuditable
public interface PersonRepository extends JpaRepository<Person, Long> {
}
