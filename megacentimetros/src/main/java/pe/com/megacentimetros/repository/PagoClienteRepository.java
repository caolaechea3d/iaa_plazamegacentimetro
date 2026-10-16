package pe.com.megacentimetros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.megacentimetros.entity.PagoClienteEntity;

public interface PagoClienteRepository extends JpaRepository<PagoClienteEntity, Long> {
}

