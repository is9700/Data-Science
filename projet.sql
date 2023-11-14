DROP TYPE Adresstyp FORCE;
DROP TYPE Personentyp FORCE;
DROP TYPE Vertragtyp FORCE;
DROP TYPE Spielertyp FORCE;
DROP TYPE Schiedsrichtertyp FORCE;
DROP TYPE Stadiontyp FORCE;
DROP TYPE traniertListenTyp FORCE;
DROP TYPE Vereintyp FORCE;
DROP TYPE spieltListenTyp FORCE;
DROP TYPE leitetListenTyp FORCE;
DROP TYPE verkauftyp FORCE;
DROP TYPE Spieltyp FORCE;
DROP TYPE TV_Kanal_Typ FORCE;
DROP TYPE Mediengruppentyp FORCE;
DROP TYPE verkaufTyp FORCE;


----------
CREATE TYPE Adresstyp AS OBJECT(
Strasse VARCHAR(50),
Ort VARCHAR(50),
PLZ INTEGER
)


--
CREATE TYPE Personentyp AS OBJECT(
Pid      INTEGER,
Nachname VARCHAR(50),
Vorname VARCHAR(50),
Adresse Adresstyp
) NOT FINAL


--
CREATE TYPE Vertragtyp AS OBJECT(
Vid INTEGER,
Startdatum VARCHAR(50),
enddatum  VARCHAR(50),
Betrag  VARCHAR(50)
)


--
CREATE TYPE Spielertyp UNDER Personentyp(
Position  VARCHAR(50),
Geburtsdatum  VARCHAR(50),
Große  VARCHAR(50),
vertrag REF Vertragtyp
)


--
CREATE TYPE Schiedsrichtertyp UNDER Personentyp(
lizenstufe VARCHAR(50)
)


--
CREATE TYPE Stadiontyp AS OBJECT(
Stid INTEGER,
Name VARCHAR(10),
Kapazität VARCHAR(10),
Adresse Adresstyp
)


--
CREATE TYPE traniertListenTyp AS TABLE OF REF Stadiontyp


--
CREATE TYPE Vereintyp AS OBJECT(
Vereinid INTEGER,
Name VARCHAR(50),
Gründungsdatum VARCHAR(50),
Adresse Adresstyp,
traniert traniertListenTyp,
vertrag REF Vertragtyp
)


--
CREATE TYPE spieltListenTyp AS TABLE OF REF Vereintyp


--
CREATE TYPE leitetListenTyp AS TABLE OF REF Schiedsrichtertyp 


--
CREATE TYPE Verkauftyp AS OBJECT(
verkaufid INTEGER,
Datum VARCHAR(50),
betrag VARCHAR(10)
)


--
CREATE TYPE Spieltyp AS OBJECT(
Sid INTEGER,
Datum VARCHAR(50),
Ergebnis  VARCHAR(10),
Stadion REF Stadiontyp,
verkauf REF verkaufid,
spielt spieltListenTyp,
leitet leitetListenTyp
)


--
CREATE TYPE TV_Kanal_Typ AS VARRAY(3) 
OF VARCHAR2(15);



--
CREATE TYPE Mediengruppentyp AS OBJECT(
Medienid INTEGER,
Nmae VARCHAR(50),
TVKanal  TV_Kanal_Typ, 
Hauptsitz VARCHAR(10),
verkauf REF verkaufid
)


--
CREATE TYPE verkaufTyp AS OBJECT(
Medien REF Mediengruppentyp,
Spiel REF Spieltyp,
Datum  ARCHAR(20),
Betrag VARCHAR(20)
)
