package com.felipe.osworks.osworksapi.domain.repository;

import com.felipe.osworks.osworksapi.domain.model.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {

}
