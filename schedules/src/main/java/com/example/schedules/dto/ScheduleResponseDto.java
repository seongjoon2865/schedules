package com.example.schedules.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime date;
    private LocalDateTime createdAt;
    private String username;
}
