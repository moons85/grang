<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="story" var="story"/>
<c:set value="notFooter" var="notFooter"/>
<%@ include file="layout/linkHeader.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" />
<link rel="stylesheet" href="/css/story.css" />
<script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
<script defer src="/js/replyForm.js"></script>
<script defer src="/js/reply.js"></script>
<%@ include file="layout/header.jsp"%>

<div class="wrap">
  <div class="swiper-wrapper">
    <c:forEach var="boards" items="${board.content}">
      <div class="swiper-slide">
        <div class="inner">
          <form class="replyform">
            <div class="r_title">
              <span><img src="/image/cat1.jpg" /></span>
              <span>${boards.user.username}</span>
            </div>
            <div class="r_img">
              <div class="img_zone">
                <c:set var="ss" value="${boards.storyImages}"></c:set>
                <%
                  String s = (String)pageContext.getAttribute("ss");
                  String[] arrStr = s.split("/");
                  for(String str : arrStr) {
                    out.print("<img src='/upload/"+ str + "'>");
                  }
                %>
              </div>
              <div class="r_img__heart">
                <i class="fa-regular fa-heart" style="padding-top:5px;"></i>
                <span>${boards.count}</span>
              </div>
            </div>

            <div class="r_info">
              <label class="r_info_label">
                <div style = "width : 400px; margin :auto; margin-top : -15px; margin-left :-5px; overflow : auto; height : 60px;">
                  <h3 style = "margin-bottom : 5px; font-weight:bolder;">${boards.title}</h3>
                  <p style = "display:initial; font-size : 14px;">${boards.content}</p>
                </div>
              </label>
              <div class="r_reply" style="overflow: auto; height: 250px; margin-bottom : -40px;">
                <c:forEach var="reply" items="${replys}">
                  <c:if test="${reply.board.id==boards.id}">
								<span>
								<input type="hidden" value="${reply.id}"/>
									<span id="reply_id" style="display: none">${reply.id}</span>
									<div id = reply_content>
											<img src="${reply.user.profileImage}" id = reply_user_img>
											<p class = "reply_username">${reply.user.username}</p>
											<p>${reply.content}</p><br>
									</div>
									<c:if test="${reply.user.id==principal.user.id}">
										<span class="reply_control">
											<button class="reply_edit" style="font-size: 12px">수정</button>
											<button class="reply_cancle" style="font-size: 12px; display: none">취소</button>
											<button class="reply_delete" style="font-size: 12px">삭제</button>
											<span id="reply_edit_span">
												<input type="text" placeholder="수정 내용을 입력하세요." class="edit_reply"
                                                       style = "width: 350px; height: 30px; padding : 0px; padding-left : 10px; border-radius : 7px;
												border: 1px solid; margin-right: 2px; margin-top: 5px; margin-left: 10px; margin-bottom : 10px;">
												<button type="submit" class="reply_edit_button" style = "background-color : #3ded97; color : #fff;
												 width : 35px; height : 25px; border-radius : 3px; margin-top : 10px;">게시</button>
											</span>
										</span>
                                      <br>
                                    </c:if> <c:if test="${reply.user.id!=principal.user.id}">
                                  <span class="reply_control" style="float:initial;"></span>
                                </c:if>
								</span>
                  </c:if>
                </c:forEach>
              </div>
              <input type="hidden" value="${boards.id}">
              <input type="hidden" value="${principal.user.id }">
              <input type="text" placeholder="댓글 추가" class="add_reply" style = "width : 320px; height : 30px; border : 1px solid;
						padding : 1px; padding-left : 10px; border-radius : 10px; padding-right : 10px;" autofocus>
              <button type="submit" class="r_btn-save" onclick="save()">게시</button>
            </div>
          </form>
        </div>
      </div>
    </c:forEach>
  </div>

  <div class="swiper-button-next"></div>
  <div class="swiper-button-prev"></div>
</div>
<%@ include file="layout/footer.jsp"%>
