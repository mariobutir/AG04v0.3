package com.articleapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.articleapp.model.Uservote;

public interface UserVoteRepository extends JpaRepository<Uservote, String> {
	Optional<Uservote> findById(String id);
}
