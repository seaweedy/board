<%@page import="kr.or.ddit.member.model.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('#writeBtn').on('click',function(){
			document.location = "/insertPost?boardname=${boardname }&userid=${S_MEMBER.userid}";
		});
			
		$('#postList #post').on('click',function(){
			var post_seq = $(this).data('post_seq');
			console.log(post_seq);
			document.location="/selectPost?post_seq="+post_seq+"&userid=${S_MEMBER.userid}";
		})
	});
</script>
<style>
	#writeBtn{
		float:right;
	}
</style>
<title>Jsp</title>
<%@ include file="/layout/commonLib.jsp" %>
</head>

<body>
<c:set var="blank" value =" " scope="page"/>
<%@ include file="/layout/header.jsp" %>	
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
			<%@ include file="/layout/left.jsp" %>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h2>${boardname }</h2>
				<div class="row">
					<div class="col-sm-8 blog-main">
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>게시글 번호</th>
									<th>제목</th>
									<th>작성자아이디</th>
									<th>작성일시</th>
								</tr>
								<c:choose>
									<c:when test="${postList.size() == 0}">
										<tr>
											<td>작성글이</td>
											<td>없습니다.</td>
											<td>첫글을</td>
											<td>작성하시겠어요?</td>
										</tr>
									</c:when>
									<c:when test="${postList.size() != 0}">
										<tbody id="postList">
											<c:forEach items="${postList }" var="post">
												<c:choose>
													<c:when test="${post.post_status == 1 }">
														<tr id="post" data-post_seq="${post.post_seq }">
															<td>${post.post_seq }</td>
<%-- 															<td>${post.post_title }</td> --%>
															<td>${fn:replace(post.post_title, blank, "&nbsp") }</td>
															<td>${post.userid }</td>
															<td><fmt:formatDate value="${post.post_date }"
																	pattern="YYYY-MM-dd" /></td>
														</tr>
													</c:when>
													<c:when test="${post.post_status == 2 }">
														<tr data-post_seq="${post.post_seq }">
															<td>${post.post_seq }</td>
															<td colspan="2" style="text-align: center">삭제된 글입니다.</td>
															<td></td>
														</tr>
													</c:when>
												</c:choose>
											</c:forEach>
										</tbody>
									</c:when>
								</c:choose>
							</table>
							<input type="button" id="writeBtn" value="글작성"
								class="btn btn-default">
							<div class="text-center">
								<ul class="pagination">
									<c:choose>
										<c:when test="${page == 1 }">
											<li class="active"><span>&lt;&lt;</span></li>
										</c:when>
										<c:when test="${page != 1 }">
											<li><a href="${cp }/selectAllPost?page=1&boardname=${boardname}">&lt;&lt;</a></li>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${page == 1 }">
											<li class="active"><span>&lt;</span></li>
										</c:when>
										<c:when test="${page != 1 }">
											<li><a href="${cp }/selectAllPost?page=${page-1 }&boardname=${boardname}">&lt;</a></li>
										</c:when>
									</c:choose>
									<c:forEach var="i" begin="1" end="${pages}">
										<c:choose>
											<c:when test="${i == page}">
												<li class="active"><span>${i }</span></li>
											</c:when>
											<c:otherwise>
												<li><a
													href="${cp }/selectAllPost?page=${i}&boardname=${boardname}">${i}</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<c:choose>
										<c:when test="${page == pages }">
											<li class="active"><span>&gt;</span></li>
										</c:when>
										<c:when test="${page != pages }">
											<li><a href="${cp }/selectAllPost?page=${page+1 }&boardname=${boardname}">&gt;</a></li>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${page == pages }">
											<li class="active"><span>&gt;&gt;</span></li>
										</c:when>
										<c:when test="${page != pages }">
											<li><a href="${cp }/selectAllPost?page=${pages }&boardname=${boardname}">&gt;&gt;</a></li>
										</c:when>
									</c:choose>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
	</div>
</div>
</body>
</html>
