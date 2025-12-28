package com.usage_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usage_service.dto.UsageLogDto;
import com.usage_service.dto.UsageLogRequest;
import com.usage_service.entity.UsageLog;
import com.usage_service.exception.UsageLogNotFoundException;
import com.usage_service.repository.UsageLogRepository;

@Service
public class UsageService {
	@Autowired
    private UsageLogRepository usageLogRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UsageLogDto addUsageLog(UsageLogRequest req) {
        UsageLog log = new UsageLog(
            req.getUserId(),
            req.getDate(),
            req.getCallDuration(),
            req.getDataUsed(),
            req.getSmsCount()
        );
        log = usageLogRepository.save(log);
        return modelMapper.map(log, UsageLogDto.class);
    }

    public List<UsageLogDto> getUsageLogsByUser(Long userId) {
        List<UsageLog> logs = usageLogRepository.findByUserId(userId);
        return logs.stream().map(l -> modelMapper.map(l, UsageLogDto.class)).collect(Collectors.toList());
    }

    public List<UsageLogDto> getAllUsageLogs() {
        List<UsageLog> logs = usageLogRepository.findAll();
        return logs.stream().map(l -> modelMapper.map(l, UsageLogDto.class)).collect(Collectors.toList());
    } 
    public UsageLogDto getUsageLogById(Long id) {
        UsageLog log = usageLogRepository.findById(id)
                .orElseThrow(() -> new UsageLogNotFoundException("Usage log not found for id: " + id));
        return modelMapper.map(log, UsageLogDto.class);
    }

    /**
     * Update an existing usage log by its ID.
     */
    public UsageLogDto updateUsageLog(Long id, UsageLogRequest req) {
        UsageLog log = usageLogRepository.findById(id)
                .orElseThrow(() -> new UsageLogNotFoundException("Usage log not found for id: " + id));
        log.setUserId(req.getUserId());
        log.setDate(req.getDate());
        log.setCallDuration(req.getCallDuration());
        log.setDataUsed(req.getDataUsed());
        log.setSmsCount(req.getSmsCount());
        UsageLog updated = usageLogRepository.save(log);
        return modelMapper.map(updated, UsageLogDto.class);
    }

     
    public void deleteUsageLog(Long id) {
        if (!usageLogRepository.existsById(id)) {
            throw new UsageLogNotFoundException("Usage log not found for id: " + id);
        }
        usageLogRepository.deleteById(id);
    } 
} 
 

