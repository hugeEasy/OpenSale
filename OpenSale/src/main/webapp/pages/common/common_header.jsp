<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<!-- topbar starts -->


<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand"  href="filter/view/index"> 
      		<img alt="Charisma Logo" src="plugin/img/logo20.png" class="hidden-xs" />
			<span>OpenSale业务后台管理</span></a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
       
			    <li><a class="ajax-link mytop" href="filter/personal/userinfo" id="userinfo" >个人资料</a></li>
				<li><a class="ajax-link mytop" href="filter/personal/forgetPsw" id="forgetPsw">忘记密码</a></li>
				<li><a calss="ajax-link mytop" href="login/logout" id="logout">注销</a></li>
			
      </ul>
    </div>
  </div>
</nav>

<!-- topbar ends -->
<div class="ch-container">
	<div class="row" style="min-height: 500px;">

		<!-- left menu starts -->
		<div class="col-sm-2 col-lg-2 out-l">
			<div class="sidebar-nav" style="min-height: 450px;">
				<div class="nav-canvas">
					<div class="nav-sm nav nav-stacked"></div>
					<ul class="nav nav-pills nav-stacked main-menu">
					
					
					
					<li class="accordion"><a href="#"><span>API管理</span></a>
						 <ul class="nav nav-pills nav-stacked">
                          <li><a class="ajax-link" href="api/getApi" id="orderManger">测试1</a></li>
						  <li><a class="ajax-link"  href="hello/getStudent.do">测试2</a></li>
						  <li><a class="ajax-link"  href="hello/getInfo.do">测试2</a></li>
						 </ul>
						</li>
						
					<li class="accordion"><a href="#"><span>账单管理</span></a>
						  <ul class="nav nav-pills nav-stacked">
						      <li><a class="ajax-link" href="filter/account/showCompanyAccount">公司账单</a>
						      <li><a class="ajax-link" href="filter/account/showPersonAccount">个人账单</a>
                              <li><a class="ajax-link" href="filter/bookorder/addBill" id="addBill">挂账</a></li>
                              <li><a class="ajax-link" href="filter/billSearch/showBill" id="showBill">查询挂账</a>
                              </li>
						  </ul>	
					</li>	
				</div>
			</div>
		</div>



