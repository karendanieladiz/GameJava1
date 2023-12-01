package playjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PlayJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear lista de mapas continentes y elegir una random
        List<Mapa> mapas = new ArrayList<>();

        mapas.add(new Mapa("Africa"));
        mapas.add(new Mapa("America del Norte"));
        mapas.add(new Mapa("America del Sur"));
        mapas.add(new Mapa("Asia"));
        mapas.add(new Mapa("Europa"));
        mapas.add(new Mapa("Oceania"));
        mapas.add(new Mapa("Antartida"));

        Random random = new Random();
        int indiceContinenteElegido = random.nextInt(mapas.size());
        Mapa mapaElegido = mapas.get(indiceContinenteElegido);
        System.out.println("           -La batalla se desarrollara en " + mapaElegido.getNombre() + " -indice " + indiceContinenteElegido);
        System.out.println(mapaElegido.getDescripcion());//descripcion   

        //ZONAS Y ARMAS 
        // instancias 
        Zona zona1 = new Zona("zona 1");
        Zona zona2 = new Zona("zona 2");
        Zona zona3 = new Zona("zona 3");
        Zona zona4 = new Zona("zona 4");
        // Asignar una arma al azar a cada zona
        zona1.setArma(crearArmaAzar());
        zona2.setArma(crearArmaAzar());
        zona3.setArma(crearArmaAzar());
        zona4.setArma(crearArmaAzar());

        //crear instancias de luchadores y asignar aleatoriamente a las zonas
        List<Player> luchadores = crearLuchadores();

        Set<Player> luchadoresAsignados = new HashSet<>();

        List<Zona> zonas = Arrays.asList(zona1, zona2, zona3, zona4);

        // Asignar luchadores a zonas de manera automática 
        for (Zona zona : zonas) {
            asignarLuchadorZonaAlAzar(luchadores, zona, luchadoresAsignados);
        }

        // Imprimir información de las zonas

        imprimirInformacionZonas(zonas);
        /////////// Enfrentamiento
        realizarRondas(zonas);
        
        // Determinar ganador final
        Zona ganadorFinal = determinarGanadorRonda(zonas.get(0), zonas.get(1));

        // Imprimir mensaje de felicitación para el ganador final
        if (ganadorFinal != null) {
            Player ganador = ganadorFinal.getLuchador();
            System.out.println("\n    Felicidades, " + ganador.getNombre() + ", eres el ganador final de la " + ganadorFinal.getNombre() + "!");
        } else {
            System.out.println("\nNo hay un ganador claro en la ronda final.");
        }

    }

    /////////// F U N C I O N E S
    private static void imprimirInformacionZonas(List<Zona> zonas){
        for(Zona elemento: zonas){
            System.out.println("\nArma disponible en "+elemento.getNombre()+": "+elemento.getArma());
            Player luchador = elemento.getLuchador();
            System.out.println("Aqui aterriza: "+luchador);
            System.out.println("Habilidad Asignada: " + luchador.getHabilidad().getNombreH());
       
        }
    }
    
    //crear armas al azar
    private static Arma crearArmaAzar() {
        List<Arma> armas = new ArrayList<>();
        armas.add(new Arma("Franco", 25));
        armas.add(new Arma("Pistola", 10));
        armas.add(new Arma("Escopeta", 17));
        armas.add(new Arma("Chancla", 4));

        if (armas.isEmpty()) {
            throw new IllegalStateException("La lista de armas está vacía.");
        }

        // Mezclar Aleatoriamente las armas 
        Collections.shuffle(armas);
        return armas.get(0);
    }

    //Crear lista de Luchadores
    private static List<Player> crearLuchadores() {
        List<Player> luchadores = new ArrayList<>();
        luchadores.add(new Player("Lucia", crearHabilidadAzar()));
        luchadores.add(new Player("Megara", crearHabilidadAzar()));
        luchadores.add(new Player("Paris", crearHabilidadAzar()));
        luchadores.add(new Player("Ross", crearHabilidadAzar()));
        return luchadores;
    }

    // Método para asignar un luchador  a una zona al azar
    //Conjunto (Set) para realizar un seguimiento de los luchadores ya asignados:
    private static void asignarLuchadorZonaAlAzar(List<Player> luchadores, Zona zona, Set<Player> luchadoresAsignados) {
        Collections.shuffle(luchadores);

        if (!luchadores.isEmpty()) {
            Player luchador = luchadores.remove(0);

            // Verificar si el luchador ya ha sido asignado
            while (luchadoresAsignados.contains(luchador)) {
                Collections.shuffle(luchadores);
                luchador = luchadores.remove(0);
            }

            // Establecer la zona al luchador
            luchador.setZona(zona);

            // Asignar la habilidad al luchador
            luchador.setHabilidad(crearHabilidadAzar());

            // Asignar un arma aleatoria a la zona
            Arma arma = crearArmaAzar();
            zona.setArma(arma);
            luchador.setArma(arma);

            // Si el arma de la zona es "Chancla", el luchador adquiere 4 veces más de vida
            if (arma != null && arma.getNombre().equals("Chancla")) {
                luchador.aumentarVida(2);
            }

            // Asignar al luchador y agregarlo al conjunto de luchadores asignados
            zona.setLuchador(luchador);
            luchadoresAsignados.add(luchador);
        }
    }

    private static Habilidad crearHabilidadAzar() {
        List<Habilidad> habilidades = new ArrayList<>();
        habilidades.add(new Habilidad("Gas toxico", 12));
        habilidades.add(new Habilidad("Granada", 30));
        habilidades.add(new Habilidad("Ninguna", 0));
        Collections.shuffle(habilidades);
        return habilidades.get(0);
    }

    //////////////////////////////////  ENFRENTAMIENTOS ////////////////////////
    private static void realizarEnfrentamientoEntreZonas(Zona zona1, Zona zona2) {
        Player luchador1 = zona1.getLuchador();
        Player luchador2 = zona2.getLuchador();

        System.out.println("\n=== Enfrentamiento entre " + luchador1.getNombre()+" HP: "+luchador1.getVida() + "  VS  " + luchador2.getNombre() +" HP: "+luchador2.getVida() + " ===");

        Player atacante;
        Player oponente;
        if (Math.random() < 0.5) {
            atacante = luchador1;
            oponente = luchador2;
        } else {
            atacante = luchador2;
            oponente = luchador1;
        }

        while (luchador1.getVida() > 0 && luchador2.getVida() > 0) {
            realizarAtaqueAzar(atacante, oponente);
            Player temp = atacante;
            atacante = oponente;
            oponente = temp;
        }

        if (luchador1.getVida() <= 0) {
            System.out.println(luchador1.getNombre() + " ha sido derrotado y " + luchador2.getNombre() + " sigue en batalla con HP: "+luchador2.getVida());
        } else {
            System.out.println(luchador2.getNombre() + " ha sido derrotado." + luchador1.getNombre() + " sigue en batalla con Hp: "+luchador1.getVida());
        }
    }
    private static  void realizarAtaqueAzar(Player a, Player o){
        boolean atacarConArma = new Random().nextBoolean();
        if(atacarConArma){
            realizarAtaque(a, o);
        }else{
            realizarAtaqueHabilidad(a, o);
        }
    }
           
    private static void realizarAtaque(Player atacante, Player oponente) {
        System.out.println("\n-" + atacante.getNombre() + " ataca a " + oponente.getNombre() + " con " + atacante.getArma().getNombre());
        int danio = atacante.getArma().getDaño();
        System.out.println("Causando " + danio + " de danio.");

        // Aplicar daño al oponente
        oponente.setVida(oponente.getVida() - danio);
        //System.out.println(atacante.getNombre() + " ha causado " + danio + " de daño a " + oponente.getNombre() + ".");
        System.out.println(oponente.getNombre() + " tiene " + oponente.getVida() + " HP restantes.");
    }
        private static void realizarAtaqueHabilidad(Player atacante, Player oponente) {
        if (atacante.getHabilidad().getNombreH().equals("Ninguna")){
            System.out.println("No posee habilidad por lo tanto ataca con su Arma");
            realizarAtaque(atacante, oponente);
        }else{
        System.out.println("\n-" + atacante.getNombre() + " usa habilidad "+atacante.getHabilidad()+ " contra "+ oponente.getNombre() );
        int danioHabilidad = atacante.getHabilidad().getEfecto();
        System.out.println("Causando " + danioHabilidad + " de danio.");

        // Aplicar daño al oponente
        oponente.setVida(oponente.getVida() - danioHabilidad);
        //System.out.println(atacante.getNombre() + " ha causado " + danio + " de daño a " + oponente.getNombre() + ".");
        System.out.println(oponente.getNombre() + " tiene " + oponente.getVida() + " HP restantes.");
    
        }
        }    
    private static void realizarRondas(List<Zona> zonas) {
        // Realizar enfrentamientos entre zonas en cada ronda
        realizarEnfrentamientoEntreZonas(zonas.get(0), zonas.get(1));
        realizarEnfrentamientoEntreZonas(zonas.get(2), zonas.get(3));

        // Obtener ganadores de las rondas anteriores
        Zona ganador1 = determinarGanadorRonda(zonas.get(0), zonas.get(1));
        Zona ganador2 = determinarGanadorRonda(zonas.get(2), zonas.get(3));

        // Verificar si hay ganadores para la ronda final
        if (ganador1 != null && ganador2 != null) {
            System.out.println("\n=== Ronda Final ===");
            realizarRondaFinal(ganador1, ganador2);
        }
    }

    private static void realizarRondaFinal(Zona ganador1, Zona ganador2) {
        // Realizar enfrentamiento entre los ganadores de las rondas anteriores
        realizarEnfrentamientoEntreZonas(ganador1, ganador2);
    }

    private static Zona determinarGanadorRonda(Zona zona1, Zona zona2) {
        Player luchador1 = zona1.getLuchador();
        Player luchador2 = zona2.getLuchador();

        if (luchador1 != null && luchador2 != null) {
            if (luchador1.getVida() > luchador2.getVida()) {
                return zona1; // Devuelve la zona del ganador

            } else {

                return zona2; // Devuelve la zona del ganador
            }
        } else {
            // En caso de que uno de los luchadores sea nulo, no hay ganador
            return null;
        }
    }

}
