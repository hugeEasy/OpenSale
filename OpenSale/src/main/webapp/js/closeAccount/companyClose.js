
$(function(){
			$('.printButton').click(function(){
				$('#printInfo').css('box-shadow','none');
				$('#printInfo').jqprint();
			});
			$(".closaccountButton").click(function(){
				var billMonth=$("#billMonth").val();
				var companyId=$("#companyId").val();
				var unsettlementFee=$("#unsettlementFee").val();
				var unsettlementRPkg=$("#unsettlementRPkg").val(); 
				var unsettlementMPkg=$("#unsettlementMPkg").val();
				$.ajax({
					url:"filter/account/companyCheckout",
					dataType:"json",
					type:"POST",
					data:{
						"companyId":companyId,
						"billMonth":billMonth,
						"unsettlementFee":unsettlementFee,
						"unsettlementRPkg":unsettlementRPkg,
						"unsettlementMPkg":unsettlementMPkg
					},cache:false,
					success:function(data){
						if(data.message=="true"){
							$('#content').load("filter/account/closeCompanyAccount?companyId="+companyId+"&billMonth="+billMonth); ;  
							alert("结账成功");
						}else if(data.message == "4002"){
							alert("账户余额不足");
						}else{
							alert("结账失败");
						}
					},error : function(data) {
						
					}
				});
				
			});
			
			
		});
