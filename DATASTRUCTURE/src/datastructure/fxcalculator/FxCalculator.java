package datastructure.fxcalculator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;

public class FxCalculator {

	static Map<String, Map<String, String>> ccyRelationalMatrix;
	static Map<String, Float> rateMap;
	static Map<String, Integer> precisionValueMap;

	public static void main(String[] args) {
		Float amount=0f;
		String fromCcy="";
		String toCcy="";
		if (args.length == 4) {
			 fromCcy = args[0];
			 amount = Float.parseFloat(args[1]);
			 toCcy = args[3];
			System.out.println(fromCcy + " " + amount + " " + "in " + toCcy);
		}
		fxCalculator(amount, fromCcy, toCcy);
	}
	public static void fxCalculator(Float amount, String fromCcy, String toCcy){
		init();

		FxCalculator fxCalcObj = new FxCalculator();
		fxCalcObj.calculateCurrencyValue(amount, fromCcy, toCcy);
		
	}

	private void calculateCurrencyValue(Float amount, String fromCcy, String toCcy) {
		Float calculatedAmount = 0f;
		Integer toCcyPrecisionValue = precisionValueMap.get(toCcy);
		Integer fromCcyPrecisionValue = precisionValueMap.get(fromCcy);
		Map<String, String> conversionMap = ccyRelationalMatrix.get(fromCcy);
		ArrayList<String> list = new ArrayList<String>();
		if (conversionMap == null) {
			System.out.println("Unable to find rate for " + fromCcy + "/" + toCcy);
			return;
		}

		String refCcy = conversionMap.get(toCcy);
		if (refCcy == null) {
			System.out.println("Unable to find rate for " + fromCcy + "/" + toCcy);
			return;
		} else if (refCcy.equals("1:1")) {
			calculatedAmount = amount;
		} else if (refCcy.equals("D")) {
			Float rate = rateMap.get(fromCcy + toCcy);
			calculatedAmount = rate * amount;
		} else if (refCcy.equals("Inv")) {
			Float rate = rateMap.get(toCcy + fromCcy);
			calculatedAmount = (1 / rate) * amount;
		} else {
			list.add(fromCcy + refCcy);
			if (rateMap.get(fromCcy + refCcy) != null)
				calculatedAmount = amount * (rateMap.get(fromCcy + refCcy));
			else if (rateMap.get(refCcy + fromCcy) != null)
				calculatedAmount = amount * (1 / rateMap.get(refCcy + fromCcy));

			String tempCcy = fromCcy;
			while (!refCcy.equals(toCcy)) {
				conversionMap = ccyRelationalMatrix.get(refCcy);
				if (conversionMap.get(toCcy).equals("D")) {
					list.add(refCcy + toCcy);
					calculatedAmount = calculatedAmount * rateMap.get(refCcy + toCcy);
					refCcy = toCcy;
				} else if (conversionMap.get(toCcy).equals("Inv")) {
					list.add(refCcy + toCcy);
					refCcy = toCcy;
					if (rateMap.get(toCcy + refCcy) != null)
						calculatedAmount = calculatedAmount * (1 / rateMap.get(toCcy + refCcy));
					else if (rateMap.get(refCcy + toCcy) != null)
						calculatedAmount = calculatedAmount * (rateMap.get(refCcy + toCcy));
				} else {
					if (rateMap.get(refCcy + conversionMap.get(toCcy)) != null)
						calculatedAmount = calculatedAmount * (rateMap.get(refCcy + conversionMap.get(toCcy)));
					else if (rateMap.get(conversionMap.get(toCcy) + refCcy) != null)
						calculatedAmount = calculatedAmount * (1 / rateMap.get(conversionMap.get(toCcy) + refCcy));
					tempCcy = refCcy;
					refCcy = conversionMap.get(toCcy);
					list.add(tempCcy + refCcy);
				}
			}
		}
		BigDecimal convertedVal = new BigDecimal(calculatedAmount.toString());
		BigDecimal inputAmt = new BigDecimal(amount.toString());
		if (toCcyPrecisionValue != null) {
			convertedVal = convertedVal.setScale(toCcyPrecisionValue, RoundingMode.HALF_UP);
			inputAmt = inputAmt.setScale(fromCcyPrecisionValue, RoundingMode.HALF_UP);
		} else
			System.out.println("Please check config file for Precision Values configuration !");

		System.out.println(fromCcy + " " + inputAmt + " = " + toCcy + " " + convertedVal);
	}

