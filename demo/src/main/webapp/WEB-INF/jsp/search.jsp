<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Assignment</title>
  <%@ include file = "../include/css.jsp" %>

</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
<%@ include file = "../include/header.jsp" %>
<%@ include file = "../include/sidebar.jsp" %>

  <div class="content-wrapper">
    <section class="content-header">
      <h1>
        Search user
      </h1>
    </section>
    
   <!-- Main content -->
    <section class="content">
      <div class="callout callout-info">
        <p>${message}</p>
      </div>
      <!-- Default box -->
      <form id="searchform">
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Title</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button"  class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <input type="hidden" id="pid" name="personid"/>
        <div class="box-body">
        <div class="form-group">
        		<div class="col-sm-10">
                  <input type="text" name="searchvalue" class="form-control" placeholder="Search ..."/>
                 </div>
                 <div class="col-sm-2">
                  <button type="button" id="searchbtn" class="btn btn-success">Search</button>
                  </div>
         </div>
         <br/> <br/>
         <div class="form-group">
         <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>Name</th>
                  <th>Gender</th>
                  <th>Address</th>
                  <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${personlist}" var="personlist">
                <tr>
                  <td>${personlist.name}</td>
                  <td>${personlist.gender}</td>
                  <td>${personlist.address}</td>
                  <td><i class="fa fa-fw fa-pencil" title="Edit" onclick="editperson(${personlist.personid})" ></i>
                  <i class="fa fa-fw fa-trash" title="Delete" onclick="deleteperson(${personlist.personid})"></i></td>
                </tr>
                </c:forEach>
              </table>
          </div>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          Footer
        </div>
        <!-- /.box-footer-->
      </div>
      </form>
      <!-- /.box -->

    </section>
  </div>
</div>

<%@ include file = "../include/footer.jsp" %>

</body>
</html>
<!-- DataTables -->

<script>
$(document).ready(function(){
    $('#searchpage').addClass('active');
    $('#example1').DataTable()
    $('#searchbtn').click(function(){
    	$("#searchform").attr("action","/demo/person/getpersonlist.htm");
    	$("#searchform").submit();
    })
   
})

function editperson(id){
	alert('edit: '+id);
	$('#pid').val(id);
	$("#searchform").attr("action","/demo/person/editperson.htm");
	$("#searchform").submit();
}

function deleteperson(id){
	alert('delete: '+id);
	$('#pid').val(id);
	$("#searchform").attr("action","/demo/person/deleteperson.htm");
	$("#searchform").submit();
}

</script>