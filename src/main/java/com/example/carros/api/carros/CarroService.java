package com.example.carros.api.carros;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.carros.api.infra.exception.ObjectNotFoundException;

@Service
public class CarroService {

	@Autowired
	private CarroRepository  carroRepository;

	public List<CarroDTO> getCarros() {
		//lambdas
		//List<CarroDTO> list = carroRepository.findAll().stream().map(c -> CarroDTO.create(c)).collect(Collectors.toList());
	    //List<CarroDTO> list = carroRepository.findAll().stream().map(CarroDTO::new).collect(Collectors.toList());
		
		
		List<CarroDTO> list = carroRepository.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());
		return list;
	}

	public CarroDTO getCarroById(Long id) {
		Optional<Carro> carro = carroRepository.findById(id);
		return carro.map(CarroDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
	}

	public List<CarroDTO> getCarrosByTipo(String tipo) {
		return carroRepository.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
	}

	public CarroDTO insert(Carro carro) {
		Assert.isNull(carro.getId(),"Não foi possível inserir o registro");

		return CarroDTO.create(carroRepository.save(carro));
	}

	public CarroDTO update(Carro carro, Long id) {
		Assert.notNull(id,"Não foi possível atualizar o registro");

		// Busca o carro no banco de dados
		Optional<Carro> optional = carroRepository.findById(id);
		if(optional.isPresent()) {
			Carro db = optional.get();
			// Copiar as propriedades
			db.setNome(carro.getNome());
			db.setTipo(carro.getTipo());
			System.out.println("Carro id " + db.getId());

			// Atualiza o carro
			carroRepository.save(db);

			return CarroDTO.create(db);
		} else {
			//return null;
			throw new RuntimeException("Não foi possível atualizar o registro");
		}
	}

	public void delete(Long id) {

		/*Optional<Carro> carro = carroRepository.findById(id);
    	  if(carro.isPresent()) {
          	carroRepository.deleteById(id);
          }*/

		carroRepository.deleteById(id);
	}


	public Boolean deleteB(Long id) {
		Optional<Carro> carro = carroRepository.findById(id);
		return carro.map(c -> {
			carroRepository.deleteById(id);
			return true;
		}).orElse(false);

	}
	/*public Optional<CarroDTO> getListCarroById(Long id) {
		Optional<Carro> carro = carroRepository.findById(id);
		return carro.map(CarroDTO::create);
	}*/
}
