package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AttendanceRequest implements Serializable {
    /**
     * ユーザーID
     */
    @NotEmpty(message = "ユーザーIDを入力してください。")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "半角英数字のみ入力してください。")
    @Size(max = 20, message = "ユーザーIDは20文字以内で入力してください。")
    private Long userId;
    /**
     * ステータス
     */
    @NotEmpty(message = "選択してください。")
    private String status;
    /**
     * AttendanceDate出勤日
     */
    @NotEmpty(message = "選択してください。")
    private LocalDate AttendanceDate;
    /**
     * 出勤時間
     */
    @NotEmpty(message = "選択してください。")
    private LocalTime AttendanceTime;
    /**
     * 備考
     */
    private String Remarks;
}
