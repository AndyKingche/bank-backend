PGDMP                 	        |            bankaccount    12.12    12.12                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    42218    bankaccount    DATABASE     �   CREATE DATABASE bankaccount WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE bankaccount;
                postgres    false            �            1255    42247    update_updated_at_column()    FUNCTION     �   CREATE FUNCTION public.update_updated_at_column() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$;
 1   DROP FUNCTION public.update_updated_at_column();
       public          postgres    false            �            1259    42221    b_acc_account    TABLE     {  CREATE TABLE public.b_acc_account (
    accountid integer NOT NULL,
    numberaccount character varying(50),
    typeaccount character varying(150),
    openingbalance numeric,
    personid numeric,
    status boolean,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);
 !   DROP TABLE public.b_acc_account;
       public         heap    postgres    false            �            1259    42219    b_acc_account_accountid_seq    SEQUENCE     �   CREATE SEQUENCE public.b_acc_account_accountid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.b_acc_account_accountid_seq;
       public          postgres    false    203                       0    0    b_acc_account_accountid_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.b_acc_account_accountid_seq OWNED BY public.b_acc_account.accountid;
          public          postgres    false    202            �            1259    42234    b_acc_transfer    TABLE     �  CREATE TABLE public.b_acc_transfer (
    transferid integer NOT NULL,
    accountid integer,
    typetransfer character varying(150),
    valuetransfer numeric(15,2),
    balance numeric(15,2),
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    datetransfer timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);
 "   DROP TABLE public.b_acc_transfer;
       public         heap    postgres    false            �            1259    42232    b_acc_transfer_transferid_seq    SEQUENCE     �   CREATE SEQUENCE public.b_acc_transfer_transferid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.b_acc_transfer_transferid_seq;
       public          postgres    false    205                       0    0    b_acc_transfer_transferid_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.b_acc_transfer_transferid_seq OWNED BY public.b_acc_transfer.transferid;
          public          postgres    false    204            �
           2604    42224    b_acc_account accountid    DEFAULT     �   ALTER TABLE ONLY public.b_acc_account ALTER COLUMN accountid SET DEFAULT nextval('public.b_acc_account_accountid_seq'::regclass);
 F   ALTER TABLE public.b_acc_account ALTER COLUMN accountid DROP DEFAULT;
       public          postgres    false    202    203    203            �
           2604    42237    b_acc_transfer transferid    DEFAULT     �   ALTER TABLE ONLY public.b_acc_transfer ALTER COLUMN transferid SET DEFAULT nextval('public.b_acc_transfer_transferid_seq'::regclass);
 H   ALTER TABLE public.b_acc_transfer ALTER COLUMN transferid DROP DEFAULT;
       public          postgres    false    204    205    205                      0    42221    b_acc_account 
   TABLE DATA           �   COPY public.b_acc_account (accountid, numberaccount, typeaccount, openingbalance, personid, status, created_at, updated_at) FROM stdin;
    public          postgres    false    203   }                 0    42234    b_acc_transfer 
   TABLE DATA           �   COPY public.b_acc_transfer (transferid, accountid, typetransfer, valuetransfer, balance, created_at, updated_at, datetransfer) FROM stdin;
    public          postgres    false    205   �                  0    0    b_acc_account_accountid_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.b_acc_account_accountid_seq', 1, true);
          public          postgres    false    202                        0    0    b_acc_transfer_transferid_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.b_acc_transfer_transferid_seq', 15, true);
          public          postgres    false    204            �
           2606    42231     b_acc_account b_acc_account_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.b_acc_account
    ADD CONSTRAINT b_acc_account_pkey PRIMARY KEY (accountid);
 J   ALTER TABLE ONLY public.b_acc_account DROP CONSTRAINT b_acc_account_pkey;
       public            postgres    false    203            �
           2606    42241 "   b_acc_transfer b_acc_transfer_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.b_acc_transfer
    ADD CONSTRAINT b_acc_transfer_pkey PRIMARY KEY (transferid);
 L   ALTER TABLE ONLY public.b_acc_transfer DROP CONSTRAINT b_acc_transfer_pkey;
       public            postgres    false    205            �
           2620    42248 &   b_acc_account update_timestamp_account    TRIGGER     �   CREATE TRIGGER update_timestamp_account BEFORE UPDATE ON public.b_acc_account FOR EACH ROW EXECUTE FUNCTION public.update_updated_at_column();
 ?   DROP TRIGGER update_timestamp_account ON public.b_acc_account;
       public          postgres    false    206    203            �
           2620    42249 (   b_acc_transfer update_timestamp_transfer    TRIGGER     �   CREATE TRIGGER update_timestamp_transfer BEFORE UPDATE ON public.b_acc_transfer FOR EACH ROW EXECUTE FUNCTION public.update_updated_at_column();
 A   DROP TRIGGER update_timestamp_transfer ON public.b_acc_transfer;
       public          postgres    false    206    205            �
           2606    42242 ,   b_acc_transfer b_acc_transfer_accountid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.b_acc_transfer
    ADD CONSTRAINT b_acc_transfer_accountid_fkey FOREIGN KEY (accountid) REFERENCES public.b_acc_account(accountid);
 V   ALTER TABLE ONLY public.b_acc_transfer DROP CONSTRAINT b_acc_transfer_accountid_fkey;
       public          postgres    false    203    205    2703               O   x�U�1� й=����"���pepфp��j��ެT:�1���N(.����K[6A,��a@�_Y�C5��f��H��         E   x�34�4�tI-.�/�,��0�30�44��FF&��@�``behaed�gdl`dhH���q��qqq �f]     