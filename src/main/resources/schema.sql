CREATE TABLE IF NOT EXISTS usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS usuario_jogos (
    id_usuario INTEGER NOT NULL,
    id_jogo INTEGER NOT NULL,
    nome_jogo VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_usuario, id_jogo, nome_jogo),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);