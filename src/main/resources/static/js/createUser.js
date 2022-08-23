
   function userValidation(form) {
    	let email = form.email.value;
        let password = form.password.value;
        let confirmPassword = form.confirmPassword.value;
        let name = form.fullName.value;

        if(email == "") {
        	form.email.focus();
        	return false;
            } 
        if(password == "") {
        	form.password.focus();
        	return false;
            } 
        if(confirmPassword == "") {
        	form.confirmPassword.focus();
        	return false;
            } 
        if(name == "") {
        	form.name.focus();
        	return false;
            } 
        
        return false;
    }