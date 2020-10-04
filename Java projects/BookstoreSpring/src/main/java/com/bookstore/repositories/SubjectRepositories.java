package com.bookstore.repositories;

import com.bookstore.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "subjects", path = "subjects")
public interface SubjectRepositories extends JpaRepository<Subject, Long> {
}
