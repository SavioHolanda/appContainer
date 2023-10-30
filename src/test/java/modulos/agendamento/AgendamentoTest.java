package modulos.agendamento;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
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

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Realizar a criação de um agendamento para titular.")
    public void testRealizarACriacaoDeUmAgendamentoParaTitular(){
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

         String mensagemSucessoAgendamento = agendamentoTela.mensagemSucessoAgendamento();
         String mensagemSucessoAgendamento2 = agendamentoTela.mensagemSucessoAgendamento2();

         Assertions.assertEquals("Sucesso", mensagemSucessoAgendamento);
         Assertions.assertEquals("Agendamento realizado com sucesso!", mensagemSucessoAgendamento2);
    }

    @Test
    @DisplayName("Realizar a criação de um reagendamento para titular com data e hora disponíveis.")
    public void testRealizarACriacaoDeUmReagendamentoParaTitularComDataEHoraDisponiveis(){
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

        String mensagemSucessoAgendamento = agendamentoTela.mensagemSucessoAgendamento();
        String mensagemSucessoAgendamento2 = agendamentoTela.mensagemSucessoAgendamento2();

        Assertions.assertEquals("Sucesso", mensagemSucessoAgendamento);
        Assertions.assertEquals("Agendamento realizado com sucesso!", mensagemSucessoAgendamento2);
    }

    @Test
    @DisplayName("Realizar um agendamento sem seleciona o tipo.")
    public void testRealizarUmAgendamentoSemSelecionarOTipo(){
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

        String mensagemAtencao = agendamentoTela.mensagemAtencao();
        String mensagemTipoAgendamenot = agendamentoTela.mensagemTipoAgendamenot();

        Assertions.assertEquals("Atenção", mensagemAtencao);
        Assertions.assertEquals("Selecione o tipo de agendamento", mensagemTipoAgendamenot);
    }

    @Test
    @DisplayName("Realizar o clique na funcionalidade do botão Cancelar na tela de agendamento.")
    public void testRealizarOCliqueNaFuncionalidadeDoBotaoCancelarNaTelaDeAgendamento(){
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

        String txtAgendamento = agendamentoTela.txtAgendamento();

        Assertions.assertEquals("Agendamento", txtAgendamento);
    }

    @Test
    @DisplayName("Realizar o clique na funcionalidade do botão Voltar na tela de agendamento.")
    public void testRealizarOCliqueNaFuncionalidadeDoBotaoVoltarNaTelaDeAgendamento(){
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

        String txtMeusAgendamentos = agendamentoTela.txtMeusAgendamentos();

        Assertions.assertEquals("Meus Agendamento", txtMeusAgendamentos);
    }

    @Test
    @DisplayName("Realizar agendamento sem selecionar um dia disponível.")
    public void testRealizarAgendamentoSemSelecionarUmDiaDisponivel(){
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

        String txtselecioneDia = agendamentoTela.txtselecioneDia();

        Assertions.assertEquals("Selecione o dia", txtselecioneDia);
    }

    @Test
    @DisplayName("Realizar agendamento na tela de selecionar o dia clique o botão VOLTAR.")
    public void testRealizarAgendamentoNaTelaDeSelecionarODiaCliqueOBotaoVoltar(){
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

        String txtTipoAgendamento = agendamentoTela.txtTipoAgendamento();

        Assertions.assertEquals("Selecione o tipo de agendamento", txtTipoAgendamento);
    }

    @Test
    @DisplayName("Realizar agendamento selecionando um horário disponível e na confirmação do agendamento clicar em Não.")
    public void testRealizarAgendamentoSelecionandoUmHorarioDisponivelENaConfirmacaoDoAgendamentoClicarEmNao(){
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

        String txthoraAgendamento = agendamentoTela.txthoraAgendamento();

        Assertions.assertEquals("Agendamento", txthoraAgendamento);
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}
