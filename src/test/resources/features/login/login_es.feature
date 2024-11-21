#language: es
@login
Característica: Iniciar sesion

  @happy
  Esquema del escenario: Iniciar sesion con credenciales validas
    Dado "Alice" desea crear una nueva publicacion
    Cuando ella ingresa sus credenciales "<userName>" "<password>"
    Entonces ella deberia ver el dashboard con el siguiente mensaje "<mensaje>"

    Ejemplos:
      | userName | password   | mensaje                    |
      | alice    | mypassword | You are logged in as alice |

  @unhappy
  Esquema del escenario: Iniciar session con credenciales invalidas
    Dado "Grecia" desea crear una nueva publicacion
    Cuando ella ingresa sus credenciales "<userName>" "<password>"
    Entonces el recibe el "<mensaje>" que significa que no logro ingresar

    Ejemplos:
      | userName | password | mensaje                                     |
      | grecia   | mypass   | Invalid login credentials, please try again |
