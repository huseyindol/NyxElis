package com.nyxelis.controller;

import com.nyxelis.dto.DtoPageIU;

public interface IPageController {

    public DtoPageIU pageFindById(Long id);

    public DtoPageIU createPage(DtoPageIU dtoPageIU);

    public DtoPageIU updatePage(Long id, DtoPageIU dtoPageIU);
}
