$(function(){
	var password;
	var pwdval1;
	var pwdval2;
	var pwdval3;
	var pwdlen2;
	var pwdlen3;
	var mark;

	$("#user-info-btn").hide();	
	$(".btn-userc").show();			
	$(".header-title > li").click(function(){
		$(this).addClass("user-selected").siblings("li").removeClass("user-selected");
		$(".user-form").eq($(this).index()).show().siblings(".user-form").hide();
		if($(this).html()=="密码修改"){
			$('#password').val("");
			$('#new-password').val("");
			$('#new-password1').val("");
			$("#span3").html("").hide();
			$("#span1").html("").hide();
			$('#span2').html("").hide();
		}
		if($(this).html()=="个人信息"){
			$('#namespan').hide();
			$('#phonespan').hide();
			$('#idCardspan').hide();
			$('#agespan').hide();
			$('#emailspan').hide();
		}
	});
	$(".btn-userc").click(function(){
		$(".user-form > div > input").removeAttr("readonly");
		$(".user-form >div >input:eq(0)").attr("readonly","readonly");
		$(".user-form >div >input:eq(4)").attr("readonly","readonly");
		$("#user-info-btn").show();
		downMenu("#sex","#project_ul");
	})
	$(".user-info #btn-users").click(function(){
		$(".user-info >div >input").attr("readonly","readonly");
		$("#user-info-btn").hide();
	})
	/*$("#btn-userg").click(function(){
		$(".user-form1 >div >input").attr("readonly","readonly");
		$("#user-info-btn").hide();
		$(".user-form >div >span").hide();
		showInfo();
	})*/
	$(".user-form > div >span").hide();
	/*$(".user-form1 :input").blur(function(){
		var regname = /^([\u4e00-\u9fa5]+|([a-zA-Z]+\s?)+)$/;
		if($(this).is("#truename")){
			if(!regname.test(this.value)){
				$(this).siblings("span").show();
				$('#namespan').html("<font color=\"#FF6A6A\" size=\"2\">请输入正确的姓名</font>");
			}else{
				$(this).siblings("span").hide();
			}
		}
		var regphone = /^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if($(this).is("#telephone")){
			if(!regphone.test(this.value)){
				$(this).siblings("span").show();
				$('#phonespan').html("<font color=\"#FF6A6A\" size=\"2\">请输入正确格式的手机号码</font>");
			}else{
				$(this).siblings("span").hide();
			}
		}
		var regidCard = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
		if($(this).is("#idnum")){
			if(!regidCard.test(this.value)){
				$(this).siblings("span").show();
				$('#idCardspan').html(
				"<font color=\"#FF6A6A\" size=\"2\">请输入正确格式的身份证号码</font>");
			}else{
				$(this).siblings("span").hide();
			}
		}
		$(this).siblings('span').css('display')=='block'?
				$(this).siblings('span').addClass('active1'):
					$(this).siblings('span').removeClass('active1');
				$(".user-form >div >span").hasClass('active1')?(
						$(".btn1-users").attr('readonly','readonly'),
						$(".btn1-users").css('cursor','not-allowed'),
						$('#btn-users').css('background','#ccc')
				):(
						$(".btn1-users").removeAttr('readonly'),
						$(".btn1-users").css('cursor','pointer'),
						$('#btn-users').css('background','#2aadff')
				);
	}).keyup(function(){
		$(this).triggerHandler("blur");
	}).focus(function(){
		$(this).triggerHandler("blur");
	});*/
	//密码验证
	/*$(".user-form2 :input").blur(function(){
			if($(this).is("#password")){
				pwdval1 = $("#password").val();
				  if(pwdval1==""){
					$(this).siblings("span").text("密码不能为空").show();
				}else{
					if(pwdval2==pwdval1){
						$('#span2').text("新密码不能与原密码相同").show();
					}
					$(this).siblings("span").hide();
				}
			}
			if($(this).is("#new-password")){
				pwdval2 = $("#new-password").val();
				pwdlen2 = $("#new-password").val().length;
				var reg=/(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{6,}/;//修改提示错误
				if(pwdval2==pwdval1){
					$(this).siblings("span").text("新密码不能与原密码相同").show();
				}else{
					if(pwdlen2<6){
						$(this).siblings("span").text("密码过短").show();	
					}else{
						if(pwdlen2>18){
							$(this).siblings("span").text("密码过长").show();
						}else{
							if(!reg.test(this.value)){
								$(this).siblings("span").text("密码格式不对").show();
							}else{
								$(this).siblings("span").hide();
							}
						}
					}
				}
			}
			if($(this).is("#new-password1")){
				pwdval3 = $("#new-password1").val();
				pwdlen3 = $("#new-password1").val().length;
				if(pwdval3!=pwdval2){
					$(this).siblings("span").text("和原密码输入不一致").show();
				}else{
					if(pwdlen3<6||pwdlen3>18){
						$(this).siblings("span").text("输入错误").show();
					}else{
						$(this).siblings("span").hide();
					}
				}
			}
			$(this).siblings('span').css('display')=='block'?
			$(this).siblings('span').addClass('active2'):
			$(this).siblings('span').removeClass('active2');
		}).keyup(function(){
           $(this).triggerHandler("blur");
        }).focus(function(){
             $(this).triggerHandler("blur");
        });*/

	//密码是否显示
	$(".user-passwd >p >img").click(function(){
		var Input = $(this).parent().siblings("input");
		Input.hasClass('active1')?(
				Input.attr('type','password'),
				Input.removeClass('active1'),
				$(this).attr("src","img/userinfo/close.png")
		):(
				Input.attr('type','text'),
				$(this).attr("src","img/userinfo/open.png"),
				Input.addClass('active1')
		)
	})



	$("#btn-userg").click(function(){
		$("#truename").val("");
		$("#telephone").val("");
		$("#idnum").val("");
	});


	//只修改密码！
	$(".save-succ").hide();		
	var timeoutName;
	var passflag = 0;
	var newpflag = 0;
	var newpflags = 0;
	$("#btn-users2").click(function(){
		if($(this).find('input').attr('readonly') != undefined) {
			console.log('readonly');
			return;
		}
		$(".user-form2 :input").triggerHandler("blur");
		if($("#password").val().length==0){
			$('#span1').show();
		}
		if($("#new-password").val().length==0){
			$('#span2').show();
		}
		if($("#new-password1").val().length==0){
			$('#span3').show();
			return;
		}
		debugger
		if($("#password").val().length==0||$("#new-password").val().length==0||$("#new-password1").val().length==0){
			return;
		}
		if($(".user-form2 >div >span").hasClass('active2')) {
			return;
		}
		if(passflag==0&&newpflag==0&&newpflags==0){
			var con = confirm("您确定要修改密码？");
			if(con == true){
				$.ajax({
					type : 'POST',
					url :"filter/personal/checkPsw",
					data : {
						oldPsw : $("#password").val(),
						newpassword : $("#new-password").val(),
					},
					dataType : 'json',
					success : function(data) {
						if(data.message == 0) {
							$('#alertInfo').text('原密码不正确');
							$('#alertInfo').css('background','red');
							$(".save-succ").show();	
							clearTimeout(timeoutName);
							timeoutName = setTimeout(function(){
								$(".save-succ").hide();
							},3000);
						} else {
							$('#alertInfo').css('background','#98D1F5');
							$('#alertInfo').text('密码保存成功');
							$(".save-succ").show();	
							if(timeoutName != undefined) {
								clearTimeout(timeoutName);
							}
							timeoutName = setTimeout(function(){
								$(".save-succ").hide();
							},3000);
							$("#password").val("");
							$("#new-password").val("");
							$("#new-password1").val("");
							window.location.href = "login/logout";
						}
					}
				});
			}
		}else{
			alert("请输入合法的密码！");
		}
	});

	$(".header-title").find("li").eq(1).click(function(){
		$("#btn-users2").addClass("btn-user");
	})
	/*------------------------------------------*/
	$('#password').blur(function(){
		var pasword = $('#password').val();
		if(pasword==""){
			$("#span1").html("密码不能为空").show();
			passflag = 1;
		}else{
			$("#span1").html("").hide();
			passflag = 0;
		}
	})
	
	$('#new-password').blur(function(){
		var newpasword = $('#new-password').val();
		var reg=/(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{6,}/;//修改提示错误
		if(newpasword!=""){
			if(newpasword.length<6||newpasword.length>18){
				$('#span2').html("密码的长度为6-18位").show();
				newpflag = 1;
			}else if(!reg.test(this.value)){
				$('#span2').html("请输入合法的密码").show();
				newpflag = 1;
			}else{
				$('#span2').html("").hide();
				newpflag = 0;
			}
		}else{
			$('#span2').html("密码不能为空").show();
			newpflag = 1;
		}
	}) 
	
	$("#new-password1").blur(function(){
		var newpasword = $('#new-password').val();
		var newpasword1 = $('#new-password1').val();
		if(newpasword!=newpasword1){
			$("#span3").html("2次密码不一致").show();
			newpflags = 1;
		}else{
			$("#span3").html("").hide();
			newpflag = 0;
		}
	})
	var tnflag = 0;
	$("#truename").blur(function(){
		var name = $("#truename").val();
		var regname = /^([\u4e00-\u9fa5]+|([a-zA-Z]+\s?)+)$/;
		if(name.length>15){
			$('#namespan').html("<font color=\"#FF6A6A\" size=\"2\">姓名长度不能大于15个汉字或15个字母</font>").show();
			tnflag = 1;
		}else{
			if(!regname.test(name)){
				$('#namespan').html("<font color=\"#FF6A6A\" size=\"2\">请输入正确的姓名</font>").show();
				tnflag = 1;
			}else{
				$('#namespan').html("").hide();
				tnflag = 0;
			}
		}
	})
	var phflag = 0;
	$('#telephone').blur(function(){
		var phone = $("#telephone").val();
		var regphone = /^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if(!regphone.test(this.value)){
			$('#phonespan').html("<font color=\"#FF6A6A\" size=\"2\">请输入正确格式的手机号码</font>").show();
			phflag = 1;
		}else{
			$('#phonespan').html("").hide();
			phflag = 0;
		}
	})
	var idflag = 0;
	$("#idnum").blur(function(){
		var idnum = $("#idnum").val();
		var regidCard = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
		if(idnum!=""){
			if(!regidCard.test(idnum)){
				$('#idCardspan').html("<font color=\"#FF6A6A\" size=\"2\">请输入正确格式的身份证号码</font>").show();
				idflag = 1;
			}else{
				$('#idCardspan').html("").hide();
				idflag = 0;
			}
		}else{
			$('#idCardspan').html("").hide();
			idflag = 0;
		}
	})
	var ageflag = 0;
	$("#age").blur(function(){
		var reage = /^\d+$/;
		var age = $("#age").val();
		if(age.length<=2&&age.length>=1&&reage.test(age)){
			$('#agespan').html("").hide();
			ageflag = 0;
		}else{
			$('#agespan').html("<font color=\"#FF6A6A\" size=\"2\">请输入合法的年龄</font>").show();
			ageflag = 1;
		}
	})
	var eflag = 0;
	$("#email").blur(function(){
		var remail = /\w@\w*\.\w/;
		var email = $("#email").val();
		if(!remail.test(email)){
			$('#emailspan').html("<font color=\"#FF6A6A\" size=\"2\">请输入合法的邮箱</font>").show();
			eflag = 1;
		}else{
			$('#emailspan').html("").hide();
			eflag = 0;
		}
	})
	
	//修改个人信息，不修改
	$("#btn-users").click(function(){
		if(tnflag==0&&eflag==0&&ageflag==0&&idflag==0&&phflag==0){
			var con = confirm("您确定要修改个人信息？");
			if(con==true){
				$.ajax({
					type : 'POST',
					url :"filter/personal/updateInfo",
					data : {
						name : $("#truename").val(),
						phone : $("#telephone").val(),
						idCard : $("#idnum").val(),
						sex : $("#sex").val(),
						age : $("#age").val(),
						email : $("#email").val(),
					},
					dataType : 'json',
					success : function(data) {
					}
				});
			}
		}else{
			alert("请填写正确的信息！");
		}
	});
	
	$(".btn-userg").click(function(){
		window.location.reload();
	})
	
	$('#project_ul > li').click(function(){
		var gender = $(this).html();
		$('#sex').val(gender);
	})
	
})
function downMenu(clickClass,dropMenu){
    $(clickClass).click(function(event){
        event=event||window.event;
        event.stopPropagation();
        $(dropMenu).toggle();
    });
    $(dropMenu).click(function(){
        $(dropMenu).toggle();
    });
    $(document).click(function(e){
        $(dropMenu).hide();
    });
  }	




