package com.nomoretools.user.integration;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nomoretools.user.domain.User;

@RepositoryRestResource(collectionResourceRel = "data", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
   User findByName( @Param("name") String name );
   
   Iterable<User> findAll();
}
