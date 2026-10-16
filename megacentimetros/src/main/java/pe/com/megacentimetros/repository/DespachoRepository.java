package pe.com.megacentimetros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.megacentimetros.entity.DespachoEntity;

public interface DespachoRepository extends JpaRepository<DespachoEntity, Long> {
}

