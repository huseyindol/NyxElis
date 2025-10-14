package com.nyxelis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoSeoInfo {
  private String title;
  private String description;
  private String keywords;
  private String canonicalUrl;
  private String noIndex;
  private String noFollow;
}
