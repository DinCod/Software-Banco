PGDMP                 	        y            databaseUser    12.4    12.4 ,    4           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            5           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            6           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            7           1262    26263    databaseUser    DATABASE     �   CREATE DATABASE "databaseUser" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE "databaseUser";
                postgres    false            �            1255    26315    bancohistorialdeposito()    FUNCTION     =  CREATE FUNCTION public.bancohistorialdeposito() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
                  insert into historialtransaccion 
                  select 
	  tra.idtransaccion, tar.tipotarjeta, tar.numerotarjeta, tar.saldoinicial, tra.tipotransaccion,
	  new.monto, tar.saldoactual + new.monto, tra.fechatransaccion
	  from tarjeta tar  inner join transaccion  tra on  tra.tarjetadestino =tar.numerotarjeta
                  where tra.idtransaccion = new.idtransaccion
                  and  new.tipotransaccion = 'DEPÓSITO'; 
RETURN NEW;
END

$$;
 /   DROP FUNCTION public.bancohistorialdeposito();
       public          postgres    false            �            1255    26313    bancohistorialretiro()    FUNCTION     �  CREATE FUNCTION public.bancohistorialretiro() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
       insert into historialtransaccion 
       select 
       tra.idtransaccion, tar.tipotarjeta, tar.numerotarjeta, tar.saldoinicial, tra.tipotransaccion,
	   new.monto, tar.saldoactual - new.monto, tra.fechatransaccion
	   from 
                   tarjeta tar  inner join transaccion  tra on tra.idtarjeta =tar.idtarjeta
	   where tra.idtransaccion = new.idtransaccion;
RETURN NEW;
END

$$;
 -   DROP FUNCTION public.bancohistorialretiro();
       public          postgres    false            �            1255    26309    bancoretiro()    FUNCTION       CREATE FUNCTION public.bancoretiro() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
           update tarjeta set saldoactual =  tarjeta.saldoactual - new.monto
           from transaccion where   tarjeta.idtarjeta= new.idtarjeta;
RETURN NEW;
END
$$;
 $   DROP FUNCTION public.bancoretiro();
       public          postgres    false            �            1255    26311    banquitodepositodestino()    FUNCTION     N  CREATE FUNCTION public.banquitodepositodestino() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
 BEGIN
          update tarjeta set saldoactual =  tarjeta.saldoactual + new.monto
          from transaccion where tarjeta.numerotarjeta= new.tarjetadestino
          and new.tipotransaccion = 'DEPÓSITO'; 
          RETURN NEW;
