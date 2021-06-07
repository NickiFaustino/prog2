package trafficlight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trafficlight.ctrl.TrafficLightCtrl;
import trafficlight.gui.TrafficLight;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrafficLightCtrltest {
    TrafficLightCtrl ctrl;

    @BeforeEach
    public void getCtrl() {
        ctrl = TrafficLightCtrl.getInstance();
    }

    @Test
    @DisplayName("Checks the state after a red light")
    public void stateTest1() {
        String actual  = ctrl.getRedState().getNextState().getColor();
        String expected = ctrl.getYellowState().getColor();
        assertSame(expected, actual);
    }

    @Test
    @DisplayName("Checks if yellow light transitions to red")
    public void stateTest2() {
        String actual  = ctrl.getYellowState().getNextState().getColor();
        String expected = ctrl.getRedState().getColor();
        assertSame(expected, actual);
    }
    @Test
    @DisplayName("Checks if yellow light transitions to ")
    public void stateTest3() {
        String actual  = ctrl.getYellowState().getNextState().getColor();
        String expected = ctrl.getGreenState().getColor();
        assertSame(expected, actual);
    }

    @Test
    @DisplayName("Checks the state after a green light")
    public void stateTest4() {
        String actual  = ctrl.getGreenState().getNextState().getColor();
        String expected = ctrl.getYellowState().getColor();
        assertSame(expected, actual);
    }

    @Test
    @DisplayName("Checks if singleton returns correct color")
    public void singletonTest() {
        TrafficLightCtrl green = TrafficLightCtrl.getInstance();
        assertSame(green, ctrl);
    }
}

