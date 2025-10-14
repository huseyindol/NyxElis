package com.nyxelis.entity;

import com.nyxelis.entity.id.WidgetPostId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
  name = "widget_posts",
  indexes = {
    @Index(name = "id_widget_post_widget_id", columnList = "widget_id"),
    @Index(name = "id_widget_post_post_id", columnList = "post_id"),
    @Index(name = "id_widget_post_order", columnList = "orderIndex"),

    // Composite - sıralama sorguları için
    @Index(name = "id_widget_post_widget_order", columnList = "widget_id, orderIndex")
  }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WidgetPost extends BaseEntity {
  @EmbeddedId
  private WidgetPostId id = new WidgetPostId();

  @ManyToOne
  @MapsId("widgetId")
  @JoinColumn(name = "widget_id")
  private Widget widget;

  @ManyToOne
  @MapsId("postId")
  @JoinColumn(name = "post_id")
  private Post post;

  private Integer orderIndex;
}
