import br.com.relatorios.gerador.ReportBuilder;

public class Run {

	public static void main(String[] args) {
		try {
			ReportBuilder.listagemDeContatos();
		}catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}

	}

}
