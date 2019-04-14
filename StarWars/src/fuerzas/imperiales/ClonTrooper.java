package fuerzas.imperiales;

public class ClonTrooper {
    private String rango;
    private String especialidad;
    private String armamento;

    public ClonTrooper() {
    }

    public ClonTrooper(String rango, String especialidad, String armamento) {
        this.rango = rango;
        this.especialidad = especialidad;
        this.armamento = armamento;
    }

    public String getRango() {
        return rango;
    }
    public void setRango(String newRango) {
        rango = newRango;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String newEspecialidad) {
        especialidad = newEspecialidad;
    }
    public String getArmamento() {
        return armamento;
    }
    public void setArmamento(String newArmamento) {
        armamento = newArmamento;
    }

    public void disparar() {
        System.out.println("pum");
    }
}