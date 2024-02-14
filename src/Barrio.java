import java.util.Scanner;

public class Barrio {

    private Parcela [] [] parcelas = new Parcela[4][4]; 

    public void rellenarParcelas() {

        int contadorCasas = 0;

        for (int i = 0; i < parcelas.length; i++) {
            for (int j = 0; j < parcelas.length; j++) {
                Parcela p = new Parcela(); 
                parcelas [i] [j] = p;
                if(parcelas[i][j].getTipo() == 'C') {
                    contadorCasas++;
                }

            }
        }

        int minimoCasas = (parcelas.length*parcelas.length)/2;

        if (contadorCasas < minimoCasas) {  // Verifica un minimo de 50% de casas, y si no, las añade, atribuyendo los datos correspondientes a una casa. 
            for (int i = 0; i < minimoCasas - contadorCasas; i++) {
                for (int j = 0; j < parcelas.length; j++) {
                    parcelas[i][j].setTipo('C');
                    parcelas[i][j].setNumJardines((int) (Math.random() * 2 + 1));
                    parcelas[i][j].setNumParques((int) (Math.random() * 2 + 1));
                }
            }
        }

    }

    public void calcularPrecio (Parcela [] [] parcelas) {

        Scanner sc = new Scanner(System.in); 
        
        int contadorParcelas = 0; 
        Parcela [] parcelasUnidim = new Parcela[parcelas.length*parcelas.length]; 
        System.out.println("   ");

        for (int i = 0; i < parcelas.length; i++) {
            for (int j = 0; j < parcelas.length; j++) {
                parcelasUnidim [contadorParcelas] = parcelas [i] [j];
                contadorParcelas++; 
            }
        }

        System.out.println("Seleccione de que casa quiere calcular el precio: ");

        for (int i = 0; i < parcelasUnidim.length; i++) {
            if (parcelasUnidim[i].getTipo() == 'C') {
                System.out.println("["+i+"]." + "Casa " + i + " | " + parcelasUnidim[i].toString());
            }
        }

        int selectorCasa = sc.nextInt(); 

        int precioCalcular = parcelasUnidim[selectorCasa].getPrecio(); 
        
        if(parcelasUnidim[selectorCasa].getNumBanos() == 3) {
            precioCalcular += 3000; // Suplemento por 3 baños 
        }

        if(parcelasUnidim[selectorCasa].isTieneGaraje()) {
            precioCalcular += 20000;  // Adición de suplemento por garaje
        } 

        precioCalcular += 1000*parcelasUnidim[selectorCasa].getNumJardines(); // Adición de suplemento por número de jardines
        precioCalcular += 2500*parcelasUnidim[selectorCasa].getNumParques();  // Adición de suplemento por número de parques

        parcelasUnidim[selectorCasa].setPrecio(precioCalcular);
        System.out.println("El precio final de la casa que has seleccionado es de: " + parcelasUnidim[selectorCasa].getPrecio());

    }

    public Parcela[][] getParcelas() {
        return parcelas;
    }

    

}