package com.codeup.coduepspringblog.repositories;

import com.codeup.coduepspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
