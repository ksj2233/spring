<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@include file="../includes/header.jsp"%>
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
			<div class="panel-heading">
				게시판
				<button id="regBtn" type="button" class="btn btn_xs pull-right">게시글
					등록</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>내용</th>
							<th>작성자</th>
							<th>등록</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="board">
							<tr>
								<td><c:out value="${board.bno}" /></td>
								<td><a class="move" href="${board.bno }"><c:out
											value="${board.title}" /></a></td>
								<td><c:out value="${board.writer}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.regdate}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.updatedate}" /></td>
							</tr>
						</c:forEach>
						<!-- <tr class="odd gradeX">
							<td>Trident</td>
							<td>Internet Explorer 4.0</td>
							<td>Win 95+</td>
							<td class="center">4</td>
							<td class="center">X</td>
						</tr>
						<tr class="even gradeC">
							<td>Trident</td>
							<td>Internet Explorer 5.0</td>
							<td>Win 95+</td>
							<td class="center">5</td>
							<td class="center">C</td>
						</tr>
						<tr class="odd gradeA">
							<td>Trident</td>
							<td>Internet Explorer 5.5</td>
							<td>Win 95+</td>
							<td class="center">5.5</td>
							<td class="center">A</td>
						</tr>
						<tr class="even gradeA">
							<td>Trident</td>
							<td>Internet Explorer 6</td>
							<td>Win 98+</td>
							<td class="center">6</td>
							<td class="center">A</td>
						</tr> -->
					</tbody>
				</table>
				<!-- /.table-responsive -->
				
				
				<!-- search박스 -->
				<div class="row">
					<div class="col-lg-12">
						<form id="searchForm" action="/board/list" method="GET">
							<select name="type">
								<option value="" <c:out value="${pageMaker.cri.type==null?'selected':''}"/>>--</option>
								<option value="T" 
									<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
								<option value="C"
									<c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
								<option value="W"
									<c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자</option>
								<option value="TC"
									<c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목 or 내용</option>
								<option value="TW"
									<c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>제목 or 작성자</option>
								<option value="TCW"
									<c:out value="${pageMaker.cri.type eq 'TCW'?'selected':''}"/>>제목 or 내용 or 작성자</option>
							</select>
							<input type="text" name="keyword" value="${pageMaker.cri.keyword }">
							<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
							<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
							<button class="btn btn-default">검색</button>
						</form>
					</div>
				
				</div>


				<!-- 페이지 버튼 -->
				<div class="pull-right">
					<ul class="pagination">
					
						<c:if test="${pageMaker.prev}">
						<li class="paginate_button">
							<a href="${pageMaker.firstPage }">처음</a>
						<li class="paginate_button previous">
							<a href="${pageMaker.startPage -1 }"><span aria-hidden="true">&laquo;</span></a>
						</li>
						</c:if>
						
						<c:forEach var="num" begin="${pageMaker.startPage }"
										end="${pageMaker.endPage }">
						<li class='paginate_button ${pageMaker.cri.pageNum == num ? "active":"" }'><a href="${num }">${num }</a></li>
						</c:forEach>
						
						<c:if test="${pageMaker.next }">
						<li class="paginate_button next">
							<a href="${pageMaker.endPage +1 }"><span aria-hidden="true">&raquo;</span></a>
						<li class="paginate_button next">
							<a href="${pageMaker.lastPage }">끝</a>
						
						</li>
						</c:if>
					</ul>
				</div>
				<!-- /페이지 버튼 -->
				
				<!-- input hidden -->
				<form id="actionForm" action="/board/list" method="GET">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
					<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
					<input type="hidden" name="type" value="${pageMaker.cri.type }">
					<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
				</form>
				<!-- /input hidden -->

				<!-- Modal 추가 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Modal title</h4>
							</div>
							<div class="modal-body">처리가 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<!-- <button type="button" class="btn btn-primary">Save changes</button> -->
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>

<script type="text/javascript">
	$(document).ready(
			function() {
				var result = '<c:out value="${result}"/>';

				checkModal(result);

				history.replaceState({}, null, null);

				function checkModal(result) {

					if (result == '' || history.state) {
						/*  if(result==''){  */
						return;
					}
					if (parseInt(result) > 0) {
						$(".modal.body").html(
								"게시글 " + parseInt(result) + " 번 글이 등록되었습니다.");

					}
					$("#myModal").modal("show");
				}

				$("#regBtn").on("click", function() {
					self.location = "/board/register";
				});
				
				/* 페이지버튼 */
				var actionForm = $("#actionForm");
				$(".paginate_button a").on("click", function(e){
					
					e.preventDefault();
					console.log('*****click*****');
					actionForm.find("input[name='pageNum']").val($(this).attr("href"));
					actionForm.submit();
					})
				/* end 페이지버튼 */
			 	$(".move").on("click", function(e){
					e.preventDefault();
					actionForm.append("<input type='hidden' name='bno' value='"+
							$(this).attr("href")+"'>");
					actionForm.attr("action","/board/get");
					actionForm.submit();
				})
				
				/* Search */
				var searchForm = $("#searchForm");
				$("#searchForm button").on("click",function(e){
					if(!searchForm.find("option:selected").val()){
						alert("검색종류를 선택하세요.");
						return false;
					}
					if(!searchForm.find("input[name='keyword']").val()){
						alert("키워드를 입력하세요.");	
						return false;
						}
					searchForm.find("input[name='pageNum']").val("1");
					e.preventDefault();
					
					searchForm.submit();
					
				})
			})
</script>
<%@include file="../includes/footer.jsp"%>