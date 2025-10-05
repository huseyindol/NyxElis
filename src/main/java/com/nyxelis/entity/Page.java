package com.nyxelis.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "pages",
        indexes = {
                @Index(columnList = "slug", name = "id_page_page_slug", unique = true),
                @Index(name = "id_page_active", columnList = "isActive")
        },
        uniqueConstraints = {@UniqueConstraint(columnNames = {"slug"}, name = "uc_page_slug")}
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Page extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String content;
    private String slug;
    private Boolean isActive;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "seo_info_id", referencedColumnName = "id")
    private SeoInfo seoInfo;

    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PageComponent> pageComponents = new ArrayList<>();
}
