package com.nyxelis.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WidgetPostId implements Serializable {
  @Column(name = "widget_id")
  private Long widgetId;

  @Column(name = "post_id")
  private Long postId;
}

