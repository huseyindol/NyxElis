package com.nyxelis.service;

import com.nyxelis.dto.DtoPageIU;

public interface IPageService {

    public DtoPageIU pageFindById(Long id);

    public DtoPageIU createPage(DtoPageIU dtoPageIU);

    public DtoPageIU updatePage(Long id, DtoPageIU dtoPageIU);
}
