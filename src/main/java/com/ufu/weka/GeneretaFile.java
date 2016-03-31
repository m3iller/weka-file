package com.ufu.weka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneretaFile {

	public static void process(Integer iteration) throws FileNotFoundException, UnsupportedEncodingException {
		
		List<LearningObject> objs = new ArrayList<LearningObject>();
		
		File f = new File("/Users/miller/Documents/Mestrado/weka-file/weka-file.arff");
		
		PrintWriter writer = new PrintWriter(f);
		
		writer.println("@relation lomfelder");
		writer.println();
		writer.println("@attribute ativo numeric");
		writer.println("@attribute reflexivo numeric");
		writer.println("@attribute sensitivo numeric");
		writer.println("@attribute intuitivo numeric");
		writer.println("@attribute sequencial numeric");
		writer.println("@attribute global numeric");
		writer.println("@attribute visual numeric");
		writer.println("@attribute verbal numeric");
		writer.println();
		
		writer.print("@data");
		writer.println();
		
		for(int i=0; i< iteration; i++) {
			LearningObject o = generateLomFelder();
			objs.add(o);
			writer.println(o.toString());
		}
		
		writer.close();
		
	}
	
	
	/**
	 * Mapeamento da quantidade máxima de estilos x lom
		Números maximos
		global = 1
		sequencial = 2
		Verbal = 2
		Visual = 2
		Reflexivo = 4
		Ativo = 4
		Intuitivo = 1
		sensitivo = 2
	 * @return
	 */
	public static LearningObject generateLomFelder() {
		
		Random rand = new Random();
		LearningObject obj = new LearningObject();
		obj.setAtivo(randInt(0, 4,rand));
		obj.setReflexivo(randInt(0, 4,rand));
		
		obj.setSensitivo(randInt(0, 2,rand));
		obj.setIntuitivo(randInt(0, 1,rand));
		
		obj.setSequencial(randInt(0, 2,rand));
		obj.setGlobal(randInt(0, 1,rand));
		
		obj.setVisual(randInt(0, 2,rand));
		obj.setVerbal(randInt(0, 2,rand));
		
		return obj;
	}
	
	public static Integer randInt(int min, int max, Random rand) {

	    // Usually this can be a field rather than a method variable
	    

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return Integer.valueOf(randomNum);
	}
	
	
	
}
