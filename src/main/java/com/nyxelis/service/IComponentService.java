package com.nyxelis.service;

import java.util.List;

import com.nyxelis.dto.DtoComponentIU;
import com.nyxelis.enums.ComponentType;

public interface IComponentService {

    public DtoComponentIU createComponent(DtoComponentIU dtoComponentIU);

    public DtoComponentIU updateComponent(Long id, DtoComponentIU dtoComponentIU);

    public void deleteComponent(Long id);

    public DtoComponentIU getComponentById(Long id);

    public List<DtoComponentIU> getComponentsByComponentType(ComponentType componentType);

    // public List<DtoComponentIU> getComponentsByPageId(Long pageId);

}
