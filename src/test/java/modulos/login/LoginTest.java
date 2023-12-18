package modulos.login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import config.AndroidDriverProvider;
import config.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.BemVindoTela;
import telas.HomeTela;
import telas.LoginTela;

import java.util.concurrent.TimeUnit;

public class LoginTest {
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
    public void testRealizarLoginComSucessoComUmUsuarioCadastradoEmApenasUmaEntidade() {
        test = extent.createTest("Realizar login com sucesso com um usuário cadastrado em apenas uma entidade.");
        HomeTela homeTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome();

        if(homeTela.txtRetorno().equals(homeTela.validarAcesso())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(homeTela.txtRetorno(), homeTela.validarAcesso());
    }

    @Test
    public void testRealizarLoginComSucessoComUmUsuarioCadastroEmMaisDeUmaEntidade() {
        test = extent.createTest("Realizar login com sucesso com um usuário cadastrado em mais de uma entidade");
        HomeTela homeTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("02971008312")
                .btnAvancar()
                .selecionarEmpresabem()
                .btnEmpresaAvancar()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome();

        if(homeTela.txtRetorno().equals(homeTela.validarAcesso())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(homeTela.txtRetorno(), homeTela.validarAcesso());
    }

    @Test
    public void testRealizarLoginAlterandoOCPFDoCampoCPF() {
        test = extent.createTest("Realizar login alterando o CPF do campo CPF.");
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("02971008312")
                .btnAvancar()
                .selecionarEmpresabem()
                .btnEmpresaAvancar()
                .escreverCPF("76549427029");

        if(loginTela.msnCpf().equals(loginTela.informacaoCampoCPF())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(loginTela.msnCpf(), loginTela.informacaoCampoCPF());

    }

    @Test
    public void testRealizarLoginComOCampoSenhaEmBranco() {
        test = extent.createTest("Realizar login com o campo Senha em branco.");
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("02971008312")
                .btnAvancar()
                .selecionarEmpresabem()
                .btnEmpresaAvancar()
                .botaoEntrarComErro();

        if(loginTela.msnCpf().equals(loginTela.informacaoCampoCPF())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(loginTela.msnCpf(), loginTela.informacaoCampoCPF());
    }

    @Test
    public void testRealizarLoginComASenhaInvalida() {
        test = extent.createTest("Realizar login com a senha invalida.");
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("02971008312")
                .btnAvancar()
                .selecionarEmpresabem()
                .btnEmpresaAvancar()
                .escreverSenha("SenhaInvalida123")
                .botaoEntrarComErro();

        if(loginTela.msnProcessoFalhou().equals(loginTela.mensagemProcessoFalhou()) && loginTela.msnSenhaIncorreta().equals(loginTela.mensagemUsuarioOuSenhaIncorreto())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(loginTela.msnProcessoFalhou(), loginTela.mensagemProcessoFalhou());
        Assertions.assertEquals(loginTela.msnSenhaIncorreta(), loginTela.mensagemUsuarioOuSenhaIncorreto());
    }

    @After
    public void fecharDriver(){
        app.quit();
        extent.flush();
    }
}