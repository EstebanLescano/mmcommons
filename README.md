DB_PASSWORD=MMpassword;
DB_SCHEMA=public;
DB_URL=jdbc:postgresql://localhost:5436/MMKeycloak;
DB_USERNAME=MMpostgres;
JPA_DDL=update;
JPA_SHOW_SQL=true;
KC_DB=postgres;
KC_DB_PASSWORD=MMpassword;
KC_DB_URL=jdbc:postgresql://postgres_MMUsers:5432/MMKeycloak;
KC_DB_USERNAME=estebanles;
SERVER_PORT=4000;
SPRING_APP_NAME=mmcommons

KEYCLOAK CONFIG
# KEYCLOAK_ADMIN=admin
# KEYCLOAK_ADMIN_PASSWORD=admin


Variables de configuración de base de datos
# KC_DB=postgres
# KC_DB_URL=jdbc:postgresql://postgres_mmlocal:5432/MMKeycloak
# KC_DB_USERNAME=MMpostgres
# KC_DB_PASSWORD=MMpassword
# KC_DB_SCHEMA=public   # opcional, si no es public

Variables de red y hostname
#  KC_HOSTNAME=localhost            # Nombre público que usará Keycloak
#  KC_HOSTNAME_PORT=8080            # Puerto expuesto
#  KC_HOSTNAME_STRICT=false         # Permite que se acceda desde cualquier host
#  KC_HOSTNAME_STRICT_HTTPS=false   # Permite HTTP sin HTTPS en dev
#  KC_HTTP_ENABLED=true             # Activa HTTP (útil en dev)

Variables de TLS (si querés HTTPS directo sin proxy)
# KC_HTTPS_CERTIFICATE_FILE=/opt/keycloak/conf/server.crt
# KC_HTTPS_CERTIFICATE_KEY_FILE=/opt/keycloak/conf/server.key

Variables para importar realms automáticamente
# KC_IMPORT=/opt/keycloak/data/import/myrealm.json
# KC_IMPORT_REALM=true

Variables de logging y debug
# KC_LOG_LEVEL=INFO
# KC_LOG_CONSOLE_COLOR=true
# KC_LOG_CONSOLE_OUTPUT=DEFAULT
