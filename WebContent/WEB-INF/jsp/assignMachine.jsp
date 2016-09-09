<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
<div class="panel-body">
                    <div class="table-responsive">
                     <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            <th width="20%"><spring:message code="label.machine"/></th>
                             <th width="20%"><spring:message code="label.operator"/></th>
                             <th width="20%"><spring:message code="label.establishment"/></th>
                             <th width="20%"><spring:message code="label.assigned"/></th>
                            </tr>
                           </thead>
                            <tbody>
                            <tr>
                             <form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/assignMachined.html">
                            <td>
                            <input type="hidden" name="action" id="action" value="assignMachine">
                            <select name="machineID" id="machineID" class="form-control" >
                            <option selected disabled hidden style='display: none' value=''></option>
                            <c:forEach var="machine" items="${machineList}">
                        <option value="${machine.id}">${machine.machineIMEI}</option>
                      </c:forEach>
                      </select>
                      </td>
                         <td>
                         <select name="operatorID" id="operatorID" class="form-control" >
                         <option selected disabled hidden style='display: none' value=''></option>
                         <c:forEach var="operator" items="${operatorList}">
                        <option value="${operator.id}">${operator.name}</option>
                      </c:forEach>
                      </select>
                      </td>
                      <td>
                         <select name="establishmentID" id="establishmentID" class="form-control" >
                         <option selected disabled hidden style='display: none' value=''></option>
                         <c:forEach var="establishment" items="${establishmentList}">
                        <option value="${establishment.id}">${establishment.establishmentName}</option>
                      </c:forEach>
                      </select>
                      </td>
                      <td>
                      <button type="submit" class="btn btn-default btn-sm"><spring:message code="label.assigned"/></button>
                      </td>
                      </form>
                            </tr>
                         
                            </tbody>
                       </table>

                      
                      
                      </div>
                      </div>
</div>                     
</body>
</html>