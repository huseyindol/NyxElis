package com.nyxelis.repository;

import com.nyxelis.entity.Component;
import com.nyxelis.enums.ComponentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComponentRepository extends JpaRepository<Component, Long> {
  List<Component> findByType(ComponentType type);
}
