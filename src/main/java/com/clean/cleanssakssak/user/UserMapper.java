package com.clean.cleanssakssak.user;

import com.clean.cleanssakssak.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int selIdComparison (String uid);// ID 중복 확인용

    int insUserSignup(UserInsSignupDto dto);// 회원가입 정보 INSERT

    String selSigninPw(UserSigninDto dto);// 로그인 성공 유/무를 위한 upw SELECT

    UserSigninVo selSignin(UserSigninDto dto);// 로그인 성공 시 해당 유저의 정보 SELECT

    Integer selUserByNickname(String nickname);
    int updUserUpw(UserUbdDto dto);
    int updUserNickname(UserUbdDto dto);
    int delUser(int loginedUserId);
}
