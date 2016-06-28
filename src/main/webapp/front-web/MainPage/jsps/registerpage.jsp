<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User</title>


<script type="text/javascript">
    //添加用户
    function addUser() {
        var form = document.forms[0];
        form.action = "${pageContext.request.contextPath}/user/addUser1";
        //form.action = "${pageContext.request.contextPath}/user/addUser2";
        //form.action = "${pageContext.request.contextPath}/user/addUser3";
        form.method = "post";
        form.submit();
    }
</script>

</head>
<body>
    <form>
        <table>
            <tr>
                <td>账号</td>
                <td>
                    <input type="text" name="username">
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input type="password" name="password">
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>
                    <input type="button" value="提交" onclick="addUser()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>