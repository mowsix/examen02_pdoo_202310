public abstract class Zona {

    protected int nivelDelMar;
    protected int area;
    protected int totalHabitantes;
    protected int distanciaRios;

    protected String zonaUbicacion;

    protected String zonaGeografia;

    protected boolean estaEnRiesgo=false;

    public Zona(){
        nivelDelMar=0;
        area=0;
        totalHabitantes=0;
        distanciaRios=0;
    }

    public int getNivelDelMar() {
        return nivelDelMar;
    }
    public void setNivelDelMar(int nivelDelMar) {
        this.nivelDelMar = nivelDelMar;
    }

    public int getArea() {
        return area;
    }
    public void setArea(int area) {
        this.area = area;
    }
    public int getTotalHabitantes() {
        return totalHabitantes;
    }

    public int getDistanciaRios() {
        return distanciaRios;
    }

    public void setDistanciaRios(int distanciaRios) {
        this.distanciaRios = distanciaRios;
    }
    public void setTotalHabitantes(int totalHabitantes) {
        this.totalHabitantes = totalHabitantes;
    }



    protected abstract void Riesgo();

}
