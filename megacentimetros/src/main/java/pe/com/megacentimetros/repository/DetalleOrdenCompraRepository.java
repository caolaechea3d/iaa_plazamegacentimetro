package pe.com.megacentimetros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.megacentimetros.entity.DetalleOrdenCompraEntity;

public interface DetalleOrdenCompraRepository extends JpaRepository<DetalleOrdenCompraEntity, Long> {
}
