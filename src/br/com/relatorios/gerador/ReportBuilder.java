package br.com.relatorios.gerador;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.swing.JFrame;

import org.apache.log4j.PropertyConfigurator;

import br.com.relatorios.model.Contato;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

public class ReportBuilder {

	public static void listagemDeContatos() throws JRException, SQLException, ClassNotFoundException, FileNotFoundException {
		// Ocultar logs de impressão
        Properties prop = new Properties();
        prop.setProperty("log4j.rootLogger", "WARN");
        PropertyConfigurator.configure(prop);

        //Obtem os dados para impressão
        ArrayList<Contato> lista = Contato.selecionarTodos();
        
        //Parametros do relatório, caso exista
        HashMap param = new HashMap();
        //param.put("DATAS_CODIGO", datas());

        //Caminho do jrxml do relatório
        String caminho = "relatorios/lista_contatos.jrxml";
        
        //Carrega o modelo
        JasperDesign jasperDesign = JRXmlLoader.load(caminho);
        
        //Compila o relatório
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        
        //Vincula os dados ao modelo
        JasperPrint print = JasperFillManager.fillReport(jasperReport, param, new JRBeanCollectionDataSource(lista));
        
        //Visualizador de impressão
        JRViewer jrViewer = new net.sf.jasperreports.swing.JRViewer(print);

        //Janela para visualização
        JFrame jf = new JFrame();
        jf.getContentPane().add(jrViewer);
        jf.validate();
        jf.setVisible(true);
        jf.setSize(new Dimension(1000, 800));
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		 
	}
}
