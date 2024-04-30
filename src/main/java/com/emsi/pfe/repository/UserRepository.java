package com.emsi.pfe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emsi.pfe.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);

	Optional<User> findByUsernameOrEmail(String username, String email);

	List<User> findByIdIn(List<Long> userIds);

	User findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	@Query(value = "select * from users where username = ?1 or email =?1", nativeQuery = true)
	User findByUsernameOrEmail(String username);

}
