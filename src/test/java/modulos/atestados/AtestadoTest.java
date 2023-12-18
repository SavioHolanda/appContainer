package modulos.atestados;

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
import telas.AtestadoTela;
import telas.BemVindoTela;

import java.util.concurrent.TimeUnit;

public class AtestadoTest {
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
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodo() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e Período.");
        AtestadoTela atestadoTela  = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .selecionarDataFim()
                .scroll(0.5,0.56,0.5,0.52)
                .btnConfirmarDataEHora()
                .selecionarHoraFim()
                .btnConfirmarDataEHora()
                .txtNomeMedico("Dr João Silva")
                .txtCRM("123456")
                .txtCID("654321")
                .txtObs("Obs")
                .btnAnexarAtestadoGaleria()
                .checkBoxConfirmacao()
                .btnSalvar();

        if(atestadoTela.mensagemTudoCerto().equals(atestadoTela.mensagemCadastroPositivo()) && atestadoTela.mensagemTudoCerto2().equals(atestadoTela.mensagemCadastroPositivoComplemento())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemTudoCerto(),atestadoTela.mensagemCadastroPositivo());
        Assertions.assertEquals(atestadoTela.mensagemTudoCerto2(),atestadoTela.mensagemCadastroPositivoComplemento());
    }

    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidade() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e Quantidade.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoHoraQtd()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .btnqtdHoras()
                .txtNomeMedico2("Dr João Silva")
                .txtCRM2("123456")
                .txtCID2("654321")
                .txtObs2("Obs")
                .btnAnexarAtestadoGaleria()
                .checkBoxConfirmacao2()
                .btnSalvar2();

        if(atestadoTela.mensagemTudoCerto().equals(atestadoTela.mensagemCadastroPositivo()) && atestadoTela.mensagemTudoCerto2().equals(atestadoTela.mensagemCadastroPositivoComplemento())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemTudoCerto(),atestadoTela.mensagemCadastroPositivo());
        Assertions.assertEquals(atestadoTela.mensagemTudoCerto2(),atestadoTela.mensagemCadastroPositivoComplemento());
    }

    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDia() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por dia.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoAtestadoDia()
                .selecionarDataInicio2()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio2()
                .btnConfirmarDataEHora()
                .btnDias()
                .txtNomeMedico3("Dr João Silva")
                .txtCRM3("123456")
                .txtCID3("654321")
                .txtObs3("Obs")
                .btnAnexarAtestadoGaleria()
                .checkBoxConfirmacao3()
                .btnSalvar3();

        if(atestadoTela.mensagemTudoCerto().equals(atestadoTela.mensagemCadastroPositivo()) && atestadoTela.mensagemTudoCerto2().equals(atestadoTela.mensagemCadastroPositivoComplemento())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemTudoCerto(),atestadoTela.mensagemCadastroPositivo());
        Assertions.assertEquals(atestadoTela.mensagemTudoCerto2(),atestadoTela.mensagemCadastroPositivoComplemento());
    }

    @Test
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemDataInicio() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e Período sem data inicio.");
        AtestadoTela atestadoTela  = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .btnSalvar();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemDataInicio().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemDataInicio(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemDataInicio() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e Quantidade sem data inicio.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoHoraQtd()
                .btnSalvar2();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemDataInicio().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemDataInicio(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDiaSemDataInicio() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por dia sem data inicio.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoAtestadoDia()
                .btnSalvar3();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemDataInicio().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemDataInicio(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemHoraInicio() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e Período sem hora inicio.");
        AtestadoTela atestadoTela  = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .btnSalvar();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemHoraInicio().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemHoraInicio(),atestadoTela.alerta());
    }

    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemHoraInicio() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e Quantidade sem hora inicio.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoHoraQtd()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .btnSalvar2();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemHoraInicio().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemHoraInicio(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDiaSemHoraInicio() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por dia sem hora inicio.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoAtestadoDia()
                .selecionarDataInicio2()
                .btnConfirmarDataEHora()
                .btnSalvar3();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemHoraInicio().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemHoraInicio(),atestadoTela.alerta());
    }

    @Test
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemDataFim() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e Período sem data fim.");
        AtestadoTela atestadoTela  = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .btnSalvar();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemDataFim().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemDataFim(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemAQtdDeHoras() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e quantidade sem  a qtd de horas.");
        //Ao deixar o valor da quantidade de dias de horas em branco, o campo não fica como obrigatório.
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoHoraQtd()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .btnSalvar2();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemQtdHoras().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemQtdHoras(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemHoraFim() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e Período sem hora fim.");
        AtestadoTela atestadoTela  = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .selecionarDataFim()
                .scroll(0.5,0.56,0.5,0.52)
                .btnConfirmarDataEHora()
                .btnSalvar();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemHoratermino().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemHoratermino(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDiaSemAQuantidadeDeDias() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por dia sem a quantidade de dias.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoAtestadoDia()
                .selecionarDataInicio2()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio2()
                .btnConfirmarDataEHora()
                .btnSalvar3();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemNumeroDias().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemNumeroDias(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemONomeDoMedico() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e Período sem o nome do medico.");
        AtestadoTela atestadoTela  = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .selecionarDataFim()
                .scroll(0.5,0.56,0.5,0.52)
                .btnConfirmarDataEHora()
                .selecionarHoraFim()
                .btnConfirmarDataEHora()
                .btnSalvar();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemMedicoResponsavel().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemMedicoResponsavel(),atestadoTela.alerta());
     }
    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemONomeDoMedico() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e quantidade sem o nome do medico.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoHoraQtd()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .btnqtdHoras()
                .btnSalvar2();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemMedicoResponsavel().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemMedicoResponsavel(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDiaSemONomeDoMedico() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por dia sem o nome do medico.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoAtestadoDia()
                .selecionarDataInicio2()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio2()
                .btnConfirmarDataEHora()
                .btnDias()
                .btnSalvar3();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemMedicoResponsavel().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemMedicoResponsavel(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemOCrmCroDoMedico() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e Período sem o CRM/CRO do medico.");
        AtestadoTela atestadoTela  = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .selecionarDataFim()
                .scroll(0.5,0.56,0.5,0.52)
                .btnConfirmarDataEHora()
                .selecionarHoraFim()
                .btnConfirmarDataEHora()
                .txtNomeMedico("Dr João Silva")
                .btnSalvar();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemCrmMedico().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemCrmMedico(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemOCrmCroDoMedico() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e quantidade sem o CRM/CRO do medico.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoHoraQtd()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .btnqtdHoras()
                .txtNomeMedico2("Dr João Silva")
                .btnSalvar2();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemCrmMedico().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemCrmMedico(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDiaSemOCrmCroDoMedico() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por dia sem o CRM/CRO do medico.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoAtestadoDia()
                .selecionarDataInicio2()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio2()
                .btnConfirmarDataEHora()
                .btnDias()
                .txtNomeMedico3("Dr João Silva")
                .btnSalvar3();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemCrmMedico().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemCrmMedico(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemAnexoDoAtestado() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e Período sem anexo do atestado.");
        AtestadoTela atestadoTela  = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .selecionarDataFim()
                .scroll(0.5,0.56,0.5,0.52)
                .btnConfirmarDataEHora()
                .selecionarHoraFim()
                .btnConfirmarDataEHora()
                .txtNomeMedico("Dr João Silva")
                .txtCRM("123456")
                .txtCID("654321")
                .txtObs("Obs")
                .btnSalvar();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemAnexoAtestado().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemAnexoAtestado(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemAnexoDoAtestado() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e quantidade sem anexo do atestado.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoHoraQtd()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .btnqtdHoras()
                .txtNomeMedico2("Dr João Silva")
                .txtCRM2("123456")
                .txtCID2("654321")
                .txtObs2("Obs")
                .btnSalvar2();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemAnexoAtestado().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemAnexoAtestado(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDiaSemAnexoDoAtestado() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por dia sem anexo do atestado.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoAtestadoDia()
                .selecionarDataInicio2()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio2()
                .btnConfirmarDataEHora()
                .btnDias()
                .txtNomeMedico3("Dr João Silva")
                .txtCRM3("123456")
                .txtCID3("654321")
                .txtObs3("Obs")
                .btnSalvar3();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemAnexoAtestado().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemAnexoAtestado(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemMarcarOCampoDeConfirmacaoDeDados() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e Período sem marcar o campo de confirmação de dados.");
        AtestadoTela atestadoTela  = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .selecionarDataFim()
                .scroll(0.5,0.56,0.5,0.52)
                .btnConfirmarDataEHora()
                .selecionarHoraFim()
                .btnConfirmarDataEHora()
                .txtNomeMedico("Dr João Silva")
                .txtCRM("123456")
                .txtCID("654321")
                .txtObs("Obs")
                .btnAnexarAtestadoGaleria()
                .btnSalvar();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemValidadeDados().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemValidadeDados(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemMarcarOCampoDeConfirmacaoDedados() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por hora e quantidade sem marcar o campo de confirmação de dados.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoHoraQtd()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .btnqtdHoras()
                .txtNomeMedico2("Dr João Silva")
                .txtCRM2("123456")
                .txtCID2("654321")
                .txtObs2("Obs")
                .btnAnexarAtestadoGaleria()
                .btnSalvar2();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemValidadeDados().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemValidadeDados(),atestadoTela.alerta());
    }
    @Test
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDiaSemMarcarOCampoDeConfirmacaoDeDados() {
        test = extent.createTest("Realizar o cadastro de um atestado do tipo: Por dia sem marcar o campo de confirmação de dados.");
        AtestadoTela atestadoTela = new BemVindoTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoAtestadoDia()
                .selecionarDataInicio2()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio2()
                .btnConfirmarDataEHora()
                .btnDias()
                .txtNomeMedico3("Dr João Silva")
                .txtCRM3("123456")
                .txtCID3("654321")
                .txtObs3("Obs")
                .btnAnexarAtestadoGaleria()
                .btnSalvar3();

        if(atestadoTela.mensagemAtencao().equals(atestadoTela.alertaAtencao()) && atestadoTela.mensagemValidadeDados().equals(atestadoTela.alerta())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemValidadeDados(),atestadoTela.alerta());
    }
    @After
    public void fecharDriver(){
        app.quit();
        extent.flush();
    }
}