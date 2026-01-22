package modelo;

public class Modelo_Horarios {
    private int idHorario;
    private int idPescador;
    private int idDistribuidor;
    private String diaSemana;
    private String horaEntrada;
    private String horaSalida;

    // Constructor vacío
    public Modelo_Horarios() {
    }

    // Constructor con parámetros
    public Modelo_Horarios(int idHorario, int idPescador, int idDistribuidor, String diaSemana, String horaEntrada, String horaSalida) {
        this.idHorario = idHorario;
        this.idPescador = idPescador;
        this.idDistribuidor = idDistribuidor;
        this.diaSemana = diaSemana;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    // Getters y Setters
    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdPescador() {
        return idPescador;
    }

    public void setIdPescador(int idPescador) {
        this.idPescador = idPescador;
    }

    public int getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
}