package com.example.schedules.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    @NotBlank(message = "제목은 필수 입력 항목입니다.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String description;

    @NotNull(message = "날짜는 필수 입력 항목입니다.")
    private String date;

    @NotNull(message = "사용자 ID는 필수입니다.")
    private Long userId;
}