package ada.entrega1;

import java.util.Scanner;

/*
 * DEVELOPED BY EIMI LEDESMA 
 * 
 * */
public class Tateti {

	private static int FILAS = 3;
	private static int COLUMNAS = 3;

	public static void main(String[] args) {
		String tateti[][] = new String[FILAS][COLUMNAS];

		Scanner scn = new Scanner(System.in);

		inicializarMatriz(FILAS, COLUMNAS, tateti);

		System.out.println("\n\t¡COMENZAMOS A JUGAR AL TATETI!");

		llenarMatriz(tateti, scn);

		System.out.println("\n ¡Tateti finalizado! ");

		imprimirMatriz(tateti);

		scn.close();

	}

	private static void imprimirMatriz(String[][] tateti) {
		for (int k = 0; k < tateti.length; k++) {
			for (int l = 0; l < tateti[k].length; l++) {
				System.out.print(tateti[k][l] + " ");
			}
			System.out.println();
		}
	}

	private static void inicializarMatriz(int fila, int columna, String[][] tateti) {
		for (int k = 0; k < fila; k++) {
			for (int l = 0; l < columna; l++) {
				tateti[k][l] = "-";
			}
		}
	}

	private static void llenarMatriz(String[][] tateti, Scanner scan) {

		int cdadMovimientos = FILAS * COLUMNAS;
		int c1 = 0, c2 = 0, count = 0;

		for (int i = 0; ((i < cdadMovimientos) && !conGanadorFila(tateti) && !conGanadorColumna(tateti)
				&& !conGanadorDiagonal(tateti)); i++) {

			int mod = i % 2;
			System.out.println("\n  Movimiento " + (i + 1) + ", va el");
			switch (mod) {

			case 0:
				System.out.println("\tJUGADOR 1");
				validarCasillero1(c1, c2, tateti, scan);
				count++;
				break;

			case 1:
				System.out.println("\tJUGADOR 2");
				validarCasillero2(c1, c2, tateti, scan);
				count++;
				break;

			}
		}

		if (count >= cdadMovimientos) {
			System.out.println("\n¡No hay más movimientos para hacer!");
			System.out.println("\n¡No hay ganador en esta partida!");
		}
	}

	private static int validarCoordenada(int c, int tope, Scanner scn) {
		while (c < 0 || c >= tope) {
			System.out.println("\nIngrese un valor de coordenada entre 0 y " + (tope - 1));
			c = scn.nextInt();
		}
		return c;
	}

	private static boolean conGanadorDiagonal(String[][] tateti) {
		boolean gana = false;

		if (tateti[0][0] == tateti[1][1] && tateti[1][1] == tateti[2][2] && tateti[0][0] != "-" && tateti[1][1] != "-"
				&& tateti[2][2] != "-") {
			System.out.println("\n\t¡Tenemos ganador en la diagonal principal!");
			System.out.println("\nLas posiciones son: [0,0], [1][1], [2][2]"); // imprimir matriz
			System.out.print("con la marca " + tateti[0][0] + " correspondiente al ");
			if (tateti[0][0] == "X") {
				System.out.print("jugador 1\n");
				System.out.println("\n\t¡FELICIDADES!");
			}
			;
			if (tateti[0][0] == "O") {
				System.out.print("jugador 2\n");
				System.out.println("\n\t¡FELICIDADES!");
			}
			;
			gana = true;
		}
		if (tateti[0][2] == tateti[1][1] && tateti[1][1] == tateti[2][0] && tateti[0][2] != "-" && tateti[1][1] != "-"
				&& tateti[2][0] != "-") {
			System.out.println("\n\t¡Tenemos ganador en la diagonal secundaria!");
			System.out.println("\nLas posiciones son: [0,2], [1][1], [2][0]"); // imprimir matriz
			System.out.print("con la marca " + tateti[0][2] + " correspondiente al ");
			if (tateti[1][1] == "X") {
				System.out.print("jugador 1\n");
				System.out.println("\n\t¡FELICIDADES!");
			}
			;
			if (tateti[1][1] == "O") {
				System.out.print("jugador 2\n");
				System.out.println("\n\t¡FELICIDADES!");
			}
			;
			gana = true;
		}
		return gana;
	}

