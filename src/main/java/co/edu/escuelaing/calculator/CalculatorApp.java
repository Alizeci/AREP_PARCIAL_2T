package co.edu.escuelaing.calculator;

import static spark.Spark.port;
import static spark.Spark.get;

public class CalculatorApp {
	public static void main(String[] args) {
		port(getPort());

		get("hello", (req, res) -> "Hello World!");
	}

	private static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4500;
	}
}
