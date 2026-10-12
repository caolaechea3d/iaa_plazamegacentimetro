package pe.com.megacentimetros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.megacentimetros.entity.AlmacenEntity;

public interface AlmacenRepository extends JpaRepository<AlmacenEntity, Long> {
}
