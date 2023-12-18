package modulos.sinaisVitais;

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
import telas.SinaisVitaisTela;

import java.util.concurrent.TimeUnit;

public class SinaisVitaisTest {
    private AndroidDriver app;
    private ExtentReports extent = TestBase.getInstance();
    private ExtentTest test;

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
        test = extent.createTest("Realizar o cadastro de um sinal vital de peso.");
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

        if(sinaisVitaisTela.mensagemTudoCerto().equals(sinaisVitaisTela.pesoAlertaSucesso1()) && sinaisVitaisTela.mensagemRegistroSucesso().equals(sinaisVitaisTela.pesoAlertaSucesso2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemTudoCerto(),sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals(sinaisVitaisTela.mensagemRegistroSucesso(),sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalPesoEmBranco() {
        test = extent.createTest("Realizar o cadastro de um sinal vital peso em branco.");
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

        if(sinaisVitaisTela.mensagemInforPeso().equals(sinaisVitaisTela.validarBtnGravarDesabilitado())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforPeso(),sinaisVitaisTela.validarBtnGravarDesabilitado());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalPesoComValorZero() {
        test = extent.createTest("Realizar o cadastro de um sinal vital peso com valor zero.");
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

        if(sinaisVitaisTela.mensagemInforPeso().equals(sinaisVitaisTela.validarBtnGravarDesabilitado())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforPeso(),sinaisVitaisTela.validarBtnGravarDesabilitado());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalPesoComCaracteresEspeciais() {
        test = extent.createTest("Realizar o cadastro de um sinal vital peso com caracteres especiais.");
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

        if(sinaisVitaisTela.mensagemInforPeso().equals(sinaisVitaisTela.validarBtnGravarDesabilitado())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforPeso(),sinaisVitaisTela.validarBtnGravarDesabilitado());
    }

    // testes de altura
    @Test
    public void testRealizarOCadastroDeUmSinalVitalAltura() {
        test = extent.createTest("Realizar o cadastro de um sinal vital altura.");
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

        if(sinaisVitaisTela.mensagemTudoCerto().equals(sinaisVitaisTela.pesoAlertaSucesso1()) && sinaisVitaisTela.mensagemRegistroSucesso().equals(sinaisVitaisTela.pesoAlertaSucesso2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemTudoCerto(),sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals(sinaisVitaisTela.mensagemRegistroSucesso(),sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalAlturaEmBranco() {
        test = extent.createTest("Realizar o cadastro de um sinal vital altura em branco.");
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

        if(sinaisVitaisTela.mensagemInforAltura().equals(sinaisVitaisTela.btnGravarDesabilitadoAltura())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforAltura(),sinaisVitaisTela.btnGravarDesabilitadoAltura());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalAlturaComValorZero() {
        test = extent.createTest("Realizar o cadastro de um sinal vital altura com valor zero.");
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

        if(sinaisVitaisTela.mensagemInforAltura().equals(sinaisVitaisTela.btnGravarDesabilitadoAltura())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforAltura(),sinaisVitaisTela.btnGravarDesabilitadoAltura());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalAlturaComCaracteresEspeciais() {
        test = extent.createTest("Realizar o cadastro de um sinal vital altura com caracteres especiais.");
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

        if(sinaisVitaisTela.mensagemInforAltura().equals(sinaisVitaisTela.btnGravarDesabilitadoAltura())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforAltura(),sinaisVitaisTela.btnGravarDesabilitadoAltura());
    }
    // Testes de Temperatura
    @Test
    public void testRealizarOCadastroDeUmSinalVitalTemperatura() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Temperatura.");
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

        if(sinaisVitaisTela.mensagemTudoCerto().equals(sinaisVitaisTela.pesoAlertaSucesso1()) && sinaisVitaisTela.mensagemRegistroSucesso().equals(sinaisVitaisTela.pesoAlertaSucesso2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemTudoCerto(),sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals(sinaisVitaisTela.mensagemRegistroSucesso(),sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalTemperaturaEmBranco() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Temperatura em branco.");
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

        if(sinaisVitaisTela.mensagemInforTemperatura().equals(sinaisVitaisTela.btnGravarDesabilitadoTemperatura())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforTemperatura(),sinaisVitaisTela.btnGravarDesabilitadoTemperatura());
    }
// O campo aceita zero no campo então esse testes não será utilizado.

    @Test
    public void testRealizarOCadastroDeUmSinalVitalTemperaturaComOValorZero() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Temperatura com valor zero.");
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

        if(sinaisVitaisTela.mensagemInforTemperatura().equals(sinaisVitaisTela.btnGravarDesabilitadoTemperatura())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

// Está sendo permitido digitar zero em temperatura.
        Assertions.assertEquals(sinaisVitaisTela.mensagemInforTemperatura(),sinaisVitaisTela.btnGravarDesabilitadoTemperatura());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalTemperaturaComCaracteresEspeciais() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Temperatura com caracteres especiais.");
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

        if(sinaisVitaisTela.mensagemInforTemperatura().equals(sinaisVitaisTela.btnGravarDesabilitadoTemperatura())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforTemperatura(),sinaisVitaisTela.btnGravarDesabilitadoTemperatura());
    }

    // Testes de Pressão Sanguínea
    @Test
    public void testRealizarOCadastroDeUmSinalVitalPressaoSanguinea() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Pressão Sanguínea.");
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

        if(sinaisVitaisTela.mensagemTudoCerto().equals(sinaisVitaisTela.pesoAlertaSucesso1()) && sinaisVitaisTela.mensagemRegistroSucesso().equals(sinaisVitaisTela.pesoAlertaSucesso2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemTudoCerto(),sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals(sinaisVitaisTela.mensagemRegistroSucesso(),sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalPressaoSanguineaOCampoSistólicaEmBranco() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Pressão Sanguínea o campo sistólica em branco.");
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

        if(sinaisVitaisTela.mensagemInforSistolica().equals(sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforSistolica(),sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalPressaoSanguineaOCampoDiastolicaEmBranco() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Pressão Sanguínea o campo diastólica em branco.");
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

        if(sinaisVitaisTela.mensagemInforDiastolica().equals(sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforDiastolica(),sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea2());
    }

    @Test
    public void testRealizarCadastroDePressaoSanguineaComOValorZero() {
        test = extent.createTest("Teste para validar realizar o cadastro de Pressão Sanguínea com o valor Zero");
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

        if(sinaisVitaisTela.mensagemInforDiastolica().equals(sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforSistolica(),sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalPressaoSanguineaComCaracteresEspeciaisNosCampos() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Pressão Sanguínea com caracteres especiais nos campos.");
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

        if(sinaisVitaisTela.mensagemInforSistolica().equals(sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea()) && sinaisVitaisTela.mensagemInforDiastolica().equals(sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforSistolica(),sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea());
        Assertions.assertEquals(sinaisVitaisTela.mensagemInforDiastolica(),sinaisVitaisTela.btnGravarDesabilitadoPressaoSanguinea2());
    }
    // Testes de pulso
    @Test
    public void testRealizarOCadastroDeUmSinalVitalPulso() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Pulso.");
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

        if(sinaisVitaisTela.mensagemTudoCerto().equals(sinaisVitaisTela.pesoAlertaSucesso1()) && sinaisVitaisTela.mensagemRegistroSucesso().equals(sinaisVitaisTela.pesoAlertaSucesso2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemTudoCerto(),sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals(sinaisVitaisTela.mensagemRegistroSucesso(),sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalPulsoEmBranco() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Pulso em branco.");
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

        if(sinaisVitaisTela.mensagemInforPulso().equals(sinaisVitaisTela.btnGravarDesabilitadoPulso())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforPulso(),sinaisVitaisTela.btnGravarDesabilitadoPulso());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalPulsoComOValorZero() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Pulso com valor zero.");
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

        if(sinaisVitaisTela.mensagemInforPulso().equals(sinaisVitaisTela.btnGravarDesabilitadoPulso())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforPulso(),sinaisVitaisTela.btnGravarDesabilitadoPulso());
    }

    @Test
    public void testRealizarOCadastroDeSinalVitalPulsoComCaracteresEspeciais() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Pulso com caracteres especiais.");
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

        if(sinaisVitaisTela.mensagemInforPulso().equals(sinaisVitaisTela.btnGravarDesabilitadoPulso())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforPulso(),sinaisVitaisTela.btnGravarDesabilitadoPulso());
    }
    // Testes de Glicemia
    @Test
    public void testRealizarOCadastroDeUmSinalVitalGlicemia() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Glicemia.");
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

        if(sinaisVitaisTela.mensagemTudoCerto().equals(sinaisVitaisTela.pesoAlertaSucesso1()) && sinaisVitaisTela.mensagemRegistroSucesso().equals(sinaisVitaisTela.pesoAlertaSucesso2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemTudoCerto(),sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals(sinaisVitaisTela.mensagemRegistroSucesso(),sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalGlicemiaEmBranco() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Glicemia em branco.");
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

        if(sinaisVitaisTela.mensagemInforGlicemia().equals(sinaisVitaisTela.btnGravarDesabilitadoGlicemia())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforGlicemia(),sinaisVitaisTela.btnGravarDesabilitadoGlicemia());
    }
// O campo aceita zero no campo então esse testes não será utilizado.

    @Test
    public void testRealizarOCadastroDeUmSinalVitalGlicemiaComValorZero() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Glicemia com valor zero.");
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

        if(sinaisVitaisTela.mensagemInforGlicemia().equals(sinaisVitaisTela.btnGravarDesabilitadoGlicemia())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }
// está aceitando 0
        Assertions.assertEquals(sinaisVitaisTela.mensagemInforGlicemia(),sinaisVitaisTela.btnGravarDesabilitadoGlicemia());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalGlicemiaComCaracteresEspeciais() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Glicemia com caracteres especiais.");
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

        if(sinaisVitaisTela.mensagemInforGlicemia().equals(sinaisVitaisTela.btnGravarDesabilitadoGlicemia())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforGlicemia(),sinaisVitaisTela.btnGravarDesabilitadoGlicemia());
    }

    // Testes de Saturação
    @Test
    public void testRealizarOCadastroDeUmSinalVitalSaturacao() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Saturação.");
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

        if(sinaisVitaisTela.mensagemTudoCerto().equals(sinaisVitaisTela.pesoAlertaSucesso1()) && sinaisVitaisTela.mensagemRegistroSucesso().equals(sinaisVitaisTela.pesoAlertaSucesso2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemTudoCerto(),sinaisVitaisTela.pesoAlertaSucesso1());
        Assertions.assertEquals(sinaisVitaisTela.mensagemRegistroSucesso(),sinaisVitaisTela.pesoAlertaSucesso2());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalSaturacaoEmBranco() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Saturação em branco.");
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

        if(sinaisVitaisTela.mensagemInforSaturacao().equals(sinaisVitaisTela.btnGravarDesabilitadoSaturacao())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforSaturacao(),sinaisVitaisTela.btnGravarDesabilitadoSaturacao());
    }
// O campo aceita zero no campo então esse testes não será utilizado.

    @Test
    public void testRealizarOCadastroDeUmSinalVitalSaturacaoComValorZero() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Saturação com valor zero.");
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

        if(sinaisVitaisTela.mensagemInforSaturacao().equals(sinaisVitaisTela.btnGravarDesabilitadoSaturacao())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforSaturacao(),sinaisVitaisTela.btnGravarDesabilitadoSaturacao());
    }

    @Test
    public void testRealizarOCadastroDeUmSinalVitalSaturacaoComCaracteresEspeciais() {
        test = extent.createTest("Realizar o cadastro de um sinal vital Saturação com caracteres especiais.");
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

        if(sinaisVitaisTela.mensagemInforSaturacao().equals(sinaisVitaisTela.btnGravarDesabilitadoSaturacao())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(sinaisVitaisTela.mensagemInforSaturacao(),sinaisVitaisTela.btnGravarDesabilitadoSaturacao());
    }

    @After
    public void fecharDriver(){
        app.quit();
        extent.flush();
    }
}