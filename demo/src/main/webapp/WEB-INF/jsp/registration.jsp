<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
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
            <div class="col-md-12">
              <div class="form-group">
                  <label>Name*</label>
                  <!-- <input type="text" name="name" class="form-control" placeholder="Name"> -->
                  <form:input path="name" class="form-control" placeholder="Name"/>
                </div>
                <div class="form-group">
                  <label>dob</label>
                  <input type="text" name="dob" class="form-control" placeholder="Date of birth" >
                </div>
                <!-- radio -->
                <div class="form-group">
                <label>Gender</label>
                  <div class="radio">
                    <label>
                      <input type="radio" name="gender" id="optionsRadios1" value="M" checked>
                      Male
                    </label>
                  </div>
                  <div class="radio">
                    <label>
                      <input type="radio" name="gender" id="optionsRadios2" value="F">
                      Female
                    </label>
                  </div>
                </div>
				<div class="form-group">
                <label>Language known</label>	
					<div class="checkbox">
	                    <label><input type="checkbox" name ="language" value="english">English</label>
                  	</div>
                  	<div class="checkbox">
	                     <label><input type="checkbox" name ="language" value="hindi">Hindi</label>
                  	</div>
                  	<div class="checkbox">
	                     <label><input type="checkbox" name ="language" value="marathi">Marathi</label>
                  	</div>
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
		              </table>
		            </div>
		            <!-- /.box-body -->
         		 </div>
         		 <button id="delete" class="btn btn-danger pull-right">Delete</button>
         		 <button id="add" class="btn btn-info pull-right">Add</button>&nbsp &nbsp &nbsp
                </div>
                <div class="form-group">
                <label>Hobbies</label>
				<select multiple="true" class="form-control" name="hobbies">
                    <option value="singing">Singing</option>
                    <option value="dancing">Dancing</option>
                    <option value="painting">Painting</option>
                  </select>
                 </div>
                 <div class="form-group">
                <label>Address</label>
                 <textarea name="address" class="form-control" rows="3" placeholder="Enter ..."></textarea>
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
    	$("#registerform").attr("action", "/demo/saveperson.htm");
		$("#registerform").submit();
          })
    
})

</script>