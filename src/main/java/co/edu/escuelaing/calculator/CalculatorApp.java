package co.edu.escuelaing.calculator;

import static spark.Spark.port;
import co.edu.escuelaing.calculator.controller.CalculatorController;
import co.edu.escuelaing.calculator.service.CalculatorService;

public class CalculatorApp {
	public static void main(String[] args) {
		port(getPort());

		new CalculatorController(new CalculatorService());
	}

	private static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4500;
	}
}