	public static Properties loadProperty() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);

			// enumKey = prop.keys();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}

	public static void init() {
		try {
			// get the property value and print it out
			Properties prop = loadProperty();
			Enumeration<Object> enumKey = prop.keys();
			Map<String, Map<String, String>> rateMatrixMap = new HashMap<>();
			ccyRelationalMatrix = new HashMap<>();
			rateMap = new HashMap<String, Float>();
			precisionValueMap = new HashMap<String, Integer>();
			while (enumKey.hasMoreElements()) {
				String key = (String) enumKey.nextElement();
				if (key.length() == 6) {
					Map<String, String> firstconMap = null;
					Map<String, String> secondConMap = null;

					rateMap.put(key, Float.parseFloat(prop.getProperty(key)));
					String firstCCy = key.substring(0, 3);
					String secondCCY = key.substring(3, 6);

					firstconMap = rateMatrixMap.get(firstCCy);
					if (firstconMap == null) {
						firstconMap = new HashMap<>();
						firstconMap.put(firstCCy, "1:1");
						firstconMap.put(secondCCY, "D");
						rateMatrixMap.put(firstCCy, firstconMap);
					} else if (firstconMap.get(secondCCY) == null) {
						firstconMap.put(secondCCY, "D");
					}

					secondConMap = rateMatrixMap.get(secondCCY);
					if (secondConMap == null) {
						secondConMap = new HashMap<>();
						secondConMap.put(firstCCy, "Inv");
						secondConMap.put(secondCCY, "1:1");
						rateMatrixMap.put(secondCCY, secondConMap);
					} else if (secondConMap.get(firstCCy) == null) {
						secondConMap.put(secondCCY, "1:1");
						secondConMap.put(firstCCy, "Inv");
					}
				} else if (key.length() == 3) {
					String propValue = prop.getProperty(key);
					propValue = propValue.substring(0, propValue.indexOf(" "));
					precisionValueMap.put(key, Integer.parseInt(propValue));
				}
			}

			for (Map.Entry<String, Map<String, String>> outerMap : rateMatrixMap.entrySet()) {
				String key = outerMap.getKey();
				Map<String, String> innerMap = outerMap.getValue();
				Map<String, String> ccyRelationalMatrixInnerMap = new HashMap<String, String>();
				Set<String> keySet = innerMap.keySet();
				Map<String, String> newMap = new HashMap<String, String>();

				for (Map.Entry<String, String> innerMapEntrySet : innerMap.entrySet()) {
					ArrayList<String> refferedCcyList = new ArrayList<String>();
					String innerKey = innerMapEntrySet.getKey();
					if (key.equals(innerKey))// || keySet.contains(innerKey))
						continue;
					else {
						refferedCcyList.add(innerKey);
						newMap = getforkey(refferedCcyList, rateMatrixMap, keySet, newMap);
					}
				}
				ccyRelationalMatrixInnerMap.putAll(innerMap);
				ccyRelationalMatrixInnerMap.putAll(newMap);
				ccyRelationalMatrix.put(key, ccyRelationalMatrixInnerMap);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static Map<String, String> getforkey(ArrayList<String> refferedCcyList,
			Map<String, Map<String, String>> rateMatrixMap, Set<String> keySet, Map<String, String> newMap) {
		String element = refferedCcyList.get(refferedCcyList.size() - 1);
		String baseCcy = refferedCcyList.get(0);

		Map<String, String> mptest = rateMatrixMap.get(element);
		for (Map.Entry<String, String> entryset : mptest.entrySet()) {
			String key = entryset.getKey();

			if (keySet.contains(key) || newMap.containsKey(key) || element.equals(key))
				continue;
			else {
				refferedCcyList.add(key);
				newMap.put(key, baseCcy);
				newMap = getforkey(refferedCcyList, rateMatrixMap, keySet, newMap);
			}
		}
		newMap.putAll(newMap);
		return newMap;
	}
}
