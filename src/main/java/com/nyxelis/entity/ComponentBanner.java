package com.nyxelis.entity;

import com.nyxelis.entity.id.ComponentBannerId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "component_banners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComponentBanner extends BaseEntity {

    @EmbeddedId
    private ComponentBannerId id = new ComponentBannerId();

    @ManyToOne
    @MapsId("componentId")
    @JoinColumn(name = "component_id")
    private Component component;

    @ManyToOne
    @MapsId("bannerId")
    @JoinColumn(name = "banner_id")
    private Banner banner;

    private Integer orderIndex;
}
