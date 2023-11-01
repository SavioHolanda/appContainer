package modulos.login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import modulos.driver.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.BemVindoTela;
import telas.LoginTela;

import java.util.concurrent.TimeUnit;

public class RelatarProblemaTest {
    private AndroidDriver app;
    private ExtentReports extent = TestBase.getInstance();
    private ExtentTest test;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testRelatarUmProblemaTecnicoCorretamentePreenchendoOsCampoNomeTelefoneMensagemEEnviando() {
        test = extent.createTest("Relatar um problema técnico corretamente preenchendo os campos Nome, Telefone, Mensagem e Enviando.");
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .faleComAGente()
                .digitarNomeRelatarProblema("Fulano da Silva")
                .digitarTelefoneRelatarProblema("85999999999")
                .digitarMensagemRelatarProblema("Mensagem testes para enviar um problema a ser reportado.")
                .botaoEnviarRelatarProblema();

        if(loginTela.msnSucesso().equals(loginTela.mensagemSucessoRelatarproblema1()) && loginTela.msnRelatarProblemaSuceso().equals(loginTela.mensagemSucessoRelatarproblema2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(loginTela.msnSucesso(), loginTela.mensagemSucessoRelatarproblema1());
        Assertions.assertEquals(loginTela.msnRelatarProblemaSuceso(), loginTela.mensagemSucessoRelatarproblema2());
    }
    @Test
    public void testRelatarUmProblemaTecnicoInvalidoNaoPreenchendoOsCamposNomeTelefoneMensagemEEnviando() {
        test = extent.createTest("Relatar um problema técnico invalido não preenchendo os campos Nome, Telefone, Mensagem e Enviando.");
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .faleComAGente()
                .botaoEnviarRelatarProblema();

        if(loginTela.msnInforNome().equals(loginTela.mensagemNomeObrigatorio()) && loginTela.msnInforTel().equals(loginTela.mensagemTelefoneObrigatorio()) && loginTela.msnInforProblema().equals(loginTela.mensagemObrigatorio())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(loginTela.msnInforNome(), loginTela.mensagemNomeObrigatorio());
        Assertions.assertEquals(loginTela.msnInforTel(), loginTela.mensagemTelefoneObrigatorio());
        Assertions.assertEquals(loginTela.msnInforProblema(), loginTela.mensagemObrigatorio());
    }
    @Test
    public void testRelatarUmProblemaComCaracteresEspeciaisOuLetrasNoCampoTelefone() {
        test = extent.createTest("Relatar um problema com caracteres especiais ou letras no campo Telefone.");
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .faleComAGente()
                .digitarTelefoneRelatarProblema("%./@!test,")
                .botaoEnviarRelatarProblema();

        if(loginTela.msnTelCelular().equals(loginTela.telefoneMensagem())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(loginTela.msnTelCelular(), loginTela.telefoneMensagem());
    }
    @Test
    public void testClicarNaFuncionalidadeBotaoCancelar() {
        test = extent.createTest("Clicar na funcionalidade botão cancelar.");
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .faleComAGente()
                .botaoCancelarRelatarProblema();

        if(loginTela.msnFaleGente().equals(loginTela.textoFaleComAGente())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(loginTela.msnFaleGente(), loginTela.textoFaleComAGente());
    }

    @After
    public void fecharDriver(){
        app.quit();
        extent.flush();
    }
}