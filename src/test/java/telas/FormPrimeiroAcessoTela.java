package telas;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class FormPrimeiroAcessoTela {
    private AndroidDriver app;
    public FormPrimeiroAcessoTela(AndroidDriver app) {
        this.app = app;
    }
    public FormPrimeiroAcessoTela btnAceiteDoc(){
        app.findElement(By.xpath("//android.widget.TextView[@text=\"Aceitar\"]")).click();
        //app.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")).click();
        //app.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")).click();
        return this;
    }
    public String alertaSucessoAceite(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
    }
    public String msnSucessoAceite(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
    }
    public FormPrimeiroAcessoTela tipoSanguineo(){
        app.findElement(By.xpath("//android.view.View[@text=\"Não Sei\"]")).click();
        return this;
    }
    public FormPrimeiroAcessoTela campoNumero(String num){
        app.findElement(By.xpath("//android.view.View[@resource-id=\"root\"]/android.view.View/android.view.View/android.view.View/android.widget.EditText[5]")).sendKeys(num);
        return this;
    }
    public FormPrimeiroAcessoTela btnEnviar(){
        app.findElement(By.className("android.widget.Button")).click();
        return this;
    }

    public FormPrimeiroAcessoTela txtNome(){
        app.findElement(By.xpath("//android.view.View[@text=\"Nome\"]")).getText();
        return this;
    }

    public FormPrimeiroAcessoTela scroll(double ix, double iy, double fx, double fy) {
        Dimension dimension = app.manage().window().getSize();
        System.out.println(dimension);

        int startx = (int) (dimension.width * ix);
        int starty = (int) (dimension.height * iy);

        int endx = (int) (dimension.width * fx);
        int endy = (int) (dimension.height * fy);

        TouchAction touch = new TouchAction(app);
        touch.press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endx, endy))
                .release()
                .perform();

        touch = new TouchAction(app);
        touch.press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endx, endy))
                .release()
                .perform();
        return this;
    }

    /*** Mensagens de retorno ***/
    public String txtalertaSucessoAceite(){
        return "Tudo certo!";
    }
    public String txtmsnSucessoAceite(){
        return "Aceite enviado com sucesso.";
    }
}