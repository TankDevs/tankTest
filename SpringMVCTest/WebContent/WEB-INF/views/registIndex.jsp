<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册</title>

<link rel="stylesheet" type="text/css" href="jquery-easyui/demo.css">

<link rel="stylesheet" type="text/css"
    href="jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
    href="jquery-easyui/themes/icon.css">

<script type="text/javascript" src="jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui/jquery.easyui.min.js"></script>
</head>
<body>
    <div style="margin: 20px 0;"></div>
    <div class="easyui-panel" title="注册"
        style="width: 100%; max-width: 400px; padding: 30px 60px;">
        <form id="ff" action="regist.spring" method="post">
            <div style="margin-bottom: 20px">
                <input class="easyui-textbox" name="username"
                    style="width: 100%"
                    data-options="label:'Name:',required:true">
            </div>

            <div style="margin-bottom: 20px">
                <input class="easyui-textbox" name="password"
                    style="width: 100%"
                    data-options="label:'Subject:',required:true">
            </div>
            <div style="margin-bottom: 20px">
                <input class="easyui-textbox" name="message"
                    style="width: 100%; height: 60px"
                    data-options="label:'Message:',multiline:true">
            </div>
            <div style="margin-bottom: 20px">
                <select class="easyui-combobox" name="language"
                    label="Language" style="width: 100%"><option
                        value="ar">Arabic</option>
                    <option value="bg">Bulgarian</option>
                    <option value="ca">Catalan</option>
                    <option value="zh-cht">Chinese Traditional</option>
                    <option value="cs">Czech</option>
                    <option value="da">Danish</option>
                    <option value="nl">Dutch</option>
                    <option value="en" selected="selected">English</option>
                    <option value="et">Estonian</option>
                    <option value="fi">Finnish</option>
                    <option value="fr">French</option>
                    <option value="de">German</option>
                    <option value="el">Greek</option>
                    <option value="ht">Haitian Creole</option>
                    <option value="he">Hebrew</option>
                    <option value="hi">Hindi</option>
                    <option value="mww">Hmong Daw</option>
                    <option value="hu">Hungarian</option>
                    <option value="id">Indonesian</option>
                    <option value="it">Italian</option>
                    <option value="ja">Japanese</option>
                    <option value="ko">Korean</option>
                    <option value="lv">Latvian</option>
                    <option value="lt">Lithuanian</option>
                    <option value="no">Norwegian</option>
                    <option value="fa">Persian</option>
                    <option value="pl">Polish</option>
                    <option value="pt">Portuguese</option>
                    <option value="ro">Romanian</option>
                    <option value="ru">Russian</option>
                    <option value="sk">Slovak</option>
                    <option value="sl">Slovenian</option>
                    <option value="es">Spanish</option>
                    <option value="sv">Swedish</option>
                    <option value="th">Thai</option>
                    <option value="tr">Turkish</option>
                    <option value="uk">Ukrainian</option>
                    <option value="vi">Vietnamese</option></select>
            </div>
            <input type="submit" value="提交">
        </form>

    </div>
    <script>
                    
                </script>
</body>
</html>