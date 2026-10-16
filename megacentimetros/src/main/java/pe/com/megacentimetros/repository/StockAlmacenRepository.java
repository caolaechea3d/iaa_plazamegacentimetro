package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.StockAlmacenEntity;
import pe.com.megacentimetros.entity.StockAlmacenId;

public interface StockAlmacenRepository extends JpaRepository<StockAlmacenEntity, StockAlmacenId> {
	@Query("select s from StockAlmacenEntity s where s.estado=true")
	List<StockAlmacenEntity> findAllCustom();
}

