package com.example.sbnz.repository;

import com.example.sbnz.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository  extends JpaRepository<Country, String>
{
}
