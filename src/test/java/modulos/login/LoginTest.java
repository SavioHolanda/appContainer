package modulos.login;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Realizar login com sucesso com um usuário cadastrado em mais de uma entidade")
    public void testRealizarLoginComSucessoComUmUsuarioCadastroEmMaisDeUmaEntidade() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .validarAcesso();

        Assertions.assertEquals("Olá, Sávio", mensagemApresentada);
    }

    @Test
    @DisplayName("Realizar login com sucesso com um usuário cadastrado em apenas uma entidade.")
    public void testRealizarLoginComSucessoComUmUsuarioCadastradoEmApenasUmaEntidade() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("48135484070")
                .escreverSenha("019980")
                .botaoProximo()
                .validarAcesso();

        Assertions.assertEquals("Olá, Sávio", mensagemApresentada);
    }

    @Test
    @DisplayName("Realizar login com CPF não cadastrado.")
    public void testRealizarLoginComCPFNaoCadastrado() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("76549427029")
                .escreverSenha("senha123")
                .botaoEntrarComErro()
                .mensagem();

        Assertions.assertEquals("Usuário não encontrado ou senha incorreta.", mensagemApresentada);
    }

    @Test
    @DisplayName("Realizar login com campos CPF e Senha em branco.")
    public void testRealizarLoginComCamposCPFESenhaEmBranco() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .botaoEntrarComErro()
                .mensagem();

        Assertions.assertEquals("Usuário não encontrado ou senha incorreta.", mensagemApresentada);
    }

    @Test
    @DisplayName("Digitar letras ou caracteres especiais no campo CPF.")
    public void testDgitarLetrasOuCaracteresEspeciaisNoCampoCPF() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("./*a,´[#")
                .textoCPF();

        Assertions.assertEquals("CPF", mensagemApresentada);
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}