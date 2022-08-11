package com.rest.hotel.config;

public enum EnumHttpStatus {
	
	OK (200, "Executado com sucesso", "Execução normal. A solicitação foi bem sucedida."),
    NO_CONTENT (204, "Requisição processada", "Requisição processada com sucesso."),
    BAD_REQUEST (400, "Requisição malformatada", "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL."),
    UNAUTHORIZAD (401, "Não Autorizado", "Cabeçalho de autenticação ausente/inválido ou token inválido"),
    FORBIDDEN (403, "Falha de Segurança", "O token tem escopo incorreto ou uma política de segurança foi violada"),
    NOT_FOUND (404, "Não Encontrado", "O recurso solicitado não existe ou não foi implementado"),
    METHOD_NOT_ALLOWED (405, "Método não suportado", "O consumidor tentou acessar o recurso com um método não suportado"),
    NOT_ACCEPTABLE (406, "Cabeçalho diferente", "A solicitação continha um cabeçalho Accept diferente dos tipos de mídia permitidos ou um conjunto de caracteres diferente de UTF-8"),
    REQUEST_TIMEOUT (408, "Tempo esgotado", "O servidor não pôde responder a requisição em tempo hábil."),
    UNSUPPORTED_MEDIA_TYPE (415, "Formato não suportado", "A operação foi recusada porque o payload está em um formato não suportado pelo endpoint."),
    UNPROCESSABLE_ENTITY (422, "Solicitação não processada", "A solicitação foi bem formada, mas não pôde ser processada devido à lógica de negócios específica da solicitação."),
    TOO_MANY_REQUEST (429, "Muitas requisições", "A operação foi recusada, pois muitas solicitações foram feitas dentro de um determinado período ou o limite global de requisições concorrentes foi atingido"),
    INTERNAL_SERVER_ERROR (500, "Erro interno", "Ocorreu um erro no gateway da API ou no microsserviço"),
    SERVICE_UNAVAILABLE (503, "Serviço indisponivel", "O serviço está indisponível no momento."),
    GATEWAY_TIMEWAY (504, "Tempo esgotado", "O servidor não pôde responder em tempo hábil.");

	
	private int codigo;
	private String titulo;
	private String detalhe;
	
	private EnumHttpStatus(Integer codigo, String titulo, String detalhe) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.detalhe = detalhe;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	
}
