public class App {
    public static void main(String[] args) throws Exception {

        Barrio b = new Barrio(); 
        b.rellenarParcelas();
        System.out.println("Parcelas rellenadas");
        b.calcularPrecio(b.getParcelas());
        
    }
}
