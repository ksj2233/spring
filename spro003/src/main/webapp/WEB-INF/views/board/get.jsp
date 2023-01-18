<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시판</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">게시글 조회</div>
			<div class="panel-body">
				<!-- <div class="row">
                                <div class="col-lg-6"> -->
				<!-- 번호 -->
				<div class="form-group">
					<label>번호</label> <input class="form-control" name="bno"
						value='<c:out value="${board.bno }"/>' readonly="readonly">
					<!-- <p class="help-block">Example block-level help text here.</p> -->
				</div>

				<!-- 제목 -->
				<div class="form-group">
					<label>제목</label> <input class="form-control" name="title"
						value='<c:out value="${board.title }"/>' readonly="readonly">
					<!-- <p class="help-block">Example block-level help text here.</p> -->
				</div>


				<!-- 내용 -->
				<div class="form-group">
					<label>내용</label>
					<textarea class="form-control" rows="10" name="content">${board.content }
                  </textarea>
				</div>

				<!-- 작성자 -->
				<div class="form-group">
					<label>작성자</label> <input class="form-control" name="writer"
						value=${board.writer } readonly>
					<!-- <p class="help-block">Example block-level help text here.</p> -->
				</div>
				
				<!-- 버튼 -->
				<button data-oper='modify' class="btn btn-default">게시글 수정</button>
				<button data-oper='list' class="btn btn-info">게시글 목록</button>


				<!-- input hidden -->
				<form id="operForm" action="/board/modify" method="GET">
					<input type="hidden" id='bno' name='bno' value='${board.bno}'>
					<input type="hidden" id="pageNum" name="pageNum"
						value="${cri.pageNum}"> <input type="hidden" id="amount"
						name="amount" value="${cri.amount}">
					<input type="hidden" id="type" name="type" value="${cri.type }">
					<input type="hidden" id="keyword" name="keyword" value="${cri.keyword }">
				</form>
				<!-- /input hidden -->

			</div>
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script>
	$(document).ready(function(){
	
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action","/board/modify").submit();
		});
		
		$("button[data-oper='list']").on("click",function(e){
			operForm.find("#bno").remove();
			operForm.attr("action","/board/list");
			operForm.submit();
		})
		
		
		
		
	})


</script>




<%@include file="../includes/footer.jsp"%>
