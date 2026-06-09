package com.duoc.deepwallet.deepwallet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.duoc.deepwallet.controller.PerfilUsuarioController;
import com.duoc.deepwallet.service.PerfilUsuarioService;

@ExtendWith(MockitoExtension.class)
class DeepwalletApplicationTests {

	@Mock
	private PerfilUsuarioService perfilUsuarioService;

	@InjectMocks
	private PerfilUsuarioController perfilUsuarioController;

	@Test
	void crearPerfilUsuario_retorna201_cuandoExisteSaldo() {

	}

}
