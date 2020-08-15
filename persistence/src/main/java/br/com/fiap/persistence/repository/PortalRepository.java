package br.com.fiap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.persistence.models.Portal;

@Repository
public interface PortalRepository extends JpaRepository<Portal, Long>{

}
