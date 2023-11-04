package com.turcologica.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TurcologicaUserRepository extends JpaRepository<TurcologicaUser, Long> {

    public TurcologicaUser findByUserDetailsUsername(String username);
}
