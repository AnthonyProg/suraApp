package com.sura.suraApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sura.suraApp.entities.PropertyType;

@Repository
public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {

}
