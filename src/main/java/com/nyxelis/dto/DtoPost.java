package com.nyxelis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoPost {
  private Long id;
  private String title;
  private String content;
  private String slug;
  private Boolean isActive;
  private DtoCustomer author; // Assuming you have a DtoCustomer class for the author
  private Integer orderIndex;
}
