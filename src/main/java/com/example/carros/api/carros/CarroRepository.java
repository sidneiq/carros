package com.example.carros.api.carros;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

	List<Carro> findByTipo(String tipo);
	
	 // @Query("select pe.id, pe.imei, pe.uuid from public.Carro pe  where pe.ativo = true and pe.uuid = :uuid and pe.cliente_id =:clienteId ")
	  //Optional<Carro> findByUuid(@Param("uuid") String uuid, @Param("clienteId") Long clienteId);
}
