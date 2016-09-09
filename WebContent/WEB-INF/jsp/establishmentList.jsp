<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>


 
<script type="text/javascript">

 function emailValidateUpdate() 
 {
 	 var mail = $("#email").val();
      if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))
      {
        return (true)
      }
      alert("You have entered an invalid email address!")
      $("#email").val("");
      return (false)
 }

 function emailValidateRegistration() 
 {
 	 var mail = $("#eemail").val();
      if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))
      {
        return (true)
      }
      alert("You have entered an invalid email address!")
      $("#eemail").val("");
      return (false)
 }
 

 function editSchool(id,schoolName,address,details,location,city){
	 
		$("#routeId").val(id);
		$("#routeName").val(schoolName);
		$("#status").val(address);
		$("#start").val(details);
		$("#stop").val(location);
		$("#regNumber").val(city);
		
		$("#edit").modal('show');
		
		
	}
 
 
 function phoneValidUpdate(inputtxt)
 {
   var phoneno = /^\d{10}$/;
   if(inputtxt.value.match(phoneno))
   {
       return true;
   }
   else
   {
      alert("Not a valid Phone Number");
      $("#phone").val("");
      return false;
   }
}

 function phoneValidRegistration(inputtxt)
 {
   var phoneno = /^\d{10}$/;
   if(inputtxt.value.match(phoneno))
   {
       return true;
   }
   else
   {
      alert("Not a valid Phone Number");
      $("#pphone").val("");
      return false;
   }
}

 
 
 function AllowAlphabet(e)
{
  isIE = document.all ? 1 : 0
  keyEntry = !isIE ? e.which : event.keyCode;
  if (((keyEntry >= '65') && (keyEntry <= '90')) || ((keyEntry >= '97') && (keyEntry <= '122')) || (keyEntry == '46') || (keyEntry == '32') || keyEntry == '45' || keyEntry == '9' || keyEntry == '13' || keyEntry == '20' || keyEntry == '13' || keyEntry == '37' || keyEntry == '38' || keyEntry == '39' || keyEntry == '40' || keyEntry == '46' || keyEntry == '8'|| keyEntry == '11' || keyEntry == '9')
     return true;
  else
	{
    	alert('Please Enter Only Character values.');
    	//$("#password").val("");	
    	return false;
    }
}

 function AllowNumber(e)
 {
   isIE = document.all ? 1 : 0
   keyEntry = !isIE ? e.which : event.keyCode;
   if (((keyEntry >= '48') && (keyEntry <= '57')) || ((keyEntry >= '96') && (keyEntry <= '105')) || (keyEntry == '46') || (keyEntry == '37') || keyEntry == '39' || keyEntry == '9' || keyEntry == '8'  || keyEntry == '13' || keyEntry == '38' || keyEntry == '39' || keyEntry == '40' || keyEntry == '46' )
      return true;
   else
 	{
     	alert('Please Enter Only numbers .');
     	return false;
     }
 }

 
 function password_length_update()
{  	
   var userInput = $("#password").val().length;  
   if(userInput >= 6 )
      {  	
        return true;  	
      }
   else
      {  	
	    alert("Please input atleast " +6+ " characters");  		
        return false;  	
      }  
}

function password_length_registration()
{  	
   var userInput = $("#ppassword").val().length;  
   //alert(userInput);
   if(userInput >= 6 )
      {  	
        return true;  	
      }
   else
      {  	
	    alert("Please input atleast " +6+ " characters");  		
	    $("#ppassword").val("");
        return false;  	
      }  
}
</script>
<script>
 var saveKara = 0;
  
 function showAlert(saveKara){
	 return saveKara;
 }
  
 function showBtn(){

	 if(saveKara == 0){
		 alert("Please select Atleast one Operator for delete");
	 }
	 else{
	
		 var result = confirm("Are you sure, you wan to delete operator(s)?");
		 if(result){
			 window.location.href = "deleteEstablishmentList.html?list="+saveKara;	 
		 }
		 	 
	 }
	 
 }
</script>

<script type="text/javascript">

