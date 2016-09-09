<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
</head>
<body>
<div class="form-horizontal">
<div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                	
                	<form action="${pageContext.request.contextPath}/admin/hopperCapacity.html" method="post">
                		Add Hopper Capacity
						<input type="hidden" id="hopperTypeId" name="hopperTypeId" value="${hopperTypeId}">
						<input type="text" id="hopperTypeCapacity" name="hopperTypeCapacity" value="">
                	    <button type="submit" name="submitButton" class="btn btn-primary">Next</button>
                	</form>
                
                </div>
             </div>
          </div>
      </div>
</div>

</body>
</html>