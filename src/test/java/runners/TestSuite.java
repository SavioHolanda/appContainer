package runners;

import modulos.agendamento.AgendamentoTest;
import modulos.atestados.AtestadoTest;
import modulos.exame.ExameTest;
import modulos.login.BemVindoTest;
import modulos.login.EsqueciSenhaTest;
import modulos.login.LoginTest;
import modulos.login.RelatarProblemaTest;
import modulos.receitas.ReceitasTest;
import modulos.sinaisVitais.SinaisVitaisTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AgendamentoTest.class,
        AtestadoTest.class,
        ExameTest.class,
        BemVindoTest.class,
        EsqueciSenhaTest.class,
        LoginTest.class,
        RelatarProblemaTest.class,
        ReceitasTest.class,
        SinaisVitaisTest.class
})
public class TestSuite {
}
