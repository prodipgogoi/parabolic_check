package com.paraboliccheck.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.paraboliccheck.entity.PriceFeedModel;

@Component
public class ParabolicCalculator {

	private double minAF = 0.02;
	private double maxAF = 0.02;
	private double dacc = 0.01;

	public List<PriceFeedModel> testTheCalculation() {
		List<PriceFeedModel> priceFeeds = readCSV();
		/*
		 * priceFeeds.add(new PriceFeedModel("t1", 4440, 4440, 4432, 4437, 2264));
		 * priceFeeds.add(new PriceFeedModel("t1", 4437, 4438, 4435, 4435, 1379));
		 * priceFeeds.add(new PriceFeedModel("t1", 4436, 4437, 4427, 4428, 1620));
		 * priceFeeds.add(new PriceFeedModel("t1", 4428, 4429, 4422, 4427, 2375));
		 * priceFeeds.add(new PriceFeedModel("t1", 4427, 4430, 4426, 4430, 1170));
		 * priceFeeds.add(new PriceFeedModel("t1", 4430, 4430, 4427, 4428, 855));
		 * priceFeeds.add(new PriceFeedModel("t1", 4428, 4429, 4424, 4428, 988));
		 */
		prbCalculation(priceFeeds);

		return priceFeeds;
	}

	public List<PriceFeedModel> readCSV(MultipartFile file, double minAF, double maxAF, double dacc) {

		this.minAF=minAF;
		this.maxAF=maxAF;
		this.dacc=dacc;
		List<PriceFeedModel> priceFeeds = new ArrayList<PriceFeedModel>();
		// read file into stream, try-with-resources
		List<String> contents = getLines(file);
		contents.forEach(p -> {
			String[] strs = p.split(",");
			if (!strs[0].equals("Date")) {
				priceFeeds.add(new PriceFeedModel(strs[0],0,  Double.parseDouble(strs[1]), Double.parseDouble(strs[2]),
						Double.parseDouble(strs[3]), Double.parseDouble(strs[4]), Double.parseDouble(strs[5]), 5));
			}
		});
		prbCalculation(priceFeeds);

		return priceFeeds;
	}

