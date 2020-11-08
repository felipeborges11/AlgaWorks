package com.felipe.osworks.osworksapi.domain.service;

import com.felipe.osworks.osworksapi.domain.exception.BusinessException;
import com.felipe.osworks.osworksapi.domain.model.Client;
import com.felipe.osworks.osworksapi.domain.model.WorkOrder;
import com.felipe.osworks.osworksapi.domain.model.WorkOrderStatus;
import com.felipe.osworks.osworksapi.domain.repository.ClientRepository;
import com.felipe.osworks.osworksapi.domain.repository.WorkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WorkOrderManagerService {

    @Autowired
    private WorkOrderRepository workOrderRepository;

    @Autowired
    private ClientRepository clientRepository;

    public WorkOrder create(WorkOrder workOrder) {
        Client client = clientRepository.findById(workOrder.getClient().getId())
                .orElseThrow(() -> new BusinessException("Client not found."));

        workOrder.setClient(client);
        workOrder.setStatus(WorkOrderStatus.OPENED);
        workOrder.setOpenDate(LocalDateTime.now());

        return workOrderRepository.save(workOrder);
    }

}
