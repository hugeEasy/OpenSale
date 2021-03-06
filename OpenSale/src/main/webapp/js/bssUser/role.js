$(function(){
	$('#formParam').val($('#roleform').serialize());
	$('#addRole').on('click',function(){
		$("#addRoledialog").dialog({ modal:true,autoOpen: true,height:'auto', width:344,resizable:false,
			close:function(){
				$('#addRoledialog').dialog('destroy');
			}});
		$('#rolename').val('');
		$('#desc').val('');
	    $('#rolenames').val('')
		$('#roleid').val('0');
		$('#descspan').html('');
		$('#Roname').html('');
	})
	$('#return').on('click',function(){
		$('#addRoledialog').dialog('destroy');
	})
	
	$('.updateRole').on('click',function(){
		$("#addRoledialog").dialog({ modal:true,autoOpen: true,height:'auto', width:344,resizable:false,
			close:function(){
				$('#addRoledialog').dialog('destroy');
			}});
		$('#rolenames').val($(this).attr('rolename'));
		$('#desc').val($(this).attr('desc'));
		$('#roleid').val($(this).attr('roleid'));
		$('#descspan').html('');
		$('#Roname').html('');
	})
	
	$('#formcheck').on('click',function(){
		var rolename = $('#rolenames').val();
		var desc = $('#desc').val();
		var page = $('#page').val();
		var roleid = $('#roleid').val();
		var roname = 0;
		if(rolename==""){
			$('#Roname').style = "18px";
			$('#Roname').html('X');
			$('#Roname').css("color","red");
			roname = 0;
		}else{
			$('#Roname').style = "18px";
			$('#Roname').html('√');
			$('#Roname').css("color","green");
			roname = 1;
		}
		var des = 0;
		if(desc==""){
			$('#descspan').style = "18px";
			$('#descspan').html('X');
			$('#descspan').css("color","red");
			des = 0;
		}else{
			$('#descspan').style = "18px";
			$('#descspan').html('√');
			$('#descspan').css("color","green");
			des = 1;
		}
		if(roname==1&&des==1){
			var con = confirm("您确定添加或修改此角色？");
			if(con == true){
//				$('#content').load('filter/bssuser/saveOrupdateRole?rolename='+rolename+"&desc="+desc+
//						"&page="+page+"&roleid="+roleid);
				$.ajax({
					url :"filter/bssuser/saveOrupdateRole",
					type : "POST",
					dataType : 'json',
					data : {
						'rolename' : rolename,
						'desc' : desc,
						'roleid' :roleid,
						'page' :page
 					},
					success : function(data){
						if(data ==1){
							$('#addRoledialog').dialog('destroy');
						}else if(data == 2){
							alert("此角色名已经存在！");
						}else if(data == 3){
							alert("添加或修改失败！");
						}
					}
				});
			}
		}
	})
	
	$('.deleteROle').on('click',function(){
		var con = confirm("您确定删除该角色？")
		if(con==true){
			$('#content').load('filter/bssuser/deleteRole?roleid='+$(this).attr('roleid')+
			"&status=0");
		}
	})
	
	$('#findproject').on('click',function(){
		var rolename = $('#rolename').val();
		$('#formParam').val($('#roleform').serialize());
		$('#projectable').load("filter/bssuser/findUserRole",$('#roleform').serialize(), function(){
			$('.pagination>li>a').on('click', pageFunc);
		});
		$('#textspan').hide();
	})
	
	$('#rolename').on('focus',function(){
		$('#textspan').hide();
	})
})