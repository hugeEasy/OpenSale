$(function(){
	$('#formParam').val($('#orgform').serialize());
	$('#addOrgan').on('click',function(){
		$("#addOdialog").dialog({ modal:true,autoOpen: true,height:'auto', width:344,resizable:false,
			close:function(){
				$('#addOdialog').dialog('destroy');
			}});
	    $('#orgname').val();
		$('#desc').val();
		$('#status').val();
		$('#page').val();
		$('#orgid').val(0);
	})
	$('#return').on('click',function(){
		$('#addOdialog').dialog('destroy');
	})
	
	$('.updatePro').on('click',function(){
		$("#addOdialog").dialog({ modal:true,autoOpen: true,height:'auto', width:344,resizable:false,
			close:function(){
				$('#addOdialog').dialog('destroy');
			}});
		$('#orgname').val($(this).attr('orgname'));
		$('#desc').val($(this).attr('desc'));
		$('#orgid').val($(this).attr('orgid'));
	})
	
	$('#formcheck').on('click',function(){
		var orgname = $('#orgname').val();
		var desc = $('#desc').val();
		var status = $('#status').val();
		var page = $('#page').val();
		var orgid = $('#orgid').val();
		var nameflag = 0;
		var descflag = 0;
		if(orgname==""){
			$('#uname').style = "18px";
			$('#uname').html('X');
			$('#uname').css("color","red");
			nameflag = 0;
		}else{
			$('#uname').style = "18px";
			$('#uname').html('√');
			$('#uname').css("color","green");
			nameflag = 1;
		}
		if(desc==""){
			$('#descspan').style = "18px";
			$('#descspan').html('X');
			$('#descspan').css("color","red");
			descflag = 0;
		}else{
			$('#descspan').style = "18px";
			$('#descspan').html('√');
			$('#descspan').css("color","green");
			descflag = 1;
		}
		if(nameflag==1&&descflag==1){
			var con = confirm("您确定要添加或修改此组织？");
			if(con == true){
//				$('#content').load('filter/bssuser/saveOrupdateOrg?orgname='+encodeURI(orgname)+"&desc="+encodeURI(desc)+
//						"&page="+page+"&orgid="+orgid);
//				$('#addOdialog').dialog('destroy');
				$.ajax({
					url :"filter/bssuser/saveOrupdateOrg",
					type : "POST",
					dataType : 'json',
					data : {
						'orgname' : orgname,
						'desc' : desc,
						'orgid' :orgid,
 					},
					success : function(data){
						if(data ==1){
							$('#addOdialog').dialog('destroy');
							$('#orgname').val();
							$('#desc').val();
							$('#status').val();
							$('#page').val();
							$('#orgid').val(0);
						}else if(data == 2){
							alert("此组织已经存在！");
						}else if(data == 3){
							alert("操作失败！");
						}
					}
				});
			}
		}
	})
	
	$('.deletePro').on('click',function(){
		var con = confirm("您确定要删除此组织？");
		if(con==true){
			$('#content').load('filter/bssuser/deleteOrg?orgid='+$(this).attr('data-orgid')+
					"&status="+$(this).attr('data-status'));
		}
	})
	
	$('#findOrgan').on('click',function(){
		var orgname = $('#orgName').val();
		$('#textspan').hide();
		$('#formParam').val($('#orgform').serialize());
		$('#projectable').load("filter/bssuser/findOrgan",$('#orgform').serialize(), function(){
			$('.pagination>li>a').on('click', pageFunc);
		});
	})
	
	$('#orgName').on('focus',function(){
		$('#textspan').hide();
	})
	
	$('.addorguser').click(function(){
		$('#content').load('filter/bssuser/showorguser?page='+$(this).attr('data-page')+'&orgid='+$(this).attr('data-orgid')+"&orgname="+
				encodeURI($(this).attr('orgname')));
	})
})