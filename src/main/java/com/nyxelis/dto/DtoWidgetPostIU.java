package com.nyxelis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoWidgetPostIU {
  private Long widgetId;
  private Long postId;
  private Integer orderIndex;
}
