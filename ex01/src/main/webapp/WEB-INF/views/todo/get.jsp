<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">TO DO LIST</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">TO DO</div>
			<div class="panel-body">
				<!-- <div class="row">
                                <div class="col-lg-6"> -->
				<!-- 번호 -->
				<div class="form-group">
					<label>번호</label> <input class="form-control" name="no"
						value='<c:out value="${todo.no }"/>' readonly="readonly">
					<!-- <p class="help-block">Example block-level help text here.</p> -->
				</div>

				<!-- 제목 -->
				<div class="form-group">
					<label>날짜</label> <input class="form-control" name="todoDate"
						value='<c:out value="${todo.todoDate }"/>' readonly="readonly">
					<!-- <p class="help-block">Example block-level help text here.</p> -->
				</div>


				<!-- 내용 -->
				<div class="form-group">
					<label>내용</label>
					<textarea class="form-control" rows="10" name="content">${todo.content }
                  </textarea>
				</div>
				
				<!-- 버튼 -->
				<button data-oper='modify' class="btn btn-default">게시글 수정</button>
				<button data-oper='list' class="btn btn-info">게시글 목록</button>


				<!-- input hidden -->
				<form id="operForm" action="/todo/modify" method="GET">
					<input type="hidden" id='no' name='no' value='${todo.no}'>
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
			operForm.attr("action","/todo/modify").submit();
		});
		
		$("button[data-oper='list']").on("click",function(e){
			operForm.find("#no").remove();
			operForm.attr("action","/todo/list");
			operForm.submit();
		})
		
		
		
		
	})


</script>




<%@include file="../includes/footer.jsp"%>
