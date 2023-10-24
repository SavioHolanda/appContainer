package modulos.sinaisVitais;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.BemVindoTela;
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
    @DisplayName("Realizar o cadastro de um sinal vital de peso.")
    public void testRealizarOCadastroDeUmSinalVitalDePeso() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnPesoInserir()
                .txtPesoInserir("8500")
                .btnPesoGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemTudoCerto(),sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals(sinaisVitaisTela.mensagemRegistroSucesso(),sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital peso em branco.")
    public void testRealizarOCadastroDeUmSinalVitalPesoEmBranco() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnPesoInserir()
                .txtPesoInserir("")
                .btnPesoGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforPeso(),sinaisVitaisTela.validarBtnGravarDesabilitado());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital peso com valor zero.")
    public void testRealizarOCadastroDeUmSinalVitalPesoComValorZero() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnPesoInserir()
                .txtPesoInserir("0")
                .btnPesoGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforPeso(),sinaisVitaisTela.validarBtnGravarDesabilitado());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital peso com caracteres especiais.")
    public void testRealizarOCadastroDeUmSinalVitalPesoComCaracteresEspeciais() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnPesoInserir()
                .txtPesoInserir(".,-A *")
                .btnPesoGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforPeso(),sinaisVitaisTela.validarBtnGravarDesabilitado());
    }

    // testes de altura
    @Test
    @DisplayName("Realizar o cadastro de um sinal vital altura.")
    public void testRealizarOCadastroDeUmSinalVitalAltura() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnAlturaInserir()
                .txtAlturaInserir("18500")
                .btnAlturaGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemTudoCerto(),sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals(sinaisVitaisTela.mensagemRegistroSucesso(),sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital altura em branco.")
    public void testRealizarOCadastroDeUmSinalVitalAlturaEmBranco() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnAlturaInserir()
                .txtAlturaInserir("")
                .btnAlturaGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforAltura(),sinaisVitaisTela.btnGravarDesabilitadoAltura());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital altura com valor zero.")
    public void testRealizarOCadastroDeUmSinalVitalAlturaComValorZero() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnAlturaInserir()
                .txtAlturaInserir("0")
                .btnAlturaGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforAltura(),sinaisVitaisTela.btnGravarDesabilitadoAltura());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital altura com caracteres especiais.")
    public void testRealizarOCadastroDeUmSinalVitalAlturaComCaracteresEspeciais() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnAlturaInserir()
                .txtAlturaInserir(".,-A *")
                .btnAlturaGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforAltura(),sinaisVitaisTela.btnGravarDesabilitadoAltura());
    }
    // Testes de Temperatura
    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Temperatura.")
    public void testRealizarOCadastroDeUmSinalVitalTemperatura() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnTemperaturaInserir()
                .txtTemperaturaInserir("18500")
                .btnTemperaturaGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemTudoCerto(),sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals(sinaisVitaisTela.mensagemRegistroSucesso(),sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Temperatura em branco.")
    public void testRealizarOCadastroDeUmSinalVitalTemperaturaEmBranco() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnTemperaturaInserir()
                .txtTemperaturaInserir("")
                .btnTemperaturaGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforTemperatura(),sinaisVitaisTela.btnGravarDesabilitadoTemperatura());
    }
// O campo aceita zero no campo então esse testes não será utilizado.

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Temperatura com valor zero.")
    public void testRealizarOCadastroDeUmSinalVitalTemperaturaComOValorZero() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnTemperaturaInserir()
                .txtTemperaturaInserir("0")
                .btnTemperaturaGravar();


