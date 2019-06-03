package element;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import mobileelement.MobileElementTest;

@RunWith(Suite.class)
@SuiteClasses({ ElementTest.class, PositionTest.class, MobileElementTest.class})
public class AllElementTests {

}
