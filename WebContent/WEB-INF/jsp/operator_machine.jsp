<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


    
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
</head>
<body>
<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                    <h1 class="page-head-text pull-left"><spring:message code="label.machine"/></h1>
                    
                                       
                   
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" onClick="goMachine()"><i class="fa fa-plus-circle"></i>  <spring:message code="label.assignMachine"/></button> 
                </div>                                    
            </div>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
           
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head"><spring:message code="label.machineList"/></span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            
    
         	
                               
                                <th width="10%"><spring:message code="label.machineNumber"/></th>
                                <th width="10%"><spring:message code="label.manufacturingDate"/></th>
                                <th width="10%"><spring:message code="label.machineIMEI"/></th>
                                <th width="10%"><spring:message code="label.machineEntries"/></th>
                                <th width="10%"><spring:message code="label.machineStatus"/></th>   
                                 <th width="10%"><spring:message code="label.machineOutput"/></th>  
                                 <th width="10%"><spring:message code="label.machineType"/></th>
                                <th width="10%"><spring:message code="label.machineHopper"/></th> 
                                 <th width="10%"><spring:message code="label.machineControl"/></th> 
                                 <th width="10%"><spring:message code="label.machinelock"/></th>
                                <th width="10%"><spring:message code="label.repairHistory"/></th>
                                
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="machine" items="${machineList}">
                                <tr>
                                  	
                                    <td>${machine.machineNumber}</td>
                                    <td>${machine.manufacturingDate}</td>
                                    <td>${machine.machineIMEI}</td>
                                    <td>${machine.machineEntries}</td>
                                    <td>${machine.machineStatus}</td>
                                    <td>${machine.machineOutput}</td>
                                    <td>${machine.machineType}</td>
                                    <td>${machine.machineHopper}</td>
                                    <td>${machine.machineControl}</td>
                                    <td>${machine.machinelock}</td>
                                    <td>${machine.repairHistory}</td>
                                  
                                    
                                 </tr>
                          	</c:forEach>                                                                                    
                          </tbody>
                        </table>
                    </div>
                </div>                                    
            </div>
        </div>
    </div>
<!-- / row -->   
</div>
<script>
function goMachine(){
	 window.location.href="${pageContext.request.contextPath}/operator/assignMachines.html";
 }
</script>
</body>
</html>