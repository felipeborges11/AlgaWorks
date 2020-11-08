package com.felipe.osworks.osworksapi.domain.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    private String description;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private WorkOrderStatus status;

    private LocalDateTime openDate;
    private LocalDateTime finalizationDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public WorkOrderStatus getStatus() {
        return status;
    }

    public void setStatus(WorkOrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDateTime openDate) {
        this.openDate = openDate;
    }

    public LocalDateTime getFinalizationDate() {
        return finalizationDate;
    }

    public void setFinalizationDate(LocalDateTime finalizationDate) {
        this.finalizationDate = finalizationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkOrder workOrder = (WorkOrder) o;
        return id.equals(workOrder.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
