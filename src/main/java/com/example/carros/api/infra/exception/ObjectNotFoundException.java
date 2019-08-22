package com.example.carros.api.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {

	
	/* 
	 public class ObjectNotFoundException extends ChecknowException {
	 public ObjectNotFoundException(String name) {
		    super("Object " + name + " não encontrado");
		  }*/
	
	
	/*
	 
	 public class InvalidObjectException extends ChecknowException {
	 public InvalidObjectException(String name) {
	    super("Objeto " + name + " inválido");
	  }*/
	
	/*var usuario = this.userTokenRepository.findUser(login, senha)
			.orElseThrow(() -> new ObjectNotFoundException("usuario"));*/
	
	/*
	  var routeOpt = routeRepository.findRoute(userToken.getClienteId(), device.getId(), positionDate.get());
    if (routeOpt.isEmpty()) {
      logger.error("rota nao encontrada. [token={}, data={}]", token, request.toString());
      throw new ObjectNotFoundException("rota");
    }
	 */
	
	public ObjectNotFoundException(String message) {
        //super(message);
		 super("Object " + message + " não encontrado");
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
