package com.turcologica.users.turcologica;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TurcologicaUserRepository extends JpaRepository<TurcologicaUser, Long> {

    TurcologicaUser findByTurcologicaUserID(long ID);

    TurcologicaUser findByUsername(String username);
}
