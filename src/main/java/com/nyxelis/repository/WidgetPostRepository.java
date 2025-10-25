package com.nyxelis.repository;

import com.nyxelis.entity.WidgetPost;
import com.nyxelis.entity.id.WidgetPostId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WidgetPostRepository extends JpaRepository<WidgetPost, WidgetPostId> {
  List<WidgetPost> findByWidgetId(Long widgetId);

}
