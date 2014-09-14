<%@ page import="com.hijoy.web.SessionHandler" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    SessionHandler sessionHandler = new SessionHandler();

    String errMessage = sessionHandler.getSessionOnce("ERROR_MESSAGE");
    String email = sessionHandler.getSessionOnce("MERCHANT_EMAIL");
    String name = sessionHandler.getSessionOnce("MERCHANT_NAME");
%>
<jsp:include page="template/1.0/header.jsp" />
<link type="text/css" rel="stylesheet" href="/js/jQuery.ValidationEngine/2.6.2/css/validationEngine.jquery.css" />
<script type="text/javascript" src="/js/jQuery.ValidationEngine/2.6.2/js/jquery.validationEngine.min.js"> </script>
<script type="text/javascript" src="/js/jQuery.ValidationEngine/2.6.2/js/jquery.validationEngine-zh_CN.js"> </script>
<style>
.btn_new_comer_wrap,.btn_old_member_wrap {
	position: relative;
	width: 400px;
	display: inline-block;
	text-align: center;
	z-index: 1;
	height: 40px;
}

.btn_new_comer,.btn_old_member {
	display: inline-block;
	color: #c00;
	padding: 2px;
	width: 150px;
	height: 50px;
	cursor: pointer;
}

.btn_new_comer {
	background: url("img/new_comer.png") no-repeat;
	margin-top: -15px;
}

.btn_old_member {
	background: url("img/old_member.png") no-repeat;
	margin-bottom: -15px;
}

.signup_box_wrap,.signin_box_wrap {
	position: relative;
	top: 0px;
}
<%
int userType=0;
if(request.getParameter("userType")!=null){
    userType = Integer.parseInt(request.getParameter("userType"));
}
if(userType==0){
%>
.signin_box_wrap {
	display: none;
    top:-226px;
}
.signup_box_wrap {
    top:0px;
}
<%
}else{
%>
.signup_box_wrap {
    display: none;
    top:271px;
}
.signin_box_wrap {
    top:0px;
}
<%}%>
.box_wrap {
	overflow-y: hidden;
	display: inline-block;
	width: 600px;
	vertical-align: middle;
}
#btn_new_comer {
	
}
.err_info{
    font-size:12px;
    color: #c00;
    display: inline;
    position: absolute;
    top:0px;
    right: 0px;
    width: 200px;
    height: 20px;
}
.signIn_input.err{
    border:1px solid #c00;
}
</style>
<script>
	$(function() {
        function formFailure(){
            for (i = 0; i <= 3; i++) {
                $(".signup_box").stop().animate({
                    left : -(21 - 7 * i)
                }, 50).animate({
                    left : 21 - 7 * i
                }, 50)
            }
        }
        $("#signup_form").validationEngine({
            onFailure:formFailure
        }).submit(function(){$(this).validationEngine('validate');}
                );
		$("#btn_remember_me").click(function() {
			$(this).toggleClass("off");
		});
		$(".btn_new_comer").click(function() {
			$(".box_wrap").css({
				"height" : 271
			});
			$(".signin_box_wrap").animate({
				"top" : -$(".signin_box_wrap").height() - 50,
				opacity : 0
			}, 600);
			$(".signup_box_wrap").css({
				opacity : 0,
				display : 'inline-block'
			}).animate({
				opacity : 1,
				"top" : -$(".signin_box_wrap").height()
			}, 600);
		})
		$(".btn_old_member").click(function() {
			$(".box_wrap").css({
				"height" : 226
			});
			$(".signup_box_wrap").animate({
				"top" : $(".signup_box_wrap").height(),
				opacity : 0
			}, 600);
			$(".signin_box_wrap").css({
				opacity : 0,
				display : 'inline-block'
			}).animate({
				opacity : 1,
				"top" : 0
			}, 600);
		})
		$("#btn_login").click(function() {
			for (i = 0; i <= 3; i++) {
				$("#login_box").stop().animate({
					left : -(21 - 7 * i)
				}, 50).animate({
					left : 21 - 7 * i
				}, 50)
			}
		})
	})
</script>
<div class="login_block">

	<div class="box_wrap">
		<div class="signin_box_wrap">
			<div class="signin_box login_box">
				<div class="row">
					<div class="col-md-12">
						<input type="email" class="input_signIn" placeholder="用户编码" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<input type="password" class="input_signIn" placeholder="密码" />
					</div>
				</div>
				<div class="remember_forgot">
					<div class="remember_wrap">
						<a id="btn_remember_me" class="btn_switch"></a><label>记住我</label>
					</div>
					<div class="forgot_wrap">
						<a href="javascript:void(0)">忘了？</a>
					</div>
				</div>
				<button id="btn_login" class="btn btn-default btn_signIn"
					type="button">登陆</button>
			</div>
			<br />
			<div class="btn_new_comer_wrap">
				<a class="btn_new_comer"></a>
			</div>
		</div>

		<div class="signup_box_wrap">
			<div class="btn_old_member_wrap">
				<a class="btn_old_member"></a>
			</div>
			<form id="signup_form" action="/merchant/register" method="post"
				class="signup_box login_box ">
				<div class="row">
					<div class="col-md-12">
						新商户入驻
						<hr />
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<input name="merchant.name" type="text" class="input_signIn validate[required,minSize[6]]"
							placeholder="商家名称" value="<%=name%>" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<input name="merchant.email" type="text" class="input_signIn validate[required,custom[email]]"
							placeholder="邮件地址" value="<%=email%>"/>
					</div>
				</div>
                <div class="row">
                    <div class="col-md-4">
                        <input name="web.securityCode" type="text" class="input_signIn validate[required]"
                               placeholder="验证码" value="<%=errMessage%>"/>
                    </div>
                    <div class="col-md-4">
                        <img src="Security/SecurityCodeImageAction" id="Verify"  style="cursor:hand;" alt="看不清，换一张"/>
                    </div>
                </div>
				<button class="btn btn-default btn_signIn" type="submit">注册</button>
		</div>
	</div>
</div>
</div>
<jsp:include page="template/1.0/footer.jsp" />