package co.edu.escuelaing.calculator.controller;

import co.edu.escuelaing.calculator.service.CalculatorService;
import static spark.Spark.*;

public class CalculatorController {
	
	public CalculatorController(final CalculatorService calculatorService) {
		get("hello", (req,res) -> "Welcome to my website!");
		get("acos", (req,res) -> calculatorService.getAcos(req, res));
		get("sqrt", (req,res) -> calculatorService.getSqrt(req, res));
	}

}
