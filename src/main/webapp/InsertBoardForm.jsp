<%@page import="kr.or.ddit.member.model.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('#editBtn').on('click',function(){
			console.log('생성버튼 클릭');
		});
	});
</script>
<style>
	label{
		width:178px;
		height:26px;
		text-align:center;
	}
</style>
<title>Jsp</title>
<%@ include file="/layout/commonLib.jsp" %>
</head>

<body>
<%@ include file="/layout/header.jsp" %>	
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
			<%@ include file="/layout/left.jsp" %>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h2>게시판 생성</h2>
			<div class="row">
				<div class="col-sm-8 blog-main">
					<div class="table-responsive">
						<hr>
						<form action="${cp }/insertBoard" method="post">
							<label>게시판 이름 :</label>
							<input type="text" name="boardname">
							<select name="use">
    							<option value="1">활성화</option>
								<option value="2">비활성화</option>
							</select>
							<input type="submit" id="createBtn" value="생성" class="btn btn-default">
						</form>
						<hr>
						<table class="table table-striped">
							<tr>
								<th>게시판이름</th>
								<th>활성화상태</th>
								<th>수정</th>
							</tr>
							<c:forEach items="${boardList}" var="board">
								<tbody id="boardList">
									<tr data-board_name="${board.board_name }">
										<td>${board.board_name }</td>
										<td>
											<select name="use">
											<c:choose>
												<c:when test="${board.board_status == 1 }">
							     					<option value="2">비활성화</option>
												</c:when>	 
												<c:when test="${board.board_status == 2 }">
							     					<option value="1">활성화</option>
												</c:when>	 
											</c:choose>
											</select>
										</td>
										<td>
											<c:choose>
												<c:when test="${board.board_status == 1 }">
													<a href="${cp }/updateBoard?boardstatus=2&boardname=${board.board_name}" class="btn btn-default">수정</a><br>
												</c:when>
												<c:when test="${board.board_status == 2 }">
													<a href="${cp }/updateBoard?boardstatus=1&boardname=${board.board_name}" class="btn btn-default">수정</a><br>
												</c:when>
											</c:choose>
										</td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
					</div>
					
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
											href="${pageContext.request.contextPath }/insertBoard?page=${i}">${i}</a></li>
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
</body>
</html>
