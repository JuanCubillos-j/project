
package negocio;
import datos1.pacienteDAO;
import entidades.paciente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JcarlosAd7
 */
public class pacienteControl {
    private final pacienteDAO DATOS;
    private paciente obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;
    
    public pacienteControl(){
        this.DATOS=new pacienteDAO();
        this.obj=new paciente();
        
        this.registrosMostrados=0;
    }
    
    public DefaultTableModel listar(String texto){
        List<paciente> lista=new ArrayList();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos={"Id","Nombre","Descripción","Estado"};
        this.modeloTabla=new DefaultTableModel(null,titulos);        
        
        String estado;
        String[] registro = new String[4];
        
        this.registrosMostrados=0;
        for (paciente item:lista){
            if (item.isActivo()){
                estado="Activo";
            } else{
                estado="Inactivo";
            }
            registro[0]=Integer.toString(item.getId());
            registro[1]=item.getNombre();
            registro[2]=item.getApellidos();
            registro[3]=estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;
        }
        return this.modeloTabla;
    }
    
    public String insertar(String nombre,String apellidos){
        if (DATOS.existe(nombre)){
            return "El registro ya existe.";
        }else{
            obj.setNombre(nombre);
            obj.setApellidos(apellidos);
            if (DATOS.insertar(obj)){
                return "OK";
            }else{
                return "Error en el registro.";
            }
        }
    }
    
    public String actualizar(int id, String nombre,String nombreAnt,String apellidos){
        if (nombre.equals(nombreAnt)){
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setApellidos(apellidos);
            if(DATOS.actualizar(obj)){
                return "OK";
            }else{
                return "Error en la actualización.";
            }
        }else{
            if (DATOS.existe(nombre)){
                return "El registro ya existe.";
            }else{
                obj.setId(id);
                obj.setNombre(nombre);
                obj.setApellidos(apellidos);
                if (DATOS.actualizar(obj)){
                    return "OK";
                }else{
                    return "Error en la actualización.";
                }
            }
        }
    }
    
    public String desactivar(int id){
        if (DATOS.desactivar(id)){
            return "OK";
        }else{
            return "No se puede desactivar el registro";
        }
    }
    
    public String activar(int id){
        if (DATOS.activar(id)){
            return "OK";
        }else{
            return "No se puede activar el registro";
        }
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
    }
}

