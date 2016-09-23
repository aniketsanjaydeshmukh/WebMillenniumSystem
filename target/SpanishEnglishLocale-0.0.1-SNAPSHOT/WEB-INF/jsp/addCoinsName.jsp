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
		 alert("Please select Atleast one Country for delete");
	 }
	 else{
	
		 var result = confirm("Are you sure, you wan to delete country(s)?");
		 if(result){
			 window.location.href = "deleteCountryList.html?list="+saveKara;	 
		 }
		 	 
	 }
	 
 }
 
 function doneCoinsName(countryId){
	var code =  $("#code").val();
	var value = $("#value").val();
	 window.location.href = "addCoinsNameDone.html?countryId="+countryId+"&code="+code+"&value="+value;	
 }
</script>

<script type="text/javascript">




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

function editSchool(id,country,currency){
	
	$("#Idd").val(id);
	
	$("#countryy").val(country);
	$("#currencyy").val(currency);
	
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





$('.dropdown-menu a').on('click', function(){    
    $('.dropdown-toggle').html($(this).html() + '<span class="caret"></span>');    
});





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
        	country: {
                validators: {
                    notEmpty: {
                        message: 'The country name is required'
                    }
                }
            },
            currency: {
                validators: {
                    notEmpty: {
                        message: 'The currency is required'
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
        	country: {
                validators: {
                    notEmpty: {
                        message: 'The country name is required'
                    }
                }
            },
            currency: {
                validators: {
                    notEmpty: {
                        message: 'The currency is required'
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

                    <h1 class="page-head-text pull-left"><spring:message code="label.coin"/></h1>
                    <h3 class="page-head-text pull-left"><spring:message code="label.coinInfo"/></h3>
                    
                </div>                                    
            </div>
        </div>
        
    </div>
    
           
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                       
            <form action="${pageContext.request.contextPath}/admin/addCoinsNameMore.html" method="post">
                
                     <input type="hidden" name="action" id="action" value="add">
                     <input type="hidden" name="countryID" id="countryID" value="${countryID}">
                    <div class="form-group">
                        <label  class="col-sm-3 control-label"><spring:message code="label.value"/> &#42;</label>
                        <div class="col-sm-8">
                       		<input type="text" name="value" id="value" name="value" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                  	
                  	<div class="form-group">
                        <label  class="col-sm-3 control-label"><spring:message code="label.code"/> &#42;</label>
                        <div class="col-sm-8">
                            <input type="text" name="code" id="code" name="code" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
                      	</div>
                   	</div>
             		
           	<div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" onClick="doneCoinsName('${countryID}')"><spring:message code="label.done"/></button>
            	<button type="submit" name="submitButton" class="btn btn-primary"><spring:message code="label.addMore"/></button>
            </div>
                                         
                
           
          
        </form> 
                </div>                                    
            </div>
        </div>
    </div>   
</div>
