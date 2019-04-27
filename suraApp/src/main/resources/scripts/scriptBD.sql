CREATE DATABASE "appSura"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

CREATE TABLE public.persona
(
    cedula bigint NOT NULL,
    nombre text NOT NULL,
    idpais bigint NOT NULL,
    PRIMARY KEY (cedula)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.persona
    OWNER to postgres;

CREATE TABLE public.tipo
(
    idtipo serial NOT NULL,
    nombre text NOT NULL,
    PRIMARY KEY (idtipo)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.tipo
    OWNER to postgres;

CREATE TABLE public.moneda
(
    idmoneda serial NOT NULL,
    nombre text NOT NULL,
    sufijo text NOT NULL,
    PRIMARY KEY (idmoneda)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.moneda
    OWNER to postgres;

CREATE TABLE public.idiomas
(
    ididioma serial NOT NULL,
    nombre text NOT NULL,
    sufijo text NOT NULL,
    PRIMARY KEY (ididioma)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.idiomas
    OWNER to postgres;

CREATE TABLE public.propiedad
(
    idpropiedad bigserial NOT NULL,
    idtipo bigint NOT NULL,
    idmoneda bigint NOT NULL,
    idpersona bigint NOT NULL,
    direccion text NOT NULL,
    valor double precision NOT NULL,
    metraje integer NOT NULL,
    estrato integer NOT NULL,
    PRIMARY KEY (idpropiedad),
    CONSTRAINT fktipo FOREIGN KEY (idtipo)
        REFERENCES public.tipo (idtipo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkmoneda FOREIGN KEY (idmoneda)
        REFERENCES public.moneda (idmoneda) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkpersona FOREIGN KEY (idpersona)
        REFERENCES public.persona (cedula) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.propiedad
    OWNER to postgres;

CREATE TABLE public.registro
(
    fecharegistro date NOT NULL,
    idregistro integer NOT NULL DEFAULT nextval('registro_idregistro_seq'::regclass),
    valorprima double precision NOT NULL,
    idpropiedad bigint NOT NULL,
    CONSTRAINT registro_pkey PRIMARY KEY (idregistro),
    CONSTRAINT fkpropiedad FOREIGN KEY (idpropiedad)
        REFERENCES public.propiedad (idpropiedad) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.registro
    OWNER to postgres;





