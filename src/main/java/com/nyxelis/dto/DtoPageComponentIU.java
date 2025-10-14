package com.nyxelis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoPageComponentIU {
  private Long pageId;
  private Long componentId;
  private Integer orderIndex;
}
