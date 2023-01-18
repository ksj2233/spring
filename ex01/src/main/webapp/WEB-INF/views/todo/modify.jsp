<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
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
			<div class="panel-heading">수정</div>
			<div class="panel-body">
				<!-- <div class="row">
                                <div class="col-lg-6"> -->

				<!-- input hidden -->
				<form action="/todo/modify" method="POST">

					<input type="hidden" name="pageNum" value="${cri.pageNum }">
					<input type="hidden" name="amount" value="${cri.amount }">
					<input type="hidden" name="type" value="${cri.type }">
					<input type="hidden" name="keyword" value="${cri.keyword }">
				<!-- input hidden -->

					<!-- 번호 -->
					<div class="form-group">
						<label>번호</label> <input class="form-control" name="no"
							value='<c:out value="${todo.no }"/>' readonly="readonly">
						<!-- <p class="help-block">Example block-level help text here.</p> -->
					</div>

					<!-- 제목 -->
					<div class="form-group">
						<label>날짜</label> <input class="form-control" name="todoDate"
							value='<c:out value="${todo.todoDate }"/>'>
						<!-- <p class="help-block">Example block-level help text here.</p> -->
					</div>


					<!-- 내용 -->
					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="10" name="content">${todo.content }
                  </textarea>
					</div>

					<div class="form-group">
						<label>등록일자</label> <input class="form-control" name="regdate"
							value='<fmt:formatDate pattern="yyyy/MM/dd"
               																value="${todo.regDate }"/>'
							readonly>
					</div>

					<div class="form-group">
						<label>수정일자</label> <input class="form-control" name="updatedate"
							value='<fmt:formatDate pattern="yyyy/MM/dd"
               																value="${todo.updateDate }"/>'
							readonly>
					</div>

					<button type="submit" data-oper='modify' class="btn btn-default">
						TODO 수정</button>

					<button type="submit" data-oper='remove' class="btn btn-danger">
						TODO 삭제</button>

					<button type="submit" data-oper='list' class="btn btn-info">
						TODO 목록</button>
				</form>
			</div>
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form");

		$('button').on("click", function(e) {
			e.preventDefault();

			var operation = $(this).data("oper");

			console.log(operation);

			if (operation === 'remove') {
				formObj.attr("action", "/todo/remove").attr("method", "POST");
			} else if (operation === 'modify') {
				formObj.attr("action", "/todo/modify").attr("method", "POST");
			} else if (operation === 'list') {
				formObj.attr("action","/todo/list").attr("method","GET");
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var typeTag = $("input[name='type']").clone();
				var keywordTag = $("input[name='keyword']").clone();
				
				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(typeTag);
				formObj.append(keywordTag);
			}
				formObj.submit();				
			
		})

	})
</script>

<%@include file="../includes/footer.jsp"%>
