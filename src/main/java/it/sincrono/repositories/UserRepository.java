package it.sincrono.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sincrono.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// TROVA UN USER DAL USERNAME
	public Optional<User> findByUsername(String username);

}