// Está sendo permitido digitar zero em temperatura.
        Assertions.assertEquals(sinaisVitaisTela.mensagemInforTemperatura(),sinaisVitaisTela.btnGravarDesabilitadoTemperatura());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Temperatura com caracteres especiais.")
    public void testRealizarOCadastroDeUmSinalVitalTemperaturaComCaracteresEspeciais() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnTemperaturaInserir()
                .txtTemperaturaInserir(".,-A *")
                .btnTemperaturaGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforTemperatura(),sinaisVitaisTela.btnGravarDesabilitadoTemperatura());
    }

    // Testes de Pressão Sanguínea
    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Pressão Sanguínea.")
    public void testRealizarOCadastroDeUmSinalVitalPressaoSanguinea() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnPressaoSanguineaInserir()
                .txtPressaoSistolica("123")
                .txtPressaoDiastolica("321")
                .btnPressaoSanguineaGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemTudoCerto(),sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals(sinaisVitaisTela.mensagemRegistroSucesso(),sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Pressão Sanguínea o campo sistólica em branco.")
    public void testRealizarOCadastroDeUmSinalVitalPressaoSanguineaOCampoSistólicaEmBranco() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnPressaoSanguineaInserir()
                .txtPressaoSistolica("")
                .txtPressaoDiastolica("123")
                .btnPressaoSanguineaGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforSistolica(),sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Pressão Sanguínea o campo diastólica em branco.")
    public void testRealizarOCadastroDeUmSinalVitalPressaoSanguineaOCampoDiastolicaEmBranco() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnPressaoSanguineaInserir()
                .txtPressaoSistolica("123")
                .txtPressaoDiastolica("")
                .btnPressaoSanguineaGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforDiastolica(),sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea2());
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de Pressão Sanguínea com o valor Zero")
    public void testRealizarCadastroDePressaoSanguineaComOValorZero() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnPressaoSanguineaInserir()
                .txtPressaoSistolica("")
                .txtPressaoDiastolica("123")
                .btnPressaoSanguineaGravar();

        Assertions.assertEquals("Insira a pressão sistólica",sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Pressão Sanguínea com caracteres especiais nos campos.")
    public void testRealizarOCadastroDeUmSinalVitalPressaoSanguineaComCaracteresEspeciaisNosCampos() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnPressaoSanguineaInserir()
                .txtPressaoSistolica(".,-A *")
                .txtPressaoDiastolica(".,-A *")
                .btnPressaoSanguineaGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforSistolica(),sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea());
        Assertions.assertEquals(sinaisVitaisTela.mensagemInforDiastolica(),sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea2());
    }
    // Testes de pulso
    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Pulso.")
    public void testRealizarOCadastroDeUmSinalVitalPulso() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnPulsoInserir()
                .txtPulsoInserir("100")
                .btnPulsoGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemTudoCerto(),sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals(sinaisVitaisTela.mensagemRegistroSucesso(),sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Pulso em branco.")
    public void testRealizarOCadastroDeUmSinalVitalPulsoEmBranco() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnPulsoInserir()
                .txtPulsoInserir("")
                .btnPulsoGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforPulso(),sinaisVitaisTela.btnGravarDesabilitadoPulso());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Pulso com valor zero.")
    public void testRealizarOCadastroDeUmSinalVitalPulsoComOValorZero() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnPulsoInserir()
                .txtPulsoInserir("")
                .btnPulsoGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforPulso(),sinaisVitaisTela.btnGravarDesabilitadoPulso());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Pulso com caracteres especiais.")
    public void testRealizarOCadastroDeSinalVitalPulsoComCaracteresEspeciais() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnPulsoInserir()
                .txtPulsoInserir(".,-A *")
                .btnPulsoGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforPulso(),sinaisVitaisTela.btnGravarDesabilitadoPulso());
    }
    // Testes de Glicemia
    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Glicemia.")
    public void testRealizarOCadastroDeUmSinalVitalGlicemia() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnGlicemiaInserir()
                .txtGlicemiaInserir("100")
                .btnGlicemiaGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemTudoCerto(),sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals(sinaisVitaisTela.mensagemRegistroSucesso(),sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Glicemia em branco.")
    public void testRealizarOCadastroDeUmSinalVitalGlicemiaEmBranco() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnGlicemiaInserir()
                .txtGlicemiaInserir("")
                .btnGlicemiaGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforGlicemia(),sinaisVitaisTela.btnGravarDesabilitadoGlicemia());
    }
// O campo aceita zero no campo então esse testes não será utilizado.

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Glicemia com valor zero.")
    public void testRealizarOCadastroDeUmSinalVitalGlicemiaComValorZero() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnGlicemiaInserir()
                .txtGlicemiaInserir("0")
                .btnGlicemiaGravar();
// está aceitando 0
        Assertions.assertEquals(sinaisVitaisTela.mensagemInforGlicemia(),sinaisVitaisTela.btnGravarDesabilitadoGlicemia());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Glicemia com caracteres especiais.")
    public void testRealizarOCadastroDeUmSinalVitalGlicemiaComCaracteresEspeciais() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnGlicemiaInserir()
                .txtGlicemiaInserir(".,-A *")
                .btnGlicemiaGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforGlicemia(),sinaisVitaisTela.btnGravarDesabilitadoGlicemia());
    }

    // Testes de Saturação
    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Saturação.")
    public void testRealizarOCadastroDeUmSinalVitalSaturacao() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnSaturacaoInserir()
                .txtSaturacaoInserir("100")
                .btnSaturacaoGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemTudoCerto(),sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals(sinaisVitaisTela.mensagemRegistroSucesso(),sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Saturação em branco.")
    public void testRealizarOCadastroDeUmSinalVitalSaturacaoEmBranco() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnSaturacaoInserir()
                .txtSaturacaoInserir("")
                .btnSaturacaoGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforSaturacao(),sinaisVitaisTela.btnGravarDesabilitadoSaturacao());
    }
// O campo aceita zero no campo então esse testes não será utilizado.

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Saturação com valor zero.")
    public void testRealizarOCadastroDeUmSinalVitalSaturacaoComValorZero() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnSaturacaoInserir()
                .txtSaturacaoInserir("0")
                .btnSaturacaoGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforSaturacao(),sinaisVitaisTela.btnGravarDesabilitadoSaturacao());
    }

    @Test
    @DisplayName("Realizar o cadastro de um sinal vital Saturação com caracteres especiais.")
    public void testRealizarOCadastroDeUmSinalVitalSaturacaoComCaracteresEspeciais() {
        SinaisVitaisTela sinaisVitaisTela  = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnSinaisVitais()
                .btnSaturacaoInserir()
                .txtSaturacaoInserir(".,-A *")
                .btnSaturacaoGravar();

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforSaturacao(),sinaisVitaisTela.btnGravarDesabilitadoSaturacao());
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}