package com.sura.suraApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sura.suraApp.entities.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long>{

}
