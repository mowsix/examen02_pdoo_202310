import java.util.Random;

public class LasZonas extends Zona{

    public LasZonas(){
    }

    @Override
    protected void Riesgo() {

    }

    private int cantidadZonas;
    protected int area;
    protected int totalHabitantes;
    protected int distanciaRios;

    protected String zonaUbicacion;
    protected String zonaGeografia;

    public Zona[] lasZonas;

    public Zona[] getLasZonas() {
        return lasZonas;
    }

    public void setLasZonas(Zona[] lasZonas) {
        this.lasZonas = lasZonas;
    }

    public LasZonas(int cantidadZonas){
        lasZonas= new Zona[cantidadZonas];
        InicializarZonas();
    }
    private void InicializarZonas() {
        Random aleatorio = new Random();
        int elArea;
        int elNivelDelMar;
        int elTotalDeHabitantes;
        int laDistanciaRios;
        String laZonaUbicacion;
        String laZonaGeografica;
        String[] zonaUbicacion = {"Rural", "Urbana"};
        String[] zonageografia = {"Montañosa", "Costera"};

        for (int i = 0; i < lasZonas.length; i++) {
            elArea = aleatorio.nextInt(50 - 2) + 1;
            elNivelDelMar = aleatorio.nextInt(3000 - 1);
            elTotalDeHabitantes = aleatorio.nextInt(1000000 - 1001) + 1000;
            laDistanciaRios = aleatorio.nextInt(2000 - 1);
            laZonaUbicacion = zonaUbicacion[aleatorio.nextInt(2)];
            laZonaGeografica = zonageografia[aleatorio.nextInt(2)];

            switch (aleatorio.nextInt(2)){
                case 0:
                    lasZonas[i] = new ZonaRural(elNivelDelMar, elArea, elTotalDeHabitantes, laDistanciaRios,
                        laZonaUbicacion, laZonaGeografica);
                case 1:
                    lasZonas[i] = new ZonaUrbana(elNivelDelMar, elArea, elTotalDeHabitantes, laDistanciaRios,
                            laZonaUbicacion, laZonaGeografica);
            }

        }
    }

}
