package com.clean.cleanssakssak.diary;

import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.diary.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService service;

    //------------------------------- 다이어리 작성 -------------------------------
    @Operation(summary = "다이어리 작성",description = "다이어리 작성")
    @Parameters(value = {
            @Parameter(name = "contents", description = "내용")
            ,@Parameter(name = "title", description = "제목")
            ,@Parameter(name = "user_id", description = "유저")
            ,@Parameter(name = "pic", description = "사진")
    })
    @ApiResponses(value = {
            @ApiResponse(description = "작성 완료 : diary pk(값), 작성 실패 :result(0)")
    })
    @PostMapping()
    public ResVo PostDiary (@RequestBody DiaryInsDto dto) {
        return service.DiaryIns(dto);
    }

    //------------------------------- 다이어리 삭제 -------------------------------
    @Operation(summary = "다이어리 삭제",description = "다이어리 삭제")
    @Parameters(value = {
            @Parameter(name = "user_id", description = "유저")
            ,@Parameter(name = "diary_id", description = "다이어리 번호")
    })
    @ApiResponses(value = {
            @ApiResponse(description = "삭제 완료 :result(1), 삭제 실패 :result(0)")
    })
    @DeleteMapping
    public ResVo DelDiary (@RequestBody DiaryDelDto dto) {
        return service.DiaryDel(dto);
    }

    //------------------------------- 다이어리 수정 -------------------------------
    @Operation(summary = "다이어리 수정",description = "다이어리 수정")
    @Parameters(value = {
            @Parameter(name = "contents", description = "내용")
            ,@Parameter(name = "title", description = "제목")
            ,@Parameter(name = "user_id", description = "유저")
            ,@Parameter(name = "diary_id", description = "다이어리 번호")
    })
    @ApiResponses(value = {
            @ApiResponse(description = "수정 완료 :result(1), 수정 실패 :result(0)")
    })
    @PatchMapping
    public ResVo PatchDiary (DiaryUptDto dto) {
        return service.DiaryUpt(dto);
    }

    //------------------------------- 다이어리 페이징 처리 -------------------------------
    @Operation(summary = "다이어리 페이징",description = "다이어리 페이징")
    @Parameters(value = {
            @Parameter(name = "userid", description = "유저")
            ,@Parameter(name = "page", description = "페이지")
    })
    @ApiResponses(value = {
            @ApiResponse(description = "조회 완료 :result(1), 조회 실패 :result(0)")
    })
    @GetMapping
    public List<DiarySelVo> TestGetDiary(DiarySelDto dto) {
        return service.DiaryGetVo(dto);
    }

}