/*This code used for hide button on page load and show when check box is chechked
$(document).ready(function() {
    
    var $submit = $("#btn").hide(),
        $cbs = $('input[name="myTextEditBox"]').click(function() {
            $submit.toggle( $cbs.is(":checked") );
        });

}); */


 $(document).ready(function() {

    $('#example').dataTable( {
        "aaSorting": [[1,'asc']],
    aoColumnDefs: [
	                   {
	                      bSortable: false,
	                      aTargets: [ -1 ]
	                   }
	                 ]
      } );
} ); 


$(document).on("click", ".open-AddBookDialog", function () {

	var myBookId = $(this).data('id');
    var data = myBookId.split(",");
    var d = data[0];
    var d1 = data[1];
    var d2 = data[2];
    var d3 = data[3];
    var d4 = data[4];
    var d5 = data[5];
    var d6 = data[6];
    var d7 = data[7];
    var d8 = data[8];
    var d9 = data[9];
    var d10 = data[10];
    var d11 = data[11];
    var d12 = data[12];
    var d13 = data[13];
    var d14 = data[14];
    var d15 = data[15];
    var d16 = data[16];
    var d17 = data[17];
    var d18 = data[18];
    var d19 = data[19];
    
    $(".modal-body #id").val( d );
    $(".modal-body #userName").val( d1 );
    $(".modal-body #password").val( d2 );
    $(".modal-body #firstName").val( d3 );
    $(".modal-body #lastName").val( d4 );
    $(".modal-body #birthDate").val( d5 );
    $(".modal-body #sex").val( d6 );
    $(".modal-body #maritalStatus").val( d7 );
    $(".modal-body #email").val( d8 );
    $(".modal-body #address").val( d9 );
    $(".modal-body #city").val( d10 );
    $(".modal-body #state").val( d11 );
    $(".modal-body #zip").val( d12 );
    $(".modal-body #country").val( d13 );
    $(".modal-body #phone").val( d14 );
    $(".modal-body #designation").val( d15 );
    $(".modal-body #userRole").val( d16 );
    $(".modal-body #rId").val( d17 );
    $(".modal-body #supervisor").val( d18 );
    $(".modal-body #sId").val( d19 );
  
});

$(document).ready(function() {

    $('#example').DataTable();
    
    
} );

function setDateFormat(manu){
	 menu = menu.substring(0,menu.length -11);
	 return menu;
}

function deleteAllRow(source){  	
	 checkboxes = document.getElementsByName('myTextEditBox');
	  for(var i=0, n=checkboxes.length;i<n;i++) {
		var id = checkboxes[i].getAttribute('id' );
	    checkboxes[i].checked = source.checked;
	    if(source.checked){
	    malaDeleteKara(id);
	    }else{
	    	removeString(id);
	    }
	  }	
}
	

function displayNote(evt){
	
	var el = evt.target || evt.srcElement;

	  if (el && el.type == 'checkbox' && el.checked == true) {
	   
	   	    malaDeleteKara(el.id);
	  }
	  else if(el && el.type == 'checkbox' && el.checked == false){
		  removeString(el.id);
	  }
	 
}
var saveKara = 0;
function malaDeleteKara(id){
	if(saveKara == 0){
		saveKara = id + ",";
	}
	else{
		saveKara = saveKara + id + ",";	
	}
	showAlert(saveKara);
}

function removeString(ch){
	ch = ch + ",";
	saveKara = saveKara.replace(ch,'');
	showAlert(saveKara);
}

console.log(saveKara);


</script>

<script type="text/javascript">




