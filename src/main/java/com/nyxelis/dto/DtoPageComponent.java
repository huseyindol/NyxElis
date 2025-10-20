package com.nyxelis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DtoPageComponent {
  private Long pageId;
  private Long componentId;
  private Integer orderIndex;
  private DtoComponent components;
}
