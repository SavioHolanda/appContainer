package modulos.sinaisVitais;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.LoginTela;
import telas.SinaisVitaisTela;

import java.util.concurrent.TimeUnit;

public class SinaisVitaisTest {
    private AndroidDriver app;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // testes de peso
    @Test
    @DisplayName("Teste para validar realizar o cadastro de peso válido")
    public void testRealizarCadastroDePesoValido() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnPesoInserir()
                .txtPesoInserir("8500")
                .btnPesoGravar();

        Assertions.assertEquals("Tudo certo!",sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals("Registro salvo com sucesso!",sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de peso com o campo em branco")
    public void testRealizarCadastroDePesoEmBranco() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnPesoInserir()
                .txtPesoInserir("")
                .btnPesoGravar();

        Assertions.assertEquals("Informe o peso.",sinaisVitaisTela.validarBtnGravarDesabilitado());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de peso com o campo com o valor 0")
    public void testRealizarCadastroDePesoComValorZero() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnPesoInserir()
                .txtPesoInserir("0")
                .btnPesoGravar();

        Assertions.assertEquals("Informe o peso.",sinaisVitaisTela.validarBtnGravarDesabilitado());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de peso com o campo com caracteres especiais.")
    public void testRealizarCadastroDePesoComCaracteresEspeciais() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnPesoInserir()
                .txtPesoInserir(".,-A *")
                .btnPesoGravar();

        Assertions.assertEquals("Informe o peso.",sinaisVitaisTela.validarBtnGravarDesabilitado());
    }

    // testes de altura
    @Test
    @DisplayName("Teste para validar realizar o cadastro de altura válido")
    public void testRealizarCadastroDeAlturaValido() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnAlturaInserir()
                .txtAlturaInserir("18500")
                .btnAlturaGravar();

        Assertions.assertEquals("Tudo certo!",sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals("Registro salvo com sucesso!",sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de altura em branco")
    public void testRealizarCadastroDeAlturaEmBranco() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnAlturaInserir()
                .txtAlturaInserir("")
                .btnAlturaGravar();

        Assertions.assertEquals("Informe a altura.",sinaisVitaisTela.btnGravarDesabilitadoAltura());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de altura com o valor Zero")
    public void testRealizarCadastroDeAlturaComOValorZero() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnAlturaInserir()
                .txtAlturaInserir("0")
                .btnAlturaGravar();

        Assertions.assertEquals("Informe a altura.",sinaisVitaisTela.btnGravarDesabilitadoAltura());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de altura com o campo com caracteres especiais.")
    public void testRealizarCadastroDeAlturaComCaracteresEspeciais() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnAlturaInserir()
                .txtAlturaInserir(".,-A *")
                .btnAlturaGravar();

        Assertions.assertEquals("Informe a altura.",sinaisVitaisTela.btnGravarDesabilitadoAltura());
    }
    // Testes de Temperatura
    @Test
    @DisplayName("Teste para validar realizar o cadastro de Temperatura válido")
    public void testRealizarCadastroDeTemperaturaValido() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnTemperaturaInserir()
                .txtTemperaturaInserir("18500")
                .btnTemperaturaGravar();

        Assertions.assertEquals("Tudo certo!",sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals("Registro salvo com sucesso!",sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de Temperatura em branco")
    public void testRealizarCadastroDeTemperaturaEmBranco() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnTemperaturaInserir()
                .txtTemperaturaInserir("")
                .btnTemperaturaGravar();

        Assertions.assertEquals("Informe a temperatura.",sinaisVitaisTela.btnGravarDesabilitadoTemperatura());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de Temperatura com o valor Zero")
    public void testRealizarCadastroDeTemperaturaComOValorZero() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnTemperaturaInserir()
                .txtTemperaturaInserir("0")
                .btnTemperaturaGravar();


// Está sendo permitido digitar zero em temperatura.
        Assertions.assertEquals("Informe a temperatura.",sinaisVitaisTela.btnGravarDesabilitadoTemperatura());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de Temperatura com o campo com caracteres especiais.")
    public void testRealizarCadastroDeTemperaturaComCaracteresEspeciais() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnTemperaturaInserir()
                .txtTemperaturaInserir(".,-A *")
                .btnTemperaturaGravar();

        Assertions.assertEquals("Informe a temperatura.",sinaisVitaisTela.btnGravarDesabilitadoTemperatura());
    }

    // Testes de Pressão Sanguínea
    @Test
    @DisplayName("Teste para validar realizar o cadastro de Pressão Sanguínea válido")
    public void testRealizarCadastroDePressaoSanguineaValido() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnPressaoSanguineaInserir()
                .txtPressaoSistolica("123")
                .txtPressaoDiastolica("321")
                .btnPressaoSanguineaGravar();

        Assertions.assertEquals("Tudo certo!",sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals("Registro salvo com sucesso!",sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de Pressão Sanguínea em branco")
    public void testRealizarCadastroDePressaoSanguineaEmBranco() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnPressaoSanguineaInserir()
                .txtPressaoSistolica("123")
                .txtPressaoDiastolica("")
                .btnPressaoSanguineaGravar();

        Assertions.assertEquals("Informe a pressão diastólica.",sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea2());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de Pressão Sanguínea com o valor Zero")
    public void testRealizarCadastroDePressaoSanguineaComOValorZero() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnPressaoSanguineaInserir()
                .txtPressaoSistolica("")
                .txtPressaoDiastolica("123")
                .btnPressaoSanguineaGravar();

        Assertions.assertEquals("Insira a pressão sistólica",sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de Pressão Sanguínea com o campo com caracteres especiais.")
    public void testRealizarCadastroDePressaoSanguineaComCaracteresEspeciais() {
        SinaisVitaisTela sinaisVitaisTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnSinaisVitais()
                .btnPressaoSanguineaInserir()
                .txtPressaoSistolica(".,-A *")
                .txtPressaoDiastolica(".,-A *")
                .btnPressaoSanguineaGravar();

        Assertions.assertEquals("Insira a pressão sistólica",sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea());
        Assertions.assertEquals("Informe a pressão diastólica.",sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea2());
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}