function loginRegisterSwitch() {
	$('form').animate({
		height : "toggle",
		opacity : "toggle"
	}, "slow");
};

function showAlertAfterRegistration() {
	$('div.alert.alert-success').show();
};

$('.message a').click(function() {
	loginRegisterSwitch();
});

$("button.registers")
		.click(
				function() {
					let firstName = $(".register-form .firstName").val();
					let surName = $(".register-form .surName").val();
					let email = $(".register-form .email").val();
					let password = $(".register-form .password").val();
					let cpassword = $(".register-form .cpassword").val();
					
					if ($('[name=status]')[0].checked) {
						let status = 'user';
					} else if ($('[name=status]')[1].checked) {
						let status = 'admin';
					}

					if (firstName == '' || surName == '' || email == '' || password == '' || cpassword == '') {
						alert("Заповніть всі поля");
					} else if ((password.length) < 4) {
						alert("Пароль має бути довший за 4 символи");
					} else if (!(password).match(cpassword)) {
						alert("Паролі відрізняються");
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
										$('.register-form').trigger('reset');
										$('.login-form').trigger('reset');
			
										loginRegisterSwitch();
										showAlertAfterRegistration();
									}
								});
					}
				});

$("button.login").click(function() {
	let email = $(".login-form .email").val();
	let password = $(".login-form .password").val();

	if (email == '' || password == '') {
		alert("Ви не пройшли авторизацію");
	} else {
		let userLogin = {
			email : email,
			password : password
		};

		$.post("login", userLogin, function(data) {
			if (typeof(data) !== 'object') {
				let customUrl = '';
				let urlContent = window.location.href.split('/');
				
				for (let i = 0; i < urlContent.length - 1; i++) {
					customUrl += urlContent[i] + '/';
				}
				
				customUrl += data.destinationUrl;
				window.location = customUrl;
			}
			alert(data);
			$('.login-form').trigger('reset');
		});
	}
});
