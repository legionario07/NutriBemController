package br.com.nutribem.relatorios;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import br.com.nutribem.dominio.EntidadeDominio;
import br.com.nutribem.factory.HibernateUtil;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import org.hibernate.internal.SessionImpl;

/**
 *
 * @author Paulinho Classe responsável por Gerar Relat�rios
 * @param <T>
 */
public class GeraRelatorio<T extends EntidadeDominio> {

    /**
     * Método responsavel por gerar Relat�rio
     *
     * @param parametros Recebe uma Map<String, Object>
     * @param con Recebe uma conexao com o Banco de Dados
     */
    /*public static void exportarJSFListPDF(HashMap<String, Object> parametros, File jasper, EntidadeDominio entidade) {

		String nome = "report" + gerarNomeComData() + ".pdf";

		List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
		lista.add(entidade);

		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros,
					new JRBeanCollectionDataSource(lista));
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			response.addHeader("Content-disposition", "attachment; filename=" + nome);
			ServletOutputStream stream = response.getOutputStream();

			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();

		} catch (JRException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Gera os Relatorios Sintéticos
	 * 
	 * @param parametros
	 *            - Parametros para gerar os relatorios, passado na VIew
	 * @param jasper
	 *            - Url do Relatorio.jasper
     */
 /*
	public static void exportarJSFListPDF(HashMap<String, Object> parametros, File jasper) {

		String nome = "report" + gerarNomeComData() + ".pdf";

		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, Conexao.getConnection());
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			response.addHeader("Content-disposition", "attachment; filename=" + nome);
			ServletOutputStream stream = response.getOutputStream();

			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();

		} catch (JRException | IOException e) {
			e.printStackTrace();
		}

	}/*/
     public static void exportarGUIPDFList(HashMap<String, Object> parametros, File jasper, List<EntidadeDominio> lista) {

        String nome = "NutriBem - Relatórios";

        JasperPrint jasperPrint;
        try {
            jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros,
					new JRBeanCollectionDataSource(lista));
            
            JRViewer jRViewer = new JRViewer(jasperPrint);
            // cria o JFrame
            JFrame frameRelatorio = new JFrame(nome);

            // adiciona o JRViewer no JFrame
            frameRelatorio.add(jRViewer, BorderLayout.CENTER);

            // configura o tamanho padrão do JFrame
            frameRelatorio.setSize(500, 500);

            // maximiza o JFrame para ocupar a tela toda.
            frameRelatorio.setExtendedState(JFrame.MAXIMIZED_BOTH);

            // configura a operação padrão quando o JFrame for fechado.
            frameRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // exibe o JFrame
            frameRelatorio.setVisible(true);
            
            //JasperPrintManager.printReport(jasperPrint, false);
            //JasperExportManager.exportReportToPdfFile(jasperPrint, nome);

        } catch (JRException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public static void exportarGUIPDF(HashMap<String, Object> parametros, File jasper) {

        String nome = "NutriBem - Relatórios";

        JasperPrint jasperPrint;
        try {
            jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, ((SessionImpl) HibernateUtil.getSession()).connection());
            
            JRViewer jRViewer = new JRViewer(jasperPrint);
            // cria o JFrame
            JFrame frameRelatorio = new JFrame(nome);

            // adiciona o JRViewer no JFrame
            frameRelatorio.add(jRViewer, BorderLayout.CENTER);

            // configura o tamanho padrão do JFrame
            frameRelatorio.setSize(500, 500);

            // maximiza o JFrame para ocupar a tela toda.
            frameRelatorio.setExtendedState(JFrame.MAXIMIZED_BOTH);

            // configura a operação padrão quando o JFrame for fechado.
            frameRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // exibe o JFrame
            frameRelatorio.setVisible(true);
            
            //JasperPrintManager.printReport(jasperPrint, false);
            //JasperExportManager.exportReportToPdfFile(jasperPrint, nome);

        } catch (JRException e) {
        }

    }

    private static String gerarNomeComData() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd _ hh:mm:ss");

        Calendar c = Calendar.getInstance();
        String s = sdf.format(c.getTime());
        return s.replace("/", "").replace(" ", "").replace(":", "");
    }


}
