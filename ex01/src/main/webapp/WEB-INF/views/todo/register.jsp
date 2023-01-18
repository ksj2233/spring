<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
         <div class="panel-heading">작성</div>
         <div class="panel-body">
            <!-- <div class="row">
                                <div class="col-lg-6"> -->
            <form action="/todo/register" method="POST">
            	<!-- 제목 -->
               <div class="form-group">
                  <label>날짜</label> <input class="form-control" name="todoDate">
                  <!-- <p class="help-block">Example block-level help text here.</p> -->
               </div>
               
				<!-- 내용 -->
               <div class="form-group">
                  <label>내용</label>
                  <textarea class="form-control" rows="10" name="content"></textarea>
               </div>
               
               <button type="submit" class="btn btn-default">TO DO 등록</button>
               <button type="reset" class="btn btn-default">다시 작성</button>
            </form>
         </div>
      </div>
      <!-- /.panel -->
   </div>
   <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp" %>