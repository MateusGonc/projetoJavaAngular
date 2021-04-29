CREATE TABLE pessoa (
	code BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(60) NOT NULL,
	logradouro VARCHAR(50),
	numero VARCHAR(5),
	complemento VARCHAR(50),
	bairro VARCHAR(50),
	cep VARCHAR(9),
	cidade VARCHAR(50),
	estado VARCHAR(50),
	ativo BOOL NOT NULL	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (name, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('João Paulo', 'Rua das Areias', '100', '', 'Jardim do Carmo', '18077-999', 'Sorocaba', 'São Paulo', true);
INSERT INTO pessoa (name, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Roberto Jefferson', 'Rua de Deus', '70', '', 'Parque da Paz', '18011-777', 'Votorantim', 'São Paulo', true);
INSERT INTO pessoa (name, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Paulo Afonso', 'Rua das Estrelas', '80', '', 'Jardim do Céu', '18901-512', 'São Paulo', 'São Paulo', false);
INSERT INTO pessoa (name, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Mateus Gonçalves', 'Avenida Independência', '90', '', 'Éden', '18070-419', 'Sorocaba', 'São Paulo', true);
INSERT INTO pessoa (name, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Luiz Inácio', 'Rua das Comunidades', '10', '', 'Parque do Presidencialismo', '11075-139', 'São Paulo', 'São Paulo', true);
INSERT INTO pessoa (name, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Paulo Guedes', 'Rua das Riqueza', '20', '', 'Jardim do Economia', '15007-923', 'Rio de Janeiro', 'Rio de Janeiro', true);
INSERT INTO pessoa (name, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Jair Messias', 'Rua da Familia', '200', '', 'Parque do Presidencialismo', '14107-239', 'São Paulo', 'São Paulo', true);
INSERT INTO pessoa (name, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Luiz Mandetta', 'Rua da Saúde', '1000', '', 'Jardim do Hospital', '13155-358', 'Sorocaba', 'São Paulo', true);
INSERT INTO pessoa (name, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Abraham Weintraub', 'Rua da Educação', '50', '', 'Parque da Sabedoria', '01567-012', 'Rio de Janeiro', 'Rio de Janeiro', true);
INSERT INTO pessoa (name, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Damares Alves', 'Rua da Mulher', '20002', '', 'Vila das Mulheres', '09531-321', 'Rio de Janeiro', 'Rio de Janeiro', true);
