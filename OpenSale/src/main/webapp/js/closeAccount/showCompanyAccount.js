//置为水贴、取消水贴事件
/*$('.change_forum').on('click',function(){
	var a = /^(\d{4})-(\d{2})-(\d{2})$/;
	var fromtime=document.getElementById("datetimepickerfrom").value; //起始时间
	var totime=document.getElementById("datetimepickerto").value; //截止时间
	var username=document.getElementById("username").value; //用户名
	var companyname=document.getElementById("companyname").value;//公司名
	var status=document.getElementById("forumstatus").value; //帖子状态
	var types=document.getElementById("forumtype").value; //帖子类型
	var forumtitle=document.getElementById("forumtitle").value; //帖子标题
	var forumId = $(this).attr('orderid');
	var page = $(this).attr('page');
	var confirms = confirm("确定置为水帖？");
	if(confirms==true){
		if (fromtime!=null&&fromtime!=""&&totime!=null&&totime!=""&&!a.test(document.getElementById("datetimepickerfrom").value)&&!a.test(document.getElementById("datetimepickerto").value)) { 
			alert("日期格式不正确!"); 
			}else{
				$('#content').load('filter/forum/change_forum?forumId='+forumId+'&cannotDel=0&page='+page+"&fourmtitle="+encodeURI(forumtitle)+"&username="+encodeURI(username)+"&companyname="+encodeURI(companyname)+"&fromtime="+fromtime+"&totime="+totime+"&status="+status+"&type="+types);
			} 
	}
});

$('.cancel_change_forum').on('click',function(){
	var a = /^(\d{4})-(\d{2})-(\d{2})$/;
	var fromtime=document.getElementById("datetimepickerfrom").value; //起始时间
	var totime=document.getElementById("datetimepickerto").value; //截止时间
	var username=document.getElementById("username").value; //用户名
	var companyname=document.getElementById("companyname").value;//公司名
	var status=document.getElementById("forumstatus").value; //帖子状态
	var types=document.getElementById("forumtype").value; //帖子类型
	var forumtitle=document.getElementById("forumtitle").value; //帖子标题
	var forumId = $(this).attr('orderid');
//	var cannotdel = $(this).attr('cannotdel');
	var page = $(this).attr('page');
	var confirms = confirm("确定置为正常帖？");
	if(confirms==true){
		if (fromtime!=null&&fromtime!=""&&totime!=null&&totime!=""&&!a.test(document.getElementById("datetimepickerfrom").value)&&!a.test(document.getElementById("datetimepickerto").value)) { 
			alert("日期格式不正确!"); 
			}else{
				$('#content').load('filter/forum/change_forum?forumId='+forumId+'&cannotDel=1&page='+page+"&fourmtitle="+encodeURI(forumtitle)+"&username="+encodeURI(username)+"&companyname="+encodeURI(companyname)+"&fromtime="+fromtime+"&totime="+totime+"&status="+status+"&type="+types);
			} 
	}
});*/


function findAccounts(){
	var companyname=$.trim($("#companyname").val());//公司名
	if($.trim(companyname).length>0){
		$.ajax({
			url:"filter/account/queryCompany",
			dataType:"json",
			type:"POST",
			data:{
				"companyName":companyname
			},cache:false,
			success:function(data){	
				if(data.message=="1"){
					$("#hiddencompa").val(data.lists[0].companyId);
					$('#fourm_table').load("filter/account/queryCompanyAccountfir?&companyId="+data.lists[0].companyId, function(){
						$('.pagination>li>a').on('click', pageFunc);
					});
				}else{
					if(data.message=="true"){
						var departmentList4 = Handlebars.compile($("#companyselect").html());
						$('#companyId').html(departmentList4(data.lists));
						$("#selectcomp").dialog({ modal:true,autoOpen: true,height:'auto', width:390,resizable:false,
							close:function(){
								$('#selectcomp').dialog('destroy');
							}});
					 
					}else{
						if(data.message=="0"){
							alert("对不起，没有查到任何信息！")
						};
					}
				}
			},error : function(data) {
			}
		});
	}else{
		alert("请输入公司名");
	}
//	$('#content').load("filter/account/showCompanyAccount?&companyName="+encodeURI(companyname));
	
	
	
};


function closeCompanyAccount(){	
	var companyname=$("#companyname").val();//公司名
	if($.trim(companyname).length>0){
		$.ajax({
			url:"filter/account/queryCompany",
			dataType:"json",
			type:"POST",
			data:{
				"companyName":companyname
			},cache:false,
			success:function(data){	
				if(data.message=="1"){
					var departmentList4 = Handlebars.compile($("#companycloseselect").html());
					$('#companyIdclose').html(departmentList4(data.lists));
					$("#selectclosecom").dialog({ modal:true,autoOpen: true,height:'auto', width:390,resizable:false,
						close:function(){
							$('#selectclosecom').dialog('destroy');
						}});
					
					
				}else{
					if(data.message=="true"){
						var departmentList4 = Handlebars.compile($("#companycloseselect").html());
						$('#companyIdclose').html(departmentList4(data.lists));
						$("#selectclosecom").dialog({ modal:true,autoOpen: true,height:'auto', width:390,resizable:false,
							close:function(){
								$('#selectclosecom').dialog('destroy');
							}});
					 
					}else{
						if(data.message=="0"){
							alert("对不起，没有查到任何信息！")
						};
					}
				}
			},error : function(data) {
			}
		});
	}else{
		alert("请输入公司名");
	}
	
	
//	var companyname=$("#companyname").val();//输入的公司名
//	var companyName=$("#company").val();//查询出的公司名
//	var companyId=$("#hiddencompa").val();
//	if(companyName!=null&&companyName!=""){
//		$('#content').load("filter/account/closeCompanyAccount?companyId="+companyId+"&billMonth=");
//	}else if(companyname!=null&&companyname!=""){
//		$('#content').load("filter/account/closeCompanyAccount?companyId="+companyId+"&billMonth=");
//	}else {
//		alert("请输入要结账的公司名！");
//	}
}


