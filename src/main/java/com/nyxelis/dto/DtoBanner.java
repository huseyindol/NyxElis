package com.nyxelis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoBanner {
  private Long id;
  private String title;
  private String description;
  private String imageUrl;
  private String link;
  private String altText;
  private Boolean isActive;
  private Integer orderDisplay;
  private Integer orderIndex; // ComponentBanner'dan gelecek
}
