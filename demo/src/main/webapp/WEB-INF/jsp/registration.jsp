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
<form:form id="registerform" modelAttribute="formperson">
<div class="wrapper">
<%@ include file = "../include/header.jsp" %>
<%@ include file = "../include/sidebar.jsp" %>
  <div class="content-wrapper">
    <section class="content-header">
      <h1>
        Add User
      </h1>
    </section>
    
    <!-- Main content -->
    <section class="content container-fluid">
		<div class="box box-default">
        <div class="box-header with-border">
          <h3 class="box-title">Enter Details</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
          </div>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
        
          <div class="row">
             <h3 >${message}</h3>
            <div class="col-md-12">
              <div class="form-group">
                  <label>Name*</label>
                  <form:input path="name" class="form-control" placeholder="Name"/>
                </div>
                <div class="form-group">
                  <label>dob</label>
                  <form:input path="dob" class="form-control" placeholder="Date of birth"/>
                </div>
                <!-- radio -->
                <div class="form-group">
                <label>Gender</label>
                  <div class="radio">
                    <label>
                      <form:radiobutton path="gender" value="M" checked="true"/>
                      Male
                    </label>
                  </div>
                  <div class="radio">
                    <label>
                      <form:radiobutton path="gender" value="F"/>
                      Female
                    </label>
                  </div>
                </div>
				<div class="form-group">
                <label>Language known</label><br/><div>	
                	<form:checkboxes items="${languageList}" path="language" delimiter="<br/>" />
				</div>
				<div class="form-group">
                <label>Skill</label>
                <div class="box">
		            <div class="box-body no-padding">
		              <table id="skilltable" class="table table-striped">
		                <tr>
		                  <th>Skill</th>
		                  <th>Year Exp</th>
		                  <th>Skill lvl</th>
		                  <th>Last used</th>
		                </tr>
		                <c:forEach items="${formperson.skillto}" var="skill" varStatus="status">
		                	<tr> <%-- <td>${skill.skillname}</td> --%>
		                	<td><input type="text" name="skillto[${status.index}].skillname" class="form-control" value="${skill.skillname}" /></td>
		                	<td><input type="text" name="skillto[${status.index}].experience" class="form-control" value="${skill.experience}" /></td>
		                	<td><select name="skillto[${status.index}].level"class="form-control" >
		                		<option value="1" ${skill.level == 1 ? 'selected="selected"' : '' }>One</option> 
		                		<option value="2" ${skill.level == 2 ? 'selected="selected"' : '' }>More than one</option></select> 
		                	</td>
		                	<td><input type="text" name="skillto[${status.index}].lastused" class="form-control" value="${skill.lastused}" /></td></tr>
		                </c:forEach>
		              </table>
		            </div>
		            <!-- /.box-body -->
         		 </div>
         		 <button id="delete" class="btn btn-danger pull-right">Delete</button>
         		 <button id="add" class="btn btn-info pull-right">Add</button>&nbsp &nbsp &nbsp
                </div>
                <div class="form-group">
                <label>Hobbies</label>
                <form:select path="hobbies" class="form-control" multiple="true">
                	<form:options items="${hobbiesList}"/>
                </form:select>
                
                
				<!-- <select multiple="true" class="form-control" name="hobbies">
                    <option value="singing">Singing</option>
                    <option value="dancing">Dancing</option>
                    <option value="painting">Painting</option>
                  </select> -->
                 </div>
                 <div class="form-group">
                <label>Address</label>
                <form:textarea path="address" class="form-control" rows="3" placeholder="Enter ..." />
				</div>
            <!-- /.col -->
          </div>
          <!-- /.row -->
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
                <button id="submit" class="btn btn-primary">Submit</button>
              </div>
      </div>
     </div>
     </div>
    
      <!-- /.box -->
    </section>
  </div>
</div>
</form:form>
<%@ include file = "../include/footer.jsp" %>

</body>
</html>

<script>

$(document).ready(function(){
	
    $('#addpage').addClass('active');
    var count = 0;
	$('#add').click(function(event){
		event.preventDefault();
		$('#skilltable').append('<tr><td><input type="text" name="skillto['+count+'].skillname" class="form-control" /></td><td><input type="text" name="skillto['+count+'].experience" class="form-control" /></td><td><select name="skillto['+count+'].level"class="form-control" > <option value="1">One</option> <option value="2">More than one</option></select> </td><td><input type="text" name="skillto['+count+'].lastused" class="form-control" /></td></tr>');
        count= count +1;
	})
    $('#delete').click(function(event){
    	event.preventDefault();
        $('#skilltable tr:last').remove();
        count= count -1;
    })
    
    $('#submit').click(function(event){
    	$("#registerform").attr("action", "/demo/person/saveperson.htm");
		$("#registerform").submit();
          })
    
})

</script>