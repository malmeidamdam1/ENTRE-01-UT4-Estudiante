/**
 * Un objeto de esta clase est� asociado con una unidad de trabajo
 * y guarda la nota que un estudiante ha sacado en los controles, actividades y
 * proyectos de esa unidad
 */
public class NotaEstudianteUnidad {
    private UnidadTrabajo unidad; //ATR "unidad" TD Clase UT
    private double notaControles;
    private double notaActividades;
    private double notaProyectos;

    //estos 3 ATR relacionados a Clase Ponderacion, se llega objeto UT "ponderacion"

    /**
     * Constructor
     */
    public NotaEstudianteUnidad(UnidadTrabajo unidad, double notaControles,
    double notaActividades,
    double notaProyectos) {
        this.unidad = unidad;
        this.notaControles = notaControles;
        this.notaActividades = notaActividades;
        this.notaProyectos = notaProyectos;
    }

    /**
     * Accesor para la UT
     */
    public UnidadTrabajo getUnidad() {
        return unidad;
    }

    /**
     * Accesor para la UT
     */
    public void setUnidad(UnidadTrabajo unidad) {
        this.unidad = unidad;
    }

    /**
     * Accesor para nota controles
     */
    public double getNotaControles() {
        return notaControles;
    }

    /**
     * Mutador para nota controles
     */
    public void setNotaControles(double notaControles) {
        this.notaControles = notaControles;
    }

    /**
     * Accesor para nota actividades
     */
    public double getNotaActividades() {
        return notaActividades;
    }

    /**
     * Mutador para nota actividades
     */
    public void setNotaActividades(double notaActividades) {
        this.notaActividades = notaActividades;
    }

    /**
     * Accesor para nota proyectos
     */
    public double getNotaProyectos() {
        return notaProyectos;
    }

    /**
     * Mutador para nota proyectos
     */
    public void setNotaProyectos(double notaProyectos) {
        this.notaProyectos = notaProyectos;
    }
    

    /**
     * Calcula y devuelve la nota obtenida en la UT teniendo
     * en cuenta la ponderaci�n de los instrumentos de evaluaci�n
     */
    public double calcularNotaUnidad() {

        //Este metodo solo funciona si se mete 70% tal cual 70 y no 7.

        double ponderacionControles = (unidad.getPonderacion().getControles())/10;

        double ponderacionActividades = (unidad.getPonderacion().getActividades())/10;

        double ponderacionProyectos = (unidad.getPonderacion().getProyectos())/10;

        return ((notaControles * ponderacionControles + 
                notaActividades * ponderacionActividades + notaProyectos * ponderacionProyectos)/10);

    }

    /**
     * Representaci�n textual del objeto (ver enunciado)
     */
    public String toString() {
        String str = String.format("Controles: %3.2f    Actividades clase: %3.2f    Proyectos: %3.2f  \nNota final obtenida en Unidad de Trabajo: %4.2f\n", 
                getNotaControles(), getNotaActividades(), getNotaProyectos(), calcularNotaUnidad());     

        return unidad.toString() + str + "-".repeat(80);
        //como no puedo concatenar varios string.format()... uno el anterior toString al final en el return
    }

    /**
     * Este m�todo se ha incluido solo para testear la clase m�s f�cilmente
     */
    public void print() {
        System.out.println(this.toString());
    }

}
