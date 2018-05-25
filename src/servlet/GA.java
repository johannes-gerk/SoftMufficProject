package servlet;

import java.util.*;
import java.util.Map.Entry;

import com.sun.jmx.snmp.Timestamp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.math.*;
import java.net.URL;
import java.sql.Time;

class GA {

	static int anz = 10; // Anzahl Individuen
	static int gene = 100; // Anzahl Gene
	static int pm = 2; // Wahrscheinlichkeit für Mutation?

	int[][] eltern = new int[anz][gene];
	int[][] nachkommen = new int[anz][gene];
	int[] besteLsg = new int[gene];
	float[] fitness = new float[anz];
	float besteFitness = -9999999.9f;

	float[][] nutzwerteA = null;
	float[][] nutzwerteB = null;

	// "Zufallsgenerator"
	java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
	Random r = new Random(time.getTime());

	float berechneFitness(int indiv) {
		/*
		 * float deciwert=-1.0f; float dualwert= 0.0f; float fitness;
		 * 
		 * for(int j=0;j<gene;j++) { dualwert += (float)eltern[indiv][j] *
		 * (float)Math.pow(2.0,(double)j); }
		 * 
		 * deciwert += dualwert *(3.0f/(float)(Math.pow(2.0,22.0)-1.0)); deciwert +=
		 * dualwert *(3.0f/(float)(Math.pow(2.0,300.0)-1.0)); fitness = deciwert *
		 * (float)Math.sin((double)deciwert*Math.PI*10.0) + 1.0f;
		 */

		int result = 0;
		boolean pair;
		for (int i = 0; i < nutzwerteA.length; i++) {
			for (int j = 0; j < nutzwerteA.length; j++) {
				/* Entlang der Diagonale. */
				if (i == j) {
					result += (eltern[indiv][j] * nutzwerteA[i][j]);
					// System.out.println("diagonal indiv "+indiv+" result " + (eltern[indiv][j] *
					// nutzwerteA[i][j]));
				}
				
				/* Bilde Paare. */
				pair = false;
				if (i == 0) {
					for (int pairs = j; pairs < nutzwerteA.length; pairs++) {

						if (eltern[indiv][j] == 0) {
							// System.out.println("CONTINUE");
							continue;
						}
						if (eltern[indiv][pairs] == 1) {
							// System.out.println("eltern[indiv][pairs] "+eltern[indiv][pairs]);
							if (pair == true) {
								result += nutzwerteA[j][pairs];
								// System.out.println("[" + j + "] [" + pairs + "] " + nutzwerteA[j][pairs]);
							} else {
								pair = true;
							}
						}
					}
				}
			}
		}

		return result;
	}

	GA() {	
		/* Daten einlesen. */
		 nutzwerteA = deserializeArr("C:\\Users\\Johannes\\eclipse-workspace\\SoftCompProject\\webapps\\resources\\files\\AgentA_Arr.ser");
		 nutzwerteB = deserializeArr("C:\\Users\\Johannes\\eclipse-workspace\\SoftCompProject\\webapps\\resources\\files\\AgentB_Arr.ser");
		//nutzwerteA = deserializeArr("D:\\home\\site\\wwwroot\\webapps\\ROOT\\resources\\files\\AgentA_Arr.ser");
	    //nutzwerteB = deserializeArr("D:\\home\\site\\wwwroot\\webapps\\ROOT\\resources\\files\\AgentB_Arr.ser");
		
	    /* Generiere zufällige Werte
		int max = 100;
		int min = -100;
		int value;
		for (int i = 0; i < external; i++) {
			for (int j = 0; j < internal; j++) {
				// System.out.println("runde:" + j);
				// System.out.println("_ curr val=" + value);
				// System.out.println("Max Runde:" + internal.toString());
				if (i <= j) {
					value = r.nextInt(max - min + 1) + min;
					nutzwerteA[i][j] = value;
				} else {
					value = 0;
				}
				// System.out.print(" [" + value + "] ");
			}
			;
			// System.out.println();
		}
		;*/

		// Generiert zufällige Gene (0-1 Werte) als Eltern.
		for (int i = 0; i < anz; i++) {
			for (int j = 0; j < gene; j++) {
				eltern[i][j] = Math.abs(r.nextInt()) % 2;
				// System.out.print(" " + eltern[i][j]);

			}
			System.out.println();
			
			// Berechne Fitness aller Eltern.
			fitness[i] = berechneFitness(i);

			// Suche den Besten.
			if (fitness[i] > besteFitness) {
				for (int j = 0; j < gene; j++) {
					besteLsg[j] = eltern[i][j];
				}
				besteFitness = fitness[i];
				System.out.println("Beste Fitness= " + besteFitness);
			}

			// System.out.print(" "+fitness[i]);
			System.out.println();

		}

	}

