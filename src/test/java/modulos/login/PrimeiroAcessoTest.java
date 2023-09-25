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

public class PrimeiroAcessoTest {
    private AndroidDriver app;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

/*    @Test
    @DisplayName("Teste para verificar primeiro acesso ao preencher o cpf valido")
    public void testParaVerificarPrimeiroAcessoAoPreencherOCpfValido() {
        new LoginTela(app)
                .primeiroAcesso()
                .primeiroAcessoCPF("aa")
                .primeiroAcessoBotaoAvancar();

        // Aguardando massa de dados para realizar testes.

        // Assertions.assertEquals("Falha no login. Tente novamente mais tarde.", mensagemApresentada);
    }*/
    @Test
    @DisplayName("Teste para verificar primeiro acesso ao deixar o cpf em branco")
    public void testParaVerificarPrimeiroAcessoAoDeixaOCampoCpfEmBranco() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .primeiroAcesso()
                .primeiroAcessoBotaoAvancar()
                .mensagemPrimeiroAcessoCpfObrigatorio();

        Assertions.assertEquals("CPF obrigatório", mensagemApresentada);
    }
    @Test
    @DisplayName("Teste para verificar primeiro acesso ao preencher o cpf valido porém já cadastrado")
    public void testParaVerfificarPrimeiroAcessoAoPreencherOCpfValidoPoremJaCadastrado() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .primeiroAcesso()
                .primeiroAcessoCPF("03907590902")
                .primeiroAcessoBotaoAvancar()
                .mensagemPrimeiroAcessoSemEmpresa();

        Assertions.assertEquals("Nenhuma empresa encontrada", mensagemApresentada);
    }
    @Test
    @DisplayName("Teste para verificar primeiro acesso ao preencher o cpf invalido")
    public void testParaVerificarPrimeiroAcessoAoPreencherOCpfInvalido() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .primeiroAcesso()
                .primeiroAcessoCPF("32873022051")
                .primeiroAcessoBotaoAvancar()
                .mensagemPrimeiroAcessoSemEmpresa();

        Assertions.assertEquals("Nenhuma empresa encontrada", mensagemApresentada);
    }
    @Test
    @DisplayName("Teste para verificar primeiro acesso ao preencher o cpf incompleto")
    public void testParaVerificarPrimeiroAcessoAoPreencherOCpfIncompleto() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .primeiroAcesso()
                .primeiroAcessoCPF("029")
                .primeiroAcessoBotaoAvancar()
                .mensagemPrimeiroAcessoCpfIncompleto();

        Assertions.assertEquals("Digite o CPF completo", mensagemApresentada);
    }
    @Test
    @DisplayName("Teste para verificar primeiro acesso ao preencher o cpf com caracteres especiais.")
    public void testParaVerificarPrimeiroAcessoAoPreencherOCpfComCaracteresEspeciais() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .primeiroAcesso()
                .primeiroAcessoCPF("%a@.;,A")
                .primeiroAcessoBotaoAvancar()
                .mensagemPrimeiroAcessoCpfObrigatorio();

        Assertions.assertEquals("CPF obrigatório", mensagemApresentada);
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}