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
import com.duoc.deepwallet.controller.CategoriaIngresoController;
import com.duoc.deepwallet.model.CategoriaIngreso;
import com.duoc.deepwallet.service.CategoriaIngresoService;

@ExtendWith(MockitoExtension.class)
class CategoriaIngresoControllerTests {

	@Mock
	private CategoriaIngresoService categoriaIngresoService;

	@InjectMocks
	private CategoriaIngresoController categoriaIngresoController;

	@Test
    void crearCategioriaIngreso_retorna201_cuandoExisteSaldo() {

    CategoriaIngreso CIngreso = new CategoriaIngreso(
        1,
        "Sueldo"

    );
 
    when(categoriaIngresoService.saveCategoriaIngreso(CIngreso))
            .thenReturn(CIngreso);

    var respuesta = categoriaIngresoController.agregarCategoriaIngreso(CIngreso);

    assertNotNull(respuesta);
    assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

    var body = respuesta.getBody();
    assertNotNull(body);

    assertEquals("Sueldo", body.getNombre_categoria());
 }

}
    