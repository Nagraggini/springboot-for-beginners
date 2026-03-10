# Kezdőknek

[Saját webfejlesztői alapismeretekről szóló blogom](https://nagraggini.github.io/Web-practising-and-fun/Web_Development/Practising/1-HTML%20Practising/2-Blog.html)

A vs code extension részen ezeket töltsd le:

- Java Development Kit (JDK)
- Extension Pack for Java
- Spring Boot Extension Pack
- Spring Boot Tools
- Spring Initializr

# Források

Ezek alapján csináltam:
https://www.youtube.com/watch?v=8qMi3e_fzKc&list=PL92V_WHHt2CnXaUIA9T2ww7peDK4lqmZj&index=23

https://www.skillversum.com/note/view/d671feafa179e5a8a946d06a344554b0154ad570

# Általános infók

A Spring Data JPA megkönnyíti az adatbázis kapcsolatot és műveleteket(CRUD), ez egy keretrendszer.

Spring Data JPA  
(Ez az ORM réteg. Entity osztályok használatához és CRUD müveletekhez.
CRUD:  
 C – Create → létrehozás  
 R – Read → lekérdezés / olvasás  
 U – Update → módosítás  
 D – Delete → törlés)

A Java Enterprise Edition (EE) és a Spring is keretrendszer. Manapság Java EE-ben fejlesztenek a nagy vállalatok, a Spring-et start-up-ok és kisvállalkozások használják. Nagyon hasonlít a kettő egymásra, ha az egyiket megtanulod a másik is könnyen fog menni.

# Gradle Androidhoz

Az Android fejlesztésben a Gradle végzi például:

az app fordítását (build)
függőségek letöltését (libraryk)
APK / AAB csomag készítését
tesztek futtatását

Az Android fejlesztésnél általában a Android Studio automatikusan tartalmazza és kezeli a Gradle-t.

# Maven

Az Apache Maven egy alkalmazásfejlesztést menedzselő és automatizáló eszköz Java programokhoz.

Segítségével könnyen build-elhetjük a kódot, dokumentációt generálhatunk, kezelhetjük a függőségeket (dependency-ket) és kiadhatjuk a verziókat.

A Maven működését a projekt leírására szolgáló pom.xml fájl irányítja.

A pom.xml (Project Object Model) tartalmazza a projekt nevét, verzióját, függőségeit és más fontos beállításokat. A fájlban előre definiált célokat (például fordítás, csomagolás) használhatunk, vagy saját célokat is definiálhatunk.

A maven projektnél kötött struktúra van, hogy hova kerülnek az osztályok , képek, tesztek stb.

Tegyük fel, hogy ${basedir} az a mappa, ahol maga a projektünk van.

- ${basedir}/src/main/java
  Itt található meg a forráskód, itt hozzuk létre a packageket, és minden kódot e mappa alá írunk

- ${basedir}/src/main/resources
  Itt találhatóak meg a resource-ok, vagyis a nem Java kód alapú külső fájlok. Például adatbázis kapcsolatra itt létrehozhatunk egy fájlt, melyben tárolhatjuk a felhasználó/jelszó párost, ahelyett, hogy beleégetnénk a kódba ezeket az értékeket.

- ${basedir}/src/test
  Sok dolgot lehet már automatizálni a világunkban, ilyen dolog lehet az alkalmazás tesztelése is. Itt a megfuttatandó testeket írjuk meg Java kódban.

- ${basedir}/target/classes
  A forráskódunkból kigenerált bytekód kerül ebbe a mappába.

A maven megcsinálja helyettünk a mappastruktúrát.

## Maven telepítése

Szükséges, hogy be legyen állítva a JAVA_HOME környezeti változó!

Nyissunk meg egy terminált és futtassuk le az echo %JAVA_HOME% parancsot ellenőrzésképpen.
Ha ilyen látsz: C:\Program Files\Java\jdk-25.0.1 akkor jó, hanem akkor telepítsd a jdk-t.

Binary zip archive kell nekünk innen:
https://maven.apache.org/download.cgi

A mappa tartalmát ide csomagold ki:
C:\Program Files\apache-maven-3.9.13

Adjuk hozzá a PATH-hoz a Maven-t:
win -> Környezeti változók
A felső részen katt az Új gombra. Változó neve: MAVEN_HOME
Változó értéke: C:\Program Files\apache-maven-3.9.13\bin (Ugyanaz legyen ahova kicsomagoltad. A bin mappa kell neki!)

Ugyanebben a listában a Path változót keresd meg és katt rá. -> Szerkesztés -> Új
Másold be ezt: C:\Program Files\apache-maven-3.9.13\bin
Ok -> Ok
Ezután zárd be teljesen a vs code-t és nyisd meg újra.

Nyissunk meg egy új terminált és futtassuk le a mvn -v parancsot ellenőrzésképpen.

Ha ilyet látsz, akkor sikerült a telepítés:

PS C:\Users\Doc> mvn -v
Apache Maven 3.9.13 (39d686bd50d8e054301e3a68ad44781df6f80dda)
Maven home: C:\Program Files\apache-maven-3.9.13
Java version: 25.0.1, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-25.0.1
Default locale: hu_HU, platform encoding: UTF-8
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"

## Maven parancsok

Fájlok törlése a target mappából: mvn clean

Ez a parancs eltávolítja az előző build során létrejött fájlokat, hogy tiszta környezetből indulhassunk.

Projekt ellenőrzése: mvn validate

A Maven ellenőrzi a projekt struktúráját és a konfigurációk helyességét.

Java fájlok fordítása: mvn compile

A parancs a Java forráskódot byte kóddá alakítja, amit a JVM futtatni tud.

Tesztelés: mvn test

Futtatja az összes projektben található tesztet, hogy ellenőrizze a kód helyességét.

Csomagolás: mvn package

A lefordított kódot összeállítja egy futtatható csomagba, például .jar fájlba.

Lokális telepítés: mvn install

Az elkészült csomagot a lokális Maven repository-ba (.m2 mappa) helyezi, így más projektek is felhasználhatják.

Hasznos opciók

Tesztelés kihagyása: -DskipTests

Lehetővé teszi a build-et anélkül, hogy a teszteket futtatná.

Részletes debug információk: -X

Segít a hibaelhárításban, részletes naplózással.

Offline módban: -o

Maven nem próbál letölteni semmit a távoli repository-kból.

Profilok használata: -P

Megadhatunk különböző profilokat a build testreszabásához.

Távoli frissítések kényszerítése: -U

A Maven újra letölti a függőségeket a távoli repository-kból, még ha lokálisan már megvannak.

Példa összetett parancsra
mvn clean install -DskipTests -P test-web,test-db

Mit csinál ez?

Törli a target mappa tartalmát (clean).

Lefordítja a kódot és csomagolja (install automatikusan meghívja a compile és package lépéseket).

Nem futtatja a teszteket (-DskipTests).

A test-web és test-db profilokat használja (-P).

Telepíti az elkészült csomagot a lokális .m2 repository-ba.

# Projekt létrehozása

Előre konfigurált Spring Boot projektet lehet generáltatni, hogy ne kelljen kézzel megírni az összes kezdő fájlt és beállítást: [Spring Initializr](https://start.spring.io/)

Itt beállíthatók a projekt alapadatai és a szükséges függőségek.

_Group_
Általában fordított domain formátum.
Példa:
hu.bme (egyetem)
com.company (cég)
Ez határozza meg a Java package struktúrát.

_Artifact_
Az alkalmazás neve.
Ez lesz a projekt mappaneve és a build artifact neve.

_Name_
A projekt megjelenített neve.
Itt szóköz is lehet.

_Packaging típus_

jar
A leggyakoribb Spring Boot esetben.
Önállóan futtatható Java alkalmazás.

war
Webalkalmazások csomagolására.
Külső alkalmazásszerverbe (pl. Tomcat) telepíthető.
Klasszikus Java EE projektekben használják gyakrabban.

Config: Properties -> A konfiguráció .properties fájlban történik:
Java: 17 -> LTS (Long Term Support) verzió

Dependecies:
Spring Web (Webalkalmazáshoz kell, hogy legyen @Controller osztály, HTTP kérések kezelés.)
Thymeleaf (szerver oldalon tudunk html fájlokkal mokolni.)

## Import

A projektet beimporáljuk a vs code-ban (File -> Open Folder)

# Elindításhoz

## Github codenamespace

Terminálban:
sdk install java 17.0.10-ms

cmd -> mvn clean install (Létrehozza a target mappát és előkészíti a buildet. A jar fájl olyan, mint egy sima zip fájl, csak jar a kiterjesztése.)

mvn spring-boot:run (elindítja a szervert)

A terminál melletti port fülön is láthatod a webcímet.

## Offline

cmd -> mvn clean install (Létrehozza a target mappát és előkészíti a buildet. A jar fájl olyan, mint egy sima zip fájl, csak jar a kiterjesztése.)

Keresd meg a fájlkezelőben a projekted target mappáját. pl: C:\Users\Doc\demo\target>
Az korábban megadott artifact lesz a mappaneve. 
Aztán a felső beírós sávba írd be, hogy cmd, így rögtön abban a mappában fog elindulni a terminál.
cmd -> java -jar demo-0.0.1-SNAPSHOT

böngésző: localhost:8080

## Vagy offline másik módszer

cmd -> mvn clean install (Létrehozza a target mappát és előkészíti a buildet. A jar fájl olyan, mint egy sima zip fájl, csak jar a kiterjesztése.)

Az artifact neve lesz elől. main/java ...
DemoApplication.java fájl nyisd meg és start.

böngésző: localhost:8080

Leállítás: Terminálban: ctrl+c

# Verzió növelése

A pom.xml fájlban változtasd meg ezt:
<version>0.0.2-SNAPSHOT</version>

# JDBC

Java Database Connectivity, ez egy szabvány/api, hogy hogyan kell egy adatbázisra rákapcsolódni, ami lehet mySQL, PostgreSQL.

Adatbázisok

Az adatbázisokat alapvetően két fő kategóriába soroljuk:

- strukturált adatbázisok
- nem strukturált adatbázisok (A kezdők struktúráltat használnak, lekérdezéshez pedig sql-t.)

Postgresql-t [innen](https://www.postgresql.org/download/) tudod letölteni. Verzió: 16.11 Egyezzen lentebb létrehozott render.com-os adatbázissal.

A PostgreSQL működhet:

- szerverként (adatbázis szerver)
- kliensként (adatbázis kezelő eszköz)

Ebben az esetben neked csak a kliensre lesz szükséged, mert az adatbázis szerver a render.com platformon fog futni, és ahhoz távolról fogsz csatlakozni.

### Windows-on:

Környezeti változó beállítása: PowerShell:setx PATH "$env:PATH;C:\Program Files\PostgreSQL\16\bin" 

Lecsekkoljuk a verziót -> Cmd:cd "C:\Program Files\PostgreSQL\16\bin"psql --version Terminálban.

### Linux-on:

Terminálban:
sudo apt update
sudo apt install postgresql

[Postgesql hivatalos honlapja](https://www.postgresql.org/download/linux/ubuntu/)

## Adatbázis létrehozása a Render.com-on

A render.com-on hozz létre egy Postgres-t. A név legyen database. A verzió 16-os, a lényeg hogy egyezzen a gépre feltepített verzióval. Region: EU Instance Type: Free -> Create Database

Miután elkészült szükséged lesz az External Database URL-re, Username, Database, Password-re.

Terminálban, csatlakoztasd Postgres-t a render.com-os adatbázissal:
psql -h "@-utáni résztől....frankfurt-postgres.render.com-ig" -U "Username" -d "Database"
Entert nyomj.
pl.: psql -h dpg-d69k87buibrs739i5fu0-a.frankfurt-postgres.render.com -U database_olpd_user -d database_olpd
A jelszónak az oldalon lévő password-t másold be. Nem fogja mutatni. Majd entert nyomj.

Adatbázis létrehozása a terminálban:
CREATE TABLE animals (uid SERIAL, name VARCHAR(255), weight INTEGER);

## \dt-vel kilistázzuk a kettő táblát:

```bash
               List of relations

Schema | Name | Type | Owner
--------+----------+-------+--------------------
public | animals | table | database_olpd_user

```

## \d animals-vel a tábla struktúráját láthatod:

```bash
                                    Table "public.animals"
 Column |          Type          | Collation | Nullable |               Default
--------+------------------------+-----------+----------+--------------------------------------
 uid    | integer                |           | not null | nextval('animals_uid_seq'::regclass)
 name   | character varying(255) |           |          |
 weight | integer                |           |          |

```

A "q"-val tudsz kilépni belőle.

Így tudsz hozzáadni plussz sort (objektum):
INSERT INTO animals (name,weight) VALUES ('Cirma',15);

Kilistázás:
SELECT \* FROM animals;

### Adatbázishoz való csatlakozás

https://dashboard.render.com/
Menj rá az adatbázisodra. -> Info -> És látod a username és password-ot ezeket kell lentebb beírnod.

win -> pgAdmin 4
Bal oldalon Server -> Jobb klikk → Register → Server
Name: Render Database

Host name/address: dpg-d69k87buibrs739i5fu0-a.frankfurt-postgres.render.com

A hostname-t az external database url részén látod
postgresql://database_olpd_user:sekoojWQ5YUGrgC3080avcnkVvgY4LSQ@**dpg-d69k87buibrs739i5fu0-a.frankfurt-postgres.render.com**/database_olpd

Port: 5432
Maintenance database: Database
Username: Username
Password: Password

Save password: ON

Adatbázis teszt:
Bal oldalt -> Databases → postgres -> SELECT version();
Ha visszaad egy PostgreSQL verziót → működik.

# Maven dependenciák

### Egyik módszer

[Maven könyvtár](https://mvnrepository.com/search?q=postgresql)
Mindig a legfrissebbet használd. Katt a verzióra és másold ki a legfrissebb postgresql dependenciát a pom.xml fájlodba a </dependencies> elé.

Utána cmd -> mvn clean install

### Másik módszer

A vs code-ban a pom.xml-hez adjuk hozzá a postgresql drivert. Jobb klikk a pom.xml-en -> Add Starts.. -> Postgresql Driver -> Enter -> Proceed.



[Pályakezdő fullstack tutorial csomag](https://www.skillversum.com/note/view/c256d513dd9e6f970aa3daa5ded7496b38d01e78)
