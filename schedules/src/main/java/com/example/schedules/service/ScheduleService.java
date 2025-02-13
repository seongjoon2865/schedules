package com.example.schedules.service;

import com.example.schedules.entity.Schedule;
import com.example.schedules.repository.ScheduleRepository;
import com.example.schedules.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, UserRepository userRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
    }

    public Schedule createSchedule(String title, String description, LocalDateTime date, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("유저를 찾을 수 없습니다."));
        Schedule schedule = new Schedule();
        schedule.setTitle(title);
        schedule.setDescription(description);
        schedule.setDate(date);
        schedule.setUser(user);
        return scheduleRepository.save(schedule);
    }
}
