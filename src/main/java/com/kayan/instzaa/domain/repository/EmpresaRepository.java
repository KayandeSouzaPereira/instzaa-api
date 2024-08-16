package com.kayan.instzaa.domain.repository;

import com.kayan.instzaa.domain.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
