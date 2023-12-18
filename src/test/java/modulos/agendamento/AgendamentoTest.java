package modulos.agendamento;

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
import telas.AgendamentoTela;
import telas.BemVindoTela;

import java.util.concurrent.TimeUnit;

public class AgendamentoTest {

    private AndroidDriver app;
    private ExtentReports extent = TestBase.getInstance();
    private ExtentTest test;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Test
    public void testRealizarACriacaoDeUmAgendamentoParaTitular(){
        test = extent.createTest("Realizar a criação de um agendamento para titular.");
        AgendamentoTela agendamentoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoAgendamento()
                .selecaoTipoAgendamento("CHECK-UP TESTE")
                .botaoOk()
                .selecionarDataDisponivel()
                .botaoOKAgenda()
                .selecionarHora()
                .confirmarAgendamento();

        if(agendamentoTela.alertaSucesso().equals(agendamentoTela.mensagemSucessoAgendamento()) && agendamentoTela.msnSucesso().equals(agendamentoTela.mensagemSucessoAgendamento2()) ){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

         Assertions.assertEquals(agendamentoTela.alertaSucesso(), agendamentoTela.mensagemSucessoAgendamento());
         Assertions.assertEquals(agendamentoTela.msnSucesso(), agendamentoTela.mensagemSucessoAgendamento2());
    }

    @Test
    public void testRealizarACriacaoDeUmReagendamentoParaTitularComDataEHoraDisponiveis(){
        test = extent.createTest("Realizar a criação de um reagendamento para titular com data e hora disponíveis.");
        AgendamentoTela agendamentoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoAgendamento()
                .selecaoTipoAgendamento("CHECK-UP TESTE")
                .botaoOk()
                .selecionarDataDisponivel()
                .botaoOKAgenda()
                .selecionarHora()
                .confirmarAgendamento();

        if(agendamentoTela.alertaSucesso().equals(agendamentoTela.mensagemSucessoAgendamento()) && agendamentoTela.msnSucesso().equals(agendamentoTela.mensagemSucessoAgendamento2()) ){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(agendamentoTela.alertaSucesso(), agendamentoTela.mensagemSucessoAgendamento());
        Assertions.assertEquals(agendamentoTela.msnSucesso(), agendamentoTela.mensagemSucessoAgendamento2());
    }

    @Test
    public void testRealizarUmAgendamentoSemSelecionarOTipo(){
        test = extent.createTest("Realizar um agendamento sem seleciona o tipo.");
        AgendamentoTela agendamentoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoAgendamento()
                .botaoOk();

        if(agendamentoTela.alertaAtencao().equals(agendamentoTela.mensagemAtencao()) && agendamentoTela.msnAtencao().equals(agendamentoTela.mensagemTipoAgendamento()) ){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(agendamentoTela.alertaAtencao(), agendamentoTela.mensagemAtencao());
        Assertions.assertEquals(agendamentoTela.msnAtencao(), agendamentoTela.mensagemTipoAgendamento());
    }

    @Test
    public void testRealizarOCliqueNaFuncionalidadeDoBotaoCancelarNaTelaDeAgendamento(){
        test = extent.createTest("Realizar o clique na funcionalidade do botão Cancelar na tela de agendamento.");
        AgendamentoTela agendamentoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoAgendamento()
                .selecaoTipoAgendamento("")
                .btnCancelar();

        if(agendamentoTela.msnAgendamento().equals(agendamentoTela.txtAgendamento())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(agendamentoTela.msnAgendamento(), agendamentoTela.txtAgendamento());
    }

    @Test
    public void testRealizarOCliqueNaFuncionalidadeDoBotaoVoltarNaTelaDeAgendamento(){
        test = extent.createTest("Realizar o clique na funcionalidade do botão Voltar na tela de agendamento.");
        AgendamentoTela agendamentoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoAgendamento()
                .btnVoltar();

        if(agendamentoTela.msnMeusAgendamentos().equals(agendamentoTela.txtMeusAgendamentos())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(agendamentoTela.msnMeusAgendamentos(), agendamentoTela.txtMeusAgendamentos());
    }

    @Test
    public void testRealizarAgendamentoSemSelecionarUmDiaDisponivel(){
        test = extent.createTest("Realizar agendamento sem selecionar um dia disponível.");
        AgendamentoTela agendamentoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoAgendamento()
                .selecaoTipoAgendamento("CHECK-UP TESTE")
                .botaoOk()
                .botaoOKAgenda();

        if(agendamentoTela.msnSelecioneDia().equals(agendamentoTela.txtselecioneDia())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(agendamentoTela.msnSelecioneDia(), agendamentoTela.txtselecioneDia());
    }

    @Test
    public void testRealizarAgendamentoNaTelaDeSelecionarODiaCliqueOBotaoVoltar(){
        test = extent.createTest("Realizar agendamento na tela de selecionar o dia clique o botão VOLTAR.");
        AgendamentoTela agendamentoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoAgendamento()
                .selecaoTipoAgendamento("CHECK-UP TESTE")
                .botaoOk()
                .btnAgendaVoltar();

        if(agendamentoTela.msnSelecioneTipoAgendamento().equals(agendamentoTela.txtTipoAgendamento())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(agendamentoTela.msnSelecioneTipoAgendamento(), agendamentoTela.txtTipoAgendamento());
    }

    @Test
    public void testRealizarAgendamentoSelecionandoUmHorarioDisponivelENaConfirmacaoDoAgendamentoClicarEmNao(){
        test = extent.createTest("Realizar agendamento selecionando um horário disponível e na confirmação do agendamento clicar em Não.");
        AgendamentoTela agendamentoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoAgendamento()
                .selecaoTipoAgendamento("CHECK-UP TESTE")
                .botaoOk()
                .selecionarDataDisponivel()
                .botaoOKAgenda()
                .selecionarHora()
                .naoConfirmarAgendamento();

        if(agendamentoTela.msnAgendamento().equals(agendamentoTela.txthoraAgendamento())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(agendamentoTela.msnAgendamento(), agendamentoTela.txthoraAgendamento());
    }

    @After
    public void fecharDriver(){
        app.quit();
        extent.flush();
    }
}
