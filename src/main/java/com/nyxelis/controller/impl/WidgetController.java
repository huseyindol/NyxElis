package com.nyxelis.controller.impl;

import com.nyxelis.controller.IWidgetController;
import com.nyxelis.dto.DtoWidget;
import com.nyxelis.dto.DtoWidgetIU;
import com.nyxelis.entity.RootEntityResponse;
import com.nyxelis.service.IWidgetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/widget")
@Tag(name = "Widget Services")
public class WidgetController extends BaseController implements IWidgetController {
  @Autowired
  private IWidgetService widgetService;

  @GetMapping("/{id}")
  public RootEntityResponse<DtoWidget> getWidgetById(@PathVariable(value = "id") Long id) {
    return ok(widgetService.getWidgetById(id));
  }

  @PostMapping("/create")
  public RootEntityResponse<DtoWidgetIU> createWidget(@RequestBody DtoWidgetIU widgetData) {
    return ok(widgetService.createWidget(widgetData));
  }

  @PutMapping("/{id}")
  public RootEntityResponse<DtoWidgetIU> updateWidget(@PathVariable(value = "id") Long id, @RequestBody DtoWidgetIU widgetData) {
    return ok(widgetService.updateWidget(id, widgetData));
  }

  @DeleteMapping("/{id}")
  public void deleteWidget(@PathVariable(value = "id") Long id) {
    widgetService.deleteWidget(id);
  }
}
