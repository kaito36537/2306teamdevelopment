package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.Data;

@Data
public class LeavingRequest implements Serializable {
    /**
     * ユーザーID
     */
    @NotNull(message = "ユーザーIDを入力してください。")
    private Long userId;
    /**
     * ステータス
     */
    @NotNull(message = "ステータスを選択して下さい")
    private String status;
    /**
     * 出勤日
     */
    @Past
    @NotNull(message = "出勤日を入力してください")
    private LocalDate leavingDate;
    /**
     * 出勤時間
     */
    @Past
    @NotNull(message = "出勤時間を入力してください")
    private LocalTime leavingTime;
    /**
     * 備考
     */
    private String remarks;
    /**
     * 休憩時間
     */
    @NotNull(message = "休憩時間は必須です")
    private Integer breakTime;
}

