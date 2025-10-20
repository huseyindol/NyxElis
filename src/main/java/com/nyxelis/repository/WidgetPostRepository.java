package com.nyxelis.repository;

import com.nyxelis.entity.WidgetPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WidgetPostRepository extends JpaRepository<WidgetPost, Long> {
  List<WidgetPost> findByWidgetId(Long widgetId);

}
