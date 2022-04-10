package com.recruitment.app.repository;

import com.recruitment.app.entity.UserManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserManagementRepository extends CrudRepository<UserManagement , Integer> {

    List<UserManagement> findByEmailId (String emailId);

    List<UserManagement> findByEmailIdAndUserRole (String emailId,String role);
}
