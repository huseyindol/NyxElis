package com.nyxelis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyxelis.entity.ComponentBanner;
import com.nyxelis.entity.id.ComponentBannerId;

public interface ComponentBannerRepository extends JpaRepository<ComponentBanner, ComponentBannerId> {

}
