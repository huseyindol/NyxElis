package com.nyxelis.entity;

import com.nyxelis.entity.id.PageComponentId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "page_components")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageComponent extends BaseEntity {

    @EmbeddedId
    private PageComponentId id = new PageComponentId();

    @ManyToOne
    @MapsId("pageId")
    @JoinColumn(name = "page_id")
    private Page page;

    @ManyToOne
    @MapsId("componentId")
    @JoinColumn(name = "component_id")
    private Component component;

    private Integer orderIndex;
}
