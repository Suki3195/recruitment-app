package com.recruitment.app.repository;

import com.recruitment.app.entity.UserManagement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserManagementRepository extends CrudRepository<UserManagement , Integer> {

    List<UserManagement> findByEmailId (String emailId);

    UserManagement findByEmailIdAndUserRole (String emailId,String role);
}
