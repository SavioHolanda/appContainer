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

        Assertions.assertEquals("Tudo certo!",atestadoTela.mensagemCadastroPositivo());
        Assertions.assertEquals("Recebemos o seu atestado e está em análise. Em até 2 dias úteis você receberá a confirmação de aceite, fique atento.\n" +
                " IMPORTANTE: Não descarte seu atestado original, ele é um documento legal, e pode ser necessário apresentá-lo pessoalmente.",atestadoTela.mensagemCadastroPositivoComplemento());
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

        Assertions.assertEquals("Tudo certo!",atestadoTela.mensagemCadastroPositivo());
        Assertions.assertEquals("Recebemos o seu atestado e está em análise. Em até 2 dias úteis você receberá a confirmação de aceite, fique atento.\n" +
                " IMPORTANTE: Não descarte seu atestado original, ele é um documento legal, e pode ser necessário apresentá-lo pessoalmente.",atestadoTela.mensagemCadastroPositivoComplemento());
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

        Assertions.assertEquals("Tudo certo!",atestadoTela.mensagemCadastroPositivo());
        Assertions.assertEquals("Recebemos o seu atestado e está em análise. Em até 2 dias úteis você receberá a confirmação de aceite, fique atento.\n" +
                " IMPORTANTE: Não descarte seu atestado original, ele é um documento legal, e pode ser necessário apresentá-lo pessoalmente.",atestadoTela.mensagemCadastroPositivoComplemento());
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

        Assertions.assertEquals("Atenção!",atestadoTela.alertaAtencao());
        Assertions.assertEquals("Informe a data de início do atestado.",atestadoTela.alerta());
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

        Assertions.assertEquals("Atenção!",atestadoTela.alertaAtencao());
        Assertions.assertEquals("Informe a data de início do atestado.",atestadoTela.alerta());
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

        Assertions.assertEquals("Atenção!",atestadoTela.alertaAtencao());
        Assertions.assertEquals("Informe a data de início do atestado.",atestadoTela.alerta());
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

        Assertions.assertEquals("Atenção!",atestadoTela.alertaAtencao());
        Assertions.assertEquals("Informe o horário de início do atestado.",atestadoTela.alerta());
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
                .btnSalvar2();

        Assertions.assertEquals("Atenção!",atestadoTela.alertaAtencao());
        Assertions.assertEquals("Informe o horário de início do atestado.",atestadoTela.alerta());
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

        Assertions.assertEquals("Atenção!",atestadoTela.alertaAtencao());
        Assertions.assertEquals("Informe o horário de início do atestado.",atestadoTela.alerta());
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
                .selecionarDataFim()
                .scroll(0.5,0.56,0.5,0.52)
                .btnConfirmarDataEHora()
                .btnSalvar();

        Assertions.assertEquals("Atenção!",atestadoTela.alertaAtencao());
        Assertions.assertEquals("Informe a data de fim do atestado.",atestadoTela.alerta());
    }
    @Test
    @DisplayName("Realizar o cadastro de um atestado do tipo: Por hora e quantidade sem  a qtd de horas.")
    public void testRealizarOCadastroDeUmAtestadoDoTipoPorHoraEQuantidadeSemAQtdDeHoras() {
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

        Assertions.assertEquals("Atenção!",atestadoTela.alertaAtencao());
        Assertions.assertEquals("Informe a quantidade de horas.",atestadoTela.alerta());
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

        Assertions.assertEquals("Atenção!",atestadoTela.alertaAtencao());
        Assertions.assertEquals("Informe o horário de término do atestado.",atestadoTela.alerta());
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

        Assertions.assertEquals("Atenção!",atestadoTela.alertaAtencao());
        Assertions.assertEquals("Informe o número de dias do atestado.",atestadoTela.alerta());
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

        Assertions.assertEquals("Atenção!",atestadoTela.alertaAtencao());
        Assertions.assertEquals("Informe os dados do médico responsável pelo atestado.",atestadoTela.alerta());
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

        Assertions.assertEquals("Atenção!",atestadoTela.alertaAtencao());
        Assertions.assertEquals("Informe os dados do médico responsável pelo atestado.",atestadoTela.alerta());
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

        Assertions.assertEquals("Atenção!",atestadoTela.alertaAtencao());
        Assertions.assertEquals("Informe os dados do médico responsável pelo atestado.",atestadoTela.alerta());
    }
    @After
    public void fecharDriver(){
        app.quit();
    }
}