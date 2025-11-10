package com.example.calculator.controller;

        import com.example.calculator.service.Calculator;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    Calculator calculatorService;
    @Autowired
    public CalculatorController(Calculator calculatorService){
        this.calculatorService = calculatorService;
    }
    @GetMapping("sum")
    int ab(@RequestParam("a") int a, @RequestParam("b") int b) {
        return calculatorService.sum(a, b);
    }


}