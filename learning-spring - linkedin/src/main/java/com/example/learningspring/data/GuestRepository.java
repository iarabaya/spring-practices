package com.example.learningspring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface GuestRepository extends CrudRepository <Guest, Long> {
}