END
$$;
 0   DROP FUNCTION public.banquitodepositodestino();
       public          postgres    false            �            1259    26266    cliente    TABLE     �   CREATE TABLE public.cliente (
    idcliente integer NOT NULL,
    dni character varying(8) NOT NULL,
    apellido character varying(30) NOT NULL,
    nombre character varying(30) NOT NULL
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    26264    cliente_idcliente_seq    SEQUENCE     �   CREATE SEQUENCE public.cliente_idcliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.cliente_idcliente_seq;
       public          postgres    false    203            8           0    0    cliente_idcliente_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.cliente_idcliente_seq OWNED BY public.cliente.idcliente;
          public          postgres    false    202            �            1259    26298    historialtransaccion    TABLE     ^  CREATE TABLE public.historialtransaccion (
    idtransaccion integer NOT NULL,
    tipotarjeta character varying(30) NOT NULL,
    numerotarjeta integer NOT NULL,
    saldoinicial integer NOT NULL,
    tipotransaccion character varying(30) NOT NULL,
    monto integer NOT NULL,
    saldoactual integer NOT NULL,
    fechatransaccion date NOT NULL
);
 (   DROP TABLE public.historialtransaccion;
       public         heap    postgres    false            �            1259    26274    tarjeta    TABLE     =  CREATE TABLE public.tarjeta (
    idtarjeta integer NOT NULL,
    idcliente integer NOT NULL,
    fechaapertura date NOT NULL,
    fechaexpiracion date NOT NULL,
    tipotarjeta character varying(30) NOT NULL,
    numerotarjeta integer NOT NULL,
    saldoinicial integer NOT NULL,
    saldoactual integer NOT NULL
);
    DROP TABLE public.tarjeta;
       public         heap    postgres    false            �            1259    26272    tarjeta_idtarjeta_seq    SEQUENCE     �   CREATE SEQUENCE public.tarjeta_idtarjeta_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.tarjeta_idtarjeta_seq;
       public          postgres    false    205            9           0    0    tarjeta_idtarjeta_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.tarjeta_idtarjeta_seq OWNED BY public.tarjeta.idtarjeta;
          public          postgres    false    204            �            1259    26287    transaccion    TABLE       CREATE TABLE public.transaccion (
    idtransaccion integer NOT NULL,
    idtarjeta integer NOT NULL,
    tipotransaccion character varying(30) NOT NULL,
    fechatransaccion date NOT NULL,
    monto integer NOT NULL,
    tarjetaorigen integer NOT NULL,
    tarjetadestino integer
);
    DROP TABLE public.transaccion;
       public         heap    postgres    false            �            1259    26285    transaccion_idtransaccion_seq    SEQUENCE     �   CREATE SEQUENCE public.transaccion_idtransaccion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.transaccion_idtransaccion_seq;
       public          postgres    false    207            :           0    0    transaccion_idtransaccion_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.transaccion_idtransaccion_seq OWNED BY public.transaccion.idtransaccion;
          public          postgres    false    206            �            1259    26303    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    idusuario integer NOT NULL,
    email character varying(100) NOT NULL,
    "contraseña" character varying(100) NOT NULL
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false            �            1259    26301    usuario_idusuario_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_idusuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.usuario_idusuario_seq;
       public          postgres    false    210            ;           0    0    usuario_idusuario_seq    SEQUENCE OWNED BY     P   ALTER SEQUENCE public.usuario_idusuario_seq OWNED BY public.usuarios.idusuario;
          public          postgres    false    209            �
           2604    26269    cliente idcliente    DEFAULT     v   ALTER TABLE ONLY public.cliente ALTER COLUMN idcliente SET DEFAULT nextval('public.cliente_idcliente_seq'::regclass);
 @   ALTER TABLE public.cliente ALTER COLUMN idcliente DROP DEFAULT;
       public          postgres    false    203    202    203            �
           2604    26277    tarjeta idtarjeta    DEFAULT     v   ALTER TABLE ONLY public.tarjeta ALTER COLUMN idtarjeta SET DEFAULT nextval('public.tarjeta_idtarjeta_seq'::regclass);
 @   ALTER TABLE public.tarjeta ALTER COLUMN idtarjeta DROP DEFAULT;
       public          postgres    false    204    205    205            �
           2604    26290    transaccion idtransaccion    DEFAULT     �   ALTER TABLE ONLY public.transaccion ALTER COLUMN idtransaccion SET DEFAULT nextval('public.transaccion_idtransaccion_seq'::regclass);
 H   ALTER TABLE public.transaccion ALTER COLUMN idtransaccion DROP DEFAULT;
       public          postgres    false    207    206    207            �
           2604    26306    usuarios idusuario    DEFAULT     w   ALTER TABLE ONLY public.usuarios ALTER COLUMN idusuario SET DEFAULT nextval('public.usuario_idusuario_seq'::regclass);
 A   ALTER TABLE public.usuarios ALTER COLUMN idusuario DROP DEFAULT;
       public          postgres    false    210    209    210            *          0    26266    cliente 
   TABLE DATA           C   COPY public.cliente (idcliente, dni, apellido, nombre) FROM stdin;
    public          postgres    false    203   �9       /          0    26298    historialtransaccion 
   TABLE DATA           �   COPY public.historialtransaccion (idtransaccion, tipotarjeta, numerotarjeta, saldoinicial, tipotransaccion, monto, saldoactual, fechatransaccion) FROM stdin;
    public          postgres    false    208   
:       ,          0    26274    tarjeta 
   TABLE DATA           �   COPY public.tarjeta (idtarjeta, idcliente, fechaapertura, fechaexpiracion, tipotarjeta, numerotarjeta, saldoinicial, saldoactual) FROM stdin;
    public          postgres    false    205   �:       .          0    26287    transaccion 
   TABLE DATA           �   COPY public.transaccion (idtransaccion, idtarjeta, tipotransaccion, fechatransaccion, monto, tarjetaorigen, tarjetadestino) FROM stdin;
    public          postgres    false    207   
;       1          0    26303    usuarios 
   TABLE DATA           C   COPY public.usuarios (idusuario, email, "contraseña") FROM stdin;
    public          postgres    false    210   t;       <           0    0    cliente_idcliente_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.cliente_idcliente_seq', 38, true);
          public          postgres    false    202            =           0    0    tarjeta_idtarjeta_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.tarjeta_idtarjeta_seq', 11, true);
          public          postgres    false    204            >           0    0    transaccion_idtransaccion_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.transaccion_idtransaccion_seq', 15, true);
          public          postgres    false    206            ?           0    0    usuario_idusuario_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.usuario_idusuario_seq', 18, true);
          public          postgres    false    209            �
           2606    26271    cliente cliente_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (idcliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    203            �
           2606    26279    tarjeta tarjeta_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.tarjeta
    ADD CONSTRAINT tarjeta_pkey PRIMARY KEY (idtarjeta);
 >   ALTER TABLE ONLY public.tarjeta DROP CONSTRAINT tarjeta_pkey;
       public            postgres    false    205            �
           2606    26292    transaccion transaccion_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.transaccion
    ADD CONSTRAINT transaccion_pkey PRIMARY KEY (idtransaccion);
 F   ALTER TABLE ONLY public.transaccion DROP CONSTRAINT transaccion_pkey;
       public            postgres    false    207            �
           2606    26308    usuarios usuario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (idusuario);
 ?   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuario_pkey;
       public            postgres    false    210            �
           2620    26316 "   transaccion bancohistorialdeposito    TRIGGER     �   CREATE TRIGGER bancohistorialdeposito AFTER INSERT ON public.transaccion FOR EACH ROW EXECUTE FUNCTION public.bancohistorialdeposito();
 ;   DROP TRIGGER bancohistorialdeposito ON public.transaccion;
       public          postgres    false    207    214            �
           2620    26314     transaccion bancohistorialretiro    TRIGGER     �   CREATE TRIGGER bancohistorialretiro AFTER INSERT ON public.transaccion FOR EACH ROW EXECUTE FUNCTION public.bancohistorialretiro();
 9   DROP TRIGGER bancohistorialretiro ON public.transaccion;
       public          postgres    false    207    213            �
           2620    26310    transaccion bancoretiro    TRIGGER     r   CREATE TRIGGER bancoretiro AFTER INSERT ON public.transaccion FOR EACH ROW EXECUTE FUNCTION public.bancoretiro();
 0   DROP TRIGGER bancoretiro ON public.transaccion;
       public          postgres    false    207    211            �
           2620    26312     transaccion bankodepositodestino    TRIGGER     �   CREATE TRIGGER bankodepositodestino AFTER INSERT ON public.transaccion FOR EACH ROW EXECUTE FUNCTION public.banquitodepositodestino();
 9   DROP TRIGGER bankodepositodestino ON public.transaccion;
       public          postgres    false    212    207            �
           2606    26280    tarjeta idcliente    FK CONSTRAINT     �   ALTER TABLE ONLY public.tarjeta
    ADD CONSTRAINT idcliente FOREIGN KEY (idcliente) REFERENCES public.cliente(idcliente) ON DELETE CASCADE;
 ;   ALTER TABLE ONLY public.tarjeta DROP CONSTRAINT idcliente;
       public          postgres    false    205    203    2718            �
           2606    26293    transaccion idtarjeta    FK CONSTRAINT     �   ALTER TABLE ONLY public.transaccion
    ADD CONSTRAINT idtarjeta FOREIGN KEY (idtarjeta) REFERENCES public.tarjeta(idtarjeta) ON DELETE CASCADE;
 ?   ALTER TABLE ONLY public.transaccion DROP CONSTRAINT idtarjeta;
       public          postgres    false    207    205    2720            *   3   x�36�4�L,J,��������2��4��M,*��K����L/M������ �I      /   �   x�34�T �� /�G�Ý.�!���FFF����A�!�A@ ���↺f��\�ƨ�]w:�5��Y�U�5s[��5!���5���`� �n����� c4Ǜ�b�%�LI��%F���qqq x'T�      ,   ^   x�34�4��4202�50�50F0�9@ �1��5�Q��p��g�?���������sp�c�od���9�p�� #�SNS�Ɩ\1z\\\ �o�      .   Z   x�34�44�r���4202�50�50
pL9c����XU��L�,��L@|׀Ó�=Cp�Q�ebaWl	7��+F��� [!P      1   6  x�eP�r�@=O�g�an�D��BA�r�%,�$~}�^����W�#BD���S$����P��,���7));��9�RRH�-�0e��u�@`(*'H��]̷���,#V���ڱN�0��R�3?���(`].�>�����`����'��Z4P� +�=5B=3�E^ͨ�׸��^p���h��e�Y,��:3F�?Z�>U���+D�=�_��Lmh4Z�Wzg��[�s+2�0�9Y᭎�ֳiJ���&z*�\M�G��:3w��+%uNm�L��$�Tٌ��K���#v%�� �-�N     