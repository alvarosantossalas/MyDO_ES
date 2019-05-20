/**
 * 
 */

function checkPassword() {
    var pass1 = document.form_registration_user._password_1.value;
    var pass2 = document.form_registration_user._password_2.value;
    
    if (pass1 != pass2) {

        addClassForInputs();

    }
}

function addClassForInputs() {
    $("#_password_2").addClass("form-control is-invalid");
    $("#_password_2").val('');
        
    $("#_password_1").addClass("is-invalid");
    $("#_password_1").val('');
    $("#_password_1").attr("placeholder", "Las claves que has introducido no coinciden").placeholder();
}