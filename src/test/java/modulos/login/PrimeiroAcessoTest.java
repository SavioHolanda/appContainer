/*
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

*/
/*    @Test
    @DisplayName("Teste para verificar primeiro acesso ao preencher o cpf valido")
    public void testParaVerificarPrimeiroAcessoAoPreencherOCpfValido() {
        new LoginTela(app)
                .primeiroAcesso()
                .primeiroAcessoCPF("aa")
                .primeiroAcessoBotaoAvancar();

        // Aguardando massa de dados para realizar testes.

        // Assertions.assertEquals("Falha no login. Tente novamente mais tarde.", mensagemApresentada);
    }*//*

    @Test
    @DisplayName("Realizar primeiro acesso com campo Digite seu CPF em branco.")
    public void testRealizarPrimeiroAcessoComCampoDigiteSeuCPFEmBranco() {
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
    @DisplayName("Realizar primeiro acesso digitando um CPF valido não sendo o primeiro acesso no campo Digite seu CPF.")
    public void testRealizarPrimeiroAcessoDigitandoUmCPFValidoNaoSendoOPrimeiroAcessoNoCampoDigiteSeCPF() {
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
    @DisplayName("Realizar primeiro acesso digitando um CPF valido não cadastrado no campo Digite seu CPF.")
    public void testRealizarPrimeiroAcessoDigitandoUmCPFValidoNaoCadastradoNoCampoDigiteSeuCPF() {
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
    @DisplayName("Realizar primeiro acesso digitando um CPF incompleto no campo Digite seu CPF.")
    public void testRealizarPrimeiroAcessoDigitandoUmCPFIncompletoNoCampoDigiteSeuCPF() {
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
    @DisplayName("Realizar primeiro acesso digitando letras ou caracteres especiais no campo Digite seu CPF.")
    public void testRealizarPrimeiroAcessoDigitandoLetrasOuCaracteresEspeciaisNoCampoDigiteSeuCPF() {
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
}*/
