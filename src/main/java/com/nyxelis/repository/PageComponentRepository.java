package com.nyxelis.repository;

import com.nyxelis.entity.PageComponent;
import com.nyxelis.entity.id.PageComponentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PageComponentRepository extends JpaRepository<PageComponent, PageComponentId> {

  List<PageComponent> findByPageId(Long pageId);
}
