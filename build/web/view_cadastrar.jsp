<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url = "topo.jsp" />

<div class="alert-success text-center espaco">
    Cadastrar Aluno
</div>

<form name="cadastrar" method="post" action="AlunosController">
    <div class="row">
        <div class="col-md-5 mb-3">
            <label>RA</label>
            <input
                class="form-control"
                placeholder="Ex.: 123"
                type="text"
                name="ra"
                value=""
                required /> <!-- força o preenchimento -->
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
                value=""
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
                value=""
                required /> <!-- força o preenchimento -->
        </div>
    </div>
    <div class="row">
        <div class="col-md-5 mb-3">
            <input type="hidden" name="operacao" value="Inserir" />
            <input
                class="form-control btn btn-sm btn-primary"
                type="submit"
                name="bt_enviar"
                value="Cadastrar" />
        </div>
    </div>
</form>
<c:import url = "rodape.jsp" />