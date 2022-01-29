package com.mvc.bys.repository;

import com.mvc.bys.model.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KullaniciRepository extends JpaRepository<Kullanici, Integer> {
}
