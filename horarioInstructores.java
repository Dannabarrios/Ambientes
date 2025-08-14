public class horarioInstructores {
    private String documentoInstructor;
    private String dia;
    private String horaInicio;
    private String horaFin;

    public horarioInstructores(String documentoInstructor, String dia, String horaInicio, String horaFin) {
        this.documentoInstructor = documentoInstructor;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    // Getters y setters
    public String getDocumentoInstructor() { return documentoInstructor; }
    public String getDia() { return dia; }
    public String getHoraInicio() { return horaInicio; }
    public String getHoraFin() { return horaFin; }

    @Override
    public String toString() {
        return "Instructor: " + documentoInstructor + " | Día: " + dia +
               " | Horario: " + horaInicio + " - " + horaFin;
    }
}
