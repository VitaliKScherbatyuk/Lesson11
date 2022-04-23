function loginRegisterSwitch() {
	$('form').animate({
		height : "toggle",
		opacity : "toggle"
	}, "slow");
};

function showAlertAfterRegistration() {
	$('div.alert.alert-success').show();
};

$('.message a').onclick(function() {
	loginRegisterSwitch();
});

$("button.register").click(function() {
					let firstName = $("form.register-form input.firstName").val();
					let surName = $("form.register-form input.surName").val();
					let email = $("form.register-form input.email").val();
					let password = $("form.register-form input.password").val();
					let cpassword = $("form.register-form input.cpassword").val();
					if ($('[name=status]')[0].checked) {
    	                   let status = 'user';
                           } else if ($('[name=status]')[1].checked) {
    	                        let status = 'admin';
                           }
														
					if (firstName == '' || surName == '' || email == ''
							|| password == '' || cpassword == '' || status == '') {
						alert("Please fill all fields...!!!!!!");
					} else if ((password.length) < 8) {
						alert("Password should atleast 8 character in length...!!!!!!");
					} else if (!(password).match(cpassword)) {
						alert("Your passwords don't match. Try again?");
					} else {
						var userRegistration = {
							firstName : firstName,
							surName : surName,
							email : email,
							password : password,
							status : status
						};

						$.post("registration", userRegistration,
								function(data) {
									if (data == 'Success') {
										$("form")[0].reset();
										
										loginRegisterSwitch();
										showAlertAfterRegistration();
									}
								});
					}
				});
				
$("button.login").onclick(function() {
	let email = $("form.login-form input.email").val();
	let password = $("form.login-form input.password").val();

	if (email == '' || password == '') {
		alert("Please fill login form!");
	} else {
		let userLogin = {
			email : email,
			password : password
		};

		$.post("login", userLogin, function(data) {
			if(data !== ''){
				let customUrl = '';
				let urlContent = window.location.href.split('/');
				for (let i = 0; i < urlContent.length-1; i++) {
					customUrl+=urlContent[i]+'/'
				}
				customUrl+=data.destinationUrl;
				window.location = customUrl;
			}
			$("form")[0].reset();
		});
	}
});
