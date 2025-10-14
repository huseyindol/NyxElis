package com.nyxelis.entity;

import com.nyxelis.entity.id.PageComponentId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
  name = "page_components",
  indexes = {
    @Index(name = "id_page_comp_page_id", columnList = "page_id"),
    @Index(name = "id_page_comp_component_id", columnList = "component_id"),
    @Index(name = "id_page_comp_order", columnList = "orderIndex"),

    // Composite - sıralama sorguları için
    @Index(name = "id_page_comp_page_order", columnList = "page_id, orderIndex")
  }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageComponent extends BaseEntity {

  @EmbeddedId
  private PageComponentId id = new PageComponentId();

  @ManyToOne
  @MapsId("pageId")
  @JoinColumn(name = "page_id")
  private Page page;

  @ManyToOne
  @MapsId("componentId")
  @JoinColumn(name = "component_id")
  private Component component;

  private Integer orderIndex;

}
