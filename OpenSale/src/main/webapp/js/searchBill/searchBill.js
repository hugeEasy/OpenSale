$(function() {


	$('#forBillSearch').on('click',function(){
		/*$('#versionSearchCondition').val($('#forid').serialize());*/
		$('#tid').load("filter/billSearch/getBillSearch?page=0",$('#forBillId').serialize(), function(){
			$('.pagination>li>a').on('click', pageFunc);
		});
	})

});
