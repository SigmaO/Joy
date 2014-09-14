<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="template/1.0/header.jsp"/>
<div class="login_block">
    <div class="login_box">
        <div class="row">
            <div class="col-md-12">
            基本信息：<hr />
            </div>
        </div>
        <div class="row">
            <div class="col-md-8">
                <input type="text" class="input_signIn" placeholder="商家名称" />
            </div>
        </div>
        <div class="row">
            <div class="col-md-8">
                <input type="text" class="input_signIn" placeholder="邮件地址" />
            </div>
        </div>
        <button class="btn btn-default btn_signIn" type="button">注册</button>
    </div>
</div>
<jsp:include page="template/1.0/footer.jsp"/>