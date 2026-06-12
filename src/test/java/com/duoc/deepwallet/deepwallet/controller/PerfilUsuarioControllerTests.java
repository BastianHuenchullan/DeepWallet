package com.duoc.deepwallet.deepwallet.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.duoc.deepwallet.controller.PerfilUsuarioController;
import com.duoc.deepwallet.model.PerfilUsuario;
import com.duoc.deepwallet.service.PerfilUsuarioService;

@ExtendWith(MockitoExtension.class)
class PerfilUsuarioControllerTests {

	@Mock
	private PerfilUsuarioService perfilUsuarioService;

	@InjectMocks
	private PerfilUsuarioController perfilUsuarioController;

	@Test
    void crearPerfilUsuario_retorna201_cuandoExisteSaldo() {

    PerfilUsuario usuario = new PerfilUsuario(
		    1,
            "Pepito",
            "pepito@gmail.com",
            "pepito123",
            50000,
            19,
            "masculino"
    );

    when(perfilUsuarioService.savePerfilUsuario(usuario))
            .thenReturn(usuario);

    var respuesta = perfilUsuarioController.registrarPerfilUsuario(usuario);

    assertNotNull(respuesta);
    assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

    var body = respuesta.getBody();
    assertNotNull(body);

    assertEquals(50000, body.getSaldo());
 }

}
    