package com.nyxelis.dto;

import com.nyxelis.enums.WidgetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoWidgetIU {
  private String name;
  private String content;
  private String description;
  private WidgetType type;
  private Boolean isActive;
  private Integer orderIndex;
}
