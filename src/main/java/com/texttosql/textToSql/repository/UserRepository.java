package com.texttosql.textToSql.repository;


import com.texttosql.textToSql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
