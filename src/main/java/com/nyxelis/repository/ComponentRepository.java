package com.nyxelis.repository;

import com.nyxelis.entity.Component;
import com.nyxelis.enums.ComponentType;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Long> {

  List<Component> findByType(ComponentType type);

}
