
package entidades; // Define el paquete donde se encuentra la clase
// Declaración de la clase Paciente
public class paciente {
    private int id; // Identificador único del paciente
    private String nombre; // Nombre del paciente
    private String apellidos; // Apellidos del paciente
    private String fecha_nacimiento; // Fecha de nacimiento
    private String genero; // Género del paciente
    private String tipo_documento; // Tipo de documento de identificación
    private String num_documento; // Número de documento
    private String telefono; // Número de teléfono
    private String correo; // Correo electrónico
    private String direccion; // Dirección del paciente
    private String ciudad; // Ciudad de residencia
    private String grupo_sanguineo; // Grupo sanguíneo del paciente
    private String fecha_registro; // Fecha de registro en el sistema
    private boolean activo; // Indica si el paciente está activo o no
    // Constructor con todos los parámetros
    public paciente(int id, String nombre, String apellidos, boolean activo) {
        this.id = id; // Asigna el id recibido
        this.nombre = nombre; // Asigna el nombre recibido
        this.apellidos = apellidos; // Asigna los apellidos recibidos
        this.fecha_nacimiento = fecha_nacimiento; // Asigna la fecha de nacimiento recibida
        this.genero = genero; // Asigna el género recibido
        this.tipo_documento = tipo_documento; // Asigna el tipo de documento recibido
        this.num_documento = num_documento; // Asigna el número de documento recibido
        this.telefono = telefono; // Asigna el teléfono recibido
        this.correo = correo; // Asigna el correo recibido
        this.direccion = direccion; // Asigna la dirección recibida
        this.ciudad = ciudad; // Asigna la ciudad recibida
        this.grupo_sanguineo = grupo_sanguineo; // Asigna el grupo sanguíneo recibido
        this.fecha_registro = fecha_registro; // Asigna la fecha de registro recibida
        this.activo = activo; // Asigna el estado activo recibido
    }
    // Getter para id
    public int getId() {
        return id;
    }
    // Setter para id
    public void setId(int id) {
        this.id = id;
    }
    // Getter para nombre
    public String getNombre() {
        return nombre;
    }
    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // Getter para apellidos
    public String getApellidos() {
        return apellidos;
    }
    // Setter para apellidos
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    // Getter para fecha de nacimiento
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    // Setter para fecha de nacimiento
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    // Getter para género
    public String getGenero() {
        return genero;
    }
    // Setter para género
    public void setGenero(String genero) {
        this.genero = genero;
    }
    // Getter para tipo de documento
    public String getTipo_documento() {
        return tipo_documento;
    }
    // Setter para tipo de documento
    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }
    // Getter para número de documento
    public String getNum_documento() {
        return num_documento;
    }
    // Setter para número de documento
    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }
    // Getter para teléfono
    public String getTelefono() {
        return telefono;
    }
    // Setter para teléfono
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    // Getter para correo
    public String getCorreo() {
        return correo;
    }
    // Setter para correo
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    // Getter para dirección
    public String getDireccion() {
        return direccion;
    }
    // Setter para dirección
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    // Getter para ciudad
    public String getCiudad() {
        return ciudad;
    }
    // Setter para ciudad
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    // Getter para grupo sanguíneo
    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }
    // Setter para grupo sanguíneo
    public void setGrupo_sanguineo(String grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }
    // Getter para fecha de registro
    public String getFecha_registro() {
        return fecha_registro;
    }
    // Setter para fecha de registro
    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    // Getter para estado activo
    public boolean isActivo() {
        return activo;
    }
    // Setter para estado activo
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    // Método toString para representación en texto del objeto
    @Override
    public String toString() {
        return "paciente{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_nacimiento=" + fecha_nacimiento + ", genero=" + genero + ", tipo_documento=" + tipo_documento + ", num_documento=" + num_documento + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + ", ciudad=" + ciudad + ", grupo_sanguineo=" + grupo_sanguineo + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }
}