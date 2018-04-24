
import java.util.*;
import com.sun.jmx.snmp.Timestamp;
import java.math.*;
import java.sql.Time;

class GA {

	static int anz = 4;
	static int gene = 4;// 22
	static int pm = 2;

	int[][] eltern = new int[anz][gene];
	int[][] nachkommen = new int[anz][gene];
	int[] besteLsg = new int[gene];
	float[] fitness = new float[anz];
	float besteFitness = -9999999.9f;

	Integer external = 4;
	Integer internal = 4;

	int[][] nutwerte = new int[external][internal];
	int[][] pairs = new int[2][2];

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
		for (int i = 0; i < external; i++) {
			for (int j = 0; j < internal; j++) {
				// Entlang der Diagonale.
				if (i == j) {
					result += (eltern[indiv][j] * nutwerte[i][j]);
					// System.out.println("diagonal indiv "+indiv+" result " + (eltern[indiv][j] *
					// nutwerte[i][j]));
				}

				// Zusätzliche Paare.
				pair = false;
				if (i == 0) {
					for (int pairs = j; pairs < internal; pairs++) {

						if (eltern[indiv][j] == 0) {
							// System.out.println("CONTINUE");
							continue;
						}
						if (eltern[indiv][pairs] == 1) {
							// System.out.println("eltern[indiv][pairs] "+eltern[indiv][pairs]);
							if (pair == true) {
								result += nutwerte[j][pairs];
								// System.out.println("[" + j + "] [" + pairs + "] " + nutwerte[j][pairs]);
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
					nutwerte[i][j] = value;
				} else {
					value = 0;
				}
				// System.out.print(" [" + value + "] ");
			}
			;
			// System.out.println();
		}
		;

		for (int i = 0; i < anz; i++) {
			for (int j = 0; j < gene; j++) {
				eltern[i][j] = Math.abs(r.nextInt()) % 2;
				// System.out.print(" " + eltern[i][j]);

			}
			System.out.println();
			fitness[i] = berechneFitness(i);

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

	void rekombinieren() {
		int elter1, elter2, indi1, indi2, trennstelle;

		for (int i = 0; i < anz; i++) {
			indi1 = Math.abs(r.nextInt()) % anz;
			indi2 = Math.abs(r.nextInt()) % anz;
			if (fitness[indi1] > fitness[indi2])
				elter1 = indi1;
			else
				elter1 = indi2;

			indi1 = Math.abs(r.nextInt()) % anz;
			indi2 = Math.abs(r.nextInt()) % anz;
			if (fitness[indi1] > fitness[indi2])
				elter2 = indi1;
			else
				elter2 = indi2;

			trennstelle = Math.abs(r.nextInt()) % gene;

			for (int j = 0; j < trennstelle; j++)
				nachkommen[i][j] = eltern[elter1][j];

			for (int j = trennstelle; j < gene; j++)
				nachkommen[i][j] = eltern[elter2][j];

		}

	}

	void mutieren() {
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

	void bewerten() {
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
		System.out.println("Beste Loesung: " + besteFitness + " Aktuelle Loesung: " + fitness[0]);
		/*
		 * for(int j=0;j<gene;j++) { System.out.print(" "+eltern[0][j]); }
		 * System.out.println();
		 */

	}

}
