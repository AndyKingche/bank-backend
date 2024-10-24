PGDMP                 	        |         
   bankclient    12.12    12.12                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    42183 
   bankclient    DATABASE     �   CREATE DATABASE bankclient WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE bankclient;
                postgres    false            �            1255    42215    update_updated_at_column()    FUNCTION     �   CREATE FUNCTION public.update_updated_at_column() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$;
 1   DROP FUNCTION public.update_updated_at_column();
       public          postgres    false            �            1259    42199    b_cli_client    TABLE     %  CREATE TABLE public.b_cli_client (
    clientid integer NOT NULL,
    personid integer,
    passwordclient text,
    status boolean,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);
     DROP TABLE public.b_cli_client;
       public         heap    postgres    false            �            1259    42197    b_cli_client_clientid_seq    SEQUENCE     �   CREATE SEQUENCE public.b_cli_client_clientid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.b_cli_client_clientid_seq;
       public          postgres    false    205                       0    0    b_cli_client_clientid_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.b_cli_client_clientid_seq OWNED BY public.b_cli_client.clientid;
          public          postgres    false    204            �            1259    42186    b_cli_person    TABLE     �  CREATE TABLE public.b_cli_person (
    personid integer NOT NULL,
    nameperson character varying(50),
    gender character varying(50),
    age numeric,
    identification character varying(10),
    address character varying(150),
    phone character varying(10),
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);
     DROP TABLE public.b_cli_person;
       public         heap    postgres    false            �            1259    42184    b_cli_person_personid_seq    SEQUENCE     �   CREATE SEQUENCE public.b_cli_person_personid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.b_cli_person_personid_seq;
       public          postgres    false    203                       0    0    b_cli_person_personid_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.b_cli_person_personid_seq OWNED BY public.b_cli_person.personid;
          public          postgres    false    202            �
           2604    42202    b_cli_client clientid    DEFAULT     ~   ALTER TABLE ONLY public.b_cli_client ALTER COLUMN clientid SET DEFAULT nextval('public.b_cli_client_clientid_seq'::regclass);
 D   ALTER TABLE public.b_cli_client ALTER COLUMN clientid DROP DEFAULT;
       public          postgres    false    204    205    205            �
           2604    42189    b_cli_person personid    DEFAULT     ~   ALTER TABLE ONLY public.b_cli_person ALTER COLUMN personid SET DEFAULT nextval('public.b_cli_person_personid_seq'::regclass);
 D   ALTER TABLE public.b_cli_person ALTER COLUMN personid DROP DEFAULT;
       public          postgres    false    202    203    203                      0    42199    b_cli_client 
   TABLE DATA           j   COPY public.b_cli_client (clientid, personid, passwordclient, status, created_at, updated_at) FROM stdin;
    public          postgres    false    205   g                 0    42186    b_cli_person 
   TABLE DATA           �   COPY public.b_cli_person (personid, nameperson, gender, age, identification, address, phone, created_at, updated_at) FROM stdin;
    public          postgres    false    203   �                  0    0    b_cli_client_clientid_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.b_cli_client_clientid_seq', 5, true);
          public          postgres    false    204                        0    0    b_cli_person_personid_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.b_cli_person_personid_seq', 3, true);
          public          postgres    false    202            �
           2606    42209    b_cli_client b_cli_client_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.b_cli_client
    ADD CONSTRAINT b_cli_client_pkey PRIMARY KEY (clientid);
 H   ALTER TABLE ONLY public.b_cli_client DROP CONSTRAINT b_cli_client_pkey;
       public            postgres    false    205            �
           2606    42196    b_cli_person b_cli_person_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.b_cli_person
    ADD CONSTRAINT b_cli_person_pkey PRIMARY KEY (personid);
 H   ALTER TABLE ONLY public.b_cli_person DROP CONSTRAINT b_cli_person_pkey;
       public            postgres    false    203            �
           2620    42217 $   b_cli_client update_timestamp_client    TRIGGER     �   CREATE TRIGGER update_timestamp_client BEFORE UPDATE ON public.b_cli_client FOR EACH ROW EXECUTE FUNCTION public.update_updated_at_column();
 =   DROP TRIGGER update_timestamp_client ON public.b_cli_client;
       public          postgres    false    206    205            �
           2620    42216 $   b_cli_person update_timestamp_person    TRIGGER     �   CREATE TRIGGER update_timestamp_person BEFORE UPDATE ON public.b_cli_person FOR EACH ROW EXECUTE FUNCTION public.update_updated_at_column();
 =   DROP TRIGGER update_timestamp_person ON public.b_cli_person;
       public          postgres    false    206    203            �
           2606    42210 '   b_cli_client b_cli_client_personid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.b_cli_client
    ADD CONSTRAINT b_cli_client_personid_fkey FOREIGN KEY (personid) REFERENCES public.b_cli_person(personid);
 Q   ALTER TABLE ONLY public.b_cli_client DROP CONSTRAINT b_cli_client_personid_fkey;
       public          postgres    false    203    205    2703               C   x�U�;�0��FQɓ��d,��B��zaa�s����Fp4��<dQ5G�`H��®D_SZ����.8         g   x�}ɻ�  ���� wp�c {�&�4���	|�#He��C��\�i�,�Α��n�͹�G�3OW^�#WH�W`а¨0H�5qMA#����D��/�%�     