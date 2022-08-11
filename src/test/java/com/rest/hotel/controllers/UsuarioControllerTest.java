package com.rest.hotel.controllers;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rest.hotel.controller.UsuarioController;
import com.rest.hotel.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {
	@Spy
	@InjectMocks
	private UsuarioController controller;

	@Mock
	private UsuarioService service;

//	@Test
//	@Tag("unit")
//	void consultaDadosOCRValidadora_RespOK() {
//		SingleReturn<UsuarioEntity> usuarioDummy = new SingleReturn<>();
//		var error = new ErrorDataBusiness();
//		error.setCode(EnumHttpStatus.OK.getCodigo());
//		error.setTitle(EnumHttpStatus.OK.getTitulo());
//		error.setDetail(EnumHttpStatus.OK.getDetalhe());
//		usuarioDummy.setError(error);
//		when(service.orquestradorDadosOCR("99988877765L")).thenReturn(usuarioDummy);
//
//		ResponseEntity<Object> response = controller.consultaDadosOCRValidadora("99988877765L");
//		assertEquals(ResponseEntity.status(200).body(usuarioDummy.getData()), response);
//		verifyNoMoreInteractions(service);
//	}
}
