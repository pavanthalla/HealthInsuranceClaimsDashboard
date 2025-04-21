package com.insurance.claimapi.controller;

import com.insurance.claimapi.model.Claim;
import com.insurance.claimapi.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/claims")
@CrossOrigin(origins = "*") // allow frontend to connect
public class ClaimController {

    @Autowired
    private ClaimRepository claimRepository;

    // GET all claims
    @GetMapping
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    // POST a new claim
    @PostMapping
    public Claim createClaim(@RequestBody Claim claim) {
        claim.setCreatedAt(LocalDateTime.now());
        return claimRepository.save(claim);
    }

    // PUT to approve a claim
    @PutMapping("/{id}/approve")
    public Claim approveClaim(@PathVariable Long id) {
        Claim claim = claimRepository.findById(id).orElseThrow();
        claim.setStatus("APPROVED");
        claim.setResolvedAt(LocalDateTime.now());
        return claimRepository.save(claim);
    }

    // PUT to reject a claim
    @PutMapping("/{id}/reject")
    public Claim rejectClaim(@PathVariable Long id) {
        Claim claim = claimRepository.findById(id).orElseThrow();
        claim.setStatus("REJECTED");
        claim.setResolvedAt(LocalDateTime.now());
        return claimRepository.save(claim);
    }
}