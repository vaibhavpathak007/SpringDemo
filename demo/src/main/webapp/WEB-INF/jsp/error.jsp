<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
        Error
      </h1>
    </section>
    
    <!-- Main content -->
    <section class="content container-fluid">
		<div class="error-page">
        <h2 class="headline text-yellow">505</h2>

        <div class="error-content">
          <h3><i class="fa fa-warning text-yellow"></i> Oops! something went wrong on ${url}.</h3>

          <p>${exception}</p>
            

        </div>
        <!-- /.error-content -->
      </div>
      

    </section>
  </div>
</div>

<%@ include file = "../include/footer.jsp" %>

</body>
</html>