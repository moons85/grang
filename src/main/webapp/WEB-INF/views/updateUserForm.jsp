<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="layout/linkHeader.jsp"%>
<link rel="stylesheet" href="/css/updateUserForm.css" />
<%@ include file="layout/header.jsp"%><div class="wrap">
    <div class="signupbox">
        <div class="box1"><img src = /image/logo_2.png></div>
        <h2 class="u_title">회원 정보 수정</h2>
        <div class="box2">
            <ul>
                <li>
                    <input type="text" class="id sign_input" value="사용자 ID" style="padding-left: 10px" readonly />
                </li>
            </ul>
        </div>
        <div class="box3">
            <ul>
                <li>
                    <input type="text" placeholder="이름" class="name sign_input" style="padding-left: 10px" />
                </li>
            </ul>
        </div>
        <div class="box4">
            <ul>
                <li>
                    <input type="password" placeholder="비밀번호" class="password sign_input" style="padding-left: 10px" />
                </li>
            </ul>
        </div>
        <div class="box5">
            <ul>
                <li>
                    <input
                            type="password"
                            placeholder="비밀번호 확인"
                            class="password sign_input"
                            style="padding-left: 10px"
                    />
                </li>
            </ul>
        </div>
        <div class="box6">
            <ul>
                <li>
                    <button class="ordinarysignup unactivatedsignupColor">수정하기</button>
                </li>
            </ul>
        </div>
    </div>
    <script src="/js/signup.js"></script>
</div>

<%@ include file="layout/footer.jsp"%>
