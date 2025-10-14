package com.nyxelis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoPage {
  private Long id;
  private String title;
  private String description;
  private String content;
  private String slug;
  private Boolean isActive;
  private DtoSeoInfo seoInfo;
  private List<DtoPageComponent> pageComponents; // Page içindeki component'lar
}
