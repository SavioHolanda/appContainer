package modulos.login;

import com.aventstack.extentreports.Status;
import com.sun.org.apache.xpath.internal.operations.Equals;
import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import modulos.driver.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.BemVindoTela;
import telas.HomeTela;
import telas.LoginTela;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {
    private AndroidDriver app;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Realizar login com sucesso com um usuário cadastrado em apenas uma entidade.")
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

        Assertions.assertEquals(homeTela.txtRetorno(), homeTela.validarAcesso());

            test.log(Status.PASS, "Teste aprovado");
    }

    @Test
    @DisplayName("Realizar login com sucesso com um usuário cadastrado em mais de uma entidade")
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
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome();

        Assertions.assertEquals(homeTela.txtRetorno(), homeTela.validarAcesso());

            test.log(Status.PASS, "Teste aprovado");
    }

    @Test
    @DisplayName("Realizar login alterando o CPF do campo CPF.")
    public void testRealizarLoginAlterandoOCPFDoCampoCPF() {
        test = extent.createTest("Realizar login alterando o CPF do campo CPF.");
        String informacaoCampoCPF = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("02971008312")
                .btnAvancar()
                .selecionarEmpresabem()
                .btnEmpresaAvancar()
                .escreverCPF("76549427029")
                .informacaoCampoCPF();

        Assertions.assertEquals("029.710.083-12", informacaoCampoCPF);

            test.log(Status.PASS, "Teste aprovado");

    }

    @Test
    @DisplayName("Realizar login com o campo Senha em branco.")
    public void testRealizarLoginComOCampoSenhaEmBranco() {
        test = extent.createTest("Realizar login com o campo Senha em branco.");
        String nãoLogadoBtnDesabilitado = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("02971008312")
                .btnAvancar()
                .selecionarEmpresabem()
                .btnEmpresaAvancar()
                .botaoEntrarComErro()
                .informacaoCampoCPF();

        Assertions.assertEquals("029.710.083-12", nãoLogadoBtnDesabilitado);

            test.log(Status.PASS, "Teste aprovado");
    }

    @Test
    @DisplayName("Realizar login com a senha invalida.")
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

        String mensagemProcessoFalhou = loginTela.mensagemProcessoFalhou();
        String mensagemUsuarioOuSenhaIncorreto = loginTela.mensagemUsuarioOuSenhaIncorreto();

        Assertions.assertEquals("O processo falhou.", mensagemProcessoFalhou);
        Assertions.assertEquals("Usuário não encontrado ou senha incorreta.", mensagemUsuarioOuSenhaIncorreto);

            test.log(Status.PASS, "Teste aprovado");

    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}