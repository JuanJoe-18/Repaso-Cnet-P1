<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mediciones</title>
</head>
<body>
    <h1>Gestión de Mediciones</h1>
    
    <c:if test="${not empty error}">
        <p style="color:red; font-weight:bold;">${error}</p>
    </c:if>

    <h3>Registrar Medición</h3>
    <form method="post">
        Id: <input name="id" type="number" required> <br>
        Timestamp: <input name="timestamp" type="number" required> <br>
        Valor: <input name="valor" type="number" step="any" required> <br>
        AssetId: <input name="assetId" type="number" required> <br>
        <br>
        <button type="submit">Guardar</button>
    </form>

    <hr>
    
    <h3>Lista de Mediciones</h3>
    <ul>
        <c:forEach var="m" items="${measurements}">
            <li>[ID: ${m.id}] Timestamp: ${m.timestamp} - Valor: ${m.valor} (Asset: ${m.assetId})</li>
        </c:forEach>
    </ul>
    
    <br>
    <a href="<%= request.getContextPath() %>/">Volver al Inicio</a> | 
    <a href="<%= request.getContextPath() %>/devices">Ver Dispositivos</a>
</body>
</html>
