function checkData() {
    
    var password1 = $("#_password_1").val();
    var password2 = $("#_password_2").val();

    /*alert('Hooola');
        $("#_password_1").addClass("border border-danger");
        $("#_password_2").addClass("border border-danger");
  
    
    document.form_registration_user.target = "null";
    document.form_registration_user.action = "UserRegistration";
    document.form_registration_user.submit();
    alert("Proceso terminado");*/
    
    if (password1 === password2) {
        document.form_registration_user.target = "null";
        document.form_registration_user.action = "UserRegistration";
        document.form_registration_user.submit();
        alert("Proceso terminado");
    } else {
        $("#_password_1").addClass("border border-danger");
        $("#_password_2").addClass("border border-danger");
  
    }
    

}