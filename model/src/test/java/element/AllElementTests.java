package element;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import mobileelement.AllMobilesTests;

@RunWith(Suite.class)
@SuiteClasses({ ElementTest.class, PositionTest.class, AllMobilesTests.class})
public class AllElementTests {

}
