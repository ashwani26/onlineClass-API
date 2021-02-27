package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserSubjectAssociation;

public interface UserSubjectAssociationRepository extends JpaRepository<UserSubjectAssociation, Long> {

}
