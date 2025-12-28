package com.usage_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usage_service.dto.UsageLogDto;
import com.usage_service.dto.UsageLogRequest;
import com.usage_service.entity.UsageLog;
import com.usage_service.service.UsageService;
// import com.usage_service.service.UsageService123;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usage-logs")
public class UsageController {
	@Autowired
    private UsageService usageService;

    @PostMapping
    public UsageLogDto addUsage(@RequestBody UsageLogRequest req) {
        return usageService.addUsageLog(req);
    }

    @GetMapping("/user/{userId}")
    public List<UsageLogDto> getLogsByUser(@PathVariable Long userId) {
        return usageService.getUsageLogsByUser(userId);
    }

    @GetMapping
    public List<UsageLogDto> getAllLogs() {
        return usageService.getAllUsageLogs();
    }
    @GetMapping("/{id}")
    public UsageLogDto getUsageLogById(@PathVariable Long id) {
        return usageService.getUsageLogById(id);
    }

    
    @PutMapping("/{id}")
    public UsageLogDto updateUsageLog(@PathVariable Long id, @RequestBody UsageLogRequest req) {
        return usageService.updateUsageLog(id, req);
    } 

    // Delete a usage log by its ID
    @DeleteMapping("/{id}")
    public void deleteUsageLog(@PathVariable Long id) {
        usageService.deleteUsageLog(id);
    }
 
}