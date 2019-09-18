package sistema.datos;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author pruebas reportes
 */
public class reportesDatos {
    
    // ganancias
    public void imprimirGananciasDia(String fecha, String gastos, String ventas, String ganancia){
        Connection cnn = Coneccion.getConnection();
        Map p=new HashMap(); // para parametros
        p.put("fecha", fecha);
        p.put("PtotalGasto", gastos);
        p.put("ventas", ventas);
        p.put("ganancia", ganancia);
        JasperReport report;
        JasperPrint print;
        
        try {
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/gananciasDia.jrxml");
            print=JasperFillManager.fillReport(report, p,cnn);
            JasperViewer view=new JasperViewer(print,false);
            view.setTitle("Reporte de Ganancias al Día");
            view.setVisible(true);            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void imprimirGananciasRango(String fecha,String fecha2, String gastos, String ventas, String ganancia){
        Connection cnn = Coneccion.getConnection();
        Map p=new HashMap(); // para parametros
        p.put("fecha", fecha);
        p.put("PtotalGasto", gastos);
        p.put("ventas", ventas);
        p.put("ganancia", ganancia);
        p.put("fecha2", fecha2);
        JasperReport report;
        JasperPrint print;
        
        try {
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/gananciasFechas.jrxml");
            print=JasperFillManager.fillReport(report, p,cnn);
            JasperViewer view=new JasperViewer(print,false);
            view.setTitle("Reporte de Ganancias por Fechas");
            view.setVisible(true);            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void imprimirVentaDiaria(String fecha){
        Connection cnn = Coneccion.getConnection();
        fventas objVentas = new fventas();
        Map p=new HashMap(); // para parametros
        p.put("fechaVenta", fecha);
        String totalVenta =objVentas.calculoTotalVenta(fecha);
        
        p.put("totalVenta", totalVenta);
        JasperReport report;
        JasperPrint print;
        
        try {
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/reporteVentaDiario.jrxml");
            print=JasperFillManager.fillReport(report, p,cnn);
            JasperViewer view=new JasperViewer(print,false);
            view.setTitle("Reporte de ventas al día");
            view.setVisible(true);            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public  void imprimirVentaRango(String fecha1, String fecha2){
        Connection cnn = Coneccion.getConnection();
        fventas objVentas = new fventas();
        Map p=new HashMap(); // para parametros
        p.put("fecha1", fecha1); 
        p.put("fecha2", fecha2);
        String totalVenta =objVentas.calculoTotalVenta(fecha1,fecha2);
        p.put("totalVenta", totalVenta);
       
        JasperReport report;
        JasperPrint print;
        
        try {
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/reporteVentaRango.jrxml");
            print=JasperFillManager.fillReport(report, p,cnn);
            JasperViewer view=new JasperViewer(print,false);
            view.setTitle("Reporte de rango de ventas");
            view.setVisible(true);            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public  void imprimirGananciasProductos(String fecha){
        Connection cnn = Coneccion.getConnection();
        Map p=new HashMap(); // para parametros
        p.put("fecha", fecha);
        JasperReport report;
        JasperPrint print;
        
        try {
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/reporteGananciasProductos.jrxml");
            print=JasperFillManager.fillReport(report, p,cnn);
            JasperViewer view=new JasperViewer(print,false);
            view.setTitle("Reporte de Ganancias");
            view.setVisible(true);            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // producto mas vendido
     public  void imprimirProductosVendidos(String fecha){
        Connection cnn = Coneccion.getConnection();
        Map p=new HashMap(); // para parametros
        p.put("fecha", fecha);
        JasperReport report;
        JasperPrint print;
        
        try {
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/productosMasVendido.jrxml");
            print=JasperFillManager.fillReport(report, p,cnn);
            JasperViewer view=new JasperViewer(print,false);
            view.setTitle("Reporte de Productos mas vendidos");
            view.setVisible(true);            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     // imprimir las alertas de productos 
     public  void imprimirAlertaProductos(){
        Connection cnn = Coneccion.getConnection();
        Map p=new HashMap(); // para parametros
        JasperReport report;
        JasperPrint print;
        
        try {
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/reporteStocks.jrxml");
            print=JasperFillManager.fillReport(report, p,cnn);
            JasperViewer view=new JasperViewer(print,false);
            view.setTitle("Reporte de Ganancias");
            view.setVisible(true);            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public void imprimirEnvioProductos(String idEnvio){
         try {
            Connection cnn = Coneccion.getConnection();
            Map p = new HashMap();
            p.put("envio", idEnvio);
            JasperReport report;
            JasperPrint print;

            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/enviosProducto.jrxml");
            print = JasperFillManager.fillReport(report, p, cnn);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte de productos enviados");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
     }
     
     //reporte de gastos
     public void imprimirGastos(String fecha){
         Connection cnn = Coneccion.getConnection();
         fgastos objgasto = new fgastos();
         
        Map p=new HashMap();
        p.put("fecha", fecha);
        
        // calcular gastos
        String totalGasto =objgasto.calculoTotalGasto(fecha) ;
        p.put("PtotalGasto",totalGasto);// para parametros
        JasperReport report;
        JasperPrint print;
        
        try {
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/reporteGastos.jrxml");
            print=JasperFillManager.fillReport(report, p,cnn);
            JasperViewer view=new JasperViewer(print,false);
            view.setTitle("Reporte de Productos en Stocks");
            view.setVisible(true);            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
    public static void main(String[] args) {
        
        

    }
}
