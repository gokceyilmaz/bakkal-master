package com.mvc.bys.repository;

import com.mvc.bys.model.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrunRepository extends JpaRepository<Urun, Integer> {
}