//called when user clicks login
function sendDataForUpdation(){
	var id = $("#id").val(); 
	
	 var userName = $("#userName").val();
	 var password = $("#password").val();
	 var firstName = $("#firstName").val();
	 var lastName = $("#lastName").val();
	 var birthDate = $("#birthDate").val();
	 var sex = $("#sex").val();
	 var maritalStatus = $("#maritalStatus").val();
	 var email = $("#email").val();
	 var address = $("#address").val();
	 var city = $("#city").val();
	 var state = $("#state").val();
	 var zip = $("#zip").val();
	 var country = $("#country").val();
	 var phone = $("#phone").val();
	 var designation = $("#designation").val();
	 var userRole = $("#userRole").val();
	 var rId = $("#rId").val();
	 var supervisor = $("#supervisor").val();
	 var sId = $("#sId").val();
	 if(id == null || id == "" || userName == null || userName == "" || password == null || password == "" || firstName == null || firstName == "" || lastName == null || lastName == "" || birthDate == null || birthDate == "" || sex == null || sex == "" || maritalStatus == null || maritalStatus == "" || email == null || email == "" || address == null || address == "" || city == null || city == "" || state == null || state == "" || zip == null || zip == "" || country == null || country == "" || phone == null || phone == "" || designation == null || designation == "" || userRole == null || userRole == ""){
			alert("some fields are empty");
		}else{
	 
	 var allData = id+","+userName+","+password+","+firstName+","+lastName+","+birthDate+","+sex+","+maritalStatus+","+email+","+address+","+city+","+state+","+zip+","+country+","+phone+","+designation+","+userRole+","+rId+","+supervisor+","+sId;
	 var formData = "accessList="+allData;
	 $.ajax({
		    type : "POST",
		    url : "${pageContext.request.contextPath}/admin/updateEmployee",
		    data : formData,
		    success : function(response) {	       
		       alert("Employee Profile Updated");
		    },
		    error : function(e) {
		       alert('Error: ' + e);
		    }
		});
	}
}

function editSchool(id,establishmentName,geolocation,phone,address,username,password,sector,population,province,dischargeDate,percentage,establishmentsType,hours,status,loans,withdrawals,prepayments,fund){
	alert(id);
	$("#Idd").val(id);
	alert(name);
	$("#establishmentName").val(establishmentName);
	$("#geolocation").val(geolocation);
	$("#phone").val(phone);
	$("#address").val(address);
	$("#username").val(username);
	$("#password").val(password);
	$("#sector").val(sector);
	$("#population").val(population);
	$("#province").val(province);
	$("#dischargeDate").val(dischargeDate);
	$("#percentage").val(percentage);
	$("#establishmentsType").val(establishmentsType);
	$("#status").val(status);
	$("#hours").val(hours);
	$("#loans").val(loans);
	$("#withdrawals").val(withdrawals);
	$("#prepayments").val(prepayments);
	$("#fund").val(fund);
	$("#edit").modal('show');
}

function useHTML(id,data){
	 var id = "#" + id;
	var text = "";
	for (i = 0; i < data.length; i++) { 
		if(data[i] == "<"){
   	text += "<<span>";
		}else if(data[i] == ">"){
			text += "</span>>";
		}
		else{
			text += data[i];
		}
	}
	 $(id).val(text);
}


function sendDataForRegistration(){
	 var name=$("#schoolName").val();
	 var address=$("#address").val();
	 var details=$("#details").val();
	 var location=$("#location").val();
	 var city=$("#city1").val();
	 var allData = name+","+address+","+details+","+location+","+city;
	 
	 var formData = "accessList="+allData;
	 
	 $.ajax({
		    type : "POST",
		    url : "${pageContext.request.contextPath}/admin/addSchool",
		    data : formData,
		    success : function(response) {	       
		
		    	$("#schoolAdd").modal('hide');
		       alert("School Added"+response);
		       window.location.href="${pageContext.request.contextPath}/admin/parentList";
		       window.location.href="${pageContext.request.contextPath}/admin/schoolList";
		       //	window.location.reload();
		    },
		    error : function(e) {
		    	alert(e);
		       
		    }
		});
	}




$('.dropdown-menu a').on('click', function(){    
    $('.dropdown-toggle').html($(this).html() + '<span class="caret"></span>');    
});



function checkUsernameUpdate(){

	 var userName = $("#userName").val(); 
    $.ajax({url: "checkUserName?userName="+userName, 
    	dataType: "text",
    	
    	success: function(result){
        
        	if(result == "true"){
        		alert("This username "+ userName + " is not allowed.")
        		$("#userName").val("");
        		
        	}
        	else{
        		$("#err").text("");
        	}
    			
    }});
// }); 
}

function checkUsernameRegister(){

		 var userName = $("#uuserName").val(); 
	    $.ajax({url: "checkUserName?userName="+userName, 
	    	dataType: "text",
	    	
	    	success: function(result){
	        
	        	if(result == "true"){
	        		alert("This username "+ userName + " is not allowed.")
	        		$("#uuserName").val("");
	        	}
	        	else{
	        		$("#err").text("");
	        	}
	    			
	    }});
	}

