package com.sura.suraApp.dao;

import com.sura.suraApp.entities.Client;
import com.sura.suraApp.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
