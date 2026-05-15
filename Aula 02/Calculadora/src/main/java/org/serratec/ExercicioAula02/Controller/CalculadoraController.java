package org.serratec.ExercicioAula02.Controller;

import org.serratec.ExercicioAula02.Exceptions.ValorInvalidoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @GetMapping("/somar")
    public double somar(@RequestParam double a, @RequestParam double b){
        return a + b;
    }

    @GetMapping("/subtrair")
    public double subtrair(@RequestParam double a, @RequestParam double b){
        return a - b;
    }

    @GetMapping("/dividir")
    public double dividir(@RequestParam double a, @RequestParam double b){
        if (a == 0 || b == 0){
            throw new ValorInvalidoException("Valor inválido!");
        }
        return a / b;
    }

    @GetMapping("/multiplicar")
    public double multiplicar (@RequestParam double a, @RequestParam double b){
        return a * b;
    }

    @ExceptionHandler(ValorInvalidoException.class)
    public ResponseEntity<String> handleValorInvalido(ValorInvalidoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
