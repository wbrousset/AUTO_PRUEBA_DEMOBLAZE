@Demoblaze
Feature: Demoblaze

  @Signup
  Scenario Outline: Dar de alta a un usuario
    Given ingreso a la web de demoblaze
    When hago click en la opcion Sign up del menu
    And ingreso credenciales nuevas "<Username>" y "<Password>"
    And hago click en el boton Sign up
    Then visualizare una alerta que indica que mi usuario ha sido creado exitosamente

    Examples: 
      | Username   | Password   |
      | prueba202i | prueba202i |

  @Login
  Scenario Outline: Log in de un usuario
    Given ingreso a la web de demoblaze
    When hago click en la opcion Log in del menu
    And ingreso credenciales "<Username>" y "<Password>"
    And hago click en el boton Log in
    Then visualizare en el menu el mensaje de welcome "<Username>"

    Examples: 
      | Username | Password |
      | admin    | admin    |

  @Logout
  Scenario Outline: Log out de un usuario
    Given existe un usuario logueado con "<Username>" y "<Password>" en la web de demoblaze
    When hago click en la opcion Log out del menu
    Then visualizare en el menu la opcion de Log in nuevamente

    Examples: 
      | Username | Password |
      | admin    | admin    |

  @AgregarLaptop
  Scenario Outline: Agregar laptop al carrito
    Given existe un usuario logueado con "<Username>" y "<Password>" en la web de demoblaze
    When selecciono la categoria "<categoria>"
    And busco un producto "<producto>"
    And agrego el producto al carrito
    Then visualizare una alerta que indica que mi producto ha sido agregado

    Examples: 
      | Username | Password | categoria | producto    |
      | admin    | admin    | Laptops   | MacBook air |

  @ValidarCart
  Scenario Outline: Validar productos agregados al carrito
    Given existe un usuario logueado con "<Username>" y "<Password>" en la web de demoblaze
    And agrego producto "<producto>" al carrito
    When hago click en la opcion Cart del menu
    Then visualizare mis productos agregados "<producto>"

    Examples: 
      | Username | Password | producto     |
      | admin    | admin    | ASUS Full HD |
