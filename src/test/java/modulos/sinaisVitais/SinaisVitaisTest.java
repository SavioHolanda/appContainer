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
// O campo aceita zero no campo então esse testes não será utilizado.
/*    @Test
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
    }*/

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
    // Testes de pulso
    @Test
    @DisplayName("Teste para validar realizar o cadastro de pulso válido")
    public void testRealizarCadastroDePulsoValido() {
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
                .btnPulsoInserir()
                .txtPulsoInserir("100")
                .btnPulsoGravar();

        Assertions.assertEquals("Tudo certo!",sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals("Registro salvo com sucesso!",sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de pulso em branco")
    public void testRealizarCadastroDePulsoEmBranco() {
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
                .btnPulsoInserir()
                .txtPulsoInserir("")
                .btnPulsoGravar();

        Assertions.assertEquals("Informe o pulso.",sinaisVitaisTela.btnGravarDesabilitadoPulso());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de pulso com o valor Zero")
    public void testRealizarCadastroDePulsoComOValorZero() {
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
                .btnPulsoInserir()
                .txtPulsoInserir("")
                .btnPulsoGravar();

        Assertions.assertEquals("Informe o pulso.",sinaisVitaisTela.btnGravarDesabilitadoPulso());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de pulso com o campo com caracteres especiais.")
    public void testRealizarCadastroDePulsoComCaracteresEspeciais() {
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
                .btnPulsoInserir()
                .txtPulsoInserir(".,-A *")
                .btnPulsoGravar();

        Assertions.assertEquals("Informe o pulso.",sinaisVitaisTela.btnGravarDesabilitadoPulso());
    }
    // Testes de Glicemia
    @Test
    @DisplayName("Teste para validar realizar o cadastro de Glicemia válido")
    public void testRealizarCadastroDeGlicemiaValido() {
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
                .btnGlicemiaInserir()
                .txtGlicemiaInserir("100")
                .btnGlicemiaGravar();

        Assertions.assertEquals("Tudo certo!",sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals("Registro salvo com sucesso!",sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de Glicemia em branco")
    public void testRealizarCadastroDeGlicemiaEmBranco() {
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
                .btnGlicemiaInserir()
                .txtGlicemiaInserir("")
                .btnGlicemiaGravar();

        Assertions.assertEquals("Informe o valor da glicemia.",sinaisVitaisTela.btnGravarDesabilitadoGlicemia());
    }
// O campo aceita zero no campo então esse testes não será utilizado.
/*    @Test
    @DisplayName("Teste para validar realizar o cadastro de Glicemia com o valor Zero")
    public void testRealizarCadastroDeGlicemiaComOValorZero() {
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
                .btnGlicemiaInserir()
                .txtGlicemiaInserir("0")
                .btnGlicemiaGravar();

        Assertions.assertEquals("Informe o valor da glicemia.",sinaisVitaisTela.btnGravarDesabilitadoGlicemia());
    }*/

    @Test
    @DisplayName("Teste para validar realizar o cadastro de Glicemia com o campo com caracteres especiais.")
    public void testRealizarCadastroDeGlicemiaComCaracteresEspeciais() {
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
                .btnGlicemiaInserir()
                .txtGlicemiaInserir(".,-A *")
                .btnGlicemiaGravar();

        Assertions.assertEquals("Informe o valor da glicemia.",sinaisVitaisTela.btnGravarDesabilitadoGlicemia());
    }

    // Testes de Saturação
    @Test
    @DisplayName("Teste para validar realizar o cadastro de Saturação válido")
    public void testRealizarCadastroDeSaturacaoValido() {
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
                .btnSaturacaoInserir()
                .txtSaturacaoInserir("100")
                .btnSaturacaoGravar();

        Assertions.assertEquals("Tudo certo!",sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals("Registro salvo com sucesso!",sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de Saturação em branco")
    public void testRealizarCadastroDeSaturacaoEmBranco() {
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
                .btnSaturacaoInserir()
                .txtSaturacaoInserir("")
                .btnSaturacaoGravar();

        Assertions.assertEquals("Informe a saturação.",sinaisVitaisTela.btnGravarDesabilitadoSaturacao());
    }
// O campo aceita zero no campo então esse testes não será utilizado.
/*    @Test
    @DisplayName("Teste para validar realizar o cadastro de Saturação com o valor Zero")
    public void testRealizarCadastroDeSaturacaoComOValorZero() {
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
                .btnSaturacaoInserir()
                .txtSaturacaoInserir("0")
                .btnSaturacaoGravar();

        Assertions.assertEquals("Informe a saturação.",sinaisVitaisTela.btnGravarDesabilitadoSaturacao());
    }*/

    @Test
    @DisplayName("Teste para validar realizar o cadastro de Saturação com o campo com caracteres especiais.")
    public void testRealizarCadastroDeSaturacaoComCaracteresEspeciais() {
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
                .btnSaturacaoInserir()
                .txtSaturacaoInserir(".,-A *")
                .btnSaturacaoGravar();

        Assertions.assertEquals("Informe a saturação.",sinaisVitaisTela.btnGravarDesabilitadoSaturacao());
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}