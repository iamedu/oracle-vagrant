INADEM
=======

Este es el proyecto principal de INADEM, por ahora tenemos un sistema base

Ambiente
========

Requisitos para instalar ambiente:

* Java 7
* Maven
* Vagrant
* Instalador de oracle para linux: (oracle-xe-11.2.0-1.0.x86_64.rpm.zip) se puede descargar de http://www.oracle.com/technetwork/database/express-edition/downloads/index.html
* Conexión a internet

Pasos para montar ambiente de desarrollo:

#. Copiar instalador de oracle a la carpeta: vagrant/modules/oracle/files
#. Compilar el proyecto (desde la raiz): mvn clean install
#. Executar el comando: vagrant up

TODO:
=====

* Migrar el proyecto viejo
* Cargar script de arranque
* Deployarlo automaticamente
