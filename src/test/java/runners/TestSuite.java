package runners;

import modulos.login.BemVindoTest;
import modulos.login.EsqueciSenhaTest;
import modulos.login.LoginTest;
import modulos.login.RelatarProblemaTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        RelatarProblemaTest.class,
        BemVindoTest.class,
        EsqueciSenhaTest.class
        // adicione mais classes de teste aqui
})
public class TestSuite {
}
