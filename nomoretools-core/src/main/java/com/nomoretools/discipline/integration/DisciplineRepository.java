package com.nomoretools.discipline.integration;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nomoretools.discipline.domain.Discipline;

@RepositoryRestResource(collectionResourceRel = "disciplines", path = "disciplines")
public interface DisciplineRepository extends PagingAndSortingRepository<Discipline, Long> {
   Discipline findByName( @Param("name") String name );
   
   Iterable<Discipline> findAll();
}
