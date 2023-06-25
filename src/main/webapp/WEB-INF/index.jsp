<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ninja Gold Name</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="row">
        <h2>Your Gold:</h2>
        <span><c:out value="${gold}"/></span>
    </div>
    <br>
    <div class="row space">
        <form class="Gold" action="/farm" method="post">
            <h2>Farm</h2>
            <p>(earns 10-20 gold)</p>
            <button>Find Gold</button>
        </form>
        <form class="Gold" action="/cave" method="post">
            <h2>Cave</h2>
            <p>(earns 5-10 gold)</p>
            <button>Find Gold</button>
        </form>
        <form class="Gold" action="/house" method="post">
            <h2>House</h2>
            <p>(earns 2-5 gold)</p>
            <button>Find Gold</button>
        </form>
        <form class="Gold" action="/quest" method="post">
            <h2>Quest</h2>
            <p>(earns/takes 0-50 gold)</p>
            <button>Find Gold</button>
        </form>
    </div>
    <h2>Activities:</h2>
    <div class="logs">
        <c:forEach items="${log}" var="oneLog">
            <c:if test = '${!oneLog.contains("failed")}'>
                <p class="success"><c:out value="${oneLog}"/></p>
            </c:if>
            <c:if test = '${oneLog.contains("failed")}'>
                <p class="failed"><c:out value="${oneLog}"/></p>
            </c:if>
        </c:forEach>
    </div>
</body>
</html>