	/* Ein-Punkt Crossover */
	void onePointCrossover() {
		int elter1, elter2, indi1, indi2, trennstelle;

		// Nehme zwei zufällige Individuen aus dem Fitness Array.
		// TODO: anz-1 um arrayoutofbound zuvorzukommen
		for (int i = 0; i < anz-1; i++) {
			indi1 = Math.abs(r.nextInt()) % anz;
			indi2 = Math.abs(r.nextInt()) % anz;
			if (fitness[indi1] > fitness[indi2]) {
				elter1 = indi1;
			} else {
				elter1 = indi2;
			}
			// elter2 kann elter1 gleich sein
			indi1 = Math.abs(r.nextInt()) % anz;
			indi2 = Math.abs(r.nextInt()) % anz;
			if (fitness[indi1] > fitness[indi2]) {
				elter2 = indi1;
			} else {
				elter2 = indi2;
			}

			// Bilde zufällige Trennstelle.
			trennstelle = Math.abs(r.nextInt()) % gene;

			// Ein-Punkt-Crossover
			for (int j = 0; j < trennstelle; j++) {
				nachkommen[i][j] = eltern[elter1][j];
				try {
					nachkommen[i+1][j] = eltern[elter2][j];
				} catch (ArrayIndexOutOfBoundsException e) {
					nachkommen[0][j] = eltern[elter2][j];
				}
			}
			for (int j = trennstelle; j < gene; j++) {
				nachkommen[i][j] = eltern[elter2][j];
				try {
					nachkommen[i+1][j] = eltern[elter1][j];
				} catch (ArrayIndexOutOfBoundsException e) {
					nachkommen[0][j] = eltern[elter1][j];
				}
			}
		}

	}
	
	/* Uniform Crossover */
	void uniformCrossover() {
		int elter1, elter2, indi1, indi2;

		// Nehme zwei zufällige Individuen aus dem Fitness Array.
		// TODO: anz-1 um arrayoutofbound zuvorzukommen
		for (int i = 0; i < anz-1; i++) {
			indi1 = Math.abs(r.nextInt()) % anz;
			indi2 = Math.abs(r.nextInt()) % anz;
			if (fitness[indi1] > fitness[indi2]) {
				elter1 = indi1;
			} else {
				elter1 = indi2;
			}
			// elter2 kann elter1 gleich sein
			indi1 = Math.abs(r.nextInt()) % anz;
			indi2 = Math.abs(r.nextInt()) % anz;
			if (fitness[indi1] > fitness[indi2]) {
				elter2 = indi1;
			} else {
				elter2 = indi2;
			}
			
			//Bit-Maske
			int[] bitMaske = new int[gene];
			for (int iMask: bitMaske) {
				bitMaske[iMask] = Math.abs(r.nextInt()) % 2;
			}
			
			// Uniform-Crossover
			for (int j = 0; j < gene; j++) {
				if (bitMaske[j]==0) {
					nachkommen[i][j] = eltern[elter1][j];
					nachkommen[i+1][j] = eltern[elter2][j];
				} else {
					nachkommen[i][j] = eltern[elter2][j];
					nachkommen[i+1][j] = eltern[elter1][j];
				}
				
			}
		}
	}

