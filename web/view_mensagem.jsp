<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url = "topo.jsp" />

<div class="alert-success text-center espaco">
    Tela de Mensagens
</div>

<!--
    A variável ${mensagem} vai receber um valor enviado
    pelo Controler Alunos
-->
<c:out value = "${mensagem}" />

<c:import url = "rodape.jsp" />