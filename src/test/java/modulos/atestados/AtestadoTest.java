package modulos.atestados;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.AtestadoTela;
import telas.LoginTela;

import java.util.concurrent.TimeUnit;

public class AtestadoTest {
    private AndroidDriver app;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e Período.")
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodo() {
        AtestadoTela atestadoTela  = new LoginTela(app)
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

        Assertions.assertEquals(atestadoTela.mensagemTudoCerto(),atestadoTela.mensagemCadastroPositivo());
        Assertions.assertEquals(atestadoTela.mensagemTudoCerto2(),atestadoTela.mensagemCadastroPositivoComplemento());
    }

    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e Quantidade.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidade() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
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
                .btnAnexarAtestadoGaleria2()
                .checkBoxConfirmacao2()
                .btnSalvar2();

        Assertions.assertEquals(atestadoTela.mensagemTudoCerto(),atestadoTela.mensagemCadastroPositivo());
        Assertions.assertEquals(atestadoTela.mensagemTudoCerto2(),atestadoTela.mensagemCadastroPositivoComplemento());
    }

    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por dia.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDia() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
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
                .btnAnexarAtestadoGaleria3()
                .checkBoxConfirmacao3()
                .btnSalvar3();

        Assertions.assertEquals(atestadoTela.mensagemTudoCerto(),atestadoTela.mensagemCadastroPositivo());
        Assertions.assertEquals(atestadoTela.mensagemTudoCerto2(),atestadoTela.mensagemCadastroPositivoComplemento());
    }

    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e Período sem data inicio.")
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemDataInicio() {
        AtestadoTela atestadoTela  = new LoginTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .btnSalvar();

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemDataInicio(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e Quantidade sem data inicio.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemDataInicio() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoHoraQtd()
                .btnSalvar2();

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemDataInicio(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por dia sem data inicio.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDiaSemDataInicio() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoAtestadoDia()
                .btnSalvar3();

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemDataInicio(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e Período sem hora inicio.")
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemHoraInicio() {
        AtestadoTela atestadoTela  = new LoginTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .btnSalvar();

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemHoraInicio(),atestadoTela.alerta());
    }

    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e Quantidade sem hora inicio.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemHoraInicio() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoHoraQtd()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .btnSalvar2();

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemHoraInicio(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por dia sem hora inicio.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDiaSemHoraInicio() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .tipoAtestadoDia()
                .selecionarDataInicio2()
                .btnConfirmarDataEHora()
                .btnSalvar3();

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemHoraInicio(),atestadoTela.alerta());
    }

    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e Período sem data fim.")
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemDataFim() {
        AtestadoTela atestadoTela  = new LoginTela(app)
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
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .btnSalvar();

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemDataFim(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e quantidade sem  a qtd de horas.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemAQtdDeHoras() {
        //Ao deixar o valor da quantidade de dias de horas em branco, o campo não fica como obrigatório.
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
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

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemQtdHoras(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e Período sem hora fim.")
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemHoraFim() {
        AtestadoTela atestadoTela  = new LoginTela(app)
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

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemHoratermino(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por dia sem a quantidade de dias.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDiaSemAQuantidadeDeDias() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
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

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemNumeroDias(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e Período sem o nome do medico.")
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemONomeDoMedico() {
        AtestadoTela atestadoTela  = new LoginTela(app)
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

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemMedicoResponsavel(),atestadoTela.alerta());
     }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e quantidade sem o nome do medico.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemONomeDoMedico() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
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

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemMedicoResponsavel(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por dia sem o nome do medico.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDiaSemONomeDoMedico() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
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

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemMedicoResponsavel(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e Período sem o CRM/CRO do medico.")
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemOCrmCroDoMedico() {
        AtestadoTela atestadoTela  = new LoginTela(app)
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

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemCrmMedico(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e quantidade sem o CRM/CRO do medico.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemOCrmCroDoMedico() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
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

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemCrmMedico(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por dia sem o CRM/CRO do medico.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDiaSemOCrmCroDoMedico() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
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

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemCrmMedico(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e Período sem anexo do atestado.")
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemAnexoDoAtestado() {
        AtestadoTela atestadoTela  = new LoginTela(app)
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

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemAnexoAtestado(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e quantidade sem anexo do atestado.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemAnexoDoAtestado() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
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

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemAnexoAtestado(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por dia sem anexo do atestado.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDiaSemAnexoDoAtestado() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
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

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemAnexoAtestado(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e Período sem marcar o campo de confirmação de dados.")
    public void testRealizarCadastroDeUmAtestadoDoTipoPorHoraEPeriodoSemMarcarOCampoDeConfirmacaoDeDados() {
        AtestadoTela atestadoTela  = new LoginTela(app)
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

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemValidadeDados(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e quantidade sem marcar o campo de confirmação de dados.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemMarcarOCampoDeConfirmacaoDedados() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
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
                .btnAnexarAtestadoGaleria2()
                .btnSalvar2();

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemValidadeDados(),atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por dia sem marcar o campo de confirmação de dados.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorDiaSemMarcarOCampoDeConfirmacaoDeDados() {
        AtestadoTela atestadoTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5, 0.90, 0.5, 0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
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
                .btnAnexarAtestadoGaleria3()
                .btnSalvar3();

        Assertions.assertEquals(atestadoTela.mensagemAtencao(),atestadoTela.alertaAtencao());
        Assertions.assertEquals(atestadoTela.mensagemValidadeDados(),atestadoTela.alerta());
    }
    @After
    public void fecharDriver(){
        app.quit();
    }
}