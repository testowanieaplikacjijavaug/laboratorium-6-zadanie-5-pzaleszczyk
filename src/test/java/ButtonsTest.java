import java.awt.Color;

import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.timing.Pause;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ButtonsTest {
    
    JButtonMatcher add_button = JButtonMatcher.withText("Add");
    JButtonMatcher subtract_button = JButtonMatcher.withText("Minus");
    Buttons buttons;
    FrameFixture window;
    
    @Before
    public void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }
    
    @Before
    public void setUp() {
        buttons = GuiActionRunner.execute(Buttons::new);
        window = new FrameFixture(buttons);
        window.show();
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
        buttons = null;
    }
    
    @Test
    public void shouldHaveTitleName() {
        window.requireTitle("program - pzaleszczyk");
    }
    

    
    @Test
    public void ShouldBeGreenAfterPressingAdd() {
        window.button(add_button).click();
        Pause.pause();
        window.textBox().background().requireEqualTo(Color.green);

    }
    
    @Test
    public void shouldBeOrangeAfterPressingMinus() {
        
        window.button(subtract_button).click();
        Pause.pause();

        window.textBox().background().requireEqualTo(Color.orange);
    }
    

    
    @Test
    public void shouldHave0AfterAlternatingButtons() {
    	Pause.pause();
    	for(int i = 0 ; i < 5 ; i ++) {
	    	window.button(add_button).click();
	        window.button(subtract_button).click();
	        
    	}
    	Pause.pause();
        window.textBox().requireText("0");
    }
    
    @Test
    public void shouldHave5AfterPressing5TimesAdd() {
        for ( int i = 0; i < 5; i++ ) {
            window.button(add_button).click();
            Pause.pause();
        }
        window.textBox().requireText("5");
    }
    
    @Test
    public void shouldHaveminus5AfterPressing5TimesMinus() {
        for ( int i = 0; i < 5; i++ ) {
            window.button(subtract_button).click();
            Pause.pause();
        }
        window.textBox().requireText("-5");
    }
   
    
   
    
}