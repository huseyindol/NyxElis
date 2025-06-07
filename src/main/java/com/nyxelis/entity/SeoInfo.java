package com.nyxelis.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seo_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeoInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String keywords;

    private String canonicalUrl;

    @OneToOne(mappedBy = "seoInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Page page;
}
