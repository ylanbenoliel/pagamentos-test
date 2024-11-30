CREATE TABLE pagamentos {
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(19,2) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    numero VARCHAR(19) NOT NULL,
    expiracao VARCHAR(7) NOT NULL,
    codigo VARCHAR(3) NOT NULL,
    status VARCHAR(255) NOT NULL,
    pedidoId BIGINT(20) NOT NULL,
    formaDePagamentoId BIGINT(20) NOT NULL
}