	private static boolean conGanadorColumna(String[][] tateti) {
		boolean gana = false;

		for (int columna = 0; columna < tateti.length; columna++) { // Verifico de a una columna
			// Verifico todas las filas de esa columna
			if (tateti[0][columna] == tateti[1][columna] && tateti[1][columna] == tateti[2][columna]
					&& tateti[0][columna] != "-" && tateti[1][columna] != "-" && tateti[2][columna] != "-") {

				System.out.println("Tenemos ganador en la columna: " + "[0," + columna + "], " + "[1," + columna + "] y"
						+ " [2," + columna + "]");
				System.out.print("correspondiente al ");
				if (tateti[1][columna] == "X") {
					System.out.print("jugador 1");
					System.out.println("\n\t¡FELICIDADES!");
				}
				;
				if (tateti[1][columna] == "O") {
					System.out.print("jugador 2");
					System.out.println("\n\t¡FELICIDADES!");
				}
				;
				gana = true;
				break;
			}
		}
		return gana;
	}

	private static boolean conGanadorFila(String[][] tateti) {
		boolean gana = false;

		for (int fila = 0; fila < tateti.length; fila++) {
			// Verifico de a una fila
			if (tateti[fila][0] == tateti[fila][1] && tateti[fila][1] == tateti[fila][2] && tateti[fila][0] != "-"
					&& tateti[fila][1] != "-" && tateti[fila][2] != "-") {
				System.out.println("Tenemos ganador en la fila : [" + fila + ",0], [" + fila + ",1], [" + fila + ",2]");
				System.out.print("correspondiente al ");
				if (tateti[fila][0] == "X") {
					System.out.print("jugador 1\n");
					System.out.println("\n\t¡FELICIDADES!");
				}
				;
				if (tateti[fila][0] == "O") {
					System.out.print("jugador 2\n");
					System.out.println("\n\t¡FELICIDADES!");
				}
				;
				gana = true;
				break;
			}
		}
		return gana;
	}

	private static void validarCasillero1(int c1, int c2, String[][] tateti, Scanner scan) {

		System.out.println("\t\n** Ingrese las coordenadas **");
		System.out.println("\nCoordenada 1, valor entre 0 y 2 ");
		c1 = scan.nextInt();
		c1 = validarCoordenada(c1, FILAS, scan);

		System.out.println("\nCoordenada 2, valor entre 0 y 2 ");
		c2 = scan.nextInt();
		c2 = validarCoordenada(c2, COLUMNAS, scan);

		while (tateti[c1][c2] == "O" || tateti[c1][c2] == "X") {
			System.out.println("\nEl casillero [" + c1 + "," + c2 + "] está ocupado, ");
			System.out.println("ingrese otras coordenadas.");

			System.out.println("\nCoordenada 1, valor entre 0 y 2 ");
			c1 = scan.nextInt();
			c1 = validarCoordenada(c1, FILAS, scan);

			System.out.println("\nCoordenada 2, valor entre 0 y 2 ");
			c2 = scan.nextInt();
			c2 = validarCoordenada(c2, COLUMNAS, scan);

		}
		tateti[c1][c2] = "X";
	}

	private static void validarCasillero2(int c1, int c2, String[][] tateti, Scanner scan) {

		System.out.println("\n** Ingrese las coordenadas **");
		System.out.println("\nCoordenada 1, valor entre 0 y 2 ");
		c1 = scan.nextInt();
		c1 = validarCoordenada(c1, FILAS, scan);

		System.out.println("\nCoordenada 2, valor entre 0 y 2 ");
		c2 = scan.nextInt();
		c2 = validarCoordenada(c2, COLUMNAS, scan);

		while (tateti[c1][c2] == "O" || tateti[c1][c2] == "X") {
			System.out.println("\nEl casillero [" + c1 + "," + c2 + "] está ocupado, ");
			System.out.println("ingrese otras coordenadas.");

			System.out.println("\nCoordenada 1, valor entre 0 y 2 ");
			c1 = scan.nextInt();
			c1 = validarCoordenada(c1, FILAS, scan);

			System.out.println("\nCoordenada 2, valor entre 0 y 2 ");
			c2 = scan.nextInt();
			c2 = validarCoordenada(c2, COLUMNAS, scan);

		}
		tateti[c1][c2] = "O";
	}

}
