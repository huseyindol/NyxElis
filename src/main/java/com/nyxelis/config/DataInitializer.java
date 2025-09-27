package com.nyxelis.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nyxelis.dto.DtoPage;
import com.nyxelis.dto.DtoSeoInfo;
import com.nyxelis.entity.Page;
import com.nyxelis.entity.SeoInfo;
import com.nyxelis.repository.PageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final PageRepository pageRepository;

    @Override
    public void run(String... args) throws Exception {
        if (pageRepository.count() == 0) {
            log.info("Database is empty, initializing with mock data...");
            loadMockData();
            log.info("Mock data initialization completed.");
        } else {
            log.info("Database already contains data, skipping initialization.");
        }
    }

    private void loadMockData() {
        try {
            List<DtoPage> pageList = loadPageData();

            for (DtoPage dtoPage : pageList) {
                // DTO'dan Entity'e manuel mapping
                Page page = new Page();
                page.setTitle(dtoPage.getTitle());
                page.setSlug(dtoPage.getSlug());
                page.setDescription(dtoPage.getDescription());
                page.setContent(dtoPage.getContent());
                page.setIsActive(dtoPage.getIsActive());

                // SeoInfo mapping
                if (dtoPage.getSeoInfo() != null) {
                    SeoInfo seoInfo = new SeoInfo();
                    DtoSeoInfo dtoSeoInfo = dtoPage.getSeoInfo();
                    seoInfo.setTitle(dtoSeoInfo.getTitle());
                    seoInfo.setDescription(dtoSeoInfo.getDescription());
                    seoInfo.setKeywords(dtoSeoInfo.getKeywords());
                    seoInfo.setCanonicalUrl(dtoSeoInfo.getCanonicalUrl());
                    seoInfo.setNoIndex(dtoSeoInfo.getNoIndex());
                    seoInfo.setNoFollow(dtoSeoInfo.getNoFollow());

                    page.setSeoInfo(seoInfo);
                    seoInfo.setPage(page);
                }

                pageRepository.save(page);
                log.info("Successfully created page: {}", page.getTitle());
            }

            log.info("Successfully loaded {} pages with SEO info", pageList.size());

        } catch (Exception e) {
            log.error("Error loading mock data: ", e);
        }
    }

    private List<DtoPage> loadPageData() throws IOException {
        log.info("Loading page mock data...");

        ClassPathResource resource = new ClassPathResource("mock-data/page.json");
        InputStream inputStream = resource.getInputStream();

        ObjectMapper objectMapper = new ObjectMapper();
        List<DtoPage> pageList = objectMapper.readValue(
                inputStream,
                new TypeReference<List<DtoPage>>() {
                });

        log.info("Loaded {} page records", pageList.size());
        return pageList;
    }
}
