package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    private Long attendanceId;
    /**
     * ステータス
     */
    @NotEmpty(message = "ステータスを選択して下さい")
    private String status;
    /**
     * AttendanceDate出勤日
     */
    @NotNull(message = "出勤日を入力してください")
    private LocalDate attendanceDate;
    /**
     * 出勤時間
     */
    @NotNull(message = "出勤時間を入力してください")
    private LocalTime attendanceTime;
    /**
     * 備考
     */
    private String Remarks;
}
