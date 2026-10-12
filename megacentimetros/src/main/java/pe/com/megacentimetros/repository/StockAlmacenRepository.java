package pe.com.megacentimetros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.megacentimetros.entity.StockAlmacenEntity;
import pe.com.megacentimetros.entity.StockAlmacenId;

public interface StockAlmacenRepository extends JpaRepository<StockAlmacenEntity, StockAlmacenId> {
}