	/* Flip-Mutation */
	void flipMutation() {
		int zz;
		for (int i = 0; i < anz; i++) {
			for (int j = 0; j < gene; j++) {
				zz = Math.abs(r.nextInt()) % 1000;
				if (zz < pm) {
					if (nachkommen[i][j] == 0)
						nachkommen[i][j] = 1;
					else
						nachkommen[i][j] = 0;
				}
			}
		}
	}

	/* Selektion (Gen-Replacement) */
	void selectionGenReplacement() {
		String result = "";
		for (int i = 0; i < anz; i++) {
			for (int j = 0; j < gene; j++) {
				eltern[i][j] = nachkommen[i][j];
			}
			fitness[i] = berechneFitness(i);

			if (fitness[i] > besteFitness) {
				besteFitness = fitness[i];
				for (int j = 0; j < gene; j++) {
					besteLsg[j] = eltern[i][j];
				}
			}
		}
		for (int k: besteLsg) {
			result +="["+k+"]";
		}
		System.out.println("Beste Loesung: " + besteFitness + " Aktuelle Loesung: " + fitness[0] + " Bestes Individuum: "+result);
		/*
		 * for(int j=0;j<gene;j++) { System.out.print(" "+eltern[0][j]); }
		 * System.out.println();
		 */

	}
	/* Selektion (Rank-Replacement) */
	void selectionRankReplacement() {
		String result = "";
		
		// Save der alten Generation
		int [][] save = new int [anz][gene];
		
		// Map fürs Sortieren
		Map<int[],Float> unsortedMap = new HashMap<int[],Float>();
		
		int rangTotal = 0;
		Array raenge[];
		for (int i=1; i <= anz; i++) {
			rangTotal += i; 
		}
		
		for (int i = 0; i < anz; i++) {
			for (int j = 0; j < gene; j++) {
				save [i][j] = eltern[i][j];
				eltern[i][j] = nachkommen[i][j];
			}

			// Fitness der neuen Generation
			fitness[i] = berechneFitness(i);		
			unsortedMap.put(nachkommen[i], fitness[i]);
			
			
			if (fitness[i] > besteFitness) {
				besteFitness = fitness[i];
				for (int j = 0; j < gene; j++) {
					besteLsg[j] = eltern[i][j];
				}
			}
		}
		LinkedHashMap<int[], Float> sortedMap;
		sortedMap = (LinkedHashMap<int[], Float>) sortByComparator(unsortedMap, false);
		
		int lowerBound = 0;
		int upperBound = 0;
		for (int i= 0; i < anz; i++) {
			int randomNumber = Math.abs(r.nextInt()) % rangTotal;
			lowerBound += upperBound+i;
			upperBound = lowerBound +anz-i;
			if (randomNumber >= (lowerBound) && randomNumber <= (upperBound)) {
				
			}
		}
		
		for (int k: besteLsg) {
			result +="["+k+"]";
		}
		System.out.println("Beste Loesung: " + besteFitness + " Aktuelle Loesung: " + fitness[0] + " Bestes Individuum: "+result);
		/*
		 * for(int j=0;j<gene;j++) { System.out.print(" "+eltern[0][j]); }
		 * System.out.println();
		 */

	}
	
	private static float[][] deserializeArr(String filename) {

    	float[][] arr = null;
    	
        try {
            FileInputStream fileStr = new FileInputStream(filename);   
            ObjectInputStream in = new ObjectInputStream(fileStr);

            // Reading the object => deserialization of object
            //#####Arr -> your generated Mat
            arr = (float[][]) in.readObject();
      
            in.close();
            fileStr.close();

            System.out.println("Arr has been deserialized!");
            System.out.println("Matrix Size: " + arr.length);
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException is caught");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        return arr;
    }
	
    private static Map<int[], Float> sortByComparator(Map<int[], Float> unsortMap, final boolean order){

        List<Entry<int[], Float>> list = new LinkedList<Entry<int[], Float>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<int[], Float>>() {
            public int compare(Entry<int[], Float> o1, Entry<int[], Float> o2){
                if (order){
                    return o1.getValue().compareTo(o2.getValue());
                }
                else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<int[], Float> sortedMap = new LinkedHashMap<int[], Float>();
        for (Entry<int[], Float> entry : list){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
