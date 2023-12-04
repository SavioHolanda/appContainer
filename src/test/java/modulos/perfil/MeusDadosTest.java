package modulos.perfil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import driver.AndroidDriverProvider;
import driver.TestBase;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.BemVindoTela;
import telas.PerfilTela;

import java.util.concurrent.TimeUnit;

public class MeusDadosTest {
    private AndroidDriver app;
    private ExtentReports extent = TestBase.getInstance();
    private ExtentTest test;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Test
    public void testRealizarOPreenchimentoCorretamenteDeTodosOsCamposESalvar(){
        test = extent.createTest("Realizar o preenchimento corretamente de todos os campos e salvar.");
        PerfilTela perfilTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnMeuPerfil()
                .txtNome("Sávio")
                .txtSobreNome("Borges")
                .btnSalvar();

        if(perfilTela.alertaSucesso().equals(perfilTela.mensagemAlertaSucesso()) && perfilTela.msnSucesso().equals(perfilTela.mensagemSucesso()) ){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(perfilTela.alertaSucesso(), perfilTela.mensagemAlertaSucesso());
        Assertions.assertEquals(perfilTela.msnSucesso(), perfilTela.mensagemSucesso());
    }

    @Test
    public void testRealizarONaoPreenchimentoDosCamposObrigatoriosESalvar(){
        test = extent.createTest("Realizar o não preenchimento dos campos obrigatórios e salvar.");
        PerfilTela perfilTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnMeuPerfil()
                .txtNome("")
                .txtSobreNome("")
                .btnSalvar();

        if(perfilTela.mensagemAlertaFalho().equals(perfilTela.alertaFalho()) && perfilTela.mensagemFalho().equals(perfilTela.msnFalho()) ){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(perfilTela.mensagemAlertaFalho(), perfilTela.alertaFalho());
        Assertions.assertEquals(perfilTela.mensagemFalho(), perfilTela.msnFalho());
    }

    @Test
    public void testRealizarOPreenchimentoDoCampoTelefoneComLetrasECaracteresEspeciais(){
        test = extent.createTest("Realizar o preenchimento do campo telefone com letras e caracteres especiais.");
        PerfilTela perfilTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnMeuPerfil()
                .txtTelefone("a-*/.,");

        if(perfilTela.mensagemTelefone().equals(perfilTela.msnTelefone()) ){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }
        Assertions.assertEquals(perfilTela.mensagemTelefone(), perfilTela.msnTelefone());
    }

    @Test
    public void testRealizarOPreenchimentoDoCampoCepComLetrasECaracteresEspeciais(){
        test = extent.createTest("Realizar o preenchimento do campo CEP com letras e caracteres especiais.");
        PerfilTela perfilTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnMeuPerfil()
                .txtCep("a-*/.,");

        if(perfilTela.msnCEP().equals(perfilTela.mensagemCEP()) ){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(perfilTela.msnCEP(), perfilTela.mensagemCEP());
    }
}