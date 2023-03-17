import java.util.Objects;
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
    public String[] porcentajesTipoZona;

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
            laZonaGeografica = zonageografia[aleatorio.nextInt(2)];

            switch (aleatorio.nextInt(2)){
                case 0:
                    laZonaUbicacion = zonaUbicacion[0];
                    lasZonas[i] = new ZonaRural(elNivelDelMar, elArea, elTotalDeHabitantes, laDistanciaRios,
                        laZonaUbicacion, laZonaGeografica);
                    break;
                case 1:
                    laZonaUbicacion = zonaUbicacion[1];
                    lasZonas[i] = new ZonaUrbana(elNivelDelMar, elArea, elTotalDeHabitantes, laDistanciaRios,
                            laZonaUbicacion, laZonaGeografica);
                    break;
            }

        }
    }

    protected String[] ObtienePorcentajeZonasPorTipo(Zona[] lasZonas){
        int contRiesgo=0;
        int urbanaMontañosa=0;
        int urbanaCostera=0;
        int ruralMontañosa=0;
        int ruralCostera=0;
        int porcentajeUrbanaMontañosa=0;
        int porcentajeUrbanaCostera=0;
        int porcentajeRuralMontañosa=0;
        int porcentajeRuralCostera=0;
        for (Zona cadaZona:lasZonas) {
            System.out.println(cadaZona.estadoDeRiesgo+"OEEEEEEEEEEEEEEEEE");
            if (Objects.equals(cadaZona.estadoDeRiesgo, "Esta en Riesgo")){
                contRiesgo+=1;
                if (Objects.equals(cadaZona.zonaUbicacion, "Rural") && Objects.equals(cadaZona.zonaGeografia, "Costera")){
                    ruralCostera+=1;
                }
                if (Objects.equals(cadaZona.zonaUbicacion, "Rural") && Objects.equals(cadaZona.zonaGeografia, "Montañosa")){
                    ruralMontañosa+=1;
                }
                if (Objects.equals(cadaZona.zonaUbicacion, "Urbana") && Objects.equals(cadaZona.zonaGeografia, "Costera")){
                    urbanaCostera+=1;
                }
                if (Objects.equals(cadaZona.zonaUbicacion, "Urbana") && Objects.equals(cadaZona.zonaGeografia, "Montañosa")){
                    urbanaMontañosa+=1;
                }
            }
        }
        System.out.println(contRiesgo+"#######");

        porcentajeRuralCostera=(contRiesgo/ruralCostera)*100;
        porcentajeRuralMontañosa=(contRiesgo/ruralMontañosa)*100;
        porcentajeUrbanaCostera=(contRiesgo/urbanaCostera)*100;
        porcentajeUrbanaMontañosa=(contRiesgo/urbanaMontañosa)*100;

        porcentajesTipoZona=new String[] {
                "Rural y Costera:"+porcentajeRuralCostera+"\n",
                "Rural y Montañosa:"+porcentajeRuralMontañosa+"\n",
                "Urbana y Costera:"+porcentajeUrbanaCostera+"\n",
                "Urbana y Montañosa"+porcentajeUrbanaMontañosa+"\n"
        };


        return porcentajesTipoZona;
    }

}
