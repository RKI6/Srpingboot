package day_5_3.ex_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import day_5_3.ex_3.model.Language;

public interface LanguageRepository extends JpaRepository<Language,Integer>{
    
}
