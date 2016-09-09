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
			 window.location.href = "deleteOperatorList.html?list="+saveKara;	 
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

function editSchool(id,business,name,email,telephone,address,username,password,sector,population,province,identity_card){
	alert(id);
	$("#Idd").val(id);
	alert(name);
	$("#business").val(business);
	$("#name").val(name);
	$("#email").val(email);
	$("#telephone").val(telephone);
	$("#address").val(address);
	$("#operatorUsername").val(username);
	$("#operatorPassword").val(password);
	$("#sector").val(sector);
	$("#population").val(population);
	$("#province").val(province);
	$("#identity_card").val(identity_card);
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
function showAlert(){
	alert("h");
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
        	business: {
                validators: {
                    notEmpty: {
                        message: 'The bussiness name is required'
                    }
                }
            },
            name: {
                validators: {
                    notEmpty: {
                        message: 'The name is required'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email is required'
                    },
                    emailAddress: {
                        message: 'The value is not a valid email address'
                    },
                    regexp: {
                        regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
                        message: 'The value is not a valid email address'
                    }
                }
            },
            
            telephone: {
                validators: {
                    notEmpty: {
                        message: 'The telephone is required'
                    },
                    phone: {
                        country: 'countrySelectBox',
                        message: 'The value is not valid %s phone number'
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
            operatorUsername: {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    }
                }
            },
            operatorPassword: {
                validators: {
                    notEmpty: {
                        message: 'The username is required'
                    }
                }
            },
            sector: {
                validators: {
                    notEmpty: {
                        message: 'The sector is required'
                    }
                }
            },
            population: {
                validators: {
                    notEmpty: {
                        message: 'The population is required'
                    }
                }
            },
            province: {
                validators: {
                    notEmpty: {
                        message: 'The province is required'
                    }
                }
            },
            
            identity_card: {
                validators: {
                    notEmpty: {
                        message: 'The identity_card is required'
                    }
                }
            }
            
        }
    })
    // Revalidate phone number when changing the country
        .on('change', '[name="countrySelectBox"]', function(e) {
            $('#phoneForm').formValidation('revalidateField', 'telephone');
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
        	business: {
                validators: {
                    notEmpty: {
                        message: 'The bussiness name is required'
                    }
                }
            },
            name: {
                validators: {
                    notEmpty: {
                        message: 'The name is required'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email is required'
                    },
                    emailAddress: {
                        message: 'The value is not a valid email address'
                    },
                    regexp: {
                        regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
                        message: 'The value is not a valid email address'
                    }
                }
            },
            
            telephone: {
                validators: {
                    notEmpty: {
                        message: 'The telephone is required'
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
            operatorPassword: {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    }
                }
            },
            operatorUsername: {
                validators: {
                    notEmpty: {
                        message: 'The username is required'
                    }
                }
            },
            sector: {
                validators: {
                    notEmpty: {
                        message: 'The sector is required'
                    }
                }
            },
            population: {
                validators: {
                    notEmpty: {
                        message: 'The population is required'
                    }
                }
            },
            province: {
                validators: {
                    notEmpty: {
                        message: 'The province is required'
                    }
                }
            },
            
            identity_card: {
                validators: {
                    notEmpty: {
                        message: 'The identity_card is required'
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
                    <h1 class="page-head-text pull-left"><spring:message code="label.operator"/></h1>
                    
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#schoolAdd"><i class="fa fa-plus-circle"></i>  <spring:message code="label.addOperator"/></button>                    
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
                        <span class="panel-head"><spring:message code="label.operatorList"/></span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            
                            
         	<th width="3%" class="text-center no-sort"><input type="checkbox"  onClick="deleteAllRow(this)" ></th>
                                <th width="10%"><spring:message code="label.business"/></th>
                                <th width="10%"><spring:message code="label.name"/></th>
                                <th width="10%"><spring:message code="label.email"/></th>
                                <th width="10%"><spring:message code="label.telephone"/></th>
                                <th width="10%"><spring:message code="label.address"/></th>
                                <th width="10%"><spring:message code="label.username"/></th>   
                                 <th width="10%"><spring:message code="label.password"/></th>  
                                 <th width="10%"><spring:message code="label.sector"/></th>
                                <th width="10%"><spring:message code="label.population"/></th>
                                <th width="10%"><spring:message code="label.identity_card"/></th>   
                                 <th width="10%"><spring:message code="label.province"/></th> 
                                                               
                                <th width="10%"><spring:message code="label.edit"/></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="operator" items="${operatorList}">
                                <tr>
                                  	<td class="text-center"><input type="checkbox" id="${operator.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                    <td>${operator.business}</td>
                                    <td>${operator.name}</td>
                                    <td>${operator.email}</td>
                                    <td>${operator.telephone}</td>
                                    <td>${operator.address}</td>
                                    <td>${operator.operatorUsername}</td>
                                    <td>${operator.operatorPassword}</td>
                                    <td>${operator.sector}</td>
                                    <td>${operator.population}</td>
                                    <td>${operator.identity_card}</td>
                                    <td>${operator.province}</td>
                                    <td><button type="submit" class="btn btn-default btn-sm" onClick="editSchool('${operator.id}','${operator.business}','${operator.name}','${operator.email}','${operator.telephone}','${operator.address}','${operator.operatorUsername}','${operator.operatorPassword}','${operator.sector}','${operator.population}','${operator.province}','${operator.identity_card}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.edit"/></button></td>
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
                <h4 class="modal-title"><center><spring:message code="label.operatorDetails"/></center></h4>
            </div>
            
            
	
	
             <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/operatorsList.html" commandName="operator">
            <div class="modal-body">
                
                      	<input type="hidden" name="action" id="action" value="add">
                    <div class="form-group">
                        <form:label path="business" class="col-sm-3 control-label"><spring:message code="label.business"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="business" id="businesss" name="businesss" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                  	<div class="form-group">
                        <form:label path="name" class="col-sm-3 control-label"><spring:message code="label.name"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="name" id="namee" name="namee" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
                      	</div>
                   	</div>
                    <div class="form-group">
                        <form:label path="email" class="col-sm-3 control-label"><spring:message code="label.email"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="email" id="emaill" name="emaill" value="" class="form-control" maxlength="60" onblur = "useHTML(this.id,document.getElementById('c').value)"/>
                      	</div>
                    </div>
                    <div class="form-group">
				        <label class="col-xs-3 control-label">Country</label>
				        <div class="col-xs-5">
				            <select class="form-control" name="countrySelectBox">
				                <option value="US">United States</option>
				                <option value="BG">Bulgaria</option>
				                <option value="BR">Brazil</option>
				                <option value="CN">China</option>
				                <option value="CZ">Czech Republic</option>
				                <option value="DK">Denmark</option>
				                <option value="FR">France</option>
				                <option value="DE">Germany</option>
				                <option value="IN">India</option>
				                <option value="MA">Morocco</option>
				                <option value="NL">Netherlands</option>
				                <option value="PK">Pakistan</option>
				                <option value="RO">Romania</option>
				                <option value="RU">Russia</option>
				                <option value="SK">Slovakia</option>
				                <option value="ES">Spain</option>
				                <option value="TH">Thailand</option>
				                <option value="AE">United Arab Emirates</option>
				                <option value="GB">United Kingdom</option>
				                <option value="VE">Venezuela</option>
				            </select>
				        </div>
				    </div>
                    <div class="form-group">
                        <form:label path="telephone" class="col-sm-3 control-label"><spring:message code="label.telephone"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="telephone" id="telephonee" name="telephonee" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('d').value)"/>
                     	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="address" class="col-sm-3 control-label"><spring:message code="label.address"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="address" id="addresss" name="addresss" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('e').value)"/>
                     	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="operatorUsername" class="col-sm-3 control-label"><spring:message code="label.username"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="operatorUsername" id="operatorUsernamee" name="operatorUsernamee" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('f').value)"/>
                      	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="operatorPassword" class="col-sm-3 control-label"><spring:message code="label.password"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="operatorPassword" id="operatorPasswordd" name="operatorPasswordd" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('g').value)"/>
                      	</div>
                    </div>
                    
                    
                     <div class="form-group">
                        <form:label path="sector" class="col-sm-3 control-label"><spring:message code="label.sector"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="sector" id="sectorr" name="sectorr" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('h').value)"/>
                      	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="population" class="col-sm-3 control-label"><spring:message code="label.population"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="population" id="populationn" name="populationn" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('i').value)"/>
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="province" class="col-sm-3 control-label"><spring:message code="label.province"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="province" id="provincee" name="provincee" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('j').value)"/>
                      	</div>
                    </div>
                    
                     
                    <div class="form-group">
                        <form:label path="identity_card" class="col-sm-3 control-label"><spring:message code="label.identity_card"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="identity_card" id="identity_cardd" name="identity_cardd" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('k').value)"/>
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
        <h4 class="modal-title"><spring:message code="label.editOperator"/> </h4>
      </div>
	   
	        <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/operatorsList.html" commandName="operator">
            <div class="modal-body">
                
                     
                     <form:input type="hidden" path="id" id="Idd"  />
                     <input type="hidden" name="action" id="action" value="edit"/>
                    <div class="form-group">
                        <form:label path="business" class="col-sm-3 control-label"><spring:message code="label.business"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="business" id="business" value="" class="form-control" maxlength="50" />
                       	</div>
                    </div>
                  	<div class="form-group">
                        <form:label path="name" class="col-sm-3 control-label"><spring:message code="label.name"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="name" id="name" value="" class="form-control" maxlength="50" />
                      	</div>
                   	</div>
                    <div class="form-group">
                        <form:label path="email" class="col-sm-3 control-label"><spring:message code="label.email"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="email" id="email" value="" class="form-control" maxlength="60" />
                      	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="telephone" class="col-sm-3 control-label"><spring:message code="label.telephone"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="telephone" id="telephone" value="" class="form-control" maxlength="20" />
                     	</div>
                    </div>
                     <div class="form-group">
                        <form:label path="address" class="col-sm-3 control-label"><spring:message code="label.address"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="address" id="address" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('location').value)"/>
                     	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="operatorUsername" class="col-sm-3 control-label"><spring:message code="label.username"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="operatorUsername" id="operatorUsername" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                     <div class="form-group">
                        <form:label path="operatorPassword" class="col-sm-3 control-label"><spring:message code="label.password"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="operatorPassword" id="operatorPassword" value="" class="form-control" maxlength="20" />
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
                        <form:label path="identity_card" class="col-sm-3 control-label"><spring:message code="label.identity_card"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="identity_card" id="identity_card" value="" class="form-control" maxlength="20" />
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
