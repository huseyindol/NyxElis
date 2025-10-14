package com.nyxelis.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComponentBannerId implements Serializable {

  @Column(name = "component_id")
  private Long componentId;

  @Column(name = "banner_id")
  private Long bannerId;
}

