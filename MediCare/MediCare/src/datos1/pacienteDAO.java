
package datos1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.paciente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class pacienteDAO implements CrudSimpleInterface<paciente> {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public pacienteDAO(){
        CON=Conexion.getInstancia();
    }
    
    
    @Override
    public List<paciente> listar(String texto) {
        List<paciente> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT * FROM paciente WHERE nombre LIKE ?");
            ps.setString(1,"%" + texto +"%");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBoolean(4)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(paciente obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO paciente (nombre,apellidos,fecha_nacimiento,genero,tipo_documento,num_documento,telefono,correo,direccion,ciudad,grupo_sanquineo,fecha_registro,activo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellidos());
            ps.setString(3, obj.getFecha_nacimiento());
            ps.setString(4, obj.getGenero());
            ps.setString(5, obj.getTipo_documento());
            ps.setString(6, obj.getNum_documento());
            ps.setString(7, obj.getTelefono());
            ps.setString(8, obj.getCorreo());
            ps.setString(9, obj.getDireccion());
            ps.setString(10, obj.getCiudad());
            ps.setString(11, obj.getGrupo_sanguineo());
            ps.setString(12, obj.getFecha_registro());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(paciente obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE paciente SET nombre=?, apellidos=?,fecha_nacimiento=?,genero=?,tipo_documento=?,num_documento=?,telefono=?,correo=?,direccion=?,ciudad=?,grupo_sanquineo=?,fecha_registro=? WHERE id=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellidos());
            ps.setInt(13, obj.getId());
            ps.setString(3, obj.getFecha_nacimiento());
            ps.setString(4, obj.getGenero());
            ps.setString(5, obj.getTipo_documento());
            ps.setString(6, obj.getNum_documento());
            ps.setString(7, obj.getTelefono());
            ps.setString(8, obj.getCorreo());
            ps.setString(9, obj.getDireccion());
            ps.setString(10, obj.getCiudad());
            ps.setString(11, obj.getGrupo_sanguineo());
            ps.setString(12, obj.getFecha_registro());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean desactivar(int id) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE paciente SET activo=0 WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean activar(int id) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE paciente SET activo=1 WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public int total() {
        int totalRegistros=0;
        try {
            ps=CON.conectar().prepareStatement("SELECT COUNT(id) FROM paciente");            
            rs=ps.executeQuery();
            
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id)");
            }            
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("SELECT nombre FROM paciente WHERE nombre=?");
            ps.setString(1, texto);
            rs=ps.executeQuery();
            rs.last();
            if(rs.getRow()>0){
                resp=true;
            }           
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return resp;
    }
    
}

