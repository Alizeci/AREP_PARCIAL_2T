package co.edu.escuelaing.calculator.service;

import org.json.JSONObject;
import spark.Request;
import spark.Response;

public class CalculatorService {

	public Object getAcos(Request req, Response res) {
		Double value = Double.valueOf(req.queryParams("value"));
		Double result = MathFunctions.calculateAcos(value);

		JSONObject resultObj = new JSONObject();
		resultObj.put("operation", "acos");
		resultObj.put("input", value);
		resultObj.put("output", result);

		System.out.println("acos function executed successfully!");
		System.out.println(resultObj);
		return resultObj;
	}

	public Object getSqrt(Request req, Response res) {
		Double value = Double.valueOf(req.queryParams("value"));
		Double result = MathFunctions.calculateSqrt(value);

		JSONObject resultObj = new JSONObject();
		resultObj.put("operation", "sqrt");
		resultObj.put("input", value);
		resultObj.put("output", result);

		System.out.println("sqrt function executed successfully!");
		System.out.println(resultObj);
		return resultObj;
	}

}
