$(function() {
	$(".modifymember").on("click",function(){
		$("#mod_username").val('');
		$("#userId").val('');
//		$("#mod_userPhone").val('');
		$("#mod_username").val($(this).attr("data-username"));
		$("#mod_userId").val($(this).attr("data-userID"));
//		$("#mod_userPhone").val($(this).attr("data-userPhone"));
		$("#spmod_username").hide();
//		$("#spmod_userPhone").hide();
		$("#modify_member").dialog({ modal:true,autoOpen: true,height:'auto', width:390,resizable:false,
			close:function(){
				$('#modify_member').dialog('destroy');
			}});
	});
	$("#modify_sure").on("click",function(){
		$("#spmod_username").hide();
	//	$("#spmod_userPhone").hide();
    var userId=$("#mod_userId").val();
    var userName=$.trim($("#mod_username").val());
    var userPhone=$("#mod_userPhone").val();
    var re= /^(1[0-9]{10})$/;
    var boo1=userName.length<=15&&userName.length>0;
    if(boo1){
    	$('#modify_member').dialog('destroy');
    	$('#tid').load("filter/member/modifymember?userId="+userId+"&userName="+encodeURI(userName),function(){
			$('.pagination>li>a').on('click', pageFunc);
		});
    }else{
    	if(!boo1){
    		$("#spmod_username").show();
    		return ;
    	}
    }
	});
	$("#modify_esc").on("click",function(){
		$('#modify_member').dialog('destroy');
	});
	$(".removemember").on("click",function(){
		var userid=$(this).attr("data-userID");
		var companyid=$(this).attr("data-companyid");
		var userId=$("#userId").val();
		var companyId=$("#nomalCompanyId").val();
		var userName=$.trim($("#userName").val());
		var userPhone=$("#userPhone").val();
		 var sure=confirm("是否确认移除该成员");
		   if(sure){
			   $.ajax({
					url : 'filter/member/removeuser',
					type : 'POST',
					data : {
					"userId":userid,
					"companyId":companyid
					},
					cache : false,
					dataType : 'json',
					success : function(data) {
						if(data.message=="success"){
							alert("删除成功");
							$('#content').load("filter/member/memberShow?nomalCompanyId="+
									companyId+"&userId="+userId+"&userName="+userName+"&userPhone="+userPhone);
						}else if(data.message=="admin"){
							alert("请转让公司超级管理员的权限，才可以退出公司");
						}else if(data.message=="error"){
							alert("删除失败");
						}
					},
					error:function(data){
						alert("网络异常");
					}
				});
		   }
	})
});