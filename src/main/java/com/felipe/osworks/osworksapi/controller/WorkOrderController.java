package com.felipe.osworks.osworksapi.controller;

import com.felipe.osworks.osworksapi.domain.model.WorkOrder;
import com.felipe.osworks.osworksapi.domain.service.WorkOrderManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/work-order")
public class WorkOrderController {

    @Autowired
    private WorkOrderManagerService workOrderManagerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkOrder create(@RequestBody WorkOrder workOrder) {
        return workOrderManagerService.create(workOrder);
    }
}
