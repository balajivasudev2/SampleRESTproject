package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
	
	
@Query(value="select * from user where id=:id" , nativeQuery=true)
Optional<User> findDetails(long id);

}
