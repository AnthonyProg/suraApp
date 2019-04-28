package com.sura.suraApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sura.suraApp.entities.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long>{

}