$('#frm').submit(function(e) {
    $('#messages').removeClass('hide').addClass('alert alert-success alert-dismissible').slideDown().show();
    $('#messages_content').html('<h4>MESSAGE HERE</h4>');
    $('#modal').modal('show');
    e.preventDefault();
});



$(document).ready(function() {
    $('#frm').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	schoolName: {
                validators: {
                    notEmpty: {
                        message: 'The schoolName is required'
                    }
                }
            },
            address: {
                validators: {
                    notEmpty: {
                        message: 'The address is required'
                    }
                }
            },
            details: {
                validators: {
                    notEmpty: {
                        message: 'The Details is required'
                    }
                }
            },
            
            location: {
                validators: {
                    notEmpty: {
                        message: 'The Location is required'
                    }
                }
            },
            
            city: {
                validators: {
                    notEmpty: {
                        message: 'The city is required'
                    }
                }
            }
            
        }
    });
    
    $('#editForm').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	schoolName: {
                validators: {
                    notEmpty: {
                        message: 'The schoolName is required'
                    }
                }
            },
            address: {
                validators: {
                    notEmpty: {
                        message: 'The address is required'
                    }
                }
            },
            details: {
                validators: {
                    notEmpty: {
                        message: 'The Details is required'
                    }
                }
            },
            
            location: {
                validators: {
                    notEmpty: {
                        message: 'The Location is required'
                    }
                }
            },
            
            city: {
                validators: {
                    notEmpty: {
                        message: 'The city is required'
                    }
                }
            }
            
        }
    });
    
    
});
</script>



<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                    <h1 class="page-head-text pull-left"><spring:message code="label.establishment"/></h1>
                    
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#schoolAdd"><i class="fa fa-plus-circle"></i>  <spring:message code="label.addEstablishment"/></button>                    
                    <button type="submit" class="btn btn-brown btn-sm pull-right" onClick="showBtn()" ><i class="fa fa-trash-o"></i> <spring:message code="label.delete"/></button>
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
                        <span class="panel-head"><spring:message code="label.establishmentList"/></span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            
    
         	<th width="3%" class="text-center no-sort"><input type="checkbox"  onClick="deleteAllRow(this)" ></th>
                               
                                <th width="10%"><spring:message code="label.establishmentName"/></th>
                                <th width="10%"><spring:message code="label.geolocation"/></th>
                                <th width="10%"><spring:message code="label.phone"/></th>
                                <th width="10%"><spring:message code="label.address"/></th>
                                <th width="20%"><spring:message code="label.username"/></th>   
                                 <th width="10%"><spring:message code="label.password"/></th>  
                                 <th width="10%"><spring:message code="label.sector"/></th>
                                <th width="10%"><spring:message code="label.population"/></th> 
                                 <th width="10%"><spring:message code="label.province"/></th> 
                                 <th width="10%"><spring:message code="label.dischargeDate"/></th>
                                <th width="10%"><spring:message code="label.percentage"/></th>
                                <th width="10%"><spring:message code="label.establishmentsType"/></th>   
                                 <th width="10%"><spring:message code="label.status"/></th> 
                                 <th width="10%"><spring:message code="label.hours"/></th>
                                <th width="10%"><spring:message code="label.loans"/></th>   
                                 <th width="10%"><spring:message code="label.withdrawals"/></th> 
                                 <th width="10%"><spring:message code="label.prepayments"/></th>   
                                 <th width="10%"><spring:message code="label.fund"/></th> 
                                <th width="10%"><spring:message code="label.edit"/></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="establishment" items="${establishmentList}">
                                <tr>
                                  	<td class="text-center"><input type="checkbox" id="${establishment.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                    <td>${establishment.establishmentName}</td>
                                    <td>${establishment.geolocation}</td>
                                    <td>${establishment.phone}</td>
                                    <td>${establishment.address}</td>
                                    <td>${establishment.establishmentUsername}</td>
                                    <td>${establishment.establishmentPassword}</td>
                                    <td>${establishment.sector}</td>
                                    <td>${establishment.population}</td>
                                    <td>${establishment.province}</td>
                                    <td>${establishment.dischargeDate}</td>
                                    <td>${establishment.percentage}</td>
                                    <td>${establishment.establishmentsType}</td>
                                    <td>${establishment.status}</td>
                                    <td>${establishment.hours}</td>
                                    <td>${establishment.loans}</td>
                                     <td>${establishment.withdrawals}</td>
                                    <td>${establishment.prepayments}</td>
                                     <td>${establishment.fund}</td>
                                  
                                    <td><button type="submit" class="btn btn-default btn-sm" onClick="editSchool('${establishment.id}','${establishment.establishmentName}','${establishment.geolocation}','${establishment.dischargeDate}','${establishment.phone}','${establishment.address}','${establishment.establishmentUsername}','${establishment.establishmentPassword}','${establishment.sector}','${establishment.population}','${establishment.province}','${establishment.percentage}','${establishment.establishmentsType}','${establishment.status}','${establishment.hours}','${establishment.loans}','${establishment.withdrawals}','${establishment.fund}','${establishment.prepayments}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.edit"/></button></td>
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