	private List<String> getLines(MultipartFile multipart) {
		BufferedReader br;
		List<String> result = new ArrayList<>();
		try {

			String line;
			InputStream is = multipart.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				result.add(line);
			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return result;
	}

	public List<PriceFeedModel> readCSV() {
		String fileName = "C://Parabolicdata.csv";
		List<PriceFeedModel> priceFeeds = new ArrayList<PriceFeedModel>();
		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(p -> {
				String[] strs = p.split(",");
				if (!strs[0].equals("Date")) {
					priceFeeds.add(new PriceFeedModel(strs[0], 0, Double.parseDouble(strs[1]), Double.parseDouble(strs[2]),
							Double.parseDouble(strs[3]), Double.parseDouble(strs[4]), Double.parseDouble(strs[5]), 5));
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		return priceFeeds;
	}

	private void prbCalculation(List<PriceFeedModel> priceFeeds) {
		if (priceFeeds.get(2).getTime() == "") {
			return; 
		}
		prepareTheInitialData(priceFeeds);
		int length = priceFeeds.size();
		for (int i = 3; i < length; i++) {
			if(i==22)
				System.out.println("d");
			calculateParabolic(priceFeeds.get(i - 1), priceFeeds.get(i), 0.02, 0.2,0.01);			
		}
	}
	
	public void calculateParabolic(PriceFeedModel prevModel, PriceFeedModel currentModel, double minAf, double maxAf, double dacc)
	{
		this.minAF=minAf;
		this.maxAF=maxAf;
		this.dacc=dacc;
		sarCalculation(prevModel, currentModel);
		calculateSignal(currentModel);
		epCalculation(prevModel, currentModel);
		epSARCalculation(currentModel);
		calculateAF(prevModel, currentModel);
		calculateAfDiff(currentModel);
	}

	public void prepareTheInitialData(List<PriceFeedModel> priceFeeds) {
		double difaultSAR = calculateMean(priceFeeds);
		priceFeeds.get(2).setSar(difaultSAR);
		priceFeeds.get(2).setEp(priceFeeds.get(2).getHigh());
		if (priceFeeds.get(2).getTime().equals("")) {
			priceFeeds.get(2).setEpsar(0);
		}
		priceFeeds.get(2).setEpsar(priceFeeds.get(2).getEp() - priceFeeds.get(2).getSar());
		priceFeeds.get(2).setAf(minAF);
		if (priceFeeds.get(2).getTime().equals("")) {
			priceFeeds.get(2).setAfdiff(0);
		}
		priceFeeds.get(2).setAfdiff(priceFeeds.get(2).getAf() * priceFeeds.get(2).getEpsar());
		
		priceFeeds.get(2).setSignal("SELL");
		
		if(priceFeeds.get(2).getSar()<priceFeeds.get(2).getHigh()) {
			priceFeeds.get(2).setSignal("BUY");
		}
		
	}

	private void sarCalculation(PriceFeedModel prevModel, PriceFeedModel currentModel) {
		/// =IF(A5="","",IF(AND(L4="BUY",G4+K4>D5),H4,IF(AND(L4="SELL",G4+K4<C5),H4,G4+K4)))
		if (currentModel.getTime() == "") {
			currentModel.setSar(0);
		} else if (prevModel.getSignal().equals("BUY")
				&& (prevModel.getSar() + prevModel.getAfdiff()) > currentModel.getLow()) {
			currentModel.setSar(prevModel.getEp());
		} else if (prevModel.getSignal().equals("SELL")
				&& (prevModel.getSar() + prevModel.getAfdiff()) < currentModel.getHigh()) {
			currentModel.setSar(prevModel.getEp());
		} else {
			currentModel.setSar(prevModel.getSar() + prevModel.getAfdiff());
		}
	}

	private void epCalculation(PriceFeedModel prevModel, PriceFeedModel currentModel) {
		if (prevModel.getTime() == "") {
			currentModel.setEp(0);
		} else if (currentModel.getSignal().equals("BUY") && currentModel.getHigh() > prevModel.getEp()) {
			currentModel.setEp(currentModel.getHigh());
		} else if (currentModel.getSignal().equals("BUY") && currentModel.getHigh() <= prevModel.getEp()) {
			currentModel.setEp(prevModel.getEp());
		} else if (currentModel.getSignal().equals("SELL") && currentModel.getLow() < prevModel.getEp()) {
			currentModel.setEp(currentModel.getLow());
		} else {
			currentModel.setEp(prevModel.getEp());
		}
	}

	private void epSARCalculation(PriceFeedModel currentModel) {
		if (currentModel.getTime() == "") {
			currentModel.setEpsar(0);
		} else {
			currentModel.setEpsar(currentModel.getEp() - currentModel.getSar());
		}
	}

	private void calculateAF(PriceFeedModel prevModel, PriceFeedModel currentModel) {

		double subaf=functionOne(prevModel, currentModel);
		if (currentModel.getTime().equals("")) {
			currentModel.setAf(0);
		} else if(subaf > maxAF) {
			currentModel.setAf(maxAF);
		} else if (currentModel.getSignal().equals(prevModel.getSignal())) {
			currentModel.setAf(functionTwo(prevModel, currentModel));
		} else {
			currentModel.setAf(minAF);
		}
	}

	private double functionTwo(PriceFeedModel prevModel, PriceFeedModel currentModel) {
		if (prevModel.getAf() == maxAF) {
			return maxAF;
		} else if (currentModel.getSignal().equals("BUY") && currentModel.getEp() > prevModel.getEp()) {
			return prevModel.getAf() + dacc;

		} else if (currentModel.getSignal().equals("BUY") && currentModel.getEp() <= prevModel.getEp()) {
			return prevModel.getAf();

		} else if (currentModel.getSignal().equals("SELL") && currentModel.getEp() < prevModel.getEp()) {
			return prevModel.getAf() + dacc;

		} else if (currentModel.getSignal().equals("SELL") && currentModel.getEp() >= prevModel.getEp()) {
			return prevModel.getAf();

		} else {
			return 0;
		}
	}

	private double functionOne(PriceFeedModel prevModel, PriceFeedModel currentModel) {
		double result=0;
		
		if (currentModel.getSignal().equals(prevModel.getSignal())) {
			if (prevModel.getAf() == maxAF) {
				result= maxAF;
			} else if (currentModel.getSignal().equals("BUY") && currentModel.getEp() > prevModel.getEp()) {
				result= prevModel.getAf() + minAF;
			} else if (currentModel.getSignal().equals("BUY") && currentModel.getEp() <= prevModel.getEp()) {
				result= prevModel.getAf();
			} else if (currentModel.getSignal().equals("SELL") && currentModel.getEp() < prevModel.getEp()) {
				result= prevModel.getAf() + minAF;
			} else if (currentModel.getSignal().equals("SELL") && currentModel.getEp() >= prevModel.getEp()) {
				result= prevModel.getAf();
			} else {
				result= 0;
			}
		} else {
			result= minAF;
		}
		return result;
	}

	private void calculateAfDiff(PriceFeedModel currentModel) {
		if (currentModel.getTime().equals("")) {
			currentModel.setAfdiff(0);
		} else {
			currentModel.setAfdiff(currentModel.getAf() * currentModel.getEpsar());
		}
	}

	private void calculateSignal(PriceFeedModel model) {

		if (model.getSar() < model.getHigh()) {
			model.setSignal("BUY");
		} else if (model.getSar() > model.getLow()) {
			model.setSignal("SELL");
		} else {
			model.setSignal("");
		}
	}

	private double calculateMean(List<PriceFeedModel> priceFeeds) {
		double min = priceFeeds.get(0).getLow();
		for (int i = 1; i < 3; i++) {
			if(min>=priceFeeds.get(i).getLow())
			min = priceFeeds.get(i).getLow();
		}
		return min;
	}
}
