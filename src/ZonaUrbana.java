import java.util.Objects;

public class ZonaUrbana extends Zona{


    public ZonaUrbana(int nivelDelMar, int area, int totalHabitantes, int distanciaRios, String zonaUbicacion, String zonaGeografia){
        this.area=area;
        this.distanciaRios=distanciaRios;
        this.nivelDelMar=nivelDelMar;
        this.totalHabitantes=totalHabitantes;
        this.zonaUbicacion=zonaUbicacion;
        this.zonaGeografia=zonaGeografia;
        Riesgo();
        TipoInundacion();
    }

    @Override
    protected void Riesgo() {

        densidadPoblacional= (totalHabitantes/area);


        if(densidadPoblacional>=100){
            estaEnRiesgo=true;
        }
        if (nivelDelMar<10){
            estaEnRiesgo=true;
        }
        if (distanciaRios<50){
            estaEnRiesgo=true;
        }

        if (estaEnRiesgo){
            estadoDeRiesgo="Esta en Riesgo";
        }else {
            estadoDeRiesgo="NO esta en peligro";
        }

    }

    @Override
    protected void TipoInundacion() {


        if(estaEnRiesgo){
            tipoDeRiesgo="";
            if (distanciaRios<50 && zonaGeografia=="Montañosa"){
                InundacionFluvial=true;
            }
            InundacionUrbana=true;

            if (Objects.equals(zonaGeografia, "Costera") && nivelDelMar<10){
                InundacionCostera=true;
            }



            if (InundacionFluvial){
                tipoDeRiesgo+="Fluvial ";
            }
            if (InundacionUrbana){
                tipoDeRiesgo+="Urbana ";
            }
            if (InundacionCostera){
                tipoDeRiesgo+="Costera ";
            }





        }else {
            tipoDeRiesgo="No presenta ningun tipo de riesgo";
        }
    }


    public String toString(){
        String info= String.format("Zona %s %s: %s, Nivel del mar: %d mts, Area: %.2f km2, Densidad Poblacional: %.2f, Distancia Rios: %d mts, %s",zonaUbicacion, zonaGeografia,estadoDeRiesgo,nivelDelMar,area,densidadPoblacional,distanciaRios,tipoDeRiesgo);
        return info;
    }



}
