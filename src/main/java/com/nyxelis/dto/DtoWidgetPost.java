package com.nyxelis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoWidgetPost {
  private Long widgetId;
  private Long postId;
  private Integer orderIndex;
  private DtoWidget widgets;
  private DtoPost posts;
}
