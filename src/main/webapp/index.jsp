<html>
<body>
<h2>Excel parsing application</h2>
<h4>Press to parse file</h4>
<script type="text/javascript">
   function AjaxCallServlet() {
       var oReq = new XMLHttpRequest();
       oReq.onreadystatechange = function () {
           if(oReq.readyState == 4 && oReq.status == 200) {
               document.getElementById("somediv").innerHTML = oReq.responseText;
           }
       }
       oReq.open('GET', '/WebApp/ParseServlet', true);
       oReq.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
       oReq.send();
   }
</script>
<button onclick="AjaxCallServlet()">Parse file</button>
<div id="somediv"></div><br><br>
<form action="get">
    <select name="class">
        <option disabled>Choose a class</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
        <option>6</option>
        <option>7</option>
        <option>8</option>
        <option>9</option>
    </select>
    <input type="submit" value="Submit">
</form>
</body>
</html>
