package com.nyxelis.repository;

import com.nyxelis.entity.ComponentBanner;
import com.nyxelis.entity.id.ComponentBannerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentBannerRepository extends JpaRepository<ComponentBanner, ComponentBannerId> {

}
