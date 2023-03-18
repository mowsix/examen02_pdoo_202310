import java.util.Objects;
import java.util.Random;

public class Dagran {
    //DecimalFormat df = new DecimalFormat("#.##");
    public Dagran(){
    }


    private int cantidadZonas;
    protected int area;
    protected int totalHabitantes;
    protected int distanciaRios;

    protected String zonaUbicacion;
    protected String zonaGeografia;

    public Zona[] lasZonas;

    public Zona[] lasZonasEnRiesgo;
    public String[] porcentajesTipoZona;
    public String[] porcentajesRiesgoInundacion;



    public Zona[] getLasZonas() {
        return lasZonas;
    }

    public void setLasZonas(Zona[] lasZonas) {
        this.lasZonas = lasZonas;
    }

    public Dagran(int cantidadZonas){
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
        double contRiesgo=0;
        double urbanaMontañosa=0;
        double urbanaCostera=0;
        double ruralMontañosa=0;
        double ruralCostera=0;
        double porcentajeUrbanaMontañosa=0;
        double porcentajeUrbanaCostera=0;
        double porcentajeRuralMontañosa=0;
        double porcentajeRuralCostera=0;
        for (Zona cadaZona:lasZonas) {

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


        /*porcentajeRuralCostera=Double.parseDouble(df.format((ruralCostera/contRiesgo)*100));
        porcentajeRuralMontañosa=Double.parseDouble(df.format((ruralMontañosa/contRiesgo)*100));
        porcentajeUrbanaCostera=Double.parseDouble(df.format((urbanaCostera/contRiesgo)*100));
        porcentajeUrbanaMontañosa=Double.parseDouble(df.format((urbanaMontañosa/contRiesgo)*100));*/

        porcentajeRuralCostera=((ruralCostera/contRiesgo)*100);
        porcentajeRuralMontañosa=((ruralMontañosa/contRiesgo)*100);
        porcentajeUrbanaCostera=((urbanaCostera/contRiesgo)*100);
        porcentajeUrbanaMontañosa=((urbanaMontañosa/contRiesgo)*100);

        porcentajesTipoZona=new String[] {
                String.format("Rural y Costera: %.2f",porcentajeRuralCostera)+"%",
                String.format("Rural y Montañosa: %.2f",porcentajeRuralMontañosa)+"%",
                String.format("Urbana y Costera: %.2f",porcentajeUrbanaCostera)+"%",
                String.format("Urbana y Montañosa: %.2f",porcentajeUrbanaMontañosa)+"%",
        };
        return porcentajesTipoZona;
    }




    protected String[] ObtienePorcentajeRiesgosPorTipo(Zona[] lasZonas){
        double contRiesgo=0;
        double fluvial=0;
        double urbana=0;
        double costera=0;
        double porcentajeUrbana;
        double porcentajeCostera;
        double porcentajeFluvial;
        for (Zona cadaZona:lasZonas) {
            if (cadaZona.estaEnRiesgo) {
                contRiesgo += 1;
                if (Objects.equals(cadaZona.tipoDeRiesgo, "Urbana ")) {
                    urbana += 1;
                }
                if (Objects.equals(cadaZona.tipoDeRiesgo, "Costera ")) {
                    costera += 1;
                }
                if (Objects.equals(cadaZona.tipoDeRiesgo, "Fluvial ")) {
                    fluvial += 1;
                }
            }
        }


            porcentajeUrbana=((urbana/contRiesgo)*100);
            porcentajeFluvial= ((fluvial/contRiesgo)*100);
            porcentajeCostera= ((costera/contRiesgo)*100);


            porcentajesRiesgoInundacion= new String[] {
                    String.format("Inundacion Urbana: %.2f",porcentajeUrbana)+"%",
                    String.format("Inundacion Fluvial: %.2f",porcentajeFluvial)+"%",
                    String.format("Inundacion Costera: %.2f",porcentajeCostera)+"%",
            };


        return porcentajesRiesgoInundacion;
    }
}