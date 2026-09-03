<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sistema IoT - Inicio</title>
</head>
<body>
    <h1>Sistema de Monitoreo Industrial IoT</h1>
    <h2>Seleccione el módulo a gestionar:</h2>

    <ul>
        <li><a href="<%= request.getContextPath() %>/devices">Gestión de Dispositivos</a></li>
        <li><a href="<%= request.getContextPath() %>/measurements">Gestión de Mediciones</a></li>
    </ul>
</body>
</html>