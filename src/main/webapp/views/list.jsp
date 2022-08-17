<%@ page import="org.example.Dao.DaoClass" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.entity.Class1" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 8/16/2022
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
    <script>$(document).ready( function () {
        $('#table_id').DataTable();
    } );</script>
    <title>Таблица Класса ${ClassName}</title>

</head>
<body>
<table id="table_id" class="display">
    <thead>
    <tr>
        <th rowspan="2">Б/сч</th>
        <th colspan="2">ВХОДЯЩЕЕ САЛЬДО</th>
        <th colspan="2">ОБОРОТЫ</th>
        <th colspan="2">ИСХОДЯЩЕЕ САЛЬДО</th>
    </tr>
    <tr>
        <th>Актив</th>
        <th>Пассив</th>
        <th>Дебит</th>
        <th>Кредит</th>
        <th>Актив</th>
        <th>Пассив</th>
    </tr>
    </thead>
    <tbody id="tbody">
    <%
        DaoClass dao = new DaoClass();
        List<Class1> class1 = dao.getClass((String) request.getAttribute("ClassName"));
        for(int r = 0; r < class1.size(); r++) {
            out.println("<tr>");
            for(int d = 0; d < 7; d++) {
                switch(d) {
                    case 0: out.println("<td>" + class1.get(r).getFirstLine() + "</td>"); break;
                    case 1: out.println("<td>" + class1.get(r).getSaldoInActiv() + "</td>"); break;
                    case 2: out.println("<td>" + class1.get(r).getSaldoInPassiv() + "</td>"); break;
                    case 3: out.println("<td>" + class1.get(r).getDebit() + "</td>"); break;
                    case 4: out.println("<td>" + class1.get(r).getCredit() + "</td>"); break;
                    case 5: out.println("<td>" + class1.get(r).getSaldoOutActiv() + "</td>"); break;
                    case 6: out.println("<td>" + class1.get(r).getSaldoOutPassiv() + "</td>"); break;
                }
            }
            out.println("</tr>");
        }
    %>
    </tbody>
</table>
</body>
</html>
