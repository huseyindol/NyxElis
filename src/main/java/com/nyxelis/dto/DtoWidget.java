package com.nyxelis.dto;

import com.nyxelis.enums.WidgetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoWidget {
  private Long id;
  private String name;
  private String content;
  private String description;
  private WidgetType type;
  private Boolean isActive;
  private Integer orderIndex;
  private List<DtoWidget> widgets; // Widget içindeki widget'lar
  private List<DtoPost> posts; // Widget içindeki post'lar
}
