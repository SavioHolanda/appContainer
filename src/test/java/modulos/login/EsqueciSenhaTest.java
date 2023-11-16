package modulos.login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import driver.AndroidDriverProvider;
import driver.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.BemVindoTela;
import telas.LoginTela;

import java.util.concurrent.TimeUnit;

public class EsqueciSenhaTest {
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
    public void testDigitarUmCpfCadastradoNoCampoDigiteSeuCpfEEnvialo() {
        test = extent.createTest("Digitar um CPF cadastrado no campo Digite seu CPF e envia-lo.");
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .esqueciSenha()
                .esqueciSenhaCPF("30480525005")
                .esqueciSenhaEnviar();

        if(loginTela.msnSucessoSenha().equals(loginTela.mensagemSucesso()) && loginTela.msnSenhaSucesso().equals(loginTela.mensagemSenhaAlterada())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(loginTela.msnSucessoSenha(), loginTela.mensagemSucesso());
        Assertions.assertEquals(loginTela.msnSenhaSucesso(), loginTela.mensagemSenhaAlterada());
    }

    @Test
    public void testDigitarUmCPFNaoCadastradoNoCampoDigiteSeuCPFEEnvialo() {
        test = extent.createTest("Digitar um CPF não cadastrado no campo Digite seu CPF e envia-lo.");
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .esqueciSenha()
                .esqueciSenhaCPF("12345217412")
                .esqueciSenhaEnviar();

        if(loginTela.msnAtencao().equals(loginTela.mensagemAtencao()) && loginTela.msnUsuarioNaoEncontrado().equals(loginTela.mensagemUsuarioNaoEncontrado())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(loginTela.msnAtencao(), loginTela.mensagemAtencao());
        Assertions.assertEquals(loginTela.msnUsuarioNaoEncontrado(), loginTela.mensagemUsuarioNaoEncontrado());
    }

    @Test
    public void testDigitarCaracteresEspeciaisNoCampoDigiteSeuCPF() {
        test = extent.createTest("Digitar caracteres especiais no campo digite seu CPF.");
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .esqueciSenha()
                .esqueciSenhaCPF(",.-")
                .esqueciSenhaEnviar();

        if(loginTela.msnCpfObrigatorio().equals(loginTela.cpfObrigatorio())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(loginTela.msnCpfObrigatorio(), loginTela.cpfObrigatorio());
    }

    @Test
    public void testDeixaOCampoDigiteSeuCPFEmBranco() {
        test = extent.createTest("Deixar o campo Digite seu CPF em branco.");
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .esqueciSenha()
                .esqueciSenhaCPF("")
                .esqueciSenhaEnviar();

        if(loginTela.msnCpfObrigatorio().equals(loginTela.cpfObrigatorio())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(loginTela.msnCpfObrigatorio(), loginTela.cpfObrigatorio());
    }

    @Test
    public void testDigitarUmCPFIncompletoNoCampoDigiteSeuCPF() {
        test = extent.createTest("Digitar um CPF incompleto no campo Digite seu CPF.");
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .esqueciSenha()
                .esqueciSenhaCPF("123")
                .esqueciSenhaEnviar();

        if(loginTela.msnCpfCompleto().equals(loginTela.cpfCompleto())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(loginTela.msnCpfCompleto(), loginTela.cpfCompleto());
    }

    @After
    public void fecharDriver(){
        app.quit();
        extent.flush();
    }
}