import java.util.Objects;

public class ZonaRural extends Zona {

    public ZonaRural(int nivelDelMar, int area, int totalHabitantes, int distanciaRios, String zonaUbicacion, String zonaGeografia){
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
            InundacionUrbana=false;
            if (distanciaRios<50 && zonaGeografia=="Montañosa"){
                InundacionFluvial=true;
            }
            if (Objects.equals(zonaGeografia, "Costera")){
                InundacionCostera=true;
            }


            if (InundacionFluvial){
                tipoDeRiesgo+="Fluvial ";
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
