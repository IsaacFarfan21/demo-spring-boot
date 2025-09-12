package com.utec.demo.spring_boot.producto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoBD, Long> {
}