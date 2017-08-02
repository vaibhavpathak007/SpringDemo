<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        Add User
      </h1>
    </section>
    
    <!-- Main content -->
    <section class="content container-fluid">
		<div class="box box-default">
        <div class="box-header with-border">
          <h3 class="box-title">Select2</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
          </div>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
          <div class="row">
            <div class="col-md-12">
              <div class="form-group">
                  <label>Name</label>
                  <input type="text" class="form-control" placeholder="Name">
                </div>
                <div class="form-group">
                  <label>dob</label>
                  <input type="text" class="form-control" placeholder="Date of birth" >
                </div>
                <!-- radio -->
                <div class="form-group">
                <label>Gender</label>
                  <div class="radio">
                    <label>
                      <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                      Male
                    </label>
                  </div>
                  <div class="radio">
                    <label>
                      <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                      Female
                    </label>
                  </div>
                </div>

            </div>
            <!-- /.col -->
          </div>
          <!-- /.row -->
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          Visit <a href="https://select2.github.io/">Select2 documentation</a> for more examples and information about
          the plugin.
        </div>
      </div>
      <!-- /.box -->
		
		
      

    </section>
  </div>
</div>

<%@ include file = "../include/footer.jsp" %>

</body>
</html>