<div class="modal fade" id="schoolAdd" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
    <div class="modal-dialog">
    	<!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"><center><spring:message code="label.establishmentDetails"/></center></h4>
            </div>
            
            
	
	
             <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/establishmentList.html" commandName="establishment">
            <div class="modal-body">
                
                      	<input type="hidden" name="action" id="action" value="add">
                    <div class="form-group">
                        <form:label path="establishmentName" class="col-sm-3 control-label"><spring:message code="label.establishmentName"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="establishmentName" id="a" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                  	
                   	</div>
                    <div class="form-group">
                        <form:label path="geolocation" class="col-sm-3 control-label"><spring:message code="label.geolocation"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="geolocation" id="c" value="" class="form-control" maxlength="60" onblur = "useHTML(this.id,document.getElementById('c').value)"/>
                      	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="dischargeDate" class="col-sm-3 control-label"><spring:message code="label.dischargeDate"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="dischargeDate" id="d" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('d').value)"/>
                     	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="address" class="col-sm-3 control-label"><spring:message code="label.address"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="address" id="e" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('e').value)"/>
                     	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="establishmentUsername" class="col-sm-3 control-label"><spring:message code="label.username"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="establishmentUsername" id="f" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('f').value)"/>
                      	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="establishmentPassword" class="col-sm-3 control-label"><spring:message code="label.password"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="establishmentPassword" id="g" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('g').value)"/>
                      	</div>
                    </div>
                    
                    
                     <div class="form-group">
                        <form:label path="sector" class="col-sm-3 control-label"><spring:message code="label.sector"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="sector" id="h" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('h').value)"/>
                      	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="population" class="col-sm-3 control-label"><spring:message code="label.population"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="population" id="i" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('i').value)"/>
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="province" class="col-sm-3 control-label"><spring:message code="label.province"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="province" id="j" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('j').value)"/>
                      	</div>
                    </div>
                    
                     
                    <div class="form-group">
                        <form:label path="percentage" class="col-sm-3 control-label"><spring:message code="label.percentage"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="percentage" id="k" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('k').value)"/>
                      	</div>
                    </div>
                    
                    
                    <div class="form-group">
                        <form:label path="establishmentsType" class="col-sm-3 control-label"><spring:message code="label.establishmentsType"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="establishmentsType" id="k" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('k').value)"/>
                      	</div>
                    </div>
                    
                    
                     <div class="form-group">
                        <form:label path="phone" class="col-sm-3 control-label"><spring:message code="label.phone"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="phone" id="phone" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('k').value)"/>
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="status" class="col-sm-3 control-label"><spring:message code="label.status"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="status" id="k" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('k').value)"/>
                      	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="hours" class="col-sm-3 control-label"><spring:message code="label.hours"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="hours" id="k" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('k').value)"/>
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="loans" class="col-sm-3 control-label"><spring:message code="label.loans"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="loans" id="k" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('k').value)"/>
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="withdrawals" class="col-sm-3 control-label"><spring:message code="label.withdrawals"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="withdrawals" id="k" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('k').value)"/>
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="prepayments" class="col-sm-3 control-label"><spring:message code="label.prepayments"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="prepayments" id="k" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('k').value)"/>
                      	</div>
                    </div>
                    
                    
                    <div class="form-group">
                        <form:label path="fund" class="col-sm-3 control-label"><spring:message code="label.fund"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="fund" id="k" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('k').value)"/>
                      	</div>
                    </div>
           			<input type="hidden" name="action" value="add" />
           			 <div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><spring:message code="label.cancel"/></button>
            	<button type="submit" name="submitButton" class="btn btn-primary"><spring:message code="label.save"/></button>
            </div>
                                         
                
           
          </div>
        </form:form>    
        </div>
          
	</div>
