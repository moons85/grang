let index = {
	init: function() {
		$(".ordinarysignup").on("click", () => {
			this.test();
		});
	},
    test : function() {
      var p1 = document.getElementById("password1").value;
      var p2 = document.getElementById("password2").value;
      if( p1 != p2 ) {
        alert("비밀번호가 일치하지 않습니다");
        return false;
      } else{
        this.save();
      };
    },
	save: function() {
		let data = {
			username : $(".username").val(),
			email : $(".email").val(),
			password : $("#password1").val()
		};
		console.log(data);
		/*console.log(data);*/
		$.ajax({
			type : "POST",
			url : "/auth/api/user",
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			datatype : "json"
			}).done(function(resp) {
				alert("회원가입이 완료되었습니다.")
			}).fail(function(error) {
				alert(JSON.stringify(error));
			})
		}
	}
index.init();