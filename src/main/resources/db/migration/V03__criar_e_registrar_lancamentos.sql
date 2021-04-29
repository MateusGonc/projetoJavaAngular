CREATE TABLE lancamento (
	code BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL,
	data_vencimento DATE NOT NULL,
	data_pagamento DATE,
	valor DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(100),
	tipo VARCHAR(20) NOT NULL,
	code_categoria BIGINT(20) NOT NULL,
	code_pessoa BIGINT(20) NOT NULL,
	FOREIGN KEY (code_categoria) REFERENCES categoria(code),
	FOREIGN KEY (code_pessoa) REFERENCES pessoa(code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, code_categoria, code_pessoa) values ('Cafe', '2021-04-25', null, 15.50, 'Cafe com leite', 'DESPESA', 2, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, code_categoria, code_pessoa) values ('Ferias', '2021-04-20', null, 4500.00, 'Saida de Ferias', 'RECEITA', 5, 4);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, code_categoria, code_pessoa) values ('Salario', '2021-04-21', null, 3500.00, 'Salario mensal', 'RECEITA', 4, 3);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, code_categoria, code_pessoa) values ('Despachante', '2021-04-19', null, 1200.90, 'Despesas de veiculo', 'DESPESA', 5, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, code_categoria, code_pessoa) values ('Baile Funk', '2021-04-15', null, 220.50, 'Entrada e bebudas', 'DESPESA', 1, 5);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, code_categoria, code_pessoa) values ('Lanche', '2021-04-12', null, 44.90, 'Mc Donalds', 'DESPESA', 2, 6);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, code_categoria, code_pessoa) values ('Hora Extra', '2021-04-10', null, 301.80, 'Horas trabalhadas fora do horario', 'RECEITA', 3, 8);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, code_categoria, code_pessoa) values ('Pneus', '2021-04-20', null, 990.99, '4 Pneus novos', 'DESPESA', 5, 7);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, code_categoria, code_pessoa) values ('Moto', '2021-04-22', null, 380.00, 'Reparo do kit de transmissao', 'DESPESA', 1, 6);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, code_categoria, code_pessoa) values ('Ferramentas', '2021-04-05', null, 290.10, 'Caixa de ferramentas', 'DESPESA', 4, 9);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, code_categoria, code_pessoa) values ('Panelas', '2021-04-09', null, 299.90, null, 'DESPESA', 5, 10);
