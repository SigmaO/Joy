<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="template/1.0/header.jsp"/>
<style>
    .btn_new_comer_wrap{
        position: relative;
        width: 400px;
        display: inline-block;
        text-align: center;
        z-index: 1;
    }
    .btn_new_comer{
        display: inline-block;
        margin-top:-15px;
        color:#c00;
        padding:2px;
        background: url("img/new_comer.png") no-repeat;
        width: 150px;
        height:50px;
    }
    #signup_box{
        margin-top: 700px;
        display: none;
    }
    #btn_new_comer{

    }
</style>
<script>
$(function(){
	$("#btn_remember_me").click(function(){
		$(this).toggleClass("off");
	});
    $(".btn_new_comer").click(function(){
        $(".login_block").animate({
            "margin-top":"-500px"
        })
        $("#signin_box,.btn_new_comer_wrap").fadeOut(600);
        setTimeout($("#signup_box").css("display","inline-block").fadeIn(),600);
    })
	$("#btn_login").click(function(){
		for(i=0;i<=3;i++){
			$("#login_box").stop().animate({
				left:-(21-7*i)
			},50).animate({
				left:21-7*i
			},50)
		}
	})
})
</script>

<div class="login_block">
    <br />
	<div id="signin_box" class="login_box">
        <div class="row">
            <div class="col-md-12">
			    <input type="text" class="input_signIn" placeholder="用户编码" />
		    </div>
        </div>
        <div class="row">
            <div class="col-md-12">
			<input type="password"  class="input_signIn" placeholder="密码"/>
            </div>
        </div>
		<div class="remember_forgot">
			<div class="remember_wrap">
				<a id="btn_remember_me" class="btn_switch" ></a><label>记住我</label>
			</div>
			<div class="forgot_wrap">
				<a href="javascript:void(0)">忘了？</a>
			</div>
		</div>
		<button id="btn_login" class="btn btn-default btn_signIn" type="button">登陆</button>
	</div>
    <br />
    <div class="btn_new_comer_wrap">
        <a class="btn_new_comer"></a>
    </div>
    <br /><br />
    <div id="signup_box" class="login_box">
        <div class="row">
            <div class="col-md-12">
                新商户入驻<hr />
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <input type="text" class="input_signIn" placeholder="商家名称" />
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <input type="text" class="input_signIn" placeholder="邮件地址" />
            </div>
        </div>
        <button class="btn btn-default btn_signIn" type="button">注册</button>
    </div>
</div>
<jsp:include page="template/1.0/footer.jsp"/>