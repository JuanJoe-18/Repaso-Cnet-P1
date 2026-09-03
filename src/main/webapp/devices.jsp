<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dispositivos</title>
</head>
<body>
    <h1>Gestión de Dispositivos</h1>
    
    <c:if test="${not empty error}">
        <p style="color:red; font-weight:bold;">${error}</p>
    </c:if>

    <c:choose>
        <c:when test="${not empty deviceToEdit}">
            <h3>Editar Dispositivo</h3>
            <form method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="${deviceToEdit.id}">
                
                Id: ${deviceToEdit.id} <br>
                Nombre: <input name="name" value="${deviceToEdit.name}" required> <br>
                Serial: <input name="serialNumber" value="${deviceToEdit.serialNumber}" required> <br>
                Tipo: <input name="type" value="${deviceToEdit.type}" required> <br>
                Mínimo: <input name="minValue" type="number" step="any" value="${deviceToEdit.minValue}" required> <br>
                Máximo: <input name="maxValue" type="number" step="any" value="${deviceToEdit.maxValue}" required> <br>
                Periodo: <input name="samplingPeriod" type="number" value="${deviceToEdit.samplingPeriod}" required> <br>
                Tolerancia: <input name="timeTolerance" type="number" value="${deviceToEdit.timeTolerance}" required> <br>
                Unidad: <input name="unit" value="${deviceToEdit.unit}" required> <br>
                Ubicación: <input name="ubicacion" value="${deviceToEdit.ubicacion}" required> <br>
                Estado: <input name="estate" value="${deviceToEdit.estate}" required> <br>
                <br>
                <button type="submit">Actualizar</button>
                <a href="?">Cancelar</a>
            </form>
        </c:when>
        <c:otherwise>
            <h3>Crear Dispositivo</h3>
            <form method="post">
                <input type="hidden" name="action" value="create">
                
                Id: <input name="id" type="number" required> <br>
                Nombre: <input name="name" required> <br>
                Serial: <input name="serialNumber" required> <br>
                Tipo: <input name="type" required> <br>
                Mínimo: <input name="minValue" type="number" step="any" required> <br>
                Máximo: <input name="maxValue" type="number" step="any" required> <br>
                Periodo: <input name="samplingPeriod" type="number" required> <br>
                Tolerancia: <input name="timeTolerance" type="number" required> <br>
                Unidad: <input name="unit" required> <br>
                Ubicación: <input name="ubicacion" required> <br>
                Estado: <input name="estate" required> <br>
                <br>
                <button type="submit">Guardar</button>
            </form>
        </c:otherwise>
    </c:choose>

    <hr>
    
    <h3>Lista de Dispositivos</h3>
    <ul>
        <c:forEach var="d" items="${devices}">
            <li>
                [ID: ${d.id}] ${d.name} - Serial: ${d.serialNumber} (Ubicación: ${d.ubicacion}, Estado: ${d.estate})
                
                <a href="?action=edit&id=${d.id}">[Editar]</a>
                
                <form method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${d.id}">
                    <button type="submit">[Borrar]</button>
                </form>
            </li>
        </c:forEach>
    </ul>
    
    <br>
    <a href="<%= request.getContextPath() %>/">Volver al Inicio</a> | 
    <a href="<%= request.getContextPath() %>/measurements">Ver Mediciones</a>
</body>
</html>
