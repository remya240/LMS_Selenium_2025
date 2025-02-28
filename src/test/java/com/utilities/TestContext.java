/*
 * package com.utilities;
 * 
 * import java.time.Duration;
 * 
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.interactions.Actions; import
 * org.openqa.selenium.support.ui.WebDriverWait; import
 * org.picocontainer.DefaultPicoContainer; import
 * org.picocontainer.MutablePicoContainer; import
 * org.picocontainer.PicoContainer;
 * 
 * import com.constants.EnvironmentConstants; import
 * com.driverManager.DriverFactory; import com.pages.LoginPage; import
 * com.pages.ProgramAddPage; import com.pages.ProgramPage;
 * 
 * import io.cucumber.core.backend.ObjectFactory;
 * 
 * public class TestContext implements ObjectFactory {
 * 
 * private MutablePicoContainer container;
 * 
 * private WebDriver driver; private ProgramAddPage programadd; private
 * DriverFactory driverfactory; private ConfigReader configreader; private
 * WebDriverWait wait; private Actions actions;
 * 
 * // initializing the DriverFactory
 * 
 * public TestContext() { this.driverfactory = new DriverFactory();
 * this.configreader = new ConfigReader(); // config reader initilise }
 * 
 * public TestContext() { container = new DefaultPicoContainer();
 * container.addComponent(DriverFactory.class);
 * container.addComponent(ConfigReader.class);
 * container.addComponent(ProgramAddPage.class);
 * container.addComponent(ProgramPage.class);
 * container.addComponent(LoginPage.class);
 * container.addComponent(EnvironmentConstants.class); }
 * 
 * public DriverFactory getDriverFactory() { return
 * container.getComponent(DriverFactory.class); }
 * 
 * // WebDriver instance public WebDriver getDriver() { return
 * container.getComponent(DriverFactory.class).getDriver();
 * 
 * }
 * 
 * public ProgramPage getProgramPage() { return
 * container.getComponent(ProgramPage.class); }
 * 
 * public void setDriver(WebDriver driver) { this.driver = driver; this.wait =
 * new WebDriverWait(driver, Duration.ofSeconds(30)); this.actions = new
 * Actions(driver); // Initialize Actions here, after driver is set
 * this.programadd = new ProgramAddPage(driver, this); }
 * 
 * // public String getApplicationURL() { // return
 * configreader.getLmsPortalUrl(); // Method to get URL // }
 * 
 * public ProgramAddPage getProgramAdd() { return
 * container.getComponent(ProgramAddPage.class); }
 * 
 * public EnvironmentConstants getConstants() { return
 * container.getComponent(EnvironmentConstants.class);
 * 
 * }
 * 
 * public LoginPage getLogin() { return container.getComponent(LoginPage.class);
 * }
 * 
 * @Override public boolean addClass(Class<?> clazz) {
 * container.addComponent(clazz); return true; }
 * 
 * @Override public void start() { // Initialization logic, if necessary }
 * 
 * @Override public void stop() { container.dispose(); }
 * 
 * @Override public <T> T getInstance(Class<T> clazz) { return
 * container.getComponent(clazz); }
 * 
 * // public ConfigReader getConfigReader() { // // TODO Auto-generated method
 * stub // return configreader; // }
 * 
 * }
 */