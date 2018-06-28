/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.ProductoDao;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame{
    
    public JLabel lblCodigo,lblTipo,lblNombre,lblPrecio,lblCantidad,lblDisponibilidad;
    
    public JTextField codigo, tipo, nombre,precio,cantidad;
    
    ButtonGroup disponibilidad = new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;
    
    public JPanel table;
    
    public JButton buscar,eliminar,insertar,limpiar,actualizar;
    
    private static final int ANCHOC = 130, ALTOC = 30;
    
    DefaultTableModel tm;
    
    public Consulta(){
        super("Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblCodigo);
        container.add(lblDisponibilidad);
        container.add(lblTipo);
        container.add(lblNombre);
        container.add(lblPrecio);
        container.add(lblCantidad);
        container.add(codigo);
        container.add(tipo);
        container.add(nombre);
        container.add(precio);
        container.add(cantidad);
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(limpiar);
        container.add(table);
        setSize(800,600);
        eventos();
    }
    
    public final void agregarLabels(){
        lblCodigo = new JLabel("Codigo:");
        lblTipo = new JLabel("Tipo:");
        lblNombre = new JLabel("Nombre:");
        lblCantidad = new JLabel("Cantidad:");
        lblPrecio = new JLabel("Precio:");
        lblDisponibilidad =  new JLabel("Disponibilidad:");
        lblCodigo.setBounds(10,10,ANCHOC,ALTOC);
        lblPrecio.setBounds(10,60,ANCHOC,ALTOC);
        lblNombre.setBounds(10,110,ANCHOC,ALTOC);
        lblCantidad.setBounds(10,160,ANCHOC,ALTOC);
        lblTipo.setBounds(10,210,ANCHOC,ALTOC);
        lblDisponibilidad.setBounds(10,260,ANCHOC,ALTOC);
        
    }
    
    public final void formulario(){
        codigo = new JTextField();
        precio = new JTextField();
        cantidad = new JTextField();
        nombre = new JTextField();
        tipo = new JTextField();
        si = new JRadioButton("si", true);
        no = new JRadioButton("no");
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("Insertar");
        eliminar =  new JButton("Eliminar");
        actualizar = new JButton("Actualizar");
        limpiar = new JButton("Limpiar");
        
        table = new JPanel();
        
        disponibilidad = new ButtonGroup();
        disponibilidad.add(si);
        disponibilidad.add(no);
        
        
        codigo.setBounds(140,10,ANCHOC,ALTOC);
        cantidad.setBounds(140,60,ANCHOC,ALTOC);
        nombre.setBounds(140,110,ANCHOC,ALTOC);
        precio.setBounds(140,160,ANCHOC,ALTOC);
        tipo.setBounds(140,210,ANCHOC,ALTOC);
        si.setBounds(140,260,50,ALTOC);
        no.setBounds(210,260,50,ALTOC);
        
        buscar.setBounds(300,10,ANCHOC,ALTOC);
        insertar.setBounds(300,260,100,50);
        actualizar.setBounds(400,260,100,50);
        eliminar.setBounds(500,260,100,50);
        limpiar.setBounds(600,260,100,50);
        resultados = new JTable();
        table.setBounds(10,320,600,200);
        table.add(new JScrollPane(resultados));
    }
    public void llenarTabla(){
        
        tm = new DefaultTableModel(){
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5:
                        return String.class;
                    default:
                        return String.class;
                }
            }
        };
        tm.addColumn("Codigo");
        tm.addColumn("Nombre");
        tm.addColumn("Tipo");
        tm.addColumn("Disponibilidad");
        tm.addColumn("Precio");
        tm.addColumn("cantidad");
        
        ProductoDao fd = new ProductoDao();
        ArrayList <Producto> Productos = fd.readAll();
        
        for (Producto fi: Productos){
            tm.addRow(new Object[]{ fi.getCodigo(),fi.getNombre(),fi.getTipo(),fi.getDisponibilidad(),fi.getPrecio(),fi.getCantidad()});
        }
        resultados.setModel(tm);
    }
    
    public void eventos(){
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDao fd = new ProductoDao();
                Producto f = new Producto(codigo.getText(),nombre.getText(),tipo.getText(),Double.parseDouble(precio.getText()),Integer.parseInt(cantidad.getText()),1);
                if(no.isSelected()){
                    f.setDisponibilidad(0);
                }
                if(fd.create(f)){
                    JOptionPane.showMessageDialog(null,"Filtro registrado con exito");
                    limpiarCampos();
                    llenarTabla();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Ocurrio un problema al momento de crear el filtro");
                    
                }
            }        
        });
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDao fd = new ProductoDao();
                Producto f = new Producto(codigo.getText(),nombre.getText(),tipo.getText(),Double.parseDouble(precio.getText()),Integer.parseInt(cantidad.getText()),1);
                if(no.isSelected()){
                    f.setDisponibilidad(0);
                }
                if(fd.update(f)){
                    JOptionPane.showMessageDialog(null,"Filtro registrado con exito");
                    limpiarCampos();
                    llenarTabla();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Ocurrio un problema al momento de actualizar el filtro");
                    
                }
                if(fd.delete(codigo.getText())){
                    limpiarCampos();
                    llenarTabla();
                }
            } 
        });
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDao fd = new ProductoDao();
                if(fd.delete(codigo.getText())){
                    JOptionPane.showMessageDialog(null,"Filtro registrado con exito");
                    limpiarCampos();
                    llenarTabla();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Ocurrio un problema al momento de eliminar el filtro");
                    
                }
            } 
        });
        
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDao fd = new ProductoDao();
                Producto f = fd.read(codigo.getText());
                if(f == null){
                    JOptionPane.showMessageDialog(null,"Filtro registrado con exito");
                }
                else{
                    codigo.setText(f.getCodigo());
                    cantidad.setText(Integer.toString(f.getCantidad()));
                    tipo.setText(f.getTipo());
                    precio.setText(Double.toString(f.getPrecio()));
                    nombre.setText(f.getNombre());
                    if(f.getDisponibilidad()==1){
                        si.setSelected(true);
                    }
                    else{
                        no.setSelected(true);
                    }
                }
            } 
        });
        
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            } 
        });
    }
    
    public void limpiarCampos(){
        codigo.setText("");
        precio.setText("");
        nombre.setText("");
        cantidad.setText("");
        tipo.setText("");
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
               new Consulta().setVisible(true);
            }
        });
    }

}
