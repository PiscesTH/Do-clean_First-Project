package com.clean.cleanssakssak.diary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "다이어리 페이징 처리")
public class DiarySelDto {
    @Schema(title = "유저")
    private int userId;
    @Schema(title = "페이지")
    private int page;

    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int rowCount = 10;
    @JsonIgnore
    private int diaryId;


    public void setPage(int page) { //페이징처리
        this.startIdx = (page - 1) * rowCount;
    }

}