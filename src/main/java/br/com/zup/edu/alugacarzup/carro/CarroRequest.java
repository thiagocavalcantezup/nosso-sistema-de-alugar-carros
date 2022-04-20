package br.com.zup.edu.alugacarzup.carro;

import javax.validation.constraints.NotBlank;

public class CarroRequest {

    @NotBlank
    private String reservadoPara;

    public CarroRequest() {}

    public CarroRequest(@NotBlank String reservadoPara) {
        this.reservadoPara = reservadoPara;
    }

    public String getReservadoPara() {
        return reservadoPara;
    }

}
