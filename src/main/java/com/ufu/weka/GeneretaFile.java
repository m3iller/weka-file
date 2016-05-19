package com.ufu.weka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;

public class GeneretaFile {
	
	public static Integer identificador = 0;

	public static void generateSomFile(List<LearningObject> lomList) throws FileNotFoundException, UnsupportedEncodingException {
		
		File f = new File("/Users/miller/Documents/Mestrado/weka-file/som-file.txt");
		
		PrintWriter writer = new PrintWriter(f);
		
//		writer.print("8");
//		writer.println();
//		writer.print("#n ");
		writer.print("ativo ");
		writer.print("reflexivo ");
		writer.print("sensitivo ");
		writer.print("intuitivo ");
		writer.print("sequencial ");
		writer.print("global ");
		writer.print("visual ");
		writer.print("verbal ");
		
		writer.println();
		
		writer.print("");
		for(LearningObject o:lomList) {
			writer.println(o.toStringSom());
		}
		
		writer.print("");
		writer.close();
		
		writer.close();
	}
	
	public static void generateWekaFIle(List<LearningObject> lomList) throws FileNotFoundException, UnsupportedEncodingException {
		
		File f = new File("/Users/miller/Documents/Mestrado/weka-file/weka-file.arff");
		
		PrintWriter writer = new PrintWriter(f);
		
		writer.println("@relation lomfelder");
		writer.println();
		writer.println("@attribute identificador numeric");
		writer.println("@attribute sensitivo numeric");
		writer.println("@attribute intuitivo numeric");
		writer.println("@attribute ativo numeric");
		writer.println("@attribute reflexivo numeric");
		writer.println("@attribute sequencial numeric");
		writer.println("@attribute global numeric");
		writer.println("@attribute visual numeric");
		writer.println("@attribute verbal numeric");
		
		String classValues = mountClass();
		
		writer.println(classValues);
		writer.println();
		
		writer.print("@data");
		writer.println();
		
		for(LearningObject o:lomList) {
			writer.println(o.toString());
		}
		
		writer.close();
	}
	
	
	private static String mountClass() {
		
		StringBuilder clazz = new StringBuilder();
		clazz.append("@attribute class 	{");
		
		FelderSilvermanArranjo[] styles = FelderSilvermanArranjo.values();
		
		for(FelderSilvermanArranjo s:styles) {
			clazz.append(s.getValor());
			clazz.append(",");
		}
		
		clazz.setLength(clazz.length() - 1);
		clazz.append("}");
		
		return clazz.toString();
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
		obj.setId(identificador++);
		
		obj.setAtivo(randInt(0, 4,rand));
		int maxAtivo = 6 - obj.getAtivo();
		if(maxAtivo > 4) {
			maxAtivo = 4;
		} 
		
		obj.setReflexivo(randInt(0, maxAtivo,rand));
		
		obj.setIntuitivo(randInt(0, 1,rand));
		if(obj.getIntuitivo() == 1) {
			obj.setSensitivo(randInt(0, 1,rand));
		} else {
			obj.setSensitivo(randInt(0, 2,rand));
		}
		
		obj.setGlobal(randInt(0, 1,rand));
		if(obj.getGlobal() == 1) {
			obj.setSequencial(randInt(0, 1,rand));
		} else {
			obj.setSequencial(randInt(0, 2,rand));
		}
		
		obj.setVisual(randInt(0, 2,rand));
		maxAtivo = 3 - obj.getVisual();
		if(maxAtivo > 2) {
			maxAtivo = 2;
		}
		obj.setVerbal(randInt(0, maxAtivo,rand));
		
		obj.setCluster(validaCluster(obj));
		
		return obj;
	}
	
	private static String validaCluster(LearningObject o) {
		Random r = new Random();
		
		int aleatorio = randInt(0, 1, r);
		
		StringBuilder s = new StringBuilder();
		
		String sen = "Sen";
		String intu = "Int";
		
		String ati = "Ati";
		String ref = "Ref";
		
		String glo = "Glo";
		String seq = "Seq";
		
		String vis = "Vis";
		String ver = "Ver";
		
		if(o.getSensitivo() > o.getIntuitivo()) {
			s.append(sen);
		} else if(o.getSensitivo() < o.getIntuitivo()) {
			s.append(intu);
		} else {
			if(aleatorio == 0) {
				s.append(sen);
			} else {
				s.append(intu);
			}
		}
		
		if(o.getAtivo() > o.getReflexivo()) {
			s.append(ati);
		} else if(o.getAtivo() < o.getReflexivo()) {
			s.append(ref);
		} else {
			if(aleatorio == 0) {
				s.append(ati);
			} else {
				s.append(ref);
			}
		}
		
		if(o.getSequencial() > o.getGlobal()) {
			s.append(seq);
		} else if(o.getSequencial() < o.getGlobal()) {
			s.append(glo);
		} else {
			if(aleatorio == 0) {
				s.append(seq);
			} else {
				s.append(glo);
			}
		}
		
		if(o.getVisual() > o.getVerbal()) {
			s.append(vis);
		} else if(o.getVisual() < o.getVerbal()) {
			s.append(ver);
		} else {
			if(aleatorio == 0) {
				s.append(vis);
			} else {
				s.append(ver);
			}
		}
		
		return s.toString();
	}

	public static Integer randInt(int min, int max, Random rand) {
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return Integer.valueOf(randomNum);
	}
	
}
