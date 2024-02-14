public class Parcela {

    public final int PRECIO_BASE = 300000; 
    
    private char tipo; 
    private int precio; 
    private int numParques; 
    private int numJardines;
    private boolean tieneGaraje; 
    private int numBanos;

    

    public Parcela() {

        char tempTipo = 'A';
        int autogenTipo = (int) (Math.random() * 100) + 1; 

        if(autogenTipo > 0 && autogenTipo <= 50) {
            tempTipo = 'C'; 
        } else if (autogenTipo > 50 && autogenTipo <= 85) {
            tempTipo = 'J'; 
        } else if (autogenTipo > 85 && autogenTipo <= 100) {
            tempTipo = 'P';
        }
        

        this.tipo = tempTipo;
        this.precio = PRECIO_BASE;
        this.numParques = (int) (Math.random() * 2 + 1);
        this.numJardines = (int) (Math.random() * 2 + 1);

        int autogeneradorGaraje = (int) (Math.random() * 2) + 1; 

        if(autogeneradorGaraje == 1) {
            this.tieneGaraje = true; 
        } else if (autogeneradorGaraje == 2) {
            this.tieneGaraje = false; 
        } 

        this.numBanos = (int) (Math.random() * 2 + 2);
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getNumParques() {
        return numParques;
    }

    public void setNumParques(int numParques) {
        this.numParques = numParques;
    }

    public int getNumJardines() {
        return numJardines;
    }

    public void setNumJardines(int numJardines) {
        this.numJardines = numJardines;
    }

    public boolean isTieneGaraje() {
        return tieneGaraje;
    }

    public void setTieneGaraje(boolean tieneGaraje) {
        this.tieneGaraje = tieneGaraje;
    }

    public int getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(int numBanos) {
        this.numBanos = numBanos;
    } 

    @Override
    public String toString() {
        return "Número de parques: " + numParques + "  |  Número de jardines: " + numJardines + "  |  Número de baños: " + numBanos + "  |  Garaje: " + tieneGaraje;
    }
    

    
    
}
