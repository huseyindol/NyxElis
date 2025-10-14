package com.nyxelis.repository;

import com.nyxelis.entity.Widget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WidgetRepository extends JpaRepository<Widget, Long> {
}
