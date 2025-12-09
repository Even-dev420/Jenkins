package testproject;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class AggregatorTest {

    @Test
    public void testInitialState() {
        Aggregator agr = new Aggregator();
        assertThat(agr.getSum()).isZero();
    }

    @Test
    public void testSingleAddition() {
        Aggregator agr = new Aggregator();
        double val = 20;
        agr.addValue(val);
        assertThat(agr.getSum()).isEqualTo(val);
    }

    @Test
    public void testMultipleAdditions() {
        Aggregator agr = new Aggregator();
        double val = 15;
        agr.addValue(val);
        agr.addValue(val);
        assertThat(agr.getSum()).isEqualTo(val * 2);
    }

    @Test
    public void testResetAfterAddition() {
        Aggregator agr = new Aggregator();
        agr.addValue(10.5);
        agr.addValue(20.3);
        assertThat(agr.getSum()).isEqualTo(30.8);
        
        agr.reset();
        assertThat(agr.getSum()).isZero();
    }
    
    @Test
    public void testResetAndAddAgain() {
        Aggregator agr = new Aggregator();
        agr.addValue(100);
        agr.reset();
        agr.addValue(50);
        assertThat(agr.getSum()).isEqualTo(50);
    }
    
    @Test
    public void testResetWhenAlreadyZero() {
        Aggregator agr = new Aggregator();
        agr.reset(); // reset когда сумма уже 0
        assertThat(agr.getSum()).isZero();
    }
}
