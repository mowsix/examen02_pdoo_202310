public class ZonaRural extends Zona {

    public ZonaRural(int nivelDelMar, int area, int totalHabitantes, int distanciaRios, String zonaUbicacion, String zonaGeografia){
        this.area=area;
        this.distanciaRios=distanciaRios;
        this.nivelDelMar=nivelDelMar;
        this.totalHabitantes=totalHabitantes;
        this.zonaUbicacion=zonaUbicacion;
        this.zonaGeografia=zonaGeografia;
        Riesgo();
    }



    @Override
    protected void Riesgo() {

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

    public void EvaluaTipoDeRiesgo(){
        do {
            
        }while (estaEnRiesgo);
    }


    public String toString(){
        String info= String.format("Zona %s %s: %s, Nivel del mar: %d mts, Area: %d km2, Total Habitantes: %d, Distancia Rios: %d mts",zonaUbicacion, zonaGeografia,estadoDeRiesgo,nivelDelMar,area,totalHabitantes,distanciaRios);
        return info;
    }
}
