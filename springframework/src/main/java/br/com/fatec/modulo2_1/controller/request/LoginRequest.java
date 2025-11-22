package br.com.fatec.modulo2_1.controller.request;

public record LoginRequest(
        String username,
        String password
) {
}
