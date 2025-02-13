package com.example.schedules.controller;

import com.example.schedules.dto.ScheduleRequestDto;
import com.example.schedules.dto.ScheduleResponseDto;
import com.example.schedules.entity.Schedule;
import com.example.schedules.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;  // Import 추가!

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody @Valid ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleService.createSchedule(
                requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getDate(),
                requestDto.getUserId()
        );

        ScheduleResponseDto responseDto = new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getDescription(),
                schedule.getDate(),
                schedule.getCreatedAt(),
                schedule.getUser().getUsername()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
