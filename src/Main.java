// Clase para representar al Policía
class Policia {
    private String nombre;
    private String apellido;
    private int legajo;

    public Policia(String nombre, String apellido, int legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + ", Legajo: " + legajo;
    }
}

// Clase base para Armas
abstract class Arma {
    private Policia policia;
    private int municiones;
    private int alcance;
    private String marca;
    private int calibre;
    private String estado;

    public Arma(Policia policia, int municiones, int alcance, String marca, int calibre, String estado) {
        this.policia = policia;
        this.municiones = municiones;
        this.alcance = alcance;
        this.marca = marca;
        this.calibre = calibre;
        this.estado = estado;
    }

    public boolean enCondicionesDeUso() {
        return "EN USO".equals(estado) && calibre >= 9;
    }

    public Policia getPolicia() {
        return policia;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Calibre: " + calibre + ", Estado: " + estado +
                ", Policia: " + policia.toString();
    }
}

// Clase para Armas Cortas
class ArmaCorta extends Arma {
    private boolean esAutomatica;

    public ArmaCorta(Policia policia, int municiones, int alcance, String marca, int calibre, String estado, boolean esAutomatica) {
        super(policia, municiones, alcance, marca, calibre, estado);
        this.esAutomatica = esAutomatica;
    }

    public boolean puedeDispararALargaDistancia() {
        return super.alcance >= 200;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Corta, Automática: " + esAutomatica;
    }
}

// Clase para Armas Largas
class ArmaLarga extends Arma {
    private boolean tieneSelloRENAR;
    private String descripcionUso;
    private int nivel;

    public ArmaLarga(Policia policia, int municiones, int alcance, String marca, int calibre, String estado, boolean tieneSelloRENAR, String descripcionUso, int nivel) {
        super(policia, municiones, alcance, marca, calibre, estado);
        this.tieneSelloRENAR = tieneSelloRENAR;
        this.descripcionUso = descripcionUso;
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean esMayorQue(ArmaLarga otraArma) {
        return this.nivel > otraArma.getNivel();
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Larga, Sello RENAR: " + tieneSelloRENAR +
                ", Descripción: " + descripcionUso + ", Nivel: " + nivel;
    }
}

// Clase principal para probar el sistema
public class SistemaArmas {
    public static void main(String[] args) {
        Policia policia1 = new Policia("Juan", "Pérez", 12345);

        ArmaCorta pistola = new ArmaCorta(policia1, 15, 250, "Glock", 9, "EN USO", true);
        ArmaLarga rifle = new ArmaLarga(policia1, 30, 500, "Remington", 12, "EN USO", true, "Uso policial", 4);

        System.out.println(pistola);
        System.out.println("¿Pistola en condiciones de uso? " + pistola.enCondicionesDeUso());
        System.out.println("¿Pistola puede disparar a larga distancia? " + pistola.puedeDispararALargaDistancia());

        System.out.println(rifle);
        System.out.println("¿Rifle en condiciones de uso? " + rifle.enCondicionesDeUso());

        ArmaLarga rifleOtro = new ArmaLarga(policia1, 30, 500, "Winchester", 10, "EN USO", true, "Uso militar", 5);
        System.out.println("¿Rifle es mayor que otro rifle? " + rifle.esMayorQue(rifleOtro));
    }
}
