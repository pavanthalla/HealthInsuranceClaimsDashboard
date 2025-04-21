package com.insurance.claimapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyId;
    private String status;
    private String hospital;

    private BigDecimal amount;

    private LocalDateTime createdAt;
    private LocalDateTime resolvedAt;

    // === Constructors ===
    public Claim() {}

    public Claim(String policyId, String status, String hospital, BigDecimal amount) {
        this.policyId = policyId;
        this.status = status;
        this.hospital = hospital;
        this.amount = amount;
        this.createdAt = LocalDateTime.now();
    }

    // === Getters & Setters ===

    public Long getId() { return id; }

    public String getPolicyId() { return policyId; }
    public void setPolicyId(String policyId) { this.policyId = policyId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getHospital() { return hospital; }
    public void setHospital(String hospital) { this.hospital = hospital; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getResolvedAt() { return resolvedAt; }
    public void setResolvedAt(LocalDateTime resolvedAt) { this.resolvedAt = resolvedAt; }
}