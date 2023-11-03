package telas;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class FormPrimeiroAcessoTela {
    private AndroidDriver app;
    public FormPrimeiroAcessoTela(AndroidDriver app) {
        this.app = app;
    }
    public FormPrimeiroAcessoTela btnAceiteDoc(){
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")).click();
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")).click();
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")).click();
        return this;
    }

    public String alertaSucessoAceite(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
    }
    public String msnSucessoAceite(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
    }

    /*** Mensagens de retorno ***/
    public String txtalertaSucessoAceite(){
        return "Tudo certo!";
    }
    public String txtmsnSucessoAceite(){
        return "Aceite enviado com sucesso.";
    }
}