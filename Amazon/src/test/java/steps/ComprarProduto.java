package steps;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.Home;
import pages.Lista;
import pages.Produto;


import static steps.DriverFactory.getDriver;

import org.openqa.selenium.WebDriver;



public class ComprarProduto {
	String url;
	WebDriver driver = getDriver();
	Home homePage = new Home(driver);
	Lista listaPage = new Lista(driver);
	Produto produtoPage = new Produto(driver);
	
	
	@Dado("^que acesso o site Amazon.com$")
	public void abrir_site_amazon(){
		url = "https://www.amazon.com.br/";
		driver.get(url);
		assertEquals("Amazon.com.br | Tudo pra você, de A a Z.", driver.getTitle());
	}
	
	@Quando("^busco por \"(.*?)\" e presiono Enter$")
	public void busco_por_e_presiono_Enter(String  produto) {
		homePage.buscarProduto(produto);
	}

	@Entao("^exibe uma lista de produtos relacionados com \"(.*?)\"$")
	public void exibe_uma_lista_de_produtos_relacionados_com(String produto) {
		assertEquals("\"" + produto + "\"", listaPage.lerCabecalhoResultado());
	}

	@Quando("^escolho \"(.*?)\"$")
	public void escolho(String NomeProduto) {
		listaPage.clicar(NomeProduto);
	}
	
	@Entao("^exibe nome \"(.*?)\" e o preco de R\\$\"(.*?)\"$")
		public void exibe_para_o_o_preco_de(String nome, String preco) {
			assertEquals(nome,produtoPage.lerNomeProduto());
			assertEquals(preco,produtoPage.lerPrecoProduto());
			
			}
}

	
