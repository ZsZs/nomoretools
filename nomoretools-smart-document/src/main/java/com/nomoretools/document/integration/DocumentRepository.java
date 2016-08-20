package com.nomoretools.document.integration;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nomoretools.document.domain.SmartDocument;

@RepositoryRestResource(collectionResourceRel = "data", path = "documents")
public interface DocumentRepository extends PagingAndSortingRepository<SmartDocument, Long> {
   SmartDocument findByName( @Param("name") String name );
   
   Iterable<SmartDocument> findAll();
}
