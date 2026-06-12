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
import com.duoc.deepwallet.controller.IngresoController;
import com.duoc.deepwallet.model.CategoriaIngreso;
import com.duoc.deepwallet.model.Ingreso;
import com.duoc.deepwallet.model.PerfilUsuario;
import com.duoc.deepwallet.service.IngresoService;

@ExtendWith(MockitoExtension.class)
class IngresoControllerTests {

	@Mock
	private IngresoService ingresoService;

	@InjectMocks
	private IngresoController ingresoController;

	@Test
    void crearIngreso_retorna201_cuandoExisteSaldo() {
    CategoriaIngreso CIngreso = new CategoriaIngreso(
        1,
        "Sueldo"

    );
    PerfilUsuario usuario = new PerfilUsuario(
		    1,
            "Pepito",
            "pepito@gmail.com",
            "pepito123",
            50000,
            19,
            "Masculino"
    );

    Ingreso Ingreso = new Ingreso(
        1, 5000, "Propina", usuario, CIngreso
        
    );

    when(ingresoService.saveIngreso(Ingreso))
            .thenReturn(Ingreso);

    var respuesta = ingresoController.agregarIngreso(Ingreso);

    assertNotNull(respuesta);
    assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

    var body = respuesta.getBody();
    assertNotNull(body);

    assertEquals("Propina", body.getDescripcion());
 }

}
    