<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url = "topo.jsp" />

<div class="alert-success text-center espaco">
    Editar Dados do Aluno
</div>
<c:forEach var="aluno" items="${listaAlunos}">
    <form name="cadastrar" method="post" action="AlunosController">
        <div class="row">
            <div class="col-md-5 mb-3">
                <label>RA</label><br>
                <label><strong>${aluno.ra}</strong></label>
            </div>
        </div>

        <div class="row">
            <div class="col-md-5 mb-3">
                <label>NOME</label>
                <input
                    class="form-control"
                    placeholder="Ex.: José da Silva"
                    type="text"
                    name="nome"
                    value="${aluno.nome}"
                    required /> <!-- força o preenchimento -->
            </div>
        </div>
        <div class="row">
            <div class="col-md-5 mb-3">
                <label>CURSO</label>
                <input
                    class="form-control"
                    placeholder="TADS"
                    type="text"
                    name="curso"
                    value="${aluno.curso}"
                    required /> <!-- força o preenchimento -->
            </div>
        </div>
        <div class="row">
            <div class="col-md-5 mb-3">
                <input type="hidden" name="operacao" value="Atualizar" />
                <input type="hidden" name="ra" value="${aluno.ra}" />

                <input
                    class="form-control btn btn-sm btn-primary"
                    type="submit"
                    name="bt_enviar"
                    value="Atualizar" />
            </div>
        </div>
    </form>
</c:forEach>
<c:import url = "rodape.jsp" />