package com.nyxelis.controller.impl;

import com.nyxelis.controller.ICustomerController;
import com.nyxelis.dto.DtoCustomer;
import com.nyxelis.service.ICustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@Tag(name = "Customer Services")
public class CustomerController implements ICustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/{id}")
    @Override
    public DtoCustomer findById(@PathVariable(value = "id") Long id) {
        return customerService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void removeById(@PathVariable(value = "id") Long id) {
        customerService.removeById(id);
    }
}
