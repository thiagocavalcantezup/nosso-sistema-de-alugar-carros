package br.com.zup.edu.alugacarzup.carro;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private CarroRepository carroRepository;

    public CarroController(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @Transactional
    @PatchMapping("/{carroId}")
    public ResponseEntity<Void> alugar(@PathVariable Long carroId) {
        Carro carro = carroRepository.findById(carroId)
                                     .orElseThrow(
                                         () -> new ResponseStatusException(
                                             HttpStatus.NOT_FOUND,
                                             "Não existe um carro com o id fornecido."
                                         )
                                     );

        carro.alugar();

        return ResponseEntity.noContent().build();
    }

}
