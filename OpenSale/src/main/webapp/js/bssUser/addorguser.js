$(function(){
	shownorguser();
	$('#formParam').val($('#userorg').serialize());
	$('#backorg').click(function(){
		$('#content').load('filter/bssuser/backorgan?page='+$(this).attr('orgpage')+"&orgname=");
	})
	
	$('#findOrguser').click(function(){
		$('#formParam').val($('#userorg').serialize());
		$('#textspan').hide();
		$('#orgusertable').load('filter/bssuser/showorgusers',$('#userorg').serialize(), function(){
			$('.pagination>li>a').on('click', pageFunc);
		});
	})
	
	$('#orguserName').focus(function(){
		$('#textspan').hide();
	})
	
	$('#addOrguser').click(function(){
		$("#adduserdialog").dialog({ modal:true,autoOpen: true,height:'auto', width:329,resizable:false,
			close:function(){
				$('#adduserdialog').dialog('destroy');
			}});
	})
	
	$('#sure').click(function(){
		var curCheckBox = document.getElementsByName("usercheck");
		var addidlist = [] ;
		for(var i = 0; i < curCheckBox.length; i++){
			if(curCheckBox.item(i).checked==true){
				addidlist+=curCheckBox.item(i).value+";";
			}
		}
		if(addidlist.length==0){
			alert("请选择成员!")
		}else{
			$('#orgusertable').load('filter/bssuser/addorguser?userid='+addidlist+'&orgid='+orgid+'&page='+$('#page').val());
			$('#adduserdialog').dialog('destroy');
		}
	})
	
	$('#return').click(function(){
		$('#adduserdialog').dialog('destroy');
	})
	
	$('#deleteOrguser').click(function(){
		var curCheckBox = document.getElementsByName("check");
		var idlist = [] ;
		for(var i = 0; i < curCheckBox.length; i++){
			if(curCheckBox.item(i).checked==true){
				idlist+=curCheckBox.item(i).value+";";
			}
		}
		if(idlist.length==0){
			alert("请选择需要删除的成员")
		}else{
			var form = confirm("你确定要删除这些成员!")
			if(form==true){
				$('#orgusertable').load('filter/bssuser/deleteorguser?userid='+idlist+'&orgid='+orgid+'&page='+$('#page').val());
			}
		}
	})
})
function check(temp){
	var curCheckBox = document.getElementsByName("check");
	for(var i = 0; i < curCheckBox.length; i++){
		curCheckBox.item(i).checked = temp.checked;
	}
}
function shownorguser(){
	$.ajax({
		url :"filter/bssuser/shownorguser",
		type : "POST",
		dataType : 'json',
		data : {},
		success : function(data){
			var str = "";
			$("#usertable").html(str);
			for(var i=0;i<data.length;i++){
				str = "<tr>" +
						"<td><input type=\"checkbox\" name=\"usercheck\" value="+data[i].adminId+"></td>" +
						"<td>"+data[i].adminRname+"</td>"+
                       "</tr>"
				$("#usertable").append(str);		
			}
		}
	});
}