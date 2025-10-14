package com.nyxelis.entity;

import com.nyxelis.entity.id.WidgetBannerId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
  name = "widget_banner",
  indexes = {
    @Index(name = "id_widget_banner_widget_id", columnList = "widget_id"),
    @Index(name = "id_widget_banner_banner_id", columnList = "banner_id"),
    @Index(name = "id_widget_banner_order", columnList = "orderIndex"),

    // Composite - sıralama sorguları için
    @Index(name = "id_widget_banner_widget_order", columnList = "widget_id, orderIndex")
  }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WidgetBanner extends BaseEntity {
  @EmbeddedId
  private WidgetBannerId id = new WidgetBannerId();

  @ManyToOne
  @MapsId("widgetId")
  @JoinColumn(name = "widget_id")
  private Widget widget;

  @ManyToOne
  @MapsId("bannerId")
  @JoinColumn(name = "banner_id")
  private Banner banner;

  private Integer orderIndex;
}
