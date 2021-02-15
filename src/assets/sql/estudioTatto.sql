drop database if exists tatuador;
create database tatuador;
use tatuador;

create table usuario(
	id int primary key auto_increment,
    nome varchar(60) not null,
    data_nascimento date not null,
    telefone varchar(15),
    foto_perfil longblob,
    login varchar(18) not null unique,
    senha varchar(40) not null
);

insert into usuario values (1, 'admin', '1999-10-10', '(18) 99999-9999', null, 'admin', 'admin');

create table flashes(
	id int primary key auto_increment,
    imagem longblob not null,
    id_usuario int not null,
    
    foreign key (id_usuario) references usuario(id)
);

create table orcamento(
	id int primary key auto_increment,
    descricao varchar(100) not null,
    cliente varchar(30) not null,
    telefone varchar(15) not null,
    valor_estimado double default 0
);

create table anexo_orcamento(
	id int primary key auto_increment,
	id_orcamento int,
    imagem longblob not null,
    foreign key (id_orcamento) references orcamento(id)
);

create table caixa(
	id int primary key auto_increment,
	abertura datetime not null,
    fechamento datetime unique,
    saldo_inicial double default 0,
    saldo_final double not null,
    entradas double default 0,
    saidas double default 0,
    usuario int not null,
    
    foreign key (usuario) references usuario(id)
);

create table gasto(
	id int primary key auto_increment,
    descricao varchar(40) not null,
	valor double not null,
    caixa int,
    
    foreign key (caixa) references caixa(id)
);

create table sessao(
	id int primary key auto_increment,
    id_orcamento int not null,
    valor double not null,
    horario datetime,
    duracao_maxima time,
    pago boolean default false,

    foreign key (id_orcamento) references orcamento(id)
);

create table pagamento(
    id int primary key auto_increment,
    id_sessao int not null,
    caixa int,
    valor double not null,
    foreign key (caixa) references caixa(id),    
    foreign key (id_sessao) references sessao(id)
);



DELIMITER $ 
CREATE TRIGGER addGastosCaixa AFTER INSERT
ON gasto
FOR EACH ROW
BEGIN
	UPDATE caixa SET saidas = saidas + NEW.valor 
	WHERE codigo = NEW.caixa;
END$
DELIMITER ;


DELIMITER $ 
CREATE TRIGGER updateGastosCaixa AFTER UPDATE
ON gasto
FOR EACH ROW
BEGIN
	UPDATE caixa SET saidas = saidas + NEW.valor - OLD.valor
	WHERE codigo = NEW.caixa;
END$
DELIMITER ;


DELIMITER $ 
CREATE TRIGGER deleteGastosCaixa AFTER DELETE
ON gasto
FOR EACH ROW
BEGIN
	UPDATE caixa SET saidas = saidas - OLD.valor 
	WHERE codigo = OLD.caixa;
END$
DELIMITER ;




DELIMITER $ 
CREATE TRIGGER addSessaoCaixa AFTER INSERT
ON pagamento
FOR EACH ROW
BEGIN
    UPDATE caixa SET entradas = entradas + NEW.valor
	WHERE codigo = NEW.caixa;
END$
DELIMITER ;


DELIMITER $ 
CREATE TRIGGER updateSessaoCaixa AFTER UPDATE
ON pagamento
FOR EACH ROW
BEGIN
    UPDATE caixa SET entradas = entradas + NEW.valor  - OLD.valor
	WHERE codigo = NEW.caixa;
END$
DELIMITER ;


DELIMITER $ 
CREATE TRIGGER deleteSessaoCaixa AFTER DELETE
ON pagamento
FOR EACH ROW
BEGIN
    UPDATE caixa SET entradas = entradas - OLD.valor
	WHERE codigo = OLD.caixa;
END$
DELIMITER ;



DELIMITER $ 
CREATE TRIGGER addPagoSessao AFTER INSERT
ON pagamento
FOR EACH ROW
BEGIN
    SET @idSessao = NEW.id_sessao;

    SELECT SUM(valor) INTO @total FROM pagamento WHERE id_sessao = @idSessao;
    SELECT valor INTO @preco FROM sessao WHERE id_sessao = @idSessao;

    IF(@total >= @preco) THEN
        UPDATE sessao SET pago = true
            WHERE NEW.id_sessao = id;
    END IF;
END$
DELIMITER ;

DELIMITER $ 
CREATE TRIGGER deletePagoSessao AFTER DELETE
ON pagamento
FOR EACH ROW
BEGIN
    SET @idSessao = OLD.id_sessao;

    SELECT SUM(valor) INTO @total FROM pagamento WHERE id_sessao = @idSessao;
    SELECT valor INTO @preco FROM sessao WHERE id_sessao = @idSessao;

    IF(@total < @preco) THEN
        UPDATE sessao SET pago = false
            WHERE OLD.id_sessao = id;
    END IF;
END$
DELIMITER ;

DELIMITER $ 
CREATE TRIGGER deletePagoSessao AFTER UPDATE
ON pagamento
FOR EACH ROW
BEGIN
    SET @idSessao = OLD.id_sessao;

    SELECT SUM(valor) INTO @total FROM pagamento WHERE id_sessao = @idSessao;
    SELECT valor INTO @preco FROM sessao WHERE id_sessao = @idSessao;

    IF(@total < @preco) THEN
        UPDATE sessao SET pago = false
            WHERE OLD.id_sessao = id;
    ELSE
        UPDATE sessao SET pago = true
            WHERE NEW.id_sessao = id;
    END IF;
END$
DELIMITER ;

