INSERT INTO usuarios
(
    nome,
    email,
    senha_hash,
    perfil,
    ativo
)
VALUES
(
    'Admin',
    'admin@example.com',
    '$2y$12$LHxoZ.5h0naCNnzigswKDuNHld41WB9teA.CVyQrZvJFiyCCivjDu',
    'ADMIN',
    TRUE
);