import java.util.Scanner;

public class Barrio {

    private Parcela [] [] parcelas = new Parcela[4][4]; 

    public void rellenarParcelas() {

        for (int i = 0; i < parcelas.length; i++) {
            for (int j = 0; j < parcelas.length; j++) {
                Parcela p = new Parcela(); 
                parcelas [i] [j] = p; 
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
            precioCalcular += 20000; 
        } 

        precioCalcular += 1000*parcelasUnidim[selectorCasa].getNumJardines(); 
        precioCalcular += 2500*parcelasUnidim[selectorCasa].getNumParques();

        parcelasUnidim[selectorCasa].setPrecio(precioCalcular);
        System.out.println("El precio final de la casa que has seleccionado es de: " + parcelasUnidim[selectorCasa].getPrecio());

    }

    public Parcela[][] getParcelas() {
        return parcelas;
    }

    

}