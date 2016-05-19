package com.ufu.weka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WekaMain {

	
	public static Integer idSequencial = 0;
	
	public static void main(String[] args) {
		 
		List<LearningObject> lomList = new ArrayList<LearningObject>();
		 
		List<LearningObject> lomListFinal = new ArrayList<LearningObject>();
		 
		try {
			for(int i=0; i < 5000; i++) {
				LearningObject o = GeneretaFile.generateLomFelder();
				lomList.add(o);
			}
			
			for(FelderSilvermanArranjo cluster: FelderSilvermanArranjo.values()) {
				int i = 0;
				for(LearningObject l:lomList) {
					if(cluster.getValor().equals(l.getCluster()) ) {
						lomListFinal.add(l);
						i++;
					}
					
					if(i == 100) {
						break;
					}
				}
			}
			
			Collections.sort(lomListFinal, new Comparator<LearningObject>() {
				public int compare(LearningObject o1, LearningObject o2) {
					return o1.getId().compareTo(o2.getId());
				}
			});
			
			GeneretaFile.generateWekaFIle(lomListFinal);
			GeneretaFile.identificador =0;
			GeneretaFile.generateSomFile(lomListFinal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