</div>

<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><spring:message code="label.editEstablishment"/> </h4>
      </div>
	   
	        <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/establishmentList.html" commandName="establishment">
            <div class="modal-body">
                
                     
                     <form:input type="hidden" path="id" id="Idd"  />
                     <input type="hidden" name="action" id="action" value="edit"/>
                    <div class="form-group">
                        <form:label path="establishmentName" class="col-sm-3 control-label"><spring:message code="label.establishmentName"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="establishmentName" id="establishmentName" value="" class="form-control" maxlength="50" />
                       	</div>
                    </div>
                  	<div class="form-group">
                        <form:label path="geolocation" class="col-sm-3 control-label"><spring:message code="label.geolocation"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="geolocation" id="geolocation" value="" class="form-control" maxlength="50" />
                      	</div>
                   	</div>
                    <div class="form-group">
                        <form:label path="phone" class="col-sm-3 control-label"><spring:message code="label.phone"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="phone" id="phone" value="" class="form-control" maxlength="60" />
                      	</div> 
                      	</div>              
                     <div class="form-group">
                        <form:label path="address" class="col-sm-3 control-label"><spring:message code="label.address"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="address" id="address" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('location').value)"/>
                     	</div>
                    </div>
                    </div>
                    <div class="form-group">
                        <form:label path="establishmentUsername" class="col-sm-3 control-label"><spring:message code="label.username"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="establishmentUsername" id="username" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                     <div class="form-group">
                        <form:label path="establishmentPassword" class="col-sm-3 control-label"><spring:message code="label.password"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="establishmentPassword" id="password" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>                   
                    <div class="form-group">
                        <form:label path="sector" class="col-sm-3 control-label"><spring:message code="label.sector"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="sector" id="sector" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="population" class="col-sm-3 control-label"><spring:message code="label.population"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="population" id="population" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="province" class="col-sm-3 control-label"><spring:message code="label.province"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="province" id="province" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>                 
                     <div class="form-group">
                        <form:label path="dischargeDate" class="col-sm-3 control-label"><spring:message code="label.dischargeDate"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="dischargeDate" id="dischargeDate" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                      <div class="form-group">
                        <form:label path="loans" class="col-sm-3 control-label"><spring:message code="label.loans"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="loans" id="loans" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                      <div class="form-group">
                        <form:label path="withdrawals" class="col-sm-3 control-label"><spring:message code="label.withdrawals"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="withdrawals" id="withdrawals" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                      <div class="form-group">
                        <form:label path="prepayments" class="col-sm-3 control-label"><spring:message code="label.prepayments"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="prepayments" id="prepayments" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="fund" class="col-sm-3 control-label"><spring:message code="label.fund"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="fund" id="fund" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                      <div class="form-group">
                        <form:label path="dischargeDate" class="col-sm-3 control-label"><spring:message code="label.identity_card"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="dischargeDate" id="dischargeDate" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                    
                      <div class="form-group">
                        <form:label path="hours" class="col-sm-3 control-label"><spring:message code="label.hours"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="hours" id="hours" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                      <div class="form-group">
                        <form:label path="status" class="col-sm-3 control-label"><spring:message code="label.status"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="status" id="status" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                      <div class="form-group">
                        <form:label path="establishmentsType" class="col-sm-3 control-label"><spring:message code="label.establishmentsType"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="establishmentsType" id="establishmentsType" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>  
                      <div class="form-group">
                        <form:label path="percentage" class="col-sm-3 control-label"><spring:message code="label.percentage"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="percentage" id="percentage" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
           			<input type="hidden" name="action" value="edit" />
           			 <div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><spring:message code="label.cancel"/></button>
            	<button type="submit" name="submitButton" class="btn btn-primary"><spring:message code="label.save"/></button>
            </div>
                                         
                
           
          </div>
        </form:form>   
	      
    <!-- </form> --> 
  </div>
</div>
</div>
	   
	   