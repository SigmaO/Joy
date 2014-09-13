<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="template/1.0/header.jsp"/>
<style>
    #successInfo{
        vertical-align: middle;
        width:700px;
        text-align: center;
        margin:0 auto;
    }
    #successInfo p{
        text-align: left;
        display: inline-block;
        width: 700px;
    }
    .content_cn{
        text-indent: 2em;
    }
    .star_wrap i{
        position: absolute;
    }
    .star_wrap i.star1{
        font-size:50px;
        left:0px;
        top:20px;
    }
    .star_wrap i.star2{
        font-size:30px;
        left:120px;
        top:10px;
    }
    .star_wrap i.star3{
        font-size:40px;
        left:270px;
        top:20px;
    }
    .star_wrap i.star4{
        font-size:15px;
        left:400px;
        top:30px;
    }
    .star_wrap i.star5{
        font-size:12px;
        left:500px;
        top:50px;
    }
    .star_wrap i.star6{
        font-size:32px;
        left:600px;
        top:20px;
    }
    .star_wrap{
        display: block;
        position: relative;
        width: 700px;
        margin: 0 auto;
        margin-top: 50px;
        height: 150px;
        top:0px;
    }
</style>
<div class="star_wrap">
    <i class="star1 glyphicon glyphicon-star"></i>
    <i class="star2 glyphicon glyphicon-star"></i>
    <i class="star3 glyphicon glyphicon-star"></i>
    <i class="star4 glyphicon glyphicon-star"></i>
    <i class="star5 glyphicon glyphicon-star"></i>
    <i class="star6 glyphicon glyphicon-star"></i>
</div>
<div id="successInfo">
    <br /><br />
    <p>亲爱的意大利</p>
    <p class="content_cn">感谢您加入“XXX”，现在就去<a href="javascript:void(0)">邮箱验证</a>。</p>
</div>
<jsp:include page="template/1.0/footer.jsp"/>