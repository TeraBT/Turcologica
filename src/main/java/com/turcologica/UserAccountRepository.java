package com.turcologica;

import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Integer> {

    UserAccount findUserAccountById(Integer id);
}