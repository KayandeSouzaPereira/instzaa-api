package com.kayan.instzaa.domain.repository;

import com.kayan.instzaa.domain.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, Long> {
    public Optional<UserInfo> findByEmail(String username);
}
