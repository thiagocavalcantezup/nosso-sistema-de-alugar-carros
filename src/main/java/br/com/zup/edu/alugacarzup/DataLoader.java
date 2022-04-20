package br.com.zup.edu.alugacarzup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.zup.edu.alugacarzup.carro.Carro;
import br.com.zup.edu.alugacarzup.carro.CarroRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final CarroRepository carroRepository;

    public DataLoader(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (carroRepository.count() == 0) {
            load();
        }
    }

    private void load() {
        carroRepository.save(new Carro("Celta", 2000, "Chevrolet"));
    }

}
