package com.nyxelis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts", indexes = {
    @Index(columnList = "slug", name = "idx_post_slug", unique = true),
    @Index(name = "id_posts_active", columnList = "isActive")
}, uniqueConstraints = { @UniqueConstraint(columnNames = { "slug" }, name = "uc_post_slug") })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String content;
  private String slug;
  private Boolean isActive;
  private Integer orderIndex;
  @ManyToOne
  private Customer author;
}
