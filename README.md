Se ha implementado una aplicación llamada RandomUser cumpliendo con los requisitos de la prueba.

Se ha utilizado el patrón MVI (Model-View-Intent) y JetPack Compose para las vistas.

El proyecto está dividido en 3 principales modulos o capas que son los siguientes:

Data : Contiene lo relaccionado a la obtención de datos.
Domain : Este módulo hace de desacoplo y comunica la capa de datos con la de Ui(vista)
UI : Aqui está todo lo relaccionado con las vistas y los componentes que utiliza.
Librerias utilizadas:

JetPack Compose : Creación de vistas.
Retrofit y okhttp3 : Llamadas al servicio.
Dagger Hilt : Inyección de dependencias.
Navigation: Navegación.
Junit4 y Mockito: Testing
El flujo de la aplicación es el siguiente:

Al iniciar la aplicación te aparecera un cuadro con un dialogo para que introduzca el número de resultados que quieres obtener del servicio, ya que no se especificaba en el documento de prueba y el servicio admite desde 1 a 5000 resultados. Se controla que el número que se introduce que sea válido para habilitar el botón de recuperar usuarios.

Al pulsar el botón se hará la llamada al servicio y si la respuesta es correcta se muestra la lista de usuarios ordenada alfabéticamente y sin resultados repetidos, también podrás pulsar en el menú la opción de buscar usuarios para mostrar la barra de búsqueda en la que prodrás buscar usuarios tanto por el nombre y apellidos como por el email. Si la llamada al servicio devuelve un error, se mostrará un mensaje en pantalla con un botón para volver a intentar la recuperación de datos.

Si pulsas sobre cualquier usuario de la lista, navegarás a la pantalla de detalle donde aparecerán los datos del usuario tal y como está en el diseño. Al pulsar sobre la foto te abrirá un dialogo con la imagen aumentada y el icono de género cambia según sea el género. También se muestra la ubicación que recibimos del servicio tal y como en el diseño.

Se han importado las fuentes Oswald y OpenSans como en el diseño.

Comentarios:

Se han implementado las vistas tal y como en el diseño aunque hay botones que no tienen funcionalidad

Al mostrar la ubicación en el mapa hay veces que llega la ubicación en medio del oceano o en medio de la nada y así se refleja en la app.

Como en el documento de la prueba no especifica el número de usuarios se ha implementado un dialogo al iniciar la app para que el usuario indique el numero de usuarios a recuperar
