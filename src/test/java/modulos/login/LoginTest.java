package modulos.login;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.BemVindoTela;
import telas.LoginTela;

import java.util.concurrent.TimeUnit;

public class LoginTest {
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
        String mensagemApresentada = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .validarAcesso();

        Assertions.assertEquals("Olá, Sávio", mensagemApresentada);
    }

    @Test
    @DisplayName("Realizar login com sucesso com um usuário cadastrado em mais de uma entidade")
    public void testRealizarLoginComSucessoComUmUsuarioCadastroEmMaisDeUmaEntidade() {
        String mensagemApresentada = new BemVindoTela(app)
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
                .botaoHome()
                .validarAcesso();

        Assertions.assertEquals("Olá, Sávio", mensagemApresentada);
    }

    @Test
    @DisplayName("Realizar login alterando o CPF do campo CPF.")
    public void testRealizarLoginAlterandoOCPFDoCampoCPF() {
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
    }

    @Test
    @DisplayName("Realizar login com o campo Senha em branco.")
    public void testRealizarLoginComOCampoSenhaEmBranco() {
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
    }

    @Test
    @DisplayName("Realizar login com a senha invalida.")
    public void testRealizarLoginComASenhaInvalida() {
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
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}