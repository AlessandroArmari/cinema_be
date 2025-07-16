package com.we.microservizio_base.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreRemove;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
public class AuditClass {

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @UpdateTimestamp
    @Column
    private LocalDateTime lastUpdateAt;

    @Column
    private LocalDateTime deletedAt;

    @Column
    private String createdBy;

    @Column
    private String updatedBy;

    @Column(nullable = false, columnDefinition = "BOOLEAN default true")
    public boolean isActive = true;

    @PreRemove
    public void preRemove() {
        this.deletedAt = LocalDateTime.now();
    }
}
