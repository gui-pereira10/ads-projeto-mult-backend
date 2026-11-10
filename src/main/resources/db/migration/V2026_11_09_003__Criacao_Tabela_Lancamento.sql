CREATE TABLE lancamentos
(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    descricao VARCHAR(200) NOT NULL,
    valor DECIMAL(12,2) NOT NULL,
    data_lancamento DATE NOT NULL,
    observacao VARCHAR(500),
    categoria_id INTEGER NOT NULL,
    usuario_id INTEGER NOT NULL,
    FOREIGN KEY (categoria_id)
        REFERENCES categoria(id),
    FOREIGN KEY (usuario_id)
        REFERENCES usuario(id)
);
