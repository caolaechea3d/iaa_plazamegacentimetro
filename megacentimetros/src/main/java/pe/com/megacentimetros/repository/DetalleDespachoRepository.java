package pe.com.megacentimetros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.megacentimetros.entity.DetalleDespachoEntity;

public interface DetalleDespachoRepository extends JpaRepository<DetalleDespachoEntity, Long> {